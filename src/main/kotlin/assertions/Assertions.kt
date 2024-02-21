package assertions

object Assertions {
    fun assertTrue(expression: Boolean?) {
        if(expression == null) {
            throw RuntimeException("should have been true but was null")
        }
        if(expression.not()) {
            throw RuntimeException("should have been true but was false")
        }
    }

    fun assertFalse(expression: Boolean?) {

    }
}