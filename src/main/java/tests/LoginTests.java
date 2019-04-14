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
    //private static WebDriver driver;

    protected static WebDriver driver;
    private ExtentTest log;// = new ExtentReports();
    private static WebDriverWait wait;

    /*
    ExtentHtmlReporter reporter=new ExtentHtmlReporter("./Reports/learn_automation2.html");
    ExtentReports reporter = new ExtentReports();
    ExtentTest log;
    ---
    extent.attachReporter(reporter);
    logger=extent.createTest("LoginTest");
    */
    @BeforeMethod
    public void inicializaTeste() {
        log=reporter.createTest("LoginTest");
        login = new LoginPage(log);

        //ExtentHtmlReporter reporter=new ExtentHtmlReporter("./Reports/learn_automation2.html");
       // extent = new ExtentReports();
       // extent.attachReporter(reporter);
       // logger=extent.createTest("LoginTest");
    }


    @Test
    public void deveLogarComSucesso() throws InterruptedException{
        //log=reporter.createTest("LoginTest");
        login.preencherEmail("administrator");
        login.clicarBotaoLogin();
        login.preencherSenha("duarte");
        login.clicarBotaoLogin();

        Assert.assertTrue(getDriver().getTitle().contains("Google"));
    }

    @AfterMethod
    public void tearDown(ITestResult result) throws IOException
    {
        if(result.getStatus()==ITestResult.FAILURE)
        {
            String temp= utils.Utils.getScreenshot(getDriver());
            log.fail(result.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
        }

        reporter.flush();
        driver.quit();
    }
}
