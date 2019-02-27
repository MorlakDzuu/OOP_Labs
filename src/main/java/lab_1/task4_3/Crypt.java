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

    public static File initFile(String path) {
        File file = new File(System.getProperty("user.dir"), path);
        if (file.exists()) {
            return file;
        }
        return null;
    }

    public static boolean crypt(String inputFileName, String outputFileName, int key) {
        File inputFile = initFile(inputFileName);
        File outputFile = initFile(outputFileName);
        if (inputFile == null || outputFile == null) {
            return false;
        }
        try (FileInputStream reader = new FileInputStream(inputFile);
             FileOutputStream writer = new FileOutputStream(outputFile)) {
            int elem;
            while ((elem = reader.read()) != -1) {
                elem = elem ^ key;
                String binaryString = Integer.toBinaryString(elem);
                while (binaryString.length() != 8) {
                    binaryString = '0' + binaryString;
                }
                char[] binaryArray = binaryString.toCharArray();
                binaryArray = binaryReplacementCrypt(binaryArray);
                elem = Integer.parseInt(String.valueOf(binaryArray), 2);
                writer.write(elem);
            }
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean decrypt(String inputFileName, String outputFileName, int key) {
        File inputFile = initFile(inputFileName);
        File outputFile = initFile(outputFileName);
        if (inputFile == null || outputFile == null) {
            return false;
        }
        try (FileInputStream reader = new FileInputStream(inputFile);
             FileOutputStream writer = new FileOutputStream(outputFile)) {
            int elem;
            while ((elem = reader.read()) != -1) {
                String binaryString = Integer.toBinaryString(elem);
                while (binaryString.length() != 8) {
                    binaryString = '0' + binaryString;
                }
                char[] binaryArray = binaryString.toCharArray();
                binaryArray = binaryReplacementDecrypt(binaryArray);
                elem = Integer.parseInt(String.valueOf(binaryArray), 2);
                elem = elem ^ key;
                writer.write(elem);
            }
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void main(String args[]) {
        if (args.length != 4) {
            System.out.println("Usage: java Crypt <crypt/decrypt> <input file> <output file> <key>");
            System.exit(1);
        }
        String status = args[0];
        String inputFileName = args[1];
        String outputFileName = args[2];
        int key = Integer.parseInt(args[3]);
        if (key < 0 || key > 255) {
             System.out.println("Your key should be in range from 0 to 255");
             System.exit(1);
        }
        if (status.equals("crypt")) {
            if (!crypt(inputFileName, outputFileName, key)) {
                System.exit(1);
            }
        }
        if (status.equals("decrypt")) {
            if (!decrypt(inputFileName, outputFileName, key)) {
                System.exit(1);
            }
        }
        System.exit(0);
    }
}