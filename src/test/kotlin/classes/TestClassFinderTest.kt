package classes

import TestCase
import annotations.Test
import assertions.matchers.shouldBeEqualTo
import java.io.File

class TestClassFinderTest(testMethodName: String): TestCase(testMethodName) {

    @Test
    fun `does not find any tests in dir without any classes ending in test`() {
        val testClassFinder = TestClassFinder(TestFiles.resourceAsFile("/classes/dirwithoutatest"))
        val testClasses = testClassFinder.findTestCases()
        testClasses.size.shouldBeEqualTo(0)
    }
}