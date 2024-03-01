package assertions.matchers

import assertions.Assertion

class AssertEqual(val expected: Any?, val actual: Any?): Assertion() {

    override fun check(): Boolean {
        return expected == actual
    }

    override fun errorMessage() : String {
        return "expected: [$expected] but was: [$actual]"
    }

    companion object {
        fun assertEqual(expected: Any?, actual: Any?) {
            AssertEqual(expected, actual).test()
        }
    }
}

fun Any?.shouldBeEqualTo(expected: Any?): Any? {
    AssertEqual.assertEqual(expected, this)
    return this
}