package tests;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.LoginPage;

import static base.DriverFactory.getDriver;
import static utils.Constantes.urlBase;

public class LoginTests {

    private LoginPage login;
    //private static WebDriver driver;

    protected static WebDriver driver;
    private static ExtentTest relatorio;
    private static WebDriverWait wait;

    @BeforeTest
    public void inicializaTeste() {
        getDriver().get(urlBase);
        login = new LoginPage(relatorio);
    }


    @Test
    public void deveLogarComSucesso() throws InterruptedException{
        login.preencherEmail("administrator");
        login.clicarBotaoLogin();
        login.preencherSenha("duarte");
        login.clicarBotaoLogin();

        //Assert.assertTrue(login.verficarSeLogouComSucesso());
    }
}
