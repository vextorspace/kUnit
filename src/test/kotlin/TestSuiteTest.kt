import annotations.Test
import assertions.matchers.shouldBeEqualTo
import assertions.matchers.shouldBeSimilarTo
import assertions.testers.TrueTester.Companion.assertTrue

class TestSuiteTest : TestCase {
    @Test
    fun `empty suite runs no tests`() {
        val results = TestResults()
        val suite = TestSuite()
        suite.runTests(results)

        results.summary().shouldBeSimilarTo("0 run 0 failed")
    }

    @Test
    fun `suite add function adds test case to list`() {
        val suite = TestSuite()
        val test = TestRunner(WasRun(), "testMethod")
        suite.add(test)
        suite.testRunners().size.shouldBeEqualTo(1)
        suite.testRunners()[0].shouldBeEqualTo(test)
    }

    @Test
    fun `suite with 1 good test and one bad tests runs both`() {
        val results: TestResults = TestResults()
        val suite: TestSuite = TestSuite()
        suite.add(TestRunner(WasRun(), "testFailedMethod"))
        suite.add(TestRunner(WasRun(), "testMethod"))

        suite.runTests(results)

        results.summary().shouldBeSimilarTo("2 run 1 failed")
    }

    @Test
    fun `given a sourceset, all tests within are added`() {
        val suite = TestSuite()
        suite.addAllIn("src/test/kotlin/","src/test/kotlin/suitetest/")
        suite.testRunners().size.shouldBeEqualTo(3)
    }

    @Test
    fun `when sourceSet and package root are the same, tests are still found`() {
        val suite = TestSuite()
        suite.addAllIn("src/test/kotlin/", "src/test/kotlin/")
        assertTrue(suite.testRunners().map { it.testCase::class.java.name }.containsAll(listOf("TestSuiteTest", "TestRunnerTest", "TestResultsTest", "TestCaseTest", "suitetest.Test1", "suitetest.Test2")))
    }
}