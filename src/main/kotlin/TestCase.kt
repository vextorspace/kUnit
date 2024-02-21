open class TestCase(val testMethod: String) {

    fun run() {
        val method = WasRun::class.java.getDeclaredMethod(testMethod)
        method.invoke(this)
    }
}