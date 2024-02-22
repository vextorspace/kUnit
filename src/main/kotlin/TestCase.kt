abstract class TestCase() {
    var wasSetUp: Boolean = false
    var wasRun: Boolean = false
    var wasTornDown: Boolean = false

     private fun theSetUp() {
         wasRun = false

         setUp()
         wasSetUp = true
    }

    open fun setUp() {}

    private fun theTearDown() {
        tearDown()
        wasTornDown = true
    }

    open fun tearDown() {}

    fun run(testMethodName: String) {
        theSetUp()
        val method = this::class.java.getDeclaredMethod(testMethodName)
        method.invoke(this)
        wasRun = true
        println("ran $testMethodName")
        theTearDown()
    }
}