/**
 * Created by yannickgrenzinger on 11/08/2016.
 */
class Anagram(word: String) {
    val lowerCaseWord = word.toLowerCase()
    val frequencies = buildFrequencies(lowerCaseWord)

    fun match(words: List<String>): List<String> {
        return words.filter { isAnagram(it) }
    }

    private fun isAnagram(w: String): Boolean {
        return !w.toLowerCase().equals(lowerCaseWord)
                && frequencies.equals(buildFrequencies(w.toLowerCase()))
    }

    private fun buildFrequencies(w: String): Map<Char, Int> {
        return w.groupBy { it }
                .mapValues { it.value.count() }
    }
}