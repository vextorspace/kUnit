package assertions.testers

import TestCase
import assertions.AssertionFailedException.Companion.shouldFail

class AssertFalseTest(testMethodName: String) : TestCase(testMethodName) {
    fun `assert false on true fails`() {
        shouldFail {
            true.shouldBeFalse()
        }
    }

    fun `assert false on false passes`() {
        false.shouldBeFalse()
    }

    fun `assert false on null fails`() {
        shouldFail {
            null.shouldBeFalse()
        }
    }
}