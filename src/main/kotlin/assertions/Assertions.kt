package assertions

import java.lang.Character.isLetterOrDigit

object Assertions {

    fun assertSimilar(string1: String, string2: String) {
        if (checkIfSimilar(string1, string2)) {
            throwException("($string1) should be similar to ($string2)")
        }
    }

    private fun checkIfSimilar(string1: String, string2: String) =
        reduceStringToImportantBits(string1) != reduceStringToImportantBits(string2)

    private fun reduceStringToImportantBits(string1: String): String {
        return string1.lowercase().filter { isLetterOrDigit(it) }
    }

    fun shouldFail(function: () -> Unit) {
        try {
            function.invoke()
            throw RuntimeException("Failed to catch bad assertion")
        } catch (ex: AssertionFailedException) {
        }
    }


    fun throwException(message: String) {
        throw AssertionFailedException(message)
    }
}