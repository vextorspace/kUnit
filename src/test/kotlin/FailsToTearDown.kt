class FailsToTearDown : TestCase {

    override fun tearDown() {
        throw RuntimeException("whoopsie-daisy")
    }

    fun testFailedTearDown(){}
}