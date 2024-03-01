package assertions.matchers

import assertions.Assertion
import assertions.matchers.AssertNotEqual.Companion.assertNotEqual

class AssertNotEqual(val expected: Any?, val actual: Any?): Assertion() {
    override fun test() {
        if(expected == actual) {
            throwException(errorMessage())
        }
    }

    override fun errorMessage(): String {
        return "[$actual] should not have been equal to [$expected]"
    }

    companion object {
        fun assertNotEqual(expected: Any?, actual: Any?) {
            AssertNotEqual(expected, actual).test()
        }
    }
}

fun Any?.shouldNotEqualTo(expected: Any?) {
    assertNotEqual(expected, this)
}