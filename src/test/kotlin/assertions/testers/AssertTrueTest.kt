package assertions.testers

import TestCase
import assertions.AssertionFailedException.Companion.shouldFail

class AssertTrueTest : TestCase() {

    fun `assert true on true passes`() {
        true.shouldBeTrue()
    }

    fun `assert true on false fails`() {
        shouldFail {
            false.shouldBeTrue()
        }
    }

    fun `assert true on null fails`() {
        shouldFail {
            null.shouldBeTrue()
        }
    }
}