import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by yannickgrenzinger on 06/09/2016.
 */
public class Crypto {
    private final String text;

    public Crypto(String text) {
        this.text = text;
    }

    public String getNormalizedPlaintext() {
        return text.replaceAll("[^a-zA-Z0-9]*", "").toLowerCase();
    }

    public int getSquareSize() {
        return (int)Math.ceil(Math.sqrt(getNormalizedPlaintext().length()));
    }

    public List<String> getPlaintextSegments() {
        String remainingText = getNormalizedPlaintext();
        int splitSize = getSquareSize();
        List<String> result = new ArrayList<>();
        while (remainingText.length() > splitSize) {
            result.add(remainingText.substring(0, splitSize));
            remainingText = remainingText.substring(splitSize);
        }
        result.add(remainingText);
        return result;
    }

    public String getCipherText() {
        List<String> elmts = getPlaintextSegments();
        int colSize = elmts.get(0).length();
        String result = "";
        for (int colIdx = 0; colIdx < colSize; colIdx++) {
            for (String elmt : elmts) {
                if (colIdx < elmt.length()) {
                    result += String.valueOf(elmt.charAt(colIdx));
                }
            }
        }
        return result;
    }

    public String getNormalizedCipherText() {
        List<String> elmts = getPlaintextSegments();
        int colSize = elmts.get(0).length();
        List<String> result = new ArrayList<>();
        for (int colIdx = 0; colIdx < colSize; colIdx++) {
            String row = "";
            for (String elmt : elmts) {
                if (colIdx < elmt.length()) {
                    row += String.valueOf(elmt.charAt(colIdx));
                }
            }
            result.add(row);
        }
        return result.stream().collect(Collectors.joining(" "));
    }
}
