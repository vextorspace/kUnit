package assertions.matchers

import assertions.Assertions
import java.lang.Character.isLetterOrDigit

object Matchers {

    fun assertEquals(expected: Any?, actual: Any?) {
        EqualsMatcher(expected, actual).testForEquality()
    }


    fun assertSimilar(underTest: String, expected: String) {
        SimilarMatcher(expected, underTest).testForSimilarity()
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