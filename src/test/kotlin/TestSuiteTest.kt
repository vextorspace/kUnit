import annotations.Test
import assertions.matchers.shouldBeEqualTo
import assertions.matchers.shouldBeSimilarTo

class TestSuiteTest(testMethodName: String) : TestCase(testMethodName) {
    @Test
    fun `empty suite runs no tests`() {
        val results = TestResults()
        val suite = TestSuite()
        suite.run(results)
        results.summary().shouldBeSimilarTo("0 run 0 failed")
    }

    @Test
    fun `suite add function adds test case to list`() {
        val suite = TestSuite()
        val test = TestRunner(WasRun("testMethod"), "testMethod")
        suite.add(test)
        suite.testRunners().size.shouldBeEqualTo(1)
        suite.testRunners()[0].shouldBeEqualTo(test)
    }

    @Test
    fun `suite with 1 good test and one bad tests runs both`() {
        val results: TestResults = TestResults()
        val suite: TestSuite = TestSuite()
        suite.add(TestRunner(WasRun("testFailedMethod"), "testFailedMethod"))
        suite.add(TestRunner(WasRun("testMethod"), "testMethod"))
        suite.run(results)
        results.summary().shouldBeSimilarTo("2 run 1 failed")
    }
}