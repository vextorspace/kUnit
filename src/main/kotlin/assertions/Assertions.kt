package assertions

object Assertions {
    fun assertTrue(expression: Boolean?) {
        if(expression == null) {
            throwException("should have been true but was null")
        } else if(expression.not()) {
            throwException("should have been true but was false")
        }
    }

    private fun throwException(message: String) {
        throw AssertionFailedException(message)
    }
}