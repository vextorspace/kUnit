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
}