import java.io.*;

public class CopyFile {
    public static void main(String args[]) {
        if (args.length != 2) {
            System.out.println("Input error");
            return;
        }
        File inputFile = new File(System.getProperty("user.dir"), args[0]);
        if (!inputFile.exists()) {
            System.out.println("Input file does not exist");
            return;
        }
        File outputFile = new File(System.getProperty("user.dir"), args[1]);
        if (!outputFile.exists()) {
            System.out.println("Output file does not exist");
            return;
        }
        try {
            FileReader reader = new FileReader(inputFile);
            FileWriter writer = new FileWriter(outputFile);
            int c;
            while ((c = reader.read()) != -1) {
                writer.append((char) c);
            }
            writer.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (inputFile.length() == outputFile.length()) {
            System.out.println("Success");
            return;
        }
        System.out.println("Undefined error");
    }
}