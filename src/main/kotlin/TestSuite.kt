import annotations.TestFinder

class TestSuite {

    private val testRunners = mutableListOf<TestRunner>()

    fun testRunners() : List<TestRunner> {
        return testRunners.toList()
    }

    fun add(test: TestRunner) {
        testRunners.add(test)
    }

    fun runTests(results: TestResults) {
        testRunners().forEach { it.run(results) }
    }

    fun <T> addAll(classToSearch: Class<T>) {
        testRunners.addAll(TestFinder<T>(classToSearch).findTests())
    }
}
