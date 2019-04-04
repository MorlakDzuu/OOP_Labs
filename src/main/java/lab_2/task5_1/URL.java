import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class URL {

    private String urlString;

    private Protocol protocol;
    private String host;
    private String port;
    private String doc;

    public URL(String urlString) {
        this.urlString = urlString;
    }

    private boolean parseURL() {
        String url = urlString;
        Pattern pattern = Pattern.compile("...+?://", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(url);
        if (!matcher.find()) {
            return false;
        }
        try {
            this.protocol = Protocol.valueOf(matcher.group(0).replace("://", "").toUpperCase());
        } catch (IllegalArgumentException e) {
            return false;
        }
        url = url.replace(matcher.group(0), "");
        pattern = Pattern.compile(".+?/", Pattern.CASE_INSENSITIVE);
        matcher = pattern.matcher(url);
        if (matcher.find()) {
            String host = matcher.group(0).replace("/", "");
            url = url.replace(host, "");
            pattern = Pattern.compile(":.++", Pattern.CASE_INSENSITIVE);
            matcher = pattern.matcher(host);
            String port = "";
            if (matcher.find()) {
                port = matcher.group(0).replace(":", "");
                host = host.replace(port, "").toLowerCase().replace(":", "");
            } else {
                if (this.protocol.toString().equals("HTTPS")) port = "443";
                else if (this.protocol.toString().equals("HTTP")) port = "80";
                else if (this.protocol.toString().equals("FTP")) port = "21";
            }
            this.port = port;
            this.host = host;
        } else return false;
        this.doc = url.replace("//", "").substring(1);
        return true;
    }

    public String getMeta() {
        String resultString = null;
        if (parseURL()) {
            resultString = "HOST : " + host + "\n" +
                           "PORT : " + port + "\n" +
                           "DOC : " + doc;
        }
        return resultString;
    }
}