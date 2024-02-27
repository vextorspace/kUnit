class TestRunner(val testCase: TestCase, val testMethodName: String) {
    fun run(results: TestResults) {
        if (testCase.theSetUp()) {
            testCase.runAndLogTest(results)
        }
        testCase.theTearDown()
        testCase.logToResults(results)
    }
}
