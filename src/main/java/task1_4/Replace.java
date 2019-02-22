import java.io.*;

public class Replace {

    public static void CopyStreamWithTextReplacement(FileWriter writer,
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

    public static void CopyFileWithTextReplacement(File inputFile, File outputFile, String searchString, String replacementString) {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
                FileWriter writer = new FileWriter(outputFile)) {
            CopyStreamWithTextReplacement(writer, reader, searchString, replacementString);
        } catch (IOException e) {
            System.out.println("IOException");
            System.exit(1);
            e.printStackTrace();
            return;
        }
    }

    public static void main(String args[]) {
        if (args.length != 4) {
            System.out.println("Usage: java replace <input file> <output file> <search string> <replacement string>");
            System.exit(1);
            return;
        }
        File inputFile = new File(System.getProperty("user.dir"), args[0]);
        if (!inputFile.exists()) {
            System.out.println("Input file does not exist");
            System.exit(1);
            return;
        }
        File outputFile = new File(System.getProperty("user.dir"), args[1]);
        if (!outputFile.exists()) {
            System.out.println("Output file does not exist");
            System.exit(1);
            return;
        }
        String search = args[2];
        String replacement = args[3];
        CopyFileWithTextReplacement(inputFile, outputFile, search, replacement);
        System.exit(0);
    }
}