package files

import TestCase
import annotations.Test
import assertions.matchers.shouldBeEqualTo
import java.io.File

class FileNameWithoutExtensionTest: TestCase {

    @Test
    fun `file name without extension gives name`() {
        val file = File("randomNameWithoutExtension")
        FileName(file).nameWithoutExtension().shouldBeEqualTo(file.name)
    }

    @Test
    fun `finds empty extension when no extension`() {
        val file = File("randomNameWithoutExtension")
        FileName(file).extension().shouldBeEqualTo("")
    }

    @Test
    fun `extension does not include the dot`() {
        val extension = "extension"
        val file = File("randomNameWith.$extension")
        FileName(file).extension().shouldBeEqualTo(extension)
    }

    @Test
    fun `file name with extension gives name without extension`() {
        val extension: String = "extension"
        val nameWithoutExtension = "randomNameWith"
        val file: File = File("$nameWithoutExtension.$extension")
        FileName(file).nameWithoutExtension().shouldBeEqualTo(nameWithoutExtension)
    }

    @Test
    fun `file with path does not put path in filename without extension`() {
        val extension: String = "extension"
        val nameWithoutExtension = "randomNameWith"
        val file: File = File("various/path/elements/$nameWithoutExtension.$extension")
        FileName(file).nameWithoutExtension().shouldBeEqualTo(nameWithoutExtension)
    }
}