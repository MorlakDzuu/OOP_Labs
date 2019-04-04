import java.util.Scanner;

public class URLParser {

    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        System.out.println("Введите url (для выхода из программы введите \"...\")");
        String inputString = inputScanner.nextLine();
        while (!inputString.equals("...")) {
            URL url = new URL(inputString);
            String metaString = url.getMeta();
            if (metaString != null) {
                System.out.println(metaString);
            } else {
                System.out.println("Неправильный вид url");
            }
            inputString = inputScanner.nextLine();
        }
        System.exit(0);
    }
}