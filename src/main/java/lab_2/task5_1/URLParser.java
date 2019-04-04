public class URLParser {

    public static void main(String[] args) {
        URL url = new URL("https://www.youtube.com/watch?v=IWTvgZVWeB4");
        String metaString = url.getMeta();
        if (!metaString.equals(null)) {
            System.out.println(metaString);
        }
    }
}