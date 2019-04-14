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
import static utils.Constantes.urlBase;
import static utils.Utils.getScreenshot;

public class BaseTests {

    public static ExtentHtmlReporter relatorio =new ExtentHtmlReporter("./Reports/learn_automation2.html");
    public static ExtentReports reporter = new ExtentReports();
    public static ExtentTest log;
    protected static WebDriver driver;
/*
ExtentHtmlReporter relatorio=new ExtentHtmlReporter("./Reports/learn_automation2.html");
ExtentReports reporter = new ExtentReports();
ExtentTest log;
---
reporter.attachReporter(relatorio);
log=reporter.createTest("LoginTest");

log.log(Status.INFO, "Login to amazon");
reporter.flush();
*/


    // call createTest method and pass the name of TestCase- Based on your requirement
   // ExtentTest logger=extent.createTest("LoginTest");


    @BeforeSuite
    public static void inicia() {
        //ConexaoBD.resetBD();

        reporter.attachReporter(relatorio);
        getDriver().get(urlBase);

    }


//    @BeforeTest
//    public static void  beforeTest(){
//        //log=reporter.createTest("LoginTest");
//        log.log(Status.INFO, "Before test");
//    }

    @AfterTest
    public static void afterTest() throws IOException {
       /* if(result.getStatus()==ITestResult.FAILURE)
        {
            String temp= Utils.getScreenshot(driver);
            log.fail(result.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
        }*/

     //   relatorio.flush();
       // driver.quit();
    }

    @AfterSuite
    public static void finalizaClasse() {
      //  DriverFactory.killDriver();
    }

   // @AfterMethod
   // public void tearDown() {
   //     //gerarScreenShot();
   //     relatorio.flush();
   //     //DriverFactory.getDriver().close();
   //   //  DriverFactory.killDriver();
   // }

    @BeforeMethod
    public void inicializaTeste() {
        log=reporter.createTest("LoginTest");


        //ExtentHtmlReporter reporter=new ExtentHtmlReporter("./Reports/learn_automation2.html");
        // extent = new ExtentReports();
        // extent.attachReporter(reporter);
        // logger=extent.createTest("LoginTest");
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
