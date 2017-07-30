/**
 * Created by yannickgrenzinger on 16/08/2016.
 */
object Hamming {
    fun compute(a: String, b: String): Int {
        if (a.length != b.length) throw IllegalArgumentException()
        return a.zip(b).count { !it.first.equals(it.second) }
    }
}