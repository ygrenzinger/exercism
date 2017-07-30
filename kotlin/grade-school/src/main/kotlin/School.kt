import java.util.*

/**
 * Created by yannickgrenzinger on 23/08/2016.
 */
class School {
    val db: MutableMap<Int, List<String>> = mutableMapOf()

    fun db(): Map<Int, List<String>> {
        return db
    }

    fun add(student: String, grade: Int) {
        val addedStudentToGrade = db.getOrElse(grade) { emptyList() }.plus(student)
        db.put(grade, addedStudentToGrade)
    }

    fun  grade(grade: Int): List<String> {
        return db.getOrElse(grade) { emptyList() }
    }

    fun sort(): Map<Int, List<String>> {
        return db.mapValues { it.value.sorted() }.toSortedMap()
    }


}