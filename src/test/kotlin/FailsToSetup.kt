class FailsToSetup(testMethodName: String): TestCase(testMethodName) {

    override fun setUp() {
        throw RuntimeException("whoops")
    }

    fun testFailedSetup() {}

}