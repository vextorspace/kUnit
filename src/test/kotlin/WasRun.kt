import assertions.AssertionFailedException

class WasRun(testMethodName: String) : TestCase(testMethodName) {
    fun testMethod() {

    }

    fun testMethod2() {

    }

    fun testFailedMethod() {
        throw RuntimeException("Test failed")
    }
}