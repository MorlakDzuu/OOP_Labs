import java.io.*;

public class replace {
    public static void main(String args[]) {
        if (args.length != 4) {
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
        String search = args[2];
        String replace = args[3];
        try {
            FileWriter writer = new FileWriter(outputFile);
            BufferedReader br = new BufferedReader(new FileReader(inputFile));
            String strLine;
            while (br.ready()) {
                strLine = br.readLine();
                if (strLine.contains(search)) {
                    strLine = strLine.replace(search, replace);
                }
                writer.append(strLine + '\n');
            }
            writer.flush();
        } catch (FileNotFoundException e) {
            System.out.println("Undefined error");
            e.printStackTrace();
            return;
        } catch (IOException e) {
            System.out.println("Undefined error");
            e.printStackTrace();
            return;
        }
        
    }
}