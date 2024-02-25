package classes.dirwithoutatest

import TestCase
import annotations.Test

class RandomClassWhichTestIsNotTheLastWord(testMethodName: String) : TestCase(testMethodName) {

    @Test
    fun `random test`() {}
}