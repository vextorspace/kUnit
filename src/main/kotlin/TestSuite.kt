import annotations.TestFinder

class TestSuite : TestCase("suite"){
    private val testRunners = mutableListOf<TestRunner>()

    fun testRunners() : List<TestRunner> {
        return testRunners.toList()
    }

    fun add(test: TestRunner) {
        testRunners.add(test)
    }

    override fun runAndLogTest(results: TestResults) {
        testRunners().forEach { it.run(results) }
    }

    override fun logToResults(results: TestResults) {}
    fun <T> addAll(classToSearch: Class<T>) {
        testRunners.addAll(TestFinder<T>(classToSearch).findTests())
    }
}
