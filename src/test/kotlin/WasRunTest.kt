import assertions.AssertTrueTest

object WasRunTest {
    @JvmStatic
    fun main(args: Array<String>) {

        WasRun("testCase").`was run reports if function was run`()
        AssertTrueTest.`assert true on true passes`()
    }
}