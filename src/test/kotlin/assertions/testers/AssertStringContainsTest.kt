package assertions.testers

import TestCase
import annotations.Test
import assertions.AssertionFailedException.Companion.shouldFailWithMessage
import assertions.testers.AssertStringContains.Companion.assertContains

class AssertStringContainsTest: TestCase {

    @Test
    fun `string contains itself`() {
        "::Any Old String::".shouldContain("::Any Old String::")
    }

    @Test
    fun `string contains a single letter in it`() {
        "::Any Old String::".shouldContain("O")
    }

    @Test
    fun `string does not contain some other string`() {
        shouldFailWithMessage("[XYZ] was not found in [::Any Old String::]"){
            "::Any Old String::".shouldContain("XYZ")
        }
    }
}