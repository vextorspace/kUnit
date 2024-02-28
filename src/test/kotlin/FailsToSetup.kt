class FailsToSetup : TestCase() {

    override fun setUp() {
        throw RuntimeException("whoops")
    }

    fun testFailedSetup() {}

}