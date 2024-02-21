import assertions.shouldBeFalse
import assertions.shouldBeTrue

class WasRun(methodName: String) : TestCase(methodName) {
    var wasRun: Boolean = false

    override fun setUp() {
        wasRun = false
        super.setUp()
    }

    fun testMethod(): Unit {
        wasRun = true
        println("ran testMethod")
    }

    companion object {
        fun `was run reports if function was run`() {
            val test = WasRun("testMethod")
            test.wasRun.shouldBeFalse()
            test.run()
            test.wasRun.shouldBeTrue()
        }

        fun `test setup was run`() {
            val test = WasRun("testMethod")
            test.wasSetUp.shouldBeFalse()
            test.run()
            test.wasSetUp.shouldBeTrue()
        }
    }
}