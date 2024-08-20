import java.io.File

fun main() {
    val path = readln()
    try {
        formatResources(path)
    } catch (e: Exception) {
        println(e.message)
    }
}

fun formatResources(path: String) {
    val directory = File(path)
    if (!directory.isDirectory) throw Exception("This is not a directory")
    directory.listFiles()?.forEach { file ->
        var newName: String = file.nameWithoutExtension.lowercase()
        newName = removeSpacesAndNonNumericChars(newName)
        val newPath = "${file.parentFile.path}\\$newName.${file.extension}"
        file.renameTo(File(newPath))
    }
}

fun removeSpacesAndNonNumericChars(fileName: String): String {
    return fileName
            .replace(' ', '_')
            .replace("[^a-zA-Z0-9]".toRegex(), "_")
}
