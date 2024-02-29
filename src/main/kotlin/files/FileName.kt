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
        return stripFirstAndLastFileSep(subPath(sourceSet, file.parentFile))?.replace(File.separator, ".")
    }

    private fun stripFirstAndLastFileSep(path: String?): String? {
        if(path == null) {
            return null
        }

        var newPath = path
        if(newPath.startsWith(File.separator)) {
            newPath = newPath.drop(1)
        }

        if(newPath.endsWith(File.separator)) {
            newPath = newPath.dropLast(1)
        }
        return newPath
    }

    fun subPath(sourceSet: String, subFile: File): String? {
        val sourceSetPath = File(sourceSet).absolutePath
        val filePath = subFile.absolutePath
        if(filePath.startsWith(sourceSetPath).not()) {
            return null
        }
        return filePath.substringAfter(sourceSetPath ?: "").substringBeforeLast("/")
    }

}
