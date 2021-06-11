package subtask3

import java.time.LocalDate
import kotlin.reflect.KClass

class Blocks {

    fun getData(blockA: Array<*>, blockB: KClass<*>): Any {
        return when (blockB.simpleName) {
            "String" -> {var z = StringBuffer()
                blockA.filterIsInstance<String>()
                    .forEach{z.append(it)}
                z}
            "Int" ->  blockA.filterIsInstance<Int>().sum()
            "LocalDate" -> blockA.filterIsInstance<LocalDate>()
            else -> "Incorrect filter type"
        }
    }
}
