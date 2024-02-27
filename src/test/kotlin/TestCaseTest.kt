import annotations.Test
import assertions.matchers.shouldBeSimilarTo
import assertions.testers.FalseTester.Companion.assertFalse
import assertions.testers.TrueTester.Companion.assertTrue

class TestCaseTest(testMethodName: String): TestCase(testMethodName) {

    @Test
    fun `was run does not report function has run if it was never called`() {
        val test = WasRun("testMethod")
        assertFalse(test.log.contains("testMethod"))
    }

    @Test
    fun `test setup run teardown order`() {
        val test = WasRun("testMethod")
        val results = TestResults()
        if (test.theSetUp()) {
            test.runAndLogTest(results)
        }
        test.theTearDown()
        test.logToResults(results)
        test.log.shouldBeSimilarTo("setUp testMethod passed tearDown")
    }

    @Test
    fun `if setup fails do not run test but do run teardown`() {
        val testName = "testFailedSetup"
        val test = FailsToSetup(testName)
        val results = TestResults()
        if (test.theSetUp()) {
            test.runAndLogTest(results)
        }
        test.theTearDown()
        test.logToResults(results)
        assertFalse(test.log.contains(testName))
        assertTrue(test.log.contains("tearDown"))
    }
}