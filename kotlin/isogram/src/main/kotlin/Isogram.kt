import java.text.Normalizer

/**
 * Created by yannickgrenzinger on 16/08/2016.
 */
object Isogram {

    fun isIsogram(s: String): Boolean {
        return !s.toLowerCase()
                .filter { it.isLetter() }
                .groupBy { it }
                .values.any { it.size > 1 }
    }

}