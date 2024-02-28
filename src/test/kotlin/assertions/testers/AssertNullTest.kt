package assertions.testers

import TestCase
import annotations.Test
import assertions.AssertionFailedException

class AssertNullTest: TestCase {

    @Test
    fun `null object does not fail`() {
        null.shouldBeNull()
    }

    @Test
    fun `non-null fails`() {
        AssertionFailedException.shouldFail {
            1.shouldBeNull()
        }
    }
}