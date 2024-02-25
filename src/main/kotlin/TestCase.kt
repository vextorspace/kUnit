import java.lang.reflect.InvocationTargetException

abstract class TestCase() {
    var log: String = ""

     private fun theSetUp() {
         setUp()
         log += "setup "
    }

    open fun setUp() {}

    private fun theTearDown() {
        tearDown()
        log += " tearDown"
    }

    open fun tearDown() {}

    fun run(testMethodName: String, summary: TestResults) {
        theSetUp()
        val method = this::class.java.getDeclaredMethod(testMethodName)
        try {
            method.invoke(this)
            log += "$testMethodName passed"
        } catch (ex: Exception) {
            if(ex is InvocationTargetException) {
                log += "$testMethodName --failed--"
                log += stackTraceToString(ex)
            } else {
                log += "!!!!!!!!!! Unexpected exception !!!!!!!!!!!!! ${ex.message}"
            }
        }
        theTearDown()
        summary.let {
            it.logs += log
        }
    }

    private fun stackTraceToString(ex: InvocationTargetException): String {
        var log = ""
        log += System.lineSeparator()
        log += ex.cause?.message ?: ex.message
        log += (ex.cause?.stackTrace ?: ex.stackTrace).map { "  " + it.toString() }.joinToString(System.lineSeparator())
        return log
    }
}