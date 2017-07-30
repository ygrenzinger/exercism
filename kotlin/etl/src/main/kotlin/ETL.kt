/**
 * Created by yannickgrenzinger on 09/08/2016.
 */
object ETL {
    fun transform(previous: Map<Int, List<String>>): Map<String, Int>? {
        return previous
                .flatMap { it -> it.value.map { word -> Pair(word.toLowerCase(), it.key) } }
                .associateBy({it.first}, {it.second})
    }


}