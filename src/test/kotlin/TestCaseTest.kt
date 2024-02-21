import assertions.AssertFalseTest
import assertions.AssertTrueTest
import assertions.shouldBeFalse
import assertions.shouldBeTrue

class TestCaseTest: TestCase() {
    fun `was run does not report function has run if it was never called`() {
        val test = WasRun()
        test.wasRun.shouldBeFalse()
    }

    fun `was run reports if function was run`() {
        val test = WasRun()
        test.run()
        test.wasRun.shouldBeTrue()
    }

    fun `test setup was run`() {
        val test = WasRun()
        test.wasSetUp.shouldBeFalse()
        test.run()
        test.wasSetUp.shouldBeTrue()
    }

    fun `test teardown is run after`() {
        val test = WasRun()
        test.wasTornDown.shouldBeFalse()
        test.run()
        test.wasTornDown.shouldBeTrue()
    }
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {

            TestCaseTest().`was run does not report function has run if it was never called`()
            TestCaseTest().`was run reports if function was run`()
            TestCaseTest().`test setup was run`()
            TestCaseTest().`test teardown is run after`()

            AssertTrueTest.`assert true on true passes`()
            AssertTrueTest.`assert true on false fails`()
            AssertTrueTest.`assert true on null fails`()

            AssertFalseTest.`assert false on true fails`()
            AssertFalseTest.`assert false on false passes`()
            AssertFalseTest.`assert false on null fails`()
        }
    }
}