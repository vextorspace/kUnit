import assertions.matchers.AssertEqualsTest
import assertions.matchers.AssertSimilarStringTest
import assertions.matchers.shouldBeSimilarTo
import assertions.testers.AssertFalseTest
import assertions.testers.AssertTrueTest
import assertions.testers.Testers.assertFalse

class TestCaseTest: TestCase() {
    fun `was run does not report function has run if it was never called`() {
        val test = WasRun()
        assertFalse(test.log.contains("testMethod"))
    }

    fun `test setup run teardown order`() {
        val test = WasRun()
        test.run("testMethod")
        test.log.shouldBeSimilarTo("setUp testMethod tearDown")
    }
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {

            TestCaseTest().run("test setup run teardown order")
            TestCaseTest().run("was run does not report function has run if it was never called")

            AssertTrueTest().run("assert true on true passes")
            AssertTrueTest().run("assert true on false fails")
            AssertTrueTest().run("assert true on null fails")

            AssertFalseTest().run("assert false on true fails")
            AssertFalseTest().run("assert false on false passes")
            AssertFalseTest().run("assert false on null fails")

            AssertSimilarStringTest().run("same string is similar")
            AssertSimilarStringTest().run("string with missing a letter is not similar to another")
            AssertSimilarStringTest().run("string differing only in case")
            AssertSimilarStringTest().run("string has different spacing")
            AssertSimilarStringTest().run("string has different non-alpha-numeric characters")
            AssertSimilarStringTest().run("exception should enclose strings in parenthesis")

            AssertEqualsTest().run("two different objects are not equal")
            AssertEqualsTest().run("two objects that are the same reference are equal")
        }
    }
}