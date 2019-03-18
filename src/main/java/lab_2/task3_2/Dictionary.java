import java.util.Scanner;

public class Dictionary {

    public static DictionaryMap initDictionary(String fileName) {
        DictionaryMap dictionaryMap;
        if (!fileName.isEmpty()) {
            dictionaryMap = new DictionaryMap(fileName);
            System.out.println("Был выбран словарь под названием \"" + fileName + "\"");
        } else {
            dictionaryMap = new DictionaryMap();
            System.out.println("Был выбран стандартный словарь");
        }
        return dictionaryMap;
    }

    public static void processInput(String inputString, DictionaryMap dictionaryMap, Scanner inputScanner) {
        if (!inputString.equals("")) {
            String outputString = dictionaryMap.get(inputString.toLowerCase());
            if (outputString == null) {
                System.out.println("Неизвестное слово \"" + inputString + "\" Введите перевод или пустую строку для отказа");
                outputString = inputScanner.nextLine().toLowerCase();
                if (!outputString.isEmpty()) {
                    dictionaryMap.put(inputString.toLowerCase(), outputString);
                    System.out.println("Слово \"" + inputString + "\" сохранено в словаре как \"" + outputString + "\"");
                } else {
                    System.out.println("Слово \"" + inputString + "\" проигнорировано");
                }
            } else {
                char[] inputChars = inputString.toCharArray();
                char[] outputChars = outputString.toCharArray();
                for (int i = 0; i < inputString.length(); i++) {
                    if (i < outputString.length()) {
                        if (Character.isUpperCase(inputChars[i])) {
                            outputChars[i] = Character.toUpperCase(outputChars[i]);
                        }
                    }
                }
                outputString = String.valueOf(outputChars);
                System.out.println(outputString);
            }
        }
    }

    public static void checkSave(DictionaryMap dictionaryMap, Scanner inputScanner) {
        if (dictionaryMap.getModified()) {
            System.out.println("В словарь были внесены изменения. Введите Y или y для сохранения перед выходом.");
            String inputString = inputScanner.nextLine();
            if (inputString.equals("y") || inputString.equals("Y")) {
                dictionaryMap.saveDictionary();
            }
        }
    }

    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        System.out.println("Введите имя файла");
        String inputString = inputScanner.nextLine();
        DictionaryMap dictionaryMap = initDictionary(inputString);
        while (true) {
            inputString = inputScanner.nextLine();
            if (inputString.equals("...")) {
                break;
            }
            processInput(inputString, dictionaryMap, inputScanner);

        }
        checkSave(dictionaryMap, inputScanner);
    }
}