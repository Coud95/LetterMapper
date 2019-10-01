import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Mapper {
    private String userText;

    Mapper(String userText) {
        this.userText = userText;
    }

    StringBuilder map() {
        TreeSet<Character> uniqueLetters = userText.chars()
                .mapToObj(character -> (char) character)
                .filter(character -> character.toString().matches("[a-z]+\\.?"))
                .collect(Collectors.toCollection(TreeSet::new));
        TreeSet<String> uniqueWords = Stream.of(userText.split("\\W+"))
                .collect(Collectors.toCollection(TreeSet::new));

        return matchWordsWithLetters(uniqueWords, uniqueLetters);
    }

    private StringBuilder matchWordsWithLetters(TreeSet<String> words, TreeSet<Character> letters) {
        StringBuilder allMatchedWords = new StringBuilder();
        for (Character letter : letters) {
            List<String> wordsContainingLetter = words.stream()
                    .filter(String -> String.contains(letter.toString())).collect(Collectors.toList());
            MatchedWords matchedWords = new MatchedWords(letter, wordsContainingLetter);
            allMatchedWords.append(matchedWords).append("\n");
        }
        return allMatchedWords;
    }
}
