import java.util.Scanner;

public class LetterMapper {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String userText = scanner.nextLine().toLowerCase();
        Mapper mapper = new Mapper(userText);
        System.out.println(mapper.map());
    }

}