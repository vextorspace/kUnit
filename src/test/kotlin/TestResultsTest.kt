import annotations.Test
import assertions.matchers.shouldBeEqualTo
import assertions.matchers.shouldBeSimilarTo

class TestResultsTest(testMethodName: String) : TestCase(testMethodName){

    @Test
    fun `collects logs of all tests run`() {
        val results = TestResults()
        WasRun("testMethod").run(results)
        WasRun("testMethod2").run(results)

        results.logs.size.shouldBeEqualTo(2)
        if (results.logs[0].contains("testMethod2")) {
            results.logs[0].shouldBeSimilarTo("setUp testMethod2 passed tearDown")
            results.logs[1].shouldBeSimilarTo("setUp testMethod passed tearDown")
        } else {
            results.logs[0].shouldBeSimilarTo("setUp testMethod passed tearDown")
            results.logs[1].shouldBeSimilarTo("setUp testMethod2 passed tearDown")
        }
    }

    @Test
    fun `counts number of tests run`() {
        val results = TestResults()
        WasRun("testMethod").run(results)

        results.summary().shouldBeSimilarTo("1 run 0 failed")
    }

    @Test
    fun `counts number of tests failed`() {
        val results = TestResults()
        WasRun("testFailedMethod").run(results)
        results.summary().shouldBeSimilarTo("1 run 1 failed")
    }

    @Test
    fun `counts a failure if exception occurs in setup`() {
        val results = TestResults()
        FailsToSetup("testFailedSetup").run(results)
        results.summary().shouldBeSimilarTo("1 run 1 failed")
    }

    @Test
    fun `counts a failure if exception occurs in teardown`() {
        val results = TestResults()
        FailsToTearDown("testFailedTearDown").run(results)
        results.summary().shouldBeSimilarTo("1 run 1 failed")
    }
}