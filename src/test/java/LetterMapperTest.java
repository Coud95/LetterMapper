import org.junit.Assert;
import org.junit.Test;

public class LetterMapperTest {

    @Test
    public void shouldCorrectlyMapTheSentence() {
        String exampleText = "ala ma kota, kot koduje w Javie kota";
        Mapper mapper = new Mapper(exampleText.toLowerCase());
        String expectedOutputText = "a: ala, javie, kota, ma\n" +
                "d: koduje\n" +
                "e: javie, koduje\n" +
                "i: javie\n" +
                "j: javie, koduje\n" +
                "k: koduje, kot, kota\n" +
                "l: ala\n" +
                "m: ma\n" +
                "o: koduje, kot, kota\n" +
                "t: kot, kota\n" +
                "u: koduje\n" +
                "v: javie\n" +
                "w: w";
        String actualOutputText = mapper.map().toString();
        Assert.assertTrue(actualOutputText.contains(expectedOutputText));
    }
}