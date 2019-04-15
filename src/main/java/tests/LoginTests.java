package tests;

import base.BaseTests;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.io.IOException;

import static base.DriverFactory.getDriver;
import static utils.Constantes.urlBase;

public class LoginTests extends BaseTests {

    private LoginPage login;


    @Test
    public void deveLogarComSucesso() throws InterruptedException{
        login = new LoginPage();
        login.preencherEmail("administrator");
        login.clicarBotaoLogin();
        login.preencherSenha("duarte");
        login.clicarBotaoLogin();

        Assert.assertTrue(getDriver().getTitle().contains("Minha Visão - MantisBT"));
    }

    @Test
    public void devefalhar() throws InterruptedException{
        login = new LoginPage();
        login.preencherEmail("administrator");
        login.clicarBotaoLogin();
        login.preencherSenha("duarte");
        login.clicarBotaoLogin();

        Assert.assertTrue(getDriver().getTitle().contains("Google"));
    }

}
