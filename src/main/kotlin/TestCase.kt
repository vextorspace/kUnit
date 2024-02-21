open class TestCase(private val testMethod: String) {
    var wasSetUp: Boolean = false

    open fun setUp() {
        wasSetUp = true
    }

    fun run() {
        this.setUp()
        val method = this::class.java.getDeclaredMethod(testMethod)
        method.invoke(this)
    }
}