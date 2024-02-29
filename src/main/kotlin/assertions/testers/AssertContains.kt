package assertions.testers

import assertions.Assertion

class AssertContains(val collection: List<Any>, val theObject: Any?): Assertion() {
    override fun test() {

    }

    override fun errorMessage(): String {
        val theCollectionStr = collection.joinToString(", ")
        return "[$theObject] was not found in {$theCollectionStr}"
    }
}
