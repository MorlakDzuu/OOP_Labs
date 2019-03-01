import java.io.*;

public class Replace {

    public static void copyStreamWithTextReplacement(FileWriter writer,
                                                     BufferedReader reader,
                                                     String searchString,
                                                     String replacementString) throws IOException {
        while (reader.ready()) {
            String strLine;
            strLine = reader.readLine();
            strLine = strLine.replace(searchString, replacementString);
            writer.append(strLine + '\n');
        }
        writer.flush();
    }

    public static boolean copyFileWithTextReplacement(File inputFile, File outputFile, String searchString, String replacementString) {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             FileWriter writer = new FileWriter(outputFile)) {
            copyStreamWithTextReplacement(writer, reader, searchString, replacementString);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IOException");
            return false;
        }
    }

    public static void main(String args[]) {
        if (args.length != 4) {
            System.out.println("Usage: java replace <input file> <output file> <search string> <replacement string>");
            System.exit(1);
        }
        File inputFile = new File(System.getProperty("user.dir"), args[0]);
        if (!inputFile.exists()) {
            System.out.println("Input file does not exist");
            System.exit(1);
        }
        File outputFile = new File(System.getProperty("user.dir"), args[1]);
        if (!outputFile.exists()) {
            System.out.println("Output file does not exist");
            System.exit(1);
        }
        String search = args[2];
        String replacement = args[3];
        if (!copyFileWithTextReplacement(inputFile, outputFile, search, replacement)) {
            System.exit(1);
        }
        System.exit(0);
    }
}