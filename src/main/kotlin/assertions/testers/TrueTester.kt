package assertions.testers

import assertions.Assertion

class TrueTester(val expression: Boolean?): Assertion() {

    override fun check(): Boolean {
        return expression != null && expression
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
