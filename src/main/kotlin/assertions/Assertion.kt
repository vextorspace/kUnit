package assertions

abstract class Assertion {

    fun test() {
        if (!check()) {
            throwException(errorMessage())
        }
    }

    abstract fun check(): Boolean

    abstract fun errorMessage(): String

    fun throwException(message: String) {
        throw AssertionFailedException(message)
    }
}

