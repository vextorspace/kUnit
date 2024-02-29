package assertions.testers

import TestCase
import WasRun
import annotations.Test
import assertions.matchers.shouldBeEqualTo

class AssertContainsTest: TestCase {

    @Test
    fun `collection with an object contains that object by reference`() {
        val theObject = WasRun()
        val collection = listOf(theObject)
        AssertContains(collection, theObject).test()
    }

    @Test
    fun `error message has the object and collection list`() {
        val theObject = "Fred"
        val collection = listOf("Bob", "Wilma")
        val assertion = AssertContains(collection, theObject)
        assertion.errorMessage().shouldBeEqualTo("[Fred] was not found in {Bob, Wilma}")
    }
}