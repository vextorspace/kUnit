open class TestCase(private val testMethod: String) {
    var wasRun: Boolean = false

    fun run() {
        val method = this::class.java.getDeclaredMethod(testMethod)
        method.invoke(this)
    }
}