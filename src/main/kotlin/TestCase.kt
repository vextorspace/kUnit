abstract class TestCase() {
    var log: String = ""

     private fun theSetUp() {
         setUp()
         log += "setup "
    }

    open fun setUp() {}

    private fun theTearDown() {
        tearDown()
        log += " tearDown"
    }

    open fun tearDown() {}

    fun run(testMethodName: String, summary: TestSummary? = null) {
        theSetUp()
        val method = this::class.java.getDeclaredMethod(testMethodName)
        method.invoke(this)
        log += testMethodName
        log += " passed"
        theTearDown()
        summary?.let {
            it.logs += "$log"
        }
    }
}