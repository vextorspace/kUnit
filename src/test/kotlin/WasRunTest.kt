import assertions.AssertFalseTest
import assertions.AssertTrueTest
import assertions.shouldBeFalse
import assertions.shouldBeTrue

class WasRunTest(testMethod: String): TestCase(testMethod) {

    fun `was run reports if function was run`() {
        val test = WasRunTest("testMethod")
        test.wasRun.shouldBeFalse()
        test.run()
        test.wasRun.shouldBeTrue()
    }


    fun testMethod(): Unit {
        wasRun = true
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {

            WasRunTest("testCase").`was run reports if function was run`()

            AssertTrueTest.`assert true on true passes`()
            AssertTrueTest.`assert true on false fails`()
            AssertTrueTest.`assert true on null fails`()

            AssertFalseTest.`assert false on true fails`()
            AssertFalseTest.`assert false on false passes`()
            AssertFalseTest.`assert false on null fails`()

        }
    }
}