package assertions.matchers

import assertions.Assertion
import assertions.matchers.DoubleCloseMatcher.Companion.assertClose
import kotlin.math.abs

class DoubleCloseMatcher(val expected: Number, val actual: Number, val tolerance: Number): Assertion() {
    override fun check(): Boolean {
        return abs(actual.toDouble() - expected.toDouble()) <= tolerance.toDouble()
    }

    override fun errorMessage(): String {
        return "[$actual] should have been within [$tolerance] of [$expected]"
    }

    companion object {
        fun assertClose(expected: Number, actual: Number, tolerance: Number) {
            DoubleCloseMatcher(expected, actual, tolerance).test()
        }
    }
}

fun Number.shouldBeCloseTo(expected: Number, tolerance: Number) {
    assertClose(expected, this, tolerance)
}