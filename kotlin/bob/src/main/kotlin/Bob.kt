/**
 * Created by yannickgrenzinger on 16/08/2016.
 */
object Bob {

    fun hey(sentence: String): String {
        return when {
            sentence.matches(Regex("\\s*")) -> "Fine. Be that way!"
            sentence.matches(Regex("[^a-z-A-Z]+(?<!\\?)$")) -> "Whatever."
            sentence.matches(Regex("[^a-z-A-Z]+?$")) -> "Sure."
            sentence.matches(Regex("^[^\\p{Ll}]+$")) -> "Whoa, chill out!"
            sentence.matches(Regex("^(.*)\\?$")) -> "Sure."
            else -> "Whatever."
        }
    }


}