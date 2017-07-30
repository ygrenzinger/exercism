/**
 * Created by yannickgrenzinger on 11/08/2016.
 */
object RnaTranscription {

    private fun convertStrand(strand: Char) : Char {
        return when(strand) {
            'G'  -> 'C'
            'C'  -> 'G'
            'T'  -> 'A'
            'A'  -> 'U'
            else -> throw Exception("This DNA strand is unknown")
        }
    }

    fun  ofDna(dna: String): String {
        return dna.map { convertStrand(it) }.joinToString("")
    }
}