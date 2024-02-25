class FailsToSetup: TestCase() {

    override fun setUp() {
        super.setUp()
        throw RuntimeException("whoops")
    }

    fun testFailedSetup() {}

}