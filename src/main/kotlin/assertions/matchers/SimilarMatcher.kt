package assertions.matchers

import assertions.Assertion
import java.lang.Character.isLetterOrDigit

class SimilarMatcher(val expected: String?, val actual: String?) : Assertion() {
    override fun test() {
        if (checkIfSimilar(actual, expected)) {
            throwException(errorMessage())
        }
    }

    private fun checkIfSimilar(string1: String?, string2: String?): Boolean {
        return reduceStringToImportantBits(string1) != reduceStringToImportantBits(string2)
    }

    private fun reduceStringToImportantBits(string1: String?): String? {
        return string1?.lowercase()?.filter { isLetterOrDigit(it) }
    }

    override fun errorMessage() : String {
        return "expected: [$expected] but was: [$actual]"
    }

    companion object {
        fun assertSimilar(underTest: String, expected: String) {
            SimilarMatcher(expected, underTest).test()
        }
    }
}

fun String.shouldBeSimilarTo(expected: String) : String {
    SimilarMatcher.assertSimilar(this, expected)
    return this
}