import assertions.matchers.AssertEqualsTest
import assertions.matchers.AssertSimilarStringTest
import assertions.matchers.shouldBeSimilarTo
import assertions.testers.AssertFalseTest
import assertions.testers.AssertTrueTest
import assertions.testers.FalseTester.Companion.assertFalse
import assertions.testers.TrueTester.Companion.assertTrue

class TestCaseTest: TestCase() {
    fun `was run does not report function has run if it was never called`() {
        val test = WasRun()
        assertFalse(test.log.contains("testMethod"))
    }

    fun `test setup run teardown order`() {
        val test = WasRun()
        test.run("testMethod", TestResults())
        test.log.shouldBeSimilarTo("setUp testMethod passed tearDown")
    }

    fun `if setup fails do not run test but do run teardown`() {
        val test = FailsToSetup()
        val functionName = "testFailedSetup"
        test.run(functionName, TestResults())
        assertFalse(test.log.contains(functionName))
        assertTrue(test.log.contains("tearDown"))
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val results = TestResults()
            TestCaseTest().run("test setup run teardown order", results)
            TestCaseTest().run("was run does not report function has run if it was never called", results)
            TestCaseTest().run("if setup fails do not run test but do run teardown", results)

            AssertTrueTest().run("assert true on true passes", results)
            AssertTrueTest().run("assert true on false fails", results)
            AssertTrueTest().run("assert true on null fails", results)

            AssertFalseTest().run("assert false on true fails", results)
            AssertFalseTest().run("assert false on false passes", results)
            AssertFalseTest().run("assert false on null fails", results)

            AssertSimilarStringTest().run("same string is similar", results)
            AssertSimilarStringTest().run("string with missing a letter is not similar to another", results)
            AssertSimilarStringTest().run("string differing only in case", results)
            AssertSimilarStringTest().run("string has different spacing", results)
            AssertSimilarStringTest().run("string has different non-alpha-numeric characters", results)
            AssertSimilarStringTest().run("exception should enclose strings in parenthesis", results)

            AssertEqualsTest().run("two different objects are not equal", results)
            AssertEqualsTest().run("two objects that are the same reference are equal", results)
            AssertEqualsTest().run("two objects that are different type are not equal", results)
            AssertEqualsTest().run("two value objects with same value are equal", results)
            AssertEqualsTest().run("equals failure message puts both values in string format in square brackets", results)

            TestResultsTest().run("collects logs of all tests run", results)
            TestResultsTest().run("counts number of tests run", results)
            TestResultsTest().run("counts number of tests failed", results)
            TestResultsTest().run("counts a failure if exception occurs in setup", results)
            TestResultsTest().run("counts a failure if exception occurs in teardown", results)

            TestSuiteTest().run("empty suite runs no tests", results)
            
            println(results.summary())
            results.logs.forEach {
                println(it)
            }
            println(results.summary())
        }
    }
}