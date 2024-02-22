package assertions

import TestCase

class AssertSimilarStringTest : TestCase() {

    fun `same string is similar`() {
        val theString = "::ANY OL' STRING::"
        Assertions.assertSimilar(theString, theString)
    }

    fun `string with missing a letter is not similar to another`() {
        val theString = "::Any ol' string::"
        val theOtherString = "::Any ol' sting::"

        Assertions.shouldFail {
            Assertions.assertSimilar(theString, theOtherString)
            Assertions.assertSimilar(theOtherString, theString)
        }
    }
}