import annotations.Test
import annotations.TestAnnotationTest
import annotations.TestFinder
import assertions.matchers.AssertEqualsTest
import assertions.matchers.AssertSimilarStringTest
import assertions.testers.AssertFalseTest
import assertions.testers.AssertTrueTest

object Tests {
    @JvmStatic
    fun main(args: Array<String>) {
        val results = TestResults()

        val suite = TestSuite()
        suite.addAll(TestCaseTest::class.java)
        suite.addAll(AssertTrueTest::class.java)
        suite.addAll(AssertFalseTest::class.java)
        suite.addAll(AssertSimilarStringTest::class.java)
        suite.addAll(AssertEqualsTest::class.java)
        suite.addAll(TestResultsTest::class.java)
        suite.addAll(TestSuiteTest::class.java)
        suite.addAll(TestAnnotationTest::class.java)

        suite.run(results)

        results.printResults()
    }

}