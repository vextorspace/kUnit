package assertions

object Assertions {
    fun assertTrue(expression: Boolean?) {
        if(expression == null) {
            throw AssertionFailedException("should have been true but was null")
        }

        if(expression.not()) {
            throw AssertionFailedException("should have been true but was false")
        }
    }

    fun assertFalse(expression: Boolean?) {

    }
}