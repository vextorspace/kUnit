abstract class TestCase() {
    var wasSetUp: Boolean = false

    open fun setUp() {
        wasSetUp = true
    }

    open fun testMethod() {}

    fun run() {
        this.setUp()
        testMethod()
    }
}