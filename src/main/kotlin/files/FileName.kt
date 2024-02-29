package files

import TestCase
import java.io.File

class FileName(val file: File) {
    fun nameWithoutExtension(): String {
        val fileName = file.name
        val lastDotIndex = fileName.lastIndexOf('.')
        if (lastDotIndex != -1) {
            return fileName.substring(0, lastDotIndex)
        }
        return file.name
    }

    fun extension(): String {
        if(file.name.contains('.')) {
            return file.name.split('.').last()
        }

        return ""
    }

    fun findTestCase(): Class<TestCase>? {
        if(file.isDirectory || file.exists().not()) {
            return null
        }

        val classFound = ClassLoader.getSystemClassLoader().loadClass("files.${nameWithoutExtension()}")
        return classFound as? Class<TestCase>
    }

    fun packageIn(sourceSet: String): String? {
        
    }


}
