import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HtmlDecodeTest {

    @Test
    public void htmlDecode() {
        assertEquals("\"", HtmlDecode.htmlDecode("&quot;"));
        assertEquals("'", HtmlDecode.htmlDecode("&apos;"));
        assertEquals("<", HtmlDecode.htmlDecode("&lt;"));
        assertEquals(">", HtmlDecode.htmlDecode("&gt;"));
        assertEquals("&", HtmlDecode.htmlDecode("&amp;"));
        assertEquals("", HtmlDecode.htmlDecode(""));
        assertEquals("hello", HtmlDecode.htmlDecode("hello"));
        assertEquals("\"'<>&", HtmlDecode.htmlDecode("&quot;&apos;&lt;&gt;&amp;"));
        assertEquals("Cat <says> \"Meow\". M&M's", HtmlDecode.htmlDecode("Cat &lt;says&gt; &quot;Meow&quot;. M&amp;M&apos;s"));
    }
}