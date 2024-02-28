package annotations

import TestCase
import assertions.matchers.shouldBeEqualTo

class TestAnnotationTest : TestCase() {
    @Test
    fun `finds only method in WasRun with Test annotation`() {
        val annotatedTestClass = AnnotatedTest::class.java
        val tests = TestFinder(annotatedTestClass).findTests()
        tests.size.shouldBeEqualTo(1)
        tests[0].testMethodName.shouldBeEqualTo("annotatedTest")
    }
}