package assertions.testers

import assertions.Assertion
import assertions.testers.AssertNotNull.Companion.assertNotNull

class AssertNotNull(val expression: Any?): Assertion() {
    override fun test() {
        if (expression == null) {
            throwException(errorMessage())
        }
    }

    override fun errorMessage(): String {
        return "${expression?:"null"} should not have been null"
    }

    companion object {
        fun assertNotNull(expression: Any?) {
            AssertNotNull(expression).test()
        }
    }
}

fun Any?.shouldNotBeNull(): Any? {
    assertNotNull(this)
    return this
}