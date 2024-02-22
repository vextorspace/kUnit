package assertions

object Assertions {
    fun shouldFail(function: () -> Unit) {
        try {
            function.invoke()
            throw RuntimeException("Failed to catch bad assertion")
        } catch (ex: AssertionFailedException) {
        }
    }

    fun throwException(message: String) {
        throw AssertionFailedException(message)
    }
}