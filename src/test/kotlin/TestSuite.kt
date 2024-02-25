class TestSuite : TestCase("suite"){
    private val tests = mutableListOf<TestCase>()

    fun tests() : List<TestCase> {
        return tests.toList()
    }

    fun add(test: TestCase) {
        tests.add(test)
    }

    override fun runAndLogTest(results: TestResults) {
        tests().forEach { it.run(results) }
    }

    override fun logToResults(results: TestResults) {}
}
