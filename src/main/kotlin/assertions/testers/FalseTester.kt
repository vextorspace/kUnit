package assertions.testers

import assertions.Assertion

class FalseTester(val expression: Boolean?) : Assertion() {
    override fun test() {
        if(expression == null || expression) {
            throwException(errorMessage())
        }
    }

    override fun errorMessage(): String {
        return if(expression == null) {
            "should have been false but was null"
        } else if(expression) {
            "should have been false but was true"
        } else {
            ""
        }
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