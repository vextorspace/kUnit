class TestRunner(val testCase: TestCase, val testMethodName: String) {
    fun run(results: TestResults) {
        testCase.run(results)
    }

}
