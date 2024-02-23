package assertions.matchers

import assertions.Assertions
import java.lang.Character.isLetterOrDigit

class SimilarMatcher(val expected: String?, val actual: String?) {
    fun testForSimilarity() {
        if (checkIfSimilar(actual, expected)) {
            Assertions.throwException(errorMessage())
        }
    }

    private fun checkIfSimilar(string1: String?, string2: String?): Boolean {
        return reduceStringToImportantBits(string1) != reduceStringToImportantBits(string2)
    }

    private fun oneNull(string1: String?, string2: String?) = string1 == null || string2 == null

    private fun areBothNull(string1: String?, string2: String?) = (string1 == null) && (string2 == null)


    private fun reduceStringToImportantBits(string1: String?): String? {
        return string1?.lowercase()?.filter { isLetterOrDigit(it) }
    }

    fun errorMessage() : String {
        return "expected: [$expected] but was: [$actual]"
    }

    companion object {
        fun assertSimilar(underTest: String, expected: String) {
            SimilarMatcher(expected, underTest).testForSimilarity()
        }
    }
}

fun String.shouldBeSimilarTo(expected: String) : String {
    SimilarMatcher.assertSimilar(this, expected)
    return this
}