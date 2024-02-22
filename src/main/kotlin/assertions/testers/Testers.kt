package assertions.testers

import assertions.Assertions

object Testers {
    fun assertTrue(expression: Boolean?) {
        if(expression == null) {
            Assertions.throwException("should have been true but was null")
        } else if(expression.not()) {
            Assertions.throwException("should have been true but was false")
        }
    }

    fun assertFalse(expression: Boolean?) {
        if(expression == null) {
            Assertions.throwException("should have been false but was null")
        } else if(expression) {
            Assertions.throwException("should have been false but was true")
        }
    }

}

fun Boolean?.shouldBeTrue(): Boolean?{
    Testers.assertTrue(this)
    return this
}

fun Boolean?.shouldBeFalse(): Boolean?{
    Testers.assertFalse(this)
    return this
}