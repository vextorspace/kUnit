package files

import java.io.File

class FileName(val file: File) {
    fun nameWithoutExtension(): String {
        return file.name
    }

    fun extension(): String {
        if(file.name.contains('.')) {
            return file.name.split('.').last()
        }

        return ""
    }


}
