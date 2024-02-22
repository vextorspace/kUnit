package assertions

import TestCase

class AssertSimilarStringTest : TestCase() {

    fun `same string is similar`() {
        val theString = "::ANY OL' STRING::"
        Assertions.assertSimilar(theString, theString)
    }
}