import java.util.Scanner;

public class URLParser {

    public static void UrlParser() {
        Scanner inputScanner = new Scanner(System.in);
        System.out.println("Введите url (для выхода из программы введите \"...\")");
        String inputString = inputScanner.nextLine();
        while (!inputString.equals("...")) {
            if (inputString.equals("")) {
                inputString = inputScanner.nextLine();
                continue;
            }
            URL url = new URL(inputString);
            String metaString = url.getMeta();
            if (metaString != null) {
                System.out.println(metaString);
            } else {
                System.out.println("Неправильный вид url");
            }
            inputString = inputScanner.nextLine();
        }
    }

    public static void main(String[] args) {
        UrlParser();
        System.exit(0);
    }
}