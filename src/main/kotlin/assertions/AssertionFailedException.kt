package assertions

class AssertionFailedException(message: String) : RuntimeException(message) {
    companion object {
        fun shouldFail(function: () -> Unit) {
            try {
                function.invoke()
                throw RuntimeException("Failed to catch bad assertion")
            } catch (ex: AssertionFailedException) {
            }
        }
    }

}
