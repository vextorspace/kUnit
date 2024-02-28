package assertions.testers

import TestCase
import annotations.Test
import assertions.AssertionFailedException

class AssertNotNullTest: TestCase {

    @Test
    fun `null object should fail`() {
        AssertionFailedException.shouldFail {
            null.shouldNotBeNull()
        }
    }

    @Test
    fun `non-null passes`() {
        1.shouldNotBeNull()
    }
}