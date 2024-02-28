class TestRunner(val testCase: TestCase, val testMethodName: String) {
    var log: String = ""

    fun run(results: TestResults) {
        if (theSetUp()) {
            runTests()
        }
        theTearDown()
        writeLogToResults(results)
    }

    fun theSetUp(): Boolean {
        return runAndLog("setup ", ""){testCase.setUp()}
    }
    fun theTearDown() {
        runAndLog(" tearDown", ""){testCase.tearDown()}
    }

    fun writeLogToResults(results: TestResults) {
        results.logs += log
    }

    fun runTests() {
        runAndLog(testMethodName, " passed"){
            val method = testCase::class.java.getDeclaredMethod(testMethodName)
            method.invoke(testCase)
        }
    }

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
