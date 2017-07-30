/**
 * Created by yannickgrenzinger on 12/08/2016.
 */
object Pangrams {

    private val allLetters = CharRange('a', 'z').toSet()

    private fun buildSetOfLetterUsed(sentence: String): Set<Char> {
        return sentence.toCharArray().filter { allLetters.contains(it)  }.toSet()
    }

    fun isPangram(sentence: String): Boolean {
        return buildSetOfLetterUsed(sentence.toLowerCase()).size == 26
    }
}