package assertions.testers

import assertions.Assertion

class TrueTester(val expression: Boolean?): Assertion() {

    override fun test() {
        if(checkForFalseOrNull(expression)) {
            throwException(errorMessage())
        }
    }

    private fun checkForFalseOrNull(expression: Boolean?): Boolean {
        return expression == null || expression.not()
    }

    override fun errorMessage(): String {
        if(expression == null) {
            return "should have been true but was null"
        }
        return "should have been true but was false"
    }

    companion object {
        fun assertTrue(expression: Boolean?) {
            TrueTester(expression).test()
        }
    }
}

fun Boolean?.shouldBeTrue(): Boolean?{
    TrueTester.assertTrue(this)
    return this
}
