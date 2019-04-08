import org.apache.commons.lang3.StringUtils;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class URLParser {

    public static Protocol getProtocol(String url) {
        Protocol protocol;
        Pattern pattern = Pattern.compile(".+?://", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(url);
        if (!matcher.find()) {
            return null;
        }
        try {
            protocol = Protocol.valueOf(matcher.group(0).replace("://", "").toUpperCase());
        } catch (IllegalArgumentException e) {
            return null;
        }
        return protocol;
    }

    public static String getHost(String url) {
        Pattern pattern = Pattern.compile("://.+?:", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(url);
        String host;
        if (matcher.find()) {
            host = matcher.group(0).replace("://", "").replace(":", "");
            if (host.equals(""))
                return null;
            return host;
        }
        pattern = Pattern.compile("://.+?/", Pattern.CASE_INSENSITIVE);
        matcher = pattern.matcher(url);
        if (matcher.find()) {
            host = matcher.group(0).replace("://", "").replace("/", "");
            if (host.equals("") || host.contains(":"))
                return null;
            return host;
        }
        pattern = Pattern.compile("://.++", Pattern.CASE_INSENSITIVE);
        matcher = pattern.matcher(url);
        if (matcher.find()) {
            host = matcher.group(0).replace("://", "");
            if (host.contains(":") || host.contains("/") || host.equals(""))
                return null;
            return host;
        }
        return null;
    }

    public static String getPort(String url) {
        Pattern pattern = Pattern.compile(":.+?/", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(url.replace("://", ""));
        String port = "";
        if (matcher.find()) {
            port = matcher.group(0).replace(":", "").replace("/", "");
            if (port.equals("") || !StringUtils.isNumeric(port)) return null;
            return port;
        }
        if (url.replace("://", "").contains(":"))
            port = url.replace("://", "").substring(url.replace("://", "").indexOf(":"));
        if (!port.equals("")) {
            port = port.replace(":", "");
            if (!StringUtils.isNumeric(port)) return null;
            try {
                if (Integer.parseInt(port) < 1 || Integer.parseInt(port) > 65535) port = null;
            } catch (Exception e) {
                port = null;
            }
            return port;
        }
        if (getProtocol(url) == Protocol.HTTPS) port = "443";
        else if (getProtocol(url) == Protocol.HTTP) port = "80";
        else if (getProtocol(url) == Protocol.FTP) port = "21";
        else port = null;
        return port;
    }

    public static String getDoc(String url) {
        Pattern pattern = Pattern.compile("/.++");
        Matcher matcher = pattern.matcher(url.replace("://", ""));
        if (matcher.find()) {
            String doc = matcher.group(0).substring(1);
            return doc;
        }
        return null;
    }

    public static boolean parseURL(String url) {
        if (getProtocol(url) == null || getHost(url) == null || getPort(url) == null) return false;
        return true;
    }

    public static String getMeta(String url) {
        String resultString = null;
        if (parseURL(url)) {
            resultString = "HOST : " + getHost(url) + "\n" +
                           "PORT : " + getPort(url);
            if (getDoc(url) != null)
                resultString += "\n" + "DOC : " + getDoc(url);
        }
        return resultString;
    }

    public static void userWorker() {
        Scanner inputScanner = new Scanner(System.in);
        System.out.println("Введите url (для выхода из программы введите \"...\")");
        String inputString = inputScanner.nextLine();
        while (!inputString.equals("...")) {
            if (inputString.equals("")) {
                inputString = inputScanner.nextLine();
                continue;
            }
            String metaString = getMeta(inputString);
            if (metaString != null) {
                System.out.println(metaString);
            } else {
                System.out.println("Неправильный вид url");
            }
            inputString = inputScanner.nextLine();
        }
    }

    public static void main(String[] args) {
        userWorker();
        System.exit(0);
    }
}