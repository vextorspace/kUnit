import assertions.AssertFalseTest
import assertions.AssertTrueTest

class WasRunTest() {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {

            WasRun("testCase").`was run reports if function was run`()

            AssertTrueTest.`assert true on true passes`()
            AssertTrueTest.`assert true on false fails`()
            AssertTrueTest.`assert true on null fails`()

            AssertFalseTest.`assert false on true fails`()
            AssertFalseTest.`assert false on false passes`()
            AssertFalseTest.`assert false on null fails`()

        }
    }
}