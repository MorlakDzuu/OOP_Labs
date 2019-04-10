import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class URLTest {

    @Test
    public void getHost() {
        assertEquals("google.com", URLParser.getHost("https://google.com"));
        assertEquals(null, URLParser.getHost("://"));
        assertEquals(null, URLParser.getHost("://:"));
        assertEquals(null, URLParser.getHost(":///"));
        assertEquals("localhost", URLParser.getHost("://localhost/"));
        assertEquals("localhost", URLParser.getHost("://localhost:8080/"));
        assertEquals("localhost", URLParser.getHost("://localhost:/"));
        assertEquals(null, URLParser.getHost("localhost"));
        assertEquals(null, URLParser.getHost(":localhost"));
        assertEquals(null, URLParser.getHost("/localhost"));
        assertEquals(null, URLParser.getHost("//localhost"));
        assertEquals(null, URLParser.getHost(":/localhost"));
        assertEquals(null, URLParser.getHost("http://:1/1.txt"));
    }

    @Test
    public void getProtocol() {
        assertEquals(null, URLParser.getProtocol("http"));
        assertEquals(null, URLParser.getProtocol("http:"));
        assertEquals(null, URLParser.getProtocol("http/"));
        assertEquals(null, URLParser.getProtocol("http:/"));
        assertEquals(null, URLParser.getProtocol("http//"));
        assertEquals(null, URLParser.getProtocol("htp://"));
        assertEquals(null, URLParser.getProtocol("://"));
        assertEquals(null, URLParser.getProtocol("p://"));
        assertEquals(null, URLParser.getProtocol("ftphttp://"));
        assertEquals(Protocol.HTTP, URLParser.getProtocol("http://"));
        assertEquals(Protocol.HTTPS, URLParser.getProtocol("https://"));
        assertEquals(Protocol.FTP, URLParser.getProtocol("ftp://"));
    }

    @Test
    public void getPort() {
        assertEquals(null, URLParser.getPort("http://localhost:"));
        assertEquals(null, URLParser.getPort(":/"));
        assertEquals(null, URLParser.getPort("://localhost"));
        assertEquals(null, URLParser.getPort("htp://localhost"));
        assertEquals(null, URLParser.getPort("://"));
        assertEquals(null, URLParser.getPort("://:"));
        assertEquals("80", URLParser.getPort("http://localhost"));
        assertEquals("443", URLParser.getPort("https://localhost"));
        assertEquals("21", URLParser.getPort("ftp://localhost"));
        assertEquals("5050", URLParser.getPort("ftp://localhost:5050"));
        assertEquals("5050", URLParser.getPort("ftp://localhost:5050/man"));
        assertEquals("50", URLParser.getPort(":50"));

        assertEquals(null, URLParser.getPort(":0"));
        assertEquals("1", URLParser.getPort(":1"));
        assertEquals("65535", URLParser.getPort(":65535"));
        assertEquals(null, URLParser.getPort(":65536"));
        assertEquals(null, URLParser.getPort(":-50"));
        assertEquals(null, URLParser.getPort(":500000000000000000000"));
    }

    @Test
    public void  getDoc() {
        assertEquals(null, URLParser.getDoc("https://localhost"));
        assertEquals(null, URLParser.getDoc("https://localhost/"));
        assertEquals("good", URLParser.getDoc("https://localhost/good"));
        assertEquals("g", URLParser.getDoc("https://localhost/g"));
        assertEquals("good/luck/", URLParser.getDoc("https://localhost/good/luck/"));
    }
}