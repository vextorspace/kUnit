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
        val thisClassFound = FileName(File("src/test/kotlin/FileNameToClassTest.kt")).findTestCase("")
        (thisClassFound as? Class<FileNameToClassTest>).shouldBeNull()
    }

    @Test
    fun `finds class in root`() {
        val thisClassFound = FileName(File("src/test/kotlin/WasRun")).findTestCase("")
        (thisClassFound as? Class<FileNameToClassTest>).shouldBeNull()
    }

    @Test
    fun `can find this test`() {
        val thisClassFound = FileName(File("src/test/kotlin/files/FileNameToClassTest.kt")).findTestCase("files")
        (thisClassFound as? Class<FileNameToClassTest>).shouldNotBeNull()
    }

    @Test
    fun `finds the package given sourceset and file`() {
        val sourceSet: String = "src/test/kotlin/"
        val packageOfClass = FileName(File("src/test/kotlin/files/FileNameToClassTest.kt")).packageIn(sourceSet)
        packageOfClass.shouldBeEqualTo("files")
    }

    @Test
    fun `finds the package given sourceset and file windows style`() {
        val sourceSet: String = """src\test\kotlin"""
        val packageOfClass = FileName(File("""src\test\kotlin\files\FileNameToClassTest.kt""")).packageIn(sourceSet)
        packageOfClass.shouldBeEqualTo("files")
    }



    @Test
    fun `package is empty when sourceset and root are the same`() {
        val sourceSet: String = "src/test/kotlin/"
        val packageOfClass = FileName(File("src/test/kotlin/WasRun.kt")).packageIn(sourceSet)
        packageOfClass.shouldBeEqualTo("")
    }

    @Test
    fun `package is empty when sourceset and root are the same when full paths used`() {
        val packageRoot = """C:\Users\vexto\repos\kunit\src\test\kotlin"""
        val sourceSet = """C:\Users\vexto\repos\kunit\src\test\kotlin\FailsToSetup.kt"""
        val packageOfClass: String? = FileName(File(sourceSet)).packageIn(packageRoot)
        packageOfClass.shouldBeEqualTo("")
    }
}