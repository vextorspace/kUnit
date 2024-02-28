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
        val file: File = File("randomNameWith.$extension")
        FileName(file).nameWithoutExtension().shouldBeEqualTo("randomNameWith")
    }
}