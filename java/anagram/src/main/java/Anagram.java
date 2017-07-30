import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Anagram {
    private final String word;
    private final Map<Character, Long> frequencies;

    public Anagram(String word) {
        this.word = word.toLowerCase();
        this.frequencies = buildFrequencies(this.word);
    }

    public List<String> match(List<String> words) {
        return words.stream().filter(this::isAnagram).collect(Collectors.toList());
    }

    private Map<Character, Long> buildFrequencies(String w) {
        return w.chars()
                .mapToObj(i -> (char)i)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting())
                );
    }

    private boolean isAnagram(String w) {
        String lw = w.toLowerCase();
        return !lw.equals(word) && buildFrequencies(lw).equals(frequencies);
    }
}
