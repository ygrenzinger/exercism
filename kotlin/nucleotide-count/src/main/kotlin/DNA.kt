/**
 * Created by yannickgrenzinger on 16/08/2016.
 */
class DNA(val dna: String) {
    val nucleotides = setOf('A', 'C', 'G', 'T')
    val existingNucleotides = dna.associate { it to count(it) }
    val nucleotideCounts = nucleotides.associate { it to existingNucleotides.getOrElse(it) { 0 } }

    init {
        if (existingNucleotides.keys.any { !nucleotides.contains(it) }) {
            throw IllegalArgumentException()
        }
    }

    fun count(nucleotide: Char): Int {
        if (!nucleotides.contains(nucleotide)) throw IllegalArgumentException()
        return dna.count { it.equals(nucleotide) }
    }
}