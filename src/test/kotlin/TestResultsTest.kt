import assertions.matchers.shouldBeEqualTo
import assertions.matchers.shouldBeSimilarTo

class TestResultsTest : TestCase(){

    fun `collects logs of all tests run`() {
        val results = TestResults()
        WasRun().run("testMethod", results)
        WasRun().run("testMethod2", results)

        results.logs.size.shouldBeEqualTo(2)
        if (results.logs[0].contains("testMethod2")) {
            results.logs[0].shouldBeSimilarTo("setUp testMethod2 passed tearDown")
            results.logs[1].shouldBeSimilarTo("setUp testMethod passed tearDown")
        } else {
            results.logs[0].shouldBeSimilarTo("setUp testMethod passed tearDown")
            results.logs[1].shouldBeSimilarTo("setUp testMethod2 passed tearDown")
        }
    }

    fun `counts number of tests run`() {
        val results = TestResults()
        WasRun().run("testMethod", results)

        results.summary().shouldBeSimilarTo("1 run 0 failed")
    }

    fun `counts number of tests failed`() {
        val results = TestResults()
        WasRun().run("testFailedMethod", results)
        results.summary().shouldBeSimilarTo("1 run 1 failed")
    }

    fun `counts a failure if exception occurs in setup`() {
        val results = TestResults()
        FailsToSetup().run("testFailedSetup", results)
        results.summary().shouldBeSimilarTo("1 run 1 failed")
    }

    fun `counts a failure if exception occurs in teardown`() {
        val results = TestResults()
        FailsToTearDown().run("testFailedTearDown", results)
        results.summary().shouldBeSimilarTo("1 run 1 failed")
    }
}