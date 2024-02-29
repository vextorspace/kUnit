package assertions.testers

import assertions.Assertion

class AssertStringContains(val theString: String, val toFind: String): Assertion() {
    override fun test() {
        if(theString.contains(toFind).not()) {
            throwException(errorMessage())
        }
    }

    override fun errorMessage(): String {
        return "[$toFind] was not found in [$theString]"
    }
}