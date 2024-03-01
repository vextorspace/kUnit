package assertions.testers

import assertions.Assertion
import assertions.testers.AssertCollectionContains.Companion.assertContains

class AssertCollectionContains(val collection: Collection<Any>, val theObject: Any?): Assertion() {
    override fun check(): Boolean {
        return collection.contains(theObject)
    }

    override fun errorMessage(): String {
        val theCollectionStr = collection.joinToString(", ")
        return "[$theObject] was not found in {$theCollectionStr}"
    }

    companion object {
        fun assertContains(collection: Collection<Any>, theObject: Any?) {
            AssertCollectionContains(collection, theObject).test()
        }
    }
}

fun Collection<Any>.shouldContain(expected: Any?) {
    assertContains(this, expected)
}