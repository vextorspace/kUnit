package assertions.matchers

import TestCase
import annotations.Test
import assertions.AssertionFailedException
import assertions.AssertionFailedException.Companion.shouldFail

class AssertSimilarStringTest : TestCase() {

    @Test
    fun `same string is similar`() {
        val theString = "::ANY OL' STRING::"
        theString.shouldBeSimilarTo(theString)
    }

    @Test
    fun `string with missing a letter is not similar to another`() {
        val theString = "::Any ol' string::"
        val theOtherString = "::Any ol' sting::"

        shouldFail {
            theString.shouldBeSimilarTo(theOtherString)
            theOtherString.shouldBeSimilarTo(theString)
        }
    }

    @Test
    fun `string differing only in case`() {
        val theString: String = "::Any ol' string::"
        val theOtherString: String = "::ANY OL' STRING::"

        theString.shouldBeSimilarTo(theOtherString)
        theOtherString.shouldBeSimilarTo(theString)
    }

    @Test
    fun `string has different spacing`() {
        val theString: String = "::Any ol' string::"
        val theOtherString: String = "::Any ol' string ::"

        theString.shouldBeSimilarTo(theOtherString)
        theOtherString.shouldBeSimilarTo(theString)
    }

    @Test
    fun `string has different non-alpha-numeric characters`() {
        val theString: String = "::Any ol' string::"
        val theOtherString: String = "::Any ol' string!!::"

        theString.shouldBeSimilarTo(theOtherString)
        theOtherString.shouldBeSimilarTo(theString)
    }

    @Test
    fun `exception should enclose strings in parenthesis`() {
        val theString = "::One String::"
        val expected = "::Other String::"

        try {
            theString.shouldBeSimilarTo(expected)
        } catch (exception: AssertionFailedException) {
            exception.message.shouldBeEqualTo("expected: [$expected] but was: [$theString]")
        }
    }
}