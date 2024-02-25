package assertions.testers

import TestCase
import annotations.Test
import assertions.AssertionFailedException.Companion.shouldFail

class AssertTrueTest(testMethodName: String) : TestCase(testMethodName) {

    @Test
    fun `assert true on true passes`() {
        true.shouldBeTrue()
    }

    @Test
    fun `assert true on false fails`() {
        shouldFail {
            false.shouldBeTrue()
        }
    }

    @Test
    fun `assert true on null fails`() {
        shouldFail {
            null.shouldBeTrue()
        }
    }
}