import java.lang.reflect.InvocationTargetException

abstract class TestCase(val testMethodName: String) {
    var log: String = ""

     private fun theSetUp(): Boolean {
         return runAndLog("setup ", ""){setUp()}
     }

    open fun setUp() {}

    private fun theTearDown() {
        runAndLog(" tearDown", ""){tearDown()}
    }

    open fun tearDown() {}

    private fun runAndLog(label: String, postLabel: String, toRun: () -> Unit ): Boolean {
        try {
            toRun.invoke()
            log(label + postLabel)
            return true
        } catch (ex: Exception) {
            logException(label, ex)
        }
        return false
    }

    fun run(summary: TestResults) {
            if(theSetUp()) {
                runAndLogTestMethod(testMethodName)
            }
        theTearDown()
        summary.let {
            it.logs += log
        }
    }

    private fun runAndLogTestMethod(testMethodName: String) {

        runAndLog(testMethodName, " passed"){
            val method = this::class.java.getDeclaredMethod(testMethodName)
            method.invoke(this)
        }
    }

    private fun logException(whatFailed: String, ex: Exception) {
        log("$whatFailed --failed--")
        log(stackTraceToString(ex))
    }

    private fun log(message: String) {
        log += message
    }

    private fun stackTraceToString(ex: Exception): String {
        var log = ""
        log += System.lineSeparator()
        log += ex.cause?.message ?: ex.message
        log += (ex.cause?.stackTrace ?: ex.stackTrace).map { "  " + it.toString() }.joinToString(System.lineSeparator())
        return log
    }
}