package assertions.testers

import assertions.Assertion
import assertions.testers.AssertNull.Companion.assertNull

class AssertNull(val expression: Any?): Assertion() {
    override fun test() {
        if (expression != null) {
            throwException(errorMessage())
        }
    }

    override fun errorMessage(): String {
        return "${expression?:"null"} should have been null"
    }

    companion object {
        fun assertNull(expression: Any?) {
            AssertNull(expression).test()
        }
    }
}

fun Any?.shouldBeNull(): Any? {
    assertNull(this)
    return this
}