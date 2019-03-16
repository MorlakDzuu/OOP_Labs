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

    public static String readInput(Scanner scanner) {
        String inputString = scanner.nextLine();
        String result = "";
        while (!inputString.isEmpty()) {
            result += inputString;
            inputString = scanner.nextLine();
            if (!inputString.isEmpty()) result += '\n';
        }
        return result;
    }

    public static void main(String args[]) {
        System.out.println("Введите html-сущность, которую надо декодировать");
        Scanner scanner = new Scanner(System.in);
        String inputString = readInput(scanner);
        System.out.println(htmlDecode(inputString));
    }
}