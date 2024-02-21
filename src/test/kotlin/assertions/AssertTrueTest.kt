package assertions

object AssertTrueTest {

    fun `assert true on true passes`() {
        Assertions.assertTrue(true)
    }

    fun `assert true on false fails`() {
        Assertions.shouldFail {
            Assertions.assertTrue(false)
        }
    }

    fun `assert true on null fails`() {
        Assertions.shouldFail {
            Assertions.assertTrue(null)
        }
    }
}