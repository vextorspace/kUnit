import assertions.shouldBeFalse
import assertions.shouldBeTrue

class WasRun() : TestCase() {
    var wasRun: Boolean = false

    override fun setUp() {
        wasRun = false
        super.setUp()
    }

    override fun testMethod(): Unit {
        wasRun = true
        println("ran testMethod")
    }


}