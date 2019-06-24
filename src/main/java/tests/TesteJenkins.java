package tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static base.DriverFactory.getDriver;

import java.io.IOException;

import static utils.Constantes.pathChrome;
import static utils.Constantes.pathProjeto;
import static utils.Utils.getDataString;
import static utils.Utils.getHoraString;

public class TesteJenkins {

    ExtentReports extent;
    ExtentTest logger;
    WebDriver driver;

    @BeforeMethod
    public void setup()
    {
        System.out.println("Before =================================================");
        ExtentHtmlReporter reporter=new ExtentHtmlReporter(pathProjeto+"\\output\\Reports\\Relatorio_"+getDataString()+"_"+getHoraString()+".html");
        extent = new ExtentReports();
        extent.attachReporter(reporter);
        logger=extent.createTest("LoginTest");
        System.out.println("Vai sair do Before =================================================");
    }

    // Actual Test which will start the application and verify the title
    @Test
    public void loginTest() throws IOException
    {
        System.out.println("Antes do Testes =================================================");
        ExtentTest logger=extent.createTest("Logoff Test");
        logger.log(Status.FAIL, "Title verified");

//        System.setProperty("webdriver.chrome.driver", pathChrome);
//        driver=new ChromeDriver();
        System.out.println("Antes do Testes =================================================");
        getDriver().get("http://www.google.com");
        System.out.println("Depois de abrir o google =================================================");
        System.out.println("title is "+getDriver().getTitle());
        Assert.assertTrue(getDriver().getTitle().contains("Google"));
    }



    // This will run after testcase and it will capture screenshot and add in report
    @AfterMethod
    public void tearDown(ITestResult result) throws IOException
    {
        System.out.println("After =================================================");
        if(result.getStatus()==ITestResult.FAILURE)
        {
            String temp= utils.Utils.getScreenshot(getDriver());
            logger.fail(result.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
        }

        extent.flush();
        getDriver().quit();
        System.out.println("Vai sair do After =================================================");
    }
}
