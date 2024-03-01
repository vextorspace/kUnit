import annotations.Test
import assertions.matchers.shouldBeSimilarTo
import assertions.testers.FalseTester.Companion.assertFalse
import assertions.testers.TrueTester.Companion.assertTrue
import assertions.testers.shouldContain

class TestCaseTest : TestCase {

    @Test
    fun `was run does not report function has run if it was never called`() {
        val test = TestRunner(WasRun(), "testMethod")
        assertFalse(test.log.contains("testMethod"))
    }

    @Test
    fun `test setup run teardown order`() {
        val test = TestRunner(WasRun(), "testMethod")
        val results = TestResults()
        if (test.theSetUp()) {
            test.runTests()
        }
        test.theTearDown()
        test.writeLogToResults(results)
        test.log.shouldBeSimilarTo("setUp testMethod passed tearDown")
    }

    @Test
    fun `if setup fails do not run test but do run teardown`() {
        val testName = "testFailedSetup"
        val test = TestRunner(FailsToSetup(), testName)
        val results = TestResults()
        if (test.theSetUp()) {
            test.runTests()
        }
        test.theTearDown()
        test.writeLogToResults(results)
        assertFalse(test.log.contains(testName))
        test.log.shouldContain("tearDown")
    }
}