class FailsToTearDown(testMethodName: String): TestCase(testMethodName) {

    override fun tearDown() {
        throw RuntimeException("whoopsie-daisy")
    }

    fun testFailedTearDown(){}
}