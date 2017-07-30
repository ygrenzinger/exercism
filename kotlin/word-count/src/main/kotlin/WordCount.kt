/**
 * Created by yannickgrenzinger on 24/07/2016.
 */
object WordCount {

    fun phrase(sentence: String): Map<String, Int> {
        return sentence.replace(Regex("[^A-Za-z0-9\' ]"),"")
                .toLowerCase()
                .split(" ")
                .filter { w -> w.isNotBlank() }
                .groupBy { it }
                .mapValues { e -> e.value.count() }
    }
    
}