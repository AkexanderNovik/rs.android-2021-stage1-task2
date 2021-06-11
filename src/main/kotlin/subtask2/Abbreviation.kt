package subtask2

class Abbreviation {

    fun abbreviationFromA(a: String, b: String): String {
        if (a.toUpperCase().filter { it in b }.contains(b)) {
            return "YES"
        } else return "NO"
    }
}
