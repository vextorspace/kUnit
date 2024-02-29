import annotations.TestAnnotationTest
import assertions.matchers.AssertEqualsTest
import assertions.matchers.AssertSimilarStringTest
import assertions.testers.AssertFalseTest
import assertions.testers.AssertNotNullTest
import assertions.testers.AssertNullTest
import assertions.testers.AssertTrueTest
import files.FileNameToClassTest
import files.FileNameWithoutExtensionTest

object Tests {
    @JvmStatic
    fun main(args: Array<String>) {
        val results = TestResults()

        val suite = TestSuite()

        suite.addAllIn("src/test/kotlin", "src/test/kotlin")
        suite.runTests(results)

        results.printResults()
    }

}