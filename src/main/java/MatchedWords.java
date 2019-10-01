import java.util.List;
import java.util.stream.Collectors;

public class MatchedWords {
    private char letter;
    private List<String> words;

    MatchedWords(char letter, List<String> words) {
        this.letter = letter;
        this.words = words;
    }

    @Override
    public String toString() {
        String allWords = words.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
        return letter + ": " + allWords;
    }
}
