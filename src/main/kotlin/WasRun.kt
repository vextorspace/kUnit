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
}