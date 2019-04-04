import org.junit.Test;

import static org.junit.Assert.*;

public class URLTest {

    @Test
    public void getMeta() {
        URL url = new URL("");
        assertEquals(url.getMeta(), null);

        url = new URL("hello");
        assertEquals(url.getMeta(), null);

        url = new URL("hps://javarush.ru/groups/posts/615-idea-hot-keys");
        assertEquals(url.getMeta(), null);

        url = new URL("https:/javarush.ru/groups/posts/615-idea-hot-keys");
        assertEquals(url.getMeta(), null);

        url = new URL("https/javarush.ru/groups/posts/615-idea-hot-keys");
        assertEquals(url.getMeta(), null);

        url = new URL("httpsjavarush.ru/groups/posts/615-idea-hot-keys");
        assertEquals(url.getMeta(), null);

        url = new URL("https://javarush.ru/groups/posts/615-idea-hot-keys");
        assertEquals(url.getMeta(), "HOST : javarush.ru\nPORT : 443\nDOC : groups/posts/615-idea-hot-keys");

        url = new URL("http://javarush.ru/groups/posts/615-idea-hot-keys");
        assertEquals(url.getMeta(), "HOST : javarush.ru\nPORT : 80\nDOC : groups/posts/615-idea-hot-keys");

        url = new URL("ftp://javarush.ru/groups/posts/615-idea-hot-keys");
        assertEquals(url.getMeta(), "HOST : javarush.ru\nPORT : 21\nDOC : groups/posts/615-idea-hot-keys");
    }
}