package assertions

import assertions.matchers.shouldBeEqualTo

class AssertionFailedException(message: String) : RuntimeException(message) {
    companion object {
        fun shouldFail(function: () -> Unit) {
            try {
                checkForFailure(function)
            } catch (ex: AssertionFailedException) {
            }
        }

        fun shouldFailWithMessage(message: String, function: () -> Unit) {
            try {
                checkForFailure(function)
            } catch (ex: AssertionFailedException) {
                ex.message.shouldBeEqualTo(message)
            }
        }

        private fun checkForFailure(function: () -> Unit) {
            function.invoke()
            throw RuntimeException("Failed to catch bad assertion")
        }
    }

}
