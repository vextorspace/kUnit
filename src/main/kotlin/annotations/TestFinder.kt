package annotations

import TestCase
import java.lang.reflect.Method

class TestFinder<T>(val clazz: Class<T>) {

    fun findTests(): List<TestCase> {
        return clazz.methods.filter { it.isAnnotationPresent(Test::class.java) }
            .map { testCaseFromMethod(it) }
            .filterNotNull()
            .toList()
    }

    private fun testCaseFromMethod(it: Method): TestCase? {
        return it.declaringClass
            .getConstructor(String::class.java)
            ?.newInstance(it.name)
                as? TestCase
    }

}
