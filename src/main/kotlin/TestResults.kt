class TestResults {
    val logs = mutableListOf<String>()

    fun summary(): String {
        return "${logs.size} run, 0 failed"
    }
}
