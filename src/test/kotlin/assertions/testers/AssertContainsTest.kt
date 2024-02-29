package assertions.testers

import TestCase
import WasRun
import annotations.Test
import assertions.AssertionFailedException.Companion.shouldFailWithMessage

class AssertContainsTest: TestCase {

    @Test
    fun `collection with an object contains that object by reference`() {
        val theObject = WasRun()
        val collection = listOf(theObject)
        collection.shouldContain(theObject)
    }

    @Test
    fun `collection without an object fails`() {
        val theObject = "Fred"
        val collection = listOf("Bob", "Wilma")
        shouldFailWithMessage("[Fred] was not found in {Bob, Wilma}") {
            collection.shouldContain(theObject)
        }
    }

    @Test
    fun `collection with same value object suceeds`() {
        val theObject = TheRecord("Fred")
        val collection: List<TheRecord> = listOf(TheRecord("Bob"), TheRecord("Wilma"), TheRecord("Fred"))
        collection.shouldContain(theObject)
    }

    @Test
    fun `null object is not contained in collection without a null`() {
        val theObject = null
        val collection: List<TheRecord> = listOf(TheRecord("Bob"), TheRecord("Wilma"), TheRecord("Fred"))

        shouldFailWithMessage("[null] was not found in {Bob, Wilma, Fred}") {
            collection.shouldContain(theObject)
        }
    }

    data class TheRecord(val string: String) {
        override fun toString(): String {
            return string
        }
    }
}