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
            TestCaseTest("test setup run teardown order").run(results)
            TestCaseTest("was run does not report function has run if it was never called").run(results)
            TestCaseTest("if setup fails do not run test but do run teardown").run(results)

            AssertTrueTest("assert true on true passes").run(results)
            AssertTrueTest("assert true on false fails").run(results)
            AssertTrueTest("assert true on null fails").run(results)

            AssertFalseTest("assert false on true fails").run(results)
            AssertFalseTest("assert false on false passes").run(results)
            AssertFalseTest("assert false on null fails").run(results)

            AssertSimilarStringTest("same string is similar").run(results)
            AssertSimilarStringTest("string with missing a letter is not similar to another").run(results)
            AssertSimilarStringTest("string differing only in case").run(results)
            AssertSimilarStringTest("string has different spacing").run(results)
            AssertSimilarStringTest("string has different non-alpha-numeric characters").run(results)
            AssertSimilarStringTest("exception should enclose strings in parenthesis").run(results)

            AssertEqualsTest("two different objects are not equal").run(results)
            AssertEqualsTest("two objects that are the same reference are equal").run(results)
            AssertEqualsTest("two objects that are different type are not equal").run(results)
            AssertEqualsTest("two value objects with same value are equal").run(results)
            AssertEqualsTest("equals failure message puts both values in string format in square brackets").run(results)

            TestResultsTest("collects logs of all tests run").run(results)
            TestResultsTest("counts number of tests run").run(results)
            TestResultsTest("counts number of tests failed").run(results)
            TestResultsTest("counts a failure if exception occurs in setup").run(results)
            TestResultsTest("counts a failure if exception occurs in teardown").run(results)

            TestSuiteTest("empty suite runs no tests").run(results)
            TestSuiteTest("suite add function adds test case to list").run(results)
            println(results.summary())
            results.logs.forEach {
                println(it)
            }
            println(results.summary())
        }
    }
}