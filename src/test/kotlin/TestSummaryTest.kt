import assertions.matchers.shouldBeEqualTo
import assertions.matchers.shouldBeSimilarTo

class TestSummaryTest : TestCase(){

    fun `collects logs of all tests run`() {
        val summary = TestSummary()
        WasRun().run("testMethod", summary)
        WasRun().run("testMethod2", summary)

        summary.logs.size.shouldBeEqualTo(2)
        if (summary.logs[0].contains("testMethod2")) {
            summary.logs[0].shouldBeSimilarTo("setUp testMethod2 passed tearDown")
            summary.logs[1].shouldBeSimilarTo("setUp testMethod passed tearDown")
        } else {
            summary.logs[0].shouldBeSimilarTo("setUp testMethod passed tearDown")
            summary.logs[1].shouldBeSimilarTo("setUp testMethod2 passed tearDown")
        }
    }
}