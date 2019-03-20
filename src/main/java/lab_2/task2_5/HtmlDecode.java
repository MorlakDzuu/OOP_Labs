import java.util.Scanner;

public class HtmlDecode {
    public static String htmlDecode(String inputString) {
        inputString = inputString.replace("&quot;", "\"");
        inputString = inputString.replace("&apos;", "'");
        inputString = inputString.replace("&lt;", "<");
        inputString = inputString.replace("&gt;", ">");
        inputString = inputString.replace("&amp;", "&");
        return inputString;
    }

    public static void main(String args[]) {
        System.out.println("Введите html-сущность, которую надо декодировать (чтобы выйти, введите ...)");
        Scanner scanner = new Scanner(System.in);
        String inputString = scanner.nextLine();
        while (!inputString.equals("...")) {
            System.out.println(htmlDecode(inputString));
            inputString = scanner.nextLine();
        }
    }
}