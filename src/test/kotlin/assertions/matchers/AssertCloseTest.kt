package assertions.matchers

import TestCase
import annotations.Test
import assertions.AssertionFailedException.Companion.shouldFail

class AssertCloseTest: TestCase {

    @Test
    fun `the same number is close to itself`() {
        val number = 1.3
        number.shouldBeCloseTo(number, 0.0)
    }

    @Test
    fun `a number exactly the tolerance away is still close`() {
        val number = 1.3
        val tolerance = 1
        val expected = number + tolerance
        number.shouldBeCloseTo(expected, tolerance)
    }

    @Test
    fun `a number greater than the expected by more than the tolerance is not close`() {
        val number = 1.5
        val tolerance = .1
        val expected = 1.5 - tolerance - .01

        shouldFail {
            number.shouldBeCloseTo(expected, tolerance)
        }
    }

    @Test
    fun `a number less than the expected by more than the tolerance is not close`() {
        val number = 1.5
        val tolerance = .1
        val expected = 1.5 + tolerance + .01

        shouldFail {
            number.shouldBeCloseTo(expected, tolerance)
        }
    }
}