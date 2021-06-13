package subtask3

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import kotlin.reflect.KClass

class Blocks {

    fun getData(blockA: Array<*>, blockB: KClass<*>): Any {
        return when (blockB) {
            String::class -> {
                val result = StringBuffer()
                blockA.filterIsInstance<String>().forEach { result.append(it) }
                return result.toString()
            }
            Int::class -> blockA.filterIsInstance<Int>().sum()
            LocalDate::class -> findClosestDate(blockA)
            else -> "Incorrect filter type"
        }
    }
}

private fun dateToInt(date: LocalDate): Int {
    return date.format(DateTimeFormatter.ofPattern("yyyyMMdd")).toString().toInt()
}

private fun findClosestDate(blockA: Array<*>): String {

    val sortedSet = blockA.filterIsInstance<LocalDate>().toSortedSet()

    return when {
        sortedSet.isEmpty() -> "blockA is empty"
        sortedSet.size == 1 -> sortedSet.first().format(DateTimeFormatter.ofPattern("dd.MM.yyyy"))
            .toString()
        else -> {
            val currentDay = LocalDate.now()
            lateinit var result: LocalDate

            sortedSet.add(currentDay)

            when (currentDay) {
                sortedSet.last() -> {
                    result = sortedSet.elementAt(sortedSet.size - 2)
                }
                sortedSet.first() -> {
                    result = sortedSet.elementAt(1)
                }
                else -> {
                    val currentDayIndex = sortedSet.indexOf(currentDay)
                    val closestPastDate = sortedSet.elementAt(currentDayIndex - 1)
                    val closestFutureDate = sortedSet.elementAt(currentDayIndex + 1)

                    result = if (Math.abs(dateToInt(closestPastDate) - dateToInt(currentDay)) <
                        Math.abs(dateToInt(closestFutureDate) - dateToInt(currentDay))
                    ) closestPastDate else closestFutureDate
                }

            }
            result.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")).toString()
        }
    }
}