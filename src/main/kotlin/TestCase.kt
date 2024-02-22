abstract class TestCase() {
    var log: String = ""
    var wasRun: Boolean = false
    var wasTornDown: Boolean = false

     private fun theSetUp() {
         wasRun = false

         setUp()
         log += "setup "
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
        log += testMethodName
        wasRun = true
        println("ran $testMethodName")
        theTearDown()
    }
}