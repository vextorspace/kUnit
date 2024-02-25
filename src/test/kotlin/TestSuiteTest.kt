import assertions.matchers.shouldBeSimilarTo

class TestSuiteTest: TestCase() {
    fun `empty suite runs no tests`() {
        val results = TestResults()
        val suite = TestSuite()
        suite.run(results)
        results.summary().shouldBeSimilarTo("0 run 0 failed")
    }
}