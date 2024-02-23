package assertions.testers

import assertions.Assertion

class FalseTester(val expression: Boolean?) : Assertion() {
    override fun test() {
        if(checkForTrueOrNull(expression)) {
            throwException(errorMessage())
        }
    }

    private fun checkForTrueOrNull(expression: Boolean?): Boolean {
        return expression == null || expression
    }

    override fun errorMessage(): String {
        if(expression == null) {
            return "should have been false but was null"
        }

        return "should have been false but was true"
    }

    companion object {
        fun assertFalse(expression: Boolean?) {
            FalseTester(expression).test()
        }
    }
}

fun Boolean?.shouldBeFalse(): Boolean?{
    FalseTester.assertFalse(this)
    return this
}