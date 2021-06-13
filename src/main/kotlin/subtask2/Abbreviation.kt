package subtask2

class Abbreviation {

    fun abbreviationFromA(a: String, b: String): String {
        return if (a.toUpperCase().filter { it in b }.contains(b)) {
            "YES"
        } else "NO"
    }
}
