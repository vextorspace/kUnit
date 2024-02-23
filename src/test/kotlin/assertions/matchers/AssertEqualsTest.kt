package assertions.matchers

import TestCase
import assertions.AssertionFailedException
import assertions.Assertions
import assertions.matchers.Matchers.assertEquals
import assertions.testers.Testers.assertFalse
import assertions.testers.Testers.assertTrue

class AssertEqualsTest : TestCase() {
    fun `two different objects are not equal`() {
        val object1 = listOf<String>()
        val object2 = listOf<String>("hi")


        Assertions.shouldFail {
            object2.shouldBeEqualTo(object1)
        }
    }

    fun `two objects that are the same reference are equal`() {
        val object1: List<String> = listOf<String>("hi")
        val object2: List<String> = object1
        object2.shouldBeEqualTo(object1)
    }

    fun `two objects that are different type are not equal`() {
        val object1 = listOf<String>()
        val other = "::Not a List::"

        Assertions.shouldFail {
            other.shouldBeEqualTo(object1)
        }
    }

    fun `equals failure message puts both values in string format in square brackets`() {
        val expected = "::A String::"
        val secondObject = 123

        try {
            secondObject.shouldBeEqualTo(expected)
        } catch (ex: AssertionFailedException) {
            ex.message!!.shouldBeEqualTo("expected: [$expected] but was: [$secondObject]")
        }
    }

    fun `two value objects with same value are equal`() {
        val object1 = TestValueObject("bob")
        val other = TestValueObject("bob")

        assertTrue(object1 == other)
        assertFalse(object1  === other)

        other.shouldBeEqualTo(object1)
    }
}

data class TestValueObject(val thing:String){}