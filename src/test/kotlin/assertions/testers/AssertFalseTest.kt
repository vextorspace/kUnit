package assertions.testers

import TestCase
import annotations.Test
import assertions.AssertionFailedException.Companion.shouldFail

class AssertFalseTest : TestCase() {
    @Test
    fun `assert false on true fails`() {
        shouldFail {
            true.shouldBeFalse()
        }
    }

    @Test
    fun `assert false on false passes`() {
        false.shouldBeFalse()
    }

    @Test
    fun `assert false on null fails`() {
        shouldFail {
            null.shouldBeFalse()
        }
    }
}