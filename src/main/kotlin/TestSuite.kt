import annotations.TestFinder

class TestSuite : TestCase("suite"){
    private val tests = mutableListOf<TestCase>()
    private val testRunners = mutableListOf<TestRunner>()

    fun testRunners() : List<TestRunner> {
        return testRunners.toList()
    }

    fun tests() : List<TestCase> {
        return tests.toList()
    }

    fun add(test: TestCase) {
        tests.add(test)
    }

    fun add(test: TestRunner) {
        testRunners.add(test)
    }

    override fun runAndLogTest(results: TestResults) {
        tests().forEach { it.run(results) }
        testRunners().forEach { it.run(results) }
    }

    override fun logToResults(results: TestResults) {}
    fun <T> addAll(classToSearch: Class<T>) {
        testRunners.addAll(TestFinder<T>(classToSearch).findTests())
    }
}
