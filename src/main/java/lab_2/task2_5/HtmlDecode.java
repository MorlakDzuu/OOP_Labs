public class HtmlDecode {
    public String htmlDecode(String inputString) {
        inputString = inputString.replace("&quot;", "\"");
        inputString = inputString.replace("&apos;", "'");
        inputString = inputString.replace("&lt;", "<");
        inputString = inputString.replace("&gt;", ">");
        inputString = inputString.replace("&amp;", "&");
        return inputString;
    }
}
