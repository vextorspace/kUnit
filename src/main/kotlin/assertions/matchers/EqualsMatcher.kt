package assertions.matchers

import assertions.Assertions

class EqualsMatcher(val expected: Any?, val actual: Any?) {

    fun testForEquality() {
        if (expected != actual) {
            Assertions.throwException(errorMessage())
        }
    }

    fun errorMessage() : String {
        return "expected: [$expected] but was: [$actual]"
    }

    companion object {
        fun assertEquals(expected: Any?, actual: Any?) {
            EqualsMatcher(expected, actual).testForEquality()
        }
    }
}

fun Any?.shouldBeEqualTo(expected: Any?): Any? {
    EqualsMatcher.assertEquals(expected, this)
    return this
}