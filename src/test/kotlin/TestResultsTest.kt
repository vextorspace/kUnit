import annotations.Test
import assertions.matchers.shouldBeEqualTo
import assertions.matchers.shouldBeSimilarTo

class TestResultsTest(testMethodName: String) : TestCase(testMethodName) {

    @Test
    fun `collects logs of all tests run`() {
        val results = TestResults()
        val wasRun = TestRunner(WasRun("testMethod"), "testMethod")
        if (wasRun.theSetUp()) {
            wasRun.runAndLogTest(results)
        }
        wasRun.theTearDown()
        wasRun.logToResults(results)
        val wasRun1 = TestRunner(WasRun("testMethod2"), "testMethod2")
        if (wasRun1.theSetUp()) {
            wasRun1.runAndLogTest(results)
        }
        wasRun1.theTearDown()
        wasRun1.logToResults(results)

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
        val wasRun = TestRunner(WasRun("testMethod"), "testMethod")
        if (wasRun.theSetUp()) {
            wasRun.runAndLogTest(results)
        }
        wasRun.theTearDown()
        wasRun.logToResults(results)

        results.summary().shouldBeSimilarTo("1 run 0 failed")
    }

    @Test
    fun `counts number of tests failed`() {
        val results = TestResults()
        val wasRun = TestRunner(WasRun("testFailedMethod"), "testFailedMethod")
        if (wasRun.theSetUp()) {
            wasRun.runAndLogTest(results)
        }
        wasRun.theTearDown()
        wasRun.logToResults(results)
        results.summary().shouldBeSimilarTo("1 run 1 failed")
    }

    @Test
    fun `counts a failure if exception occurs in setup`() {
        val results = TestResults()
        val failsToSetup = TestRunner(FailsToSetup("testFailedSetup"), "testFailedSetup")
        if (failsToSetup.theSetUp()) {
            failsToSetup.runAndLogTest(results)
        }
        failsToSetup.theTearDown()
        failsToSetup.logToResults(results)
        results.summary().shouldBeSimilarTo("1 run 1 failed")
    }

    @Test
    fun `counts a failure if exception occurs in teardown`() {
        val results = TestResults()
        val failsToTearDown = TestRunner(FailsToTearDown("testFailedTearDown"), "testFailedTearDown")
        if (failsToTearDown.theSetUp()) {
            failsToTearDown.runAndLogTest(results)
        }
        failsToTearDown.theTearDown()
        failsToTearDown.logToResults(results)
        results.summary().shouldBeSimilarTo("1 run 1 failed")
    }
}