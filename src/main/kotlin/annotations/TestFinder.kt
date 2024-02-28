package annotations

import TestCase
import TestRunner
import java.lang.reflect.Method

class TestFinder<T>(val testClass: Class<T>) {

    fun findTests(): List<TestRunner> {
        return testClass.methods
            .filter { it.isAnnotationPresent(Test::class.java) }
            .map { testRunnerFromMethod(it) }
            .filterNotNull()
            .toList()
    }

    private fun testRunnerFromMethod(method: Method): TestRunner? {
        return (testCaseFromMethod(method))?.let { TestRunner(it, method.name) }
    }

    private fun testCaseFromMethod(method: Method): TestCase? {
        return method.declaringClass
            .getConstructor()
            ?.newInstance()
                as? TestCase
    }

}
