import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class DictionaryMap {

    private Map<String, String> map;

    private boolean isModified;

    private String fileName;

    public DictionaryMap(String fileName) {
        this.fileName = fileName;
        initMap();
    }

    public DictionaryMap() {
        fileName = "dictionary";
        initMap();
    }

    private void initMap() {
        File inputFile = new File(fileName);
        if (inputFile.exists()) {
            try (FileInputStream fis = new FileInputStream(inputFile);
                 ObjectInputStream ois = new ObjectInputStream(fis)) {
                map = (TreeMap) ois.readObject();
            } catch (FileNotFoundException e) {
            } catch (IOException e) {
            } catch (ClassNotFoundException e) {
            }
        } else {
            map = new TreeMap<>();
        }
    }

    public void saveDictionary() {
        try {
            File objectFile = new File(fileName);
            if (!objectFile.exists()) {
                objectFile.createNewFile();
            }
            try (FileOutputStream fos = new FileOutputStream(objectFile);
                 ObjectOutputStream oos = new ObjectOutputStream(fos)) {
                oos.writeObject(map);
                oos.flush();
            }
        } catch (IOException e) {}
        setModified(false);
    }

    private String getRussian(String value) {
        List<String> valueList = new ArrayList<>();
        for (Map.Entry<String, String> entry: this.map.entrySet()) {
            if (entry.getValue().equals(value)) {
                valueList.add(entry.getKey());
            }
        }
        String separator = (valueList.size() > 1) ? ", " : "";
        if (valueList.isEmpty()) return null;
        return valueList.stream().reduce((s1, s2) -> s1 + separator + s2).get();
    }

    private String getEnglish(String value) {
        return map.get(value);
    }

    public String get(String value) {
        String english = getEnglish(value);
        String russian = getRussian(value);
        if (english != null) {
            return english;
        } else if (russian != null) {
            return russian;
        } else return null;
    }

    public void put(String word, String translation) {
        if (word.isEmpty() || translation.isEmpty()) return;
        if (word.substring(0, 1).getBytes().length == 2) {
            map.put(word, translation);
        } else {
            map.put(translation, word);
        }
        setModified(true);
    }

    public boolean getModified() {
        return isModified;
    }

    private void setModified(boolean modified) {
        isModified = modified;
    }
}