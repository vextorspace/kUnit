import assertions.matchers.AssertEqualsTest
import assertions.matchers.AssertSimilarStringTest
import assertions.matchers.shouldBeSimilarTo
import assertions.testers.AssertFalseTest
import assertions.testers.AssertTrueTest
import assertions.testers.FalseTester.Companion.assertFalse
import assertions.testers.TrueTester.Companion.assertTrue

class TestCaseTest(testMethodName: String): TestCase(testMethodName) {
    fun `was run does not report function has run if it was never called`() {
        val test = WasRun("testMethod")
        assertFalse(test.log.contains("testMethod"))
    }

    fun `test setup run teardown order`() {
        val test = WasRun("testMethod")
        test.run(TestResults())
        test.log.shouldBeSimilarTo("setUp testMethod passed tearDown")
    }

    fun `if setup fails do not run test but do run teardown`() {
        val testName = "testFailedSetup"
        val test = FailsToSetup(testName)
        test.run(TestResults())
        assertFalse(test.log.contains(testName))
        assertTrue(test.log.contains("tearDown"))
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val results = TestResults()
            
            val suite = TestSuite()
            suite.add(TestCaseTest("test setup run teardown order"))
            suite.add(TestCaseTest("was run does not report function has run if it was never called"))
            suite.add(TestCaseTest("if setup fails do not run test but do run teardown"))

            suite.add(AssertTrueTest("assert true on true passes"))
            suite.add(AssertTrueTest("assert true on false fails"))
            suite.add(AssertTrueTest("assert true on null fails"))

            suite.add(AssertFalseTest("assert false on true fails"))
            suite.add(AssertFalseTest("assert false on false passes"))
            suite.add(AssertFalseTest("assert false on null fails"))

            suite.add(AssertSimilarStringTest("same string is similar"))
            suite.add(AssertSimilarStringTest("string with missing a letter is not similar to another"))
            suite.add(AssertSimilarStringTest("string differing only in case"))
            suite.add(AssertSimilarStringTest("string has different spacing"))
            suite.add(AssertSimilarStringTest("string has different non-alpha-numeric characters"))
            suite.add(AssertSimilarStringTest("exception should enclose strings in parenthesis"))

            suite.add(AssertEqualsTest("two different objects are not equal"))
            suite.add(AssertEqualsTest("two objects that are the same reference are equal"))
            suite.add(AssertEqualsTest("two objects that are different type are not equal"))
            suite.add(AssertEqualsTest("two value objects with same value are equal"))
            suite.add(AssertEqualsTest("equals failure message puts both values in string format in square brackets"))

            suite.add(TestResultsTest("collects logs of all tests run"))
            suite.add(TestResultsTest("counts number of tests run"))
            suite.add(TestResultsTest("counts number of tests failed"))

            suite.add(TestResultsTest("counts a failure if exception occurs in setup"))
            suite.add(TestResultsTest("counts a failure if exception occurs in teardown"))

            suite.add(TestSuiteTest("empty suite runs no tests"))
            suite.add(TestSuiteTest("suite add function adds test case to list"))
            suite.add(TestSuiteTest("suite with 1 good test and one bad tests runs both"))

            suite.run(results)

            println(results.summary())
            results.logs.forEach {
                println(it)
            }
            println(results.summary())
        }
    }
}