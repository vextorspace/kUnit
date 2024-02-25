class TestSuite {
    private val tests = mutableListOf<TestCase>()

    fun tests() : List<TestCase> {
        return tests.toList()
    }

    fun run(results: TestResults) {

    }

    fun add(test: TestCase) {
        tests.add(test)
    }
}
