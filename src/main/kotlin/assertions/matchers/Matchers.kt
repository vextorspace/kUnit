package assertions.matchers

import assertions.Assertions
import java.lang.Character.isLetterOrDigit

object Matchers {

    fun assertEquals(expected: Any?, actual: Any?) {
        EqualsMatcher(expected, actual).testForEquality()
    }


    fun assertSimilar(underTest: String, expected: String) {
        if (checkIfSimilar(underTest, expected)) {
            Assertions.throwException("($underTest) should be similar to ($expected)")
        }
    }

    private fun checkIfSimilar(string1: String, string2: String) =
        reduceStringToImportantBits(string1) != reduceStringToImportantBits(string2)

    private fun reduceStringToImportantBits(string1: String): String {
        return string1.lowercase().filter { isLetterOrDigit(it) }
    }
}

fun String.shouldBeSimilarTo(expected: String) : String {
    Matchers.assertSimilar(this, expected)
    return this
}

fun Any?.shouldBeEqualTo(expected: Any?): Any? {
    Matchers.assertEquals(expected, this)
    return this
}