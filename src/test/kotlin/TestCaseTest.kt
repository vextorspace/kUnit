import assertions.*

class TestCaseTest: TestCase() {
    fun `was run does not report function has run if it was never called`() {
        val test = WasRun()
        test.wasRun.shouldBeFalse()
    }

    fun `was run reports if function was run`() {
        val test = WasRun()
        test.run("testMethod")
        test.wasRun.shouldBeTrue()
    }

    fun `test setup was run`() {
        val test = WasRun()
        test.wasSetUp.shouldBeFalse()
        test.run("testMethod")
        test.wasSetUp.shouldBeTrue()
    }

    fun `test teardown is run after`() {
        val test = WasRun()
        test.wasTornDown.shouldBeFalse()
        test.run("testMethod")
        test.wasTornDown.shouldBeTrue()
    }
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {

            TestCaseTest().run("was run does not report function has run if it was never called")
            TestCaseTest().run("was run reports if function was run")
            TestCaseTest().run("test setup was run")
            TestCaseTest().run("test teardown is run after")

            AssertTrueTest().run("assert true on true passes")
            AssertTrueTest().run("assert true on false fails")
            AssertTrueTest().run("assert true on null fails")

            AssertFalseTest().run("assert false on true fails")
            AssertFalseTest().run("assert false on false passes")
            AssertFalseTest().run("assert false on null fails")

            AssertSimilarStringTest().run("same string is similar")
            AssertSimilarStringTest().run("string with missing a letter is not similar to another")
        }
    }
}