package assertions.testers

import assertions.Assertion

class TrueTester(val expression: Boolean?): Assertion() {

    override fun test() {
        if(expression == null || expression.not()) {
            throwException(errorMessage())
        }
    }

    override fun errorMessage(): String {
        return if(expression == null) {
            "should have been true but was null"
        } else if(expression.not()) {
            "should have been true but was false"
        } else {
            return ""
        }
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
