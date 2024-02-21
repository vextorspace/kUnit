abstract class TestCase() {
    var wasSetUp: Boolean = false
    var wasTornDown: Boolean = false

    open fun setUp() {
        wasSetUp = true
    }

    open fun tearDown() {
        wasTornDown = true
    }

    open fun testMethod() {}

    fun run() {
        this.setUp()
        testMethod()
        this.tearDown()
    }
}