package assertions.testers

import TestCase
import annotations.Test
import assertions.AssertionFailedException.Companion.shouldFail
import assertions.AssertionFailedException.Companion.shouldFailWithMessage
import assertions.testers.AssertNotEqual.Companion.assertNotEqual

class AssertNotEqualTest: TestCase {

    @Test
    fun `not equal fails on same reference`() {
        val actual = TheRecord("Fred")
        val expected = actual
        shouldFailWithMessage("[$actual] should not have been equal to [$expected]") {
            actual.shouldNotEqual(expected)
        }
    }

    @Test
    fun `null value and non-null expected passes`() {
        null.shouldNotEqual("Hello")
    }

    @Test
    fun `null expected and non-null actual passes`() {
        "hello".shouldNotEqual(null)
    }

    @Test
    fun `both null fails`() {
        shouldFailWithMessage("[null] should not have been equal to [null]") {
            null.shouldNotEqual(null)
        }
    }

    data class TheRecord(val message: String) {
        override fun toString(): String {
            return message
        }
    }

}