package assertions.testers

import TestCase
import assertions.Assertions

class AssertFalseTest: TestCase() {
    fun `assert false on true fails`() {
        Assertions.shouldFail {
            true.shouldBeFalse()
        }
    }

    fun `assert false on false passes`() {
        false.shouldBeFalse()
    }

    fun `assert false on null fails`() {
        Assertions.shouldFail {
            null.shouldBeFalse()
        }
    }
}