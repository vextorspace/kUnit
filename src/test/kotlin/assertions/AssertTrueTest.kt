package assertions

import TestCase

class AssertTrueTest : TestCase() {

    fun `assert true on true passes`() {
        true.shouldBeTrue()
    }

    fun `assert true on false fails`() {
        Assertions.shouldFail {
            false.shouldBeTrue()
        }
    }

    fun `assert true on null fails`() {
        Assertions.shouldFail {
            null.shouldBeTrue()
        }
    }
}