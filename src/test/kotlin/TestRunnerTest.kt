import annotations.Test
import assertions.matchers.shouldBeSimilarTo

class TestRunnerTest(testMethodName: String) : TestCase(testMethodName) {

    @Test
    fun `test runner with test case runs`() {
        val results = TestResults()
        val runner = TestRunner(WasRun("testMethod"), "testMethod")
        runner.run(results)
        results.summary().shouldBeSimilarTo("1 run, 0 failed")
    }
}