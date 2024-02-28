package files

import TestCase
import annotations.Test
import assertions.testers.shouldNotBeNull
import java.io.File

class FileNameToClassTest: TestCase {

    @Test
    fun `can find this test`() {
        val thisClassFound = FileName(File("src/test/files/FileNameToClassTest.kt")).findTestCase()
        (thisClassFound as? Class<FileNameToClassTest>).shouldNotBeNull()
    }
}