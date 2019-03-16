import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HtmlDecodeTest {

    @Test
    public void htmlDecode() {
        assertEquals("\"'\"", HtmlDecode.htmlDecode("&quot;&apos;&quot;"));
        assertEquals("Cat <says> \"Meow\". M&M's", HtmlDecode.htmlDecode("Cat &lt;says&gt; &quot;Meow&quot;. M&amp;M&apos;s"));
        assertEquals("", HtmlDecode.htmlDecode(""));
        assertEquals("hello", HtmlDecode.htmlDecode("hello"));
    }
}