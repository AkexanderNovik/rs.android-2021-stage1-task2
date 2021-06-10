package subtask1

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

class DateFormatter {

    fun toTextDay(day: String, month: String, year: String): String {

        var value = "Такого дня не существует"
        try {
            var date = LocalDate.of(year.toInt(), month.toInt(), day.toInt())
            val localeRu = Locale("ru")
            value = date.format(DateTimeFormatter.ofPattern("dd MMMM, EEEE", localeRu))
        } catch (e: Exception) {
        }
        return value
    }
}
