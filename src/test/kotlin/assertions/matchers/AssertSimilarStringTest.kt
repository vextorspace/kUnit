package assertions.matchers

import TestCase
import assertions.AssertionFailedException
import assertions.Assertions
import assertions.testers.Testers.assertTrue

class AssertSimilarStringTest : TestCase() {

    fun `same string is similar`() {
        val theString = "::ANY OL' STRING::"
        theString.shouldBeSimilarTo(theString)
    }

    fun `string with missing a letter is not similar to another`() {
        val theString = "::Any ol' string::"
        val theOtherString = "::Any ol' sting::"

        Assertions.shouldFail {
            theString.shouldBeSimilarTo(theOtherString)
            theOtherString.shouldBeSimilarTo(theString)
        }
    }

    fun `string differing only in case`() {
        val theString: String = "::Any ol' string::"
        val theOtherString: String = "::ANY OL' STRING::"

        theString.shouldBeSimilarTo(theOtherString)
        theOtherString.shouldBeSimilarTo(theString)
    }

    fun `string has different spacing`() {
        val theString: String = "::Any ol' string::"
        val theOtherString: String = "::Any ol' string ::"

        theString.shouldBeSimilarTo(theOtherString)
        theOtherString.shouldBeSimilarTo(theString)
    }

    fun `string has different non-alpha-numeric characters`() {
        val theString: String = "::Any ol' string::"
        val theOtherString: String = "::Any ol' string!!::"

        theString.shouldBeSimilarTo(theOtherString)
        theOtherString.shouldBeSimilarTo(theString)
    }

    fun `exception should enclose strings in parenthesis`() {
        val theString = "::One String::"
        val otherString = "::Other String::"

        try {
            theString.shouldBeSimilarTo(otherString)
        } catch (exception: AssertionFailedException) {
            exception.message.shouldBeEqualTo("($theString) should be similar to ($otherString)")
        }
    }
}