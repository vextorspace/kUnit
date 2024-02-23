package assertions

abstract class Assertion {

    abstract fun test(): Unit

    abstract fun errorMessage(): String?

    fun throwException(message: String?) {
        throw AssertionFailedException(message)
    }
}

