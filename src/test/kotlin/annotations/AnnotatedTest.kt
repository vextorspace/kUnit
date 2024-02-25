package annotations

import TestCase

class AnnotatedTest(testMethod: String) : TestCase(testMethod) {

    @Test
    fun annotatedTest() {}

    fun notAnnotatedTest() {}
}