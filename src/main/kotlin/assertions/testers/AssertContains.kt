package assertions.testers

import assertions.Assertion
import assertions.testers.AssertContains.Companion.assertContains

class AssertContains(val collection: Collection<Any>, val theObject: Any?): Assertion() {
    override fun test() {
        if(collection.contains(theObject).not()) {
            throwException(errorMessage())
        }
    }

    override fun errorMessage(): String {
        val theCollectionStr = collection.joinToString(", ")
        return "[$theObject] was not found in {$theCollectionStr}"
    }

    companion object {
        fun assertContains(collection: Collection<Any>, theObject: Any?) {
            AssertContains(collection, theObject).test()
        }
    }
}

fun Collection<Any>.shouldContain(expected: Any?) {
    assertContains(this, expected)
}