package assertions.matchers

import TestCase
import assertions.Assertions
import assertions.matchers.Matchers.assertEquals

class AssertEqualsTest : TestCase() {
    fun `two different objects are not equal`() {
        val object1 = listOf<String>()
        val object2 = listOf<String>("hi")


        Assertions.shouldFail {
            assertEquals(object1, object2)
        }
    }

    fun `two objects that are the same reference are equal`() {
        val object1: List<String> = listOf<String>("hi")
        val object2: List<String> = object1
        assertEquals(object1, object2)
    }
}