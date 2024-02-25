class TestResults {
    val logs = mutableListOf<String>()

    fun summary(): String {
        val numFailed = logs.filter { it.contains("--failed--") }.count()
        return "$=== ${logs.size} run, $numFailed failed ==="
    }
}
