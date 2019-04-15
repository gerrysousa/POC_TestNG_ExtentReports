package base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.LoginPage;
import utils.Utils;

import java.io.IOException;

import static base.DriverFactory.getDriver;
import static base.DriverFactory.killDriver;
import static utils.Constantes.urlBase;
import static utils.Utils.getScreenshot;

public class BaseTests {

    public static ExtentHtmlReporter relatorio =new ExtentHtmlReporter("./Reports/learn_automation2.html");
    public static ExtentReports reporter = new ExtentReports();
    public static ExtentTest log;
    protected static WebDriver driver;

    public static String getUrlBase() {
        // return "http://192.168.99.100:8989";
        return urlBase;
    }

    @BeforeSuite
    public static void inicia() {
        //ConexaoBD.resetBD();
        reporter.attachReporter(relatorio);
//      getDriver().get(getUrlBase());

    }

    @BeforeMethod
    public void inicializaTeste() {
        getDriver().get(getUrlBase());
       // login = new LoginPage();
    }

//    @BeforeMethod
//    public void inicializaTeste() {
//        getDriver().get(urlBase);
//    }

    @AfterMethod
    public void afterMethod(ITestResult result) throws IOException
    {
        if(result.getStatus()==ITestResult.FAILURE)
        {
            String temp= utils.Utils.getScreenshot(getDriver());
            log.fail(result.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
        }

        if(result.getStatus()==ITestResult.SUCCESS)
        {
            String temp= utils.Utils.getScreenshot(getDriver());
            log.log(Status.PASS, "Title verified");
        }

        reporter.flush();
        killDriver();
    }

}
