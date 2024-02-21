package assertions

object AssertTrueTest {

    fun `assert true on true passes`() {
        Assertions.assertTrue(true)
    }

    fun `assert true on false fails`() {
        try {
            Assertions.assertTrue(false)
            throw RuntimeException("Failed to catch bad assertion")
        } catch (ex: AssertionFailedException) {

        }
    }

    fun `assert true on null fails`() {
        try {
            Assertions.assertTrue(null)
            throw RuntimeException("Failed to catch bad assertion")
        } catch (ex: AssertionFailedException) {

        }
    }
}