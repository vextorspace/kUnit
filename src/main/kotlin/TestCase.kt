import java.lang.reflect.InvocationTargetException

abstract class TestCase() {
    var log: String = ""

     private fun theSetUp(): Boolean {
         try {
             setUp()
             log("setup ")
             return true
         } catch (ex: Exception) {
             logException("setup", ex)
         }
         return false
    }

    open fun setUp() {}

    private fun theTearDown() {
        try {
            tearDown()
            log(" tearDown")
        } catch (ex: Exception) {
            logException(" tearDown", ex)
        }
    }

    open fun tearDown() {}

    fun run(testMethodName: String, summary: TestResults) {
            if(theSetUp()) {
                runAndLogTestMethod(testMethodName)
            }
        theTearDown()
        summary.let {
            it.logs += log
        }
    }

    private fun runAndLogTestMethod(testMethodName: String) {
        val method = this::class.java.getDeclaredMethod(testMethodName)
        try {
            method.invoke(this)
            log("$testMethodName passed")
        } catch (ex: Exception) {
            if (ex is InvocationTargetException) {
                logException(testMethodName, ex)
            } else {
                log("!!!!!!!!!! Unexpected exception !!!!!!!!!!!!! ${ex.message}")
            }
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