open class TestCase(val testMethod: String) {
    var wasRun: Boolean = false

    fun run() {
        val method = WasRunTest::class.java.getDeclaredMethod(testMethod)
        method.invoke(this)
    }
}