import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WordCount {
    public Map<String, Integer> phrase(String sentence) {
        final String[] splittedSentence = sentence.replaceAll("[^a-zA-Z0-9 ]", "").split(" ");
        return Stream.of(splittedSentence)
                .filter(w -> !w.isEmpty())
                .map(String::toLowerCase)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.reducing(0, e -> 1, Integer::sum)
                ));
    }
}
