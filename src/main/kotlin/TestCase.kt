abstract class TestCase(val testMethodName: String) {
    var log: String = ""

    open fun setUp() {}

    open fun tearDown() {}

    open fun logToResults(results: TestResults) {
        results.logs += log
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