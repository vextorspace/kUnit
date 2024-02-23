package assertions.matchers

import assertions.Assertion

class EqualsMatcher(val expected: Any?, val actual: Any?): Assertion() {

    override fun test() {
        if (expected != actual) {
            throwException(errorMessage())
        }
    }

    override fun errorMessage() : String {
        return "expected: [$expected] but was: [$actual]"
    }

    companion object {
        fun assertEquals(expected: Any?, actual: Any?) {
            EqualsMatcher(expected, actual).test()
        }
    }
}

fun Any?.shouldBeEqualTo(expected: Any?): Any? {
    EqualsMatcher.assertEquals(expected, this)
    return this
}