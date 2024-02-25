package classes.dirwithatest

import TestCase
import annotations.Test

class RandomClassWhoseNameEndsInTest(testMethodName: String) : TestCase(testMethodName) {
    @Test
    fun `random test`() {}
}