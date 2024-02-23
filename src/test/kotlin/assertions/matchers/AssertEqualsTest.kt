package assertions.matchers

import TestCase
import assertions.AssertionFailedException
import assertions.Assertions
import assertions.matchers.Matchers.assertEquals
import assertions.testers.Testers.assertFalse

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

    fun `two objects that are different type are not equal`() {
        val object1 = listOf<String>()
        val other = "::Not a List::"

        Assertions.shouldFail {
            assertEquals(object1, other)
        }
    }

    fun `equals failure message puts both values in string format in square brackets`() {
        val expected = "::A String::"
        val secondObject = 123

        try {
            secondObject.shouldBeEqualTo(expected)
            assertEquals(expected, secondObject)
        } catch (ex: AssertionFailedException) {
            assertEquals("expected: [$expected] but was: [$secondObject]", ex.message!!)
        }
    }

    fun `two value objects with same value are equal`() {
        val object1 = "::A String::"
        val other = "$object1"
        assertFalse(object1  == other)

        assertEquals(object1, other)
    }
}