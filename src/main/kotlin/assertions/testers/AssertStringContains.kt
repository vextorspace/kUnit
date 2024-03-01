package assertions.testers

import assertions.Assertion
import assertions.testers.AssertStringContains.Companion.assertContains

class AssertStringContains(val theString: String, val toFind: String?): Assertion() {
    override fun check(): Boolean {
        return !toFind.isNullOrBlank() && theString.contains(toFind)
    }

    override fun errorMessage(): String {
        return "[$toFind] was not found in [$theString]"
    }

    companion object {
        fun assertContains(theString: String, toFind: String?){
            AssertStringContains(theString, toFind).test()
        }
    }
}

fun String.shouldContain(toFind: String?) {
    assertContains(this, toFind)
}