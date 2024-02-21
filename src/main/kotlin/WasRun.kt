class WasRun(testMethod: String): TestCase(testMethod) {
    var wasRun: Boolean? = null

    fun `was run reports if function was run`() {
        val test = WasRun("testMethod")
        println(test.wasRun)
        test.run()
        println(test.wasRun)
    }


    fun testMethod(): Unit {
        wasRun = true
    }
}