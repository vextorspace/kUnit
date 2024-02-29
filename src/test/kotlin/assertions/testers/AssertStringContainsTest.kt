package assertions.testers

import TestCase
import annotations.Test
import assertions.AssertionFailedException.Companion.shouldFailWithMessage

class AssertStringContainsTest: TestCase {

    @Test
    fun `string contains itself`() {
        AssertStringContains("::Any Old String::", "::Any Old String::").test()
    }

    @Test
    fun `string contains a single letter in it`() {
        AssertStringContains("::Any Old String::", "O").test()
    }

    @Test
    fun `string does not contain some other string`() {
        shouldFailWithMessage("[XYZ] was not found in [::Any Old String::]"){
            AssertStringContains("::Any Old String::", "XYZ").test()
        }
    }
}