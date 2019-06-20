package utils;

public class Constantes {
    public static String pathProjeto= System.getProperty("user.dir");
    public static String pathChrome= pathProjeto+"/src/main/resources/chromedriver.exe";
    public static String pathFirefox= pathProjeto+"/src/main/resources/geckodriver.exe";

    public static String urlBase= "http://192.168.99.100:8989/login_page.php";
    public static int defaultTimeout= 30;
}
