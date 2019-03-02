import java.io.*;

public class Crypt {

    public static char[] binaryReplacementCrypt(char[] binaryArray) {
        char[] binaryArrayClone = binaryArray.clone();
        binaryArray[2] = binaryArrayClone[0];
        binaryArray[6] = binaryArrayClone[1];
        binaryArray[7] = binaryArrayClone[2];
        binaryArray[0] = binaryArrayClone[3];
        binaryArray[1] = binaryArrayClone[4];
        binaryArray[3] = binaryArrayClone[5];
        binaryArray[4] = binaryArrayClone[6];
        binaryArray[5] = binaryArrayClone[7];
        return binaryArray;
    }

    public static char[] binaryReplacementDecrypt(char[] binaryArray) {
        char[] binaryArrayClone = binaryArray.clone();
        binaryArray[0] = binaryArrayClone[2];
        binaryArray[1] = binaryArrayClone[6];
        binaryArray[2] = binaryArrayClone[7];
        binaryArray[3] = binaryArrayClone[0];
        binaryArray[4] = binaryArrayClone[1];
        binaryArray[5] = binaryArrayClone[3];
        binaryArray[6] = binaryArrayClone[4];
        binaryArray[7] = binaryArrayClone[5];
        return binaryArray;
    }

    public static boolean transformFile(CryptElement cryptElement) {
        File inputFile = cryptElement.getInputFile();
        if (inputFile == null) {
            System.out.println("Input file does not exist");
            return false;
        }
        File outputFile = cryptElement.getOutputFile();
        String state = cryptElement.getState();
        if (!(state.equals("crypt") || state.equals("decrypt"))) {
            System.out.println("Invalid state: <crypt/decrypt>");
            return false;
        }
        Integer key = cryptElement.getIntKey();
        if (key == null || (key < 0) || (key > 255)) {
            System.out.println("Your key should be a number from 0 to 255");
            return false;
        }
        try (FileInputStream reader = new FileInputStream(inputFile);
             FileOutputStream writer = new FileOutputStream(outputFile)) {
            int elem;
            while ((elem = reader.read()) != -1) {
                if (cryptElement.getState().equals("crypt")) {
                    elem = elem ^ key;
                }
                String binaryString = Integer.toBinaryString(elem);
                while (binaryString.length() != 8) {
                    binaryString = '0' + binaryString;
                }
                char[] binaryArray = binaryString.toCharArray();
                if (state.equals("crypt")) {
                    binaryArray = binaryReplacementCrypt(binaryArray);
                } else {
                    binaryArray = binaryReplacementDecrypt(binaryArray);
                }
                elem = Integer.parseInt(String.valueOf(binaryArray), 2);
                if (cryptElement.getState().equals("decrypt")) {
                    elem = elem ^ key;
                }
                writer.write(elem);
            }
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IOException");
            return false;
        }
    }

    public static void main(String args[]) {
        if (args.length != 4) {
            System.out.println("Usage: java Crypt <crypt/decrypt> <input file> <output file> <key>");
            System.exit(1);
        }
        CryptElement cryptElement = new CryptElement(args[0], args[1], args[2], args[3]);
        if (!transformFile(cryptElement)) {
            System.exit(1);
        }
        System.exit(0);
    }
}