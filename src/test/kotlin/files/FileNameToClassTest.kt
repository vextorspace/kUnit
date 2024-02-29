package files

import TestCase
import annotations.Test
import assertions.matchers.shouldBeEqualTo
import assertions.testers.shouldBeNull
import assertions.testers.shouldNotBeNull
import java.io.File

class FileNameToClassTest: TestCase {

    @Test
    fun `does not find the class if the file does not exist`() {
        val thisClassFound = FileName(File("src/test/kotlin/FileNameToClassTest.kt")).findTestCase()
        (thisClassFound as? Class<FileNameToClassTest>).shouldBeNull()
    }

    @Test
    fun `can find this test`() {
        val thisClassFound = FileName(File("src/test/kotlin/files/FileNameToClassTest.kt")).findTestCase()
        (thisClassFound as? Class<FileNameToClassTest>).shouldNotBeNull()
    }

    @Test
    fun `finds the package given sourceset and file`() {
        val sourceSet: String = "src/test/kotlin/"
        val packageOfClass = FileName(File("src/test/kotlin/files/FileNameToClassTest.kt")).packageIn(sourceSet)
        packageOfClass.shouldBeEqualTo("files")
    }
}