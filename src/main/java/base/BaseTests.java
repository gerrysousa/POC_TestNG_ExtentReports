package base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utils.Utils;

import java.io.IOException;

import static utils.Utils.getScreenshot;

public class BaseTests {

    private static ExtentReports relatorio;
    private static ExtentTest log;
    protected static WebDriver driver;
    private static ExtentHtmlReporter reporter;

    @BeforeClass
    public static void inicia() {
        //ConexaoBD.resetBD();
        reporter=new ExtentHtmlReporter("./Reports/learn_automation2.html");
        relatorio = new ExtentReports();
        relatorio.attachReporter(reporter);
    }

    @BeforeTest
    public static void  beforeTest(){
        log=relatorio.createTest("LoginTest");
    }

    @AfterTest
    public static void afterTest(ITestResult result) throws IOException {
        if(result.getStatus()==ITestResult.FAILURE)
        {
            String temp= Utils.getScreenshot(driver);
            log.fail(result.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
        }

        relatorio.flush();
        driver.quit();
    }

    @AfterClass
    public static void finalizaClasse() {
        DriverFactory.killDriver();
    }

    @AfterMethod
    public void tearDown() {
        //gerarScreenShot();
        DriverFactory.getDriver().close();
        DriverFactory.killDriver();
    }



}
