import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class DNA {
    private final List<Character> nucleotides = Arrays.asList('A', 'C', 'G', 'T');
    private final Map<Character, Integer> nucleotidesFrequencies;

    public DNA(String value) {
        final Map<Character, Long> foundNucleotides = value.chars()
                .mapToObj(i -> (char) i)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()

                ));
        nucleotidesFrequencies = nucleotides.stream().collect(Collectors.toMap(
                Function.identity(),
                character -> foundNucleotides.getOrDefault(character, 0L).intValue()
        ));

    }

    public long count(char a) {
        if (!nucleotides.contains(a)) throw new IllegalArgumentException(a + " is not a nucleotide");
        return nucleotidesFrequencies.get(a);
    }

    public Map<Character, Integer> nucleotideCounts() {
        return nucleotidesFrequencies;
    }
}
