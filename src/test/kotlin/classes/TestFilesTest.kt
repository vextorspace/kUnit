package classes

import TestCase
import annotations.Test
import assertions.matchers.shouldBeEqualTo

class TestFilesTest(testMethodName: String): TestCase(testMethodName) {

    @Test
    fun `resource that does not exist gives null file`() {
        TestFiles.resourceAsFile("/nonexistentpath")
            .shouldBeEqualTo(null)

    }

}
