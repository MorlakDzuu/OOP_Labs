import java.io.File;
import java.io.IOException;

public class CryptElement {

    private String state;
    private String inputFileName;
    private String outputFileName;
    private String key;

    CryptElement(String state, String inputFileName, String outputFileName, String key) {
        this.state = state;
        this.inputFileName = inputFileName;
        this.outputFileName = outputFileName;
        this.key = key;
    }

    public String getState() {
        return state;
    }

    public File getInputFile() {
        File inputFile = new File(System.getProperty("user.dir"), inputFileName);
        if (inputFile.exists()) {
            return inputFile;
        }
        return null;
    }

    public File getOutputFile() {
        try {
            File outputFile = new File(System.getProperty("user.dir"), outputFileName);
            if (!outputFile.exists()) {
                outputFile.createNewFile();
            }
            return outputFile;
        } catch (IOException e) {
            return null;
        }
    }

    public Integer getIntKey() {
        try {
            int key = Integer.parseInt(this.key);
            return key;
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
