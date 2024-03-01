package assertions.testers

import TestCase
import annotations.Test
import assertions.AssertionFailedException.Companion.shouldFailWithMessage
import assertions.matchers.shouldNotEqualTo

class AssertNotEqualTest: TestCase {

    @Test
    fun `not equal fails on same reference`() {
        val actual = TheRecord("Fred")
        val expected = actual
        shouldFailWithMessage("[$actual] should not have been equal to [$expected]") {
            actual.shouldNotEqualTo(expected)
        }
    }

    @Test
    fun `null value and non-null expected passes`() {
        null.shouldNotEqualTo("Hello")
    }

    @Test
    fun `null expected and non-null actual passes`() {
        "hello".shouldNotEqualTo(null)
    }

    @Test
    fun `both null fails`() {
        shouldFailWithMessage("[null] should not have been equal to [null]") {
            null.shouldNotEqualTo(null)
        }
    }

    data class TheRecord(val message: String) {
        override fun toString(): String {
            return message
        }
    }

}