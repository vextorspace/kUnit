import assertions.shouldBeFalse
import assertions.shouldBeTrue

class WasRun(methodName: String) : TestCase(methodName) {
    fun testMethod(): Unit {
        wasRun = true
        println("ran testMethod")
    }

    fun `was run reports if function was run`() {
        val test = WasRun("testMethod")
        test.wasRun.shouldBeFalse()
        test.run()
        test.wasRun.shouldBeTrue()
    }

    fun `test setup was run`() {
        val test = WasRun("test setup was run")
    }
}