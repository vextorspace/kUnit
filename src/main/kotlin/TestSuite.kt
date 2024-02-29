import annotations.TestFinder
import files.FileName
import java.io.File

class TestSuite {

    private val testRunners = mutableListOf<TestRunner>()

    fun testRunners() : List<TestRunner> {
        return testRunners.toList()
    }

    fun add(test: TestRunner) {
        testRunners.add(test)
    }

    fun runTests(results: TestResults) {
        testRunners().forEach { it.run(results) }
    }

    fun <T> addAll(classToSearch: Class<T>) {
        testRunners.addAll(TestFinder<T>(classToSearch).findTests())
    }

    fun addAllIn(packageRoot: String, sourceSet: String) {
        val file = File(sourceSet)
        if(file.isDirectory) {
            file.listFiles().forEach { addAllIn(File(packageRoot).absolutePath, it.absolutePath) }
        } else {
            val packageName = FileName(file).packageIn(packageRoot)?.let {
                it + "."
            } ?: ""

            val testCaseClass: Class<TestCase>? = FileName(file).findTestCase(packageName)
            testCaseClass?.let {
                testRunners.addAll(TestFinder<TestCase>(it).findTests())
            }
            testRunners.addAll(TestFinder<TestRunner>(TestRunner::class.java).findTests())
        }
    }
}
