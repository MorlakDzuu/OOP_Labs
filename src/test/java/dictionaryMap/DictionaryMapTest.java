import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

public class DictionaryMapTest {

    private DictionaryMap dictionaryMap;

    @Before
    public void init() {
        dictionaryMap = new DictionaryMap("test");
    }

    @After
    public void remove() {
        File file = new File("test");
        file.delete();
    }

    @Test
    public void testMap() {
        dictionaryMap.put("привет", "hello");
        dictionaryMap.put("hello", "здравствуйте");
        dictionaryMap.put("cat", "кошка");
        dictionaryMap.saveDictionary();
        DictionaryMap newDictionaryMap = new DictionaryMap("test");

        assertEquals("здравствуйте, привет", newDictionaryMap.get("hello"));
        assertEquals("кошка", newDictionaryMap.get("cat"));
        assertEquals(null, dictionaryMap.get("cucumber"));
        assertEquals(null, dictionaryMap.get("огурец"));
        assertEquals("cat", newDictionaryMap.get("кошка"));
        assertEquals("hello", newDictionaryMap.get("привет"));
        assertEquals("hello", newDictionaryMap.get("здравствуйте"));
    }
}