import annotations.Test
import assertions.matchers.shouldBeSimilarTo

class TestRunnerTest : TestCase {

    @Test
    fun `test runner with test case runs`() {
        val results = TestResults()
        val runner = TestRunner(WasRun(), "testMethod")
        runner.run(results)
        results.summary().shouldBeSimilarTo("1 run, 0 failed")
    }
}