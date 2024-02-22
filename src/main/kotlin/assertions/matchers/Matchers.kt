package assertions.matchers

import assertions.Assertions
import java.lang.Character.isLetterOrDigit

object Matchers {

    fun assertEquals(object1: Any, other: Any) {
        if(object1 != other)
            Assertions.throwException("$object1 does not equal $other")
    }

    fun assertSimilar(string1: String, string2: String) {
        if (checkIfSimilar(string1, string2)) {
            Assertions.throwException("($string1) should be similar to ($string2)")
        }
    }

    private fun checkIfSimilar(string1: String, string2: String) =
        reduceStringToImportantBits(string1) != reduceStringToImportantBits(string2)

    private fun reduceStringToImportantBits(string1: String): String {
        return string1.lowercase().filter { isLetterOrDigit(it) }
    }
}

fun String.shouldBeSimilarTo(other: String) : String {
    Matchers.assertSimilar(this, other)
    return this
}