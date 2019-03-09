import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HtmlDecodeTest {

    private HtmlDecode htmlDecode;

    @Before
    public void init() {
        htmlDecode = new HtmlDecode();
    }

    @Test
    public void htmlDecode() {
        assertEquals("\"'\"", htmlDecode.htmlDecode("&quot;&apos;&quot;"));
        assertEquals("Cat <says> \"Meow\". M&M's", htmlDecode.htmlDecode("Cat &lt;says&gt; &quot;Meow&quot;. M&amp;M&apos;s"));
        assertEquals("", htmlDecode.htmlDecode(""));
        assertEquals("hello", htmlDecode.htmlDecode("hello"));
    }
}