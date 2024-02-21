package assertions

object Assertions {
    fun assertTrue(expression: Boolean?) {
        if(expression == null) {
            throwException("should have been true but was null")
        } else if(expression.not()) {
            throwException("should have been true but was false")
        }
    }

    fun assertFalse(expression: Boolean?) {
        if(expression == null) {
            throwException("should have been false but was null")
        } else if(expression) {
            throwException("should have been false but was true")
        }
    }

    fun shouldFail(function: () -> Unit) {
        try {
            function.invoke()
            throw RuntimeException("Failed to catch bad assertion")
        } catch (ex: AssertionFailedException) {
        }
    }

    private fun throwException(message: String) {
        throw AssertionFailedException(message)
    }
}

fun Boolean?.shouldBeTrue(): Boolean?{
    Assertions.assertTrue(this)
    return this
}

fun Boolean?.shouldBeFalse(): Boolean?{
    Assertions.assertFalse(this)
    return this
}