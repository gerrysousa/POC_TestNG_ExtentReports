package base;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    protected static WebDriver driver;
    private static ExtentTest relatorio;
    private static WebDriverWait wait;

    public BasePage(ExtentTest log) {
        relatorio = log;
        driver = DriverFactory.getDriver();
        wait =  new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }


    public void escrever(WebElement element, String texto) {
       try {
           relatorio.info("set " + element + "'s text as '" + texto + "'");
           wait.until(ExpectedConditions.elementToBeClickable(element)).clear();
           element.sendKeys(texto);
       }
        catch (Exception e){
            relatorio.fail("Element is not available " + element);

            try {
                //relatorio.fail("", MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot.captureScreen()).build());
                relatorio.error(e.toString());
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }

    public void clicar(WebElement element) {
        try {
            relatorio.info("Click on " + element);
            wait.until(ExpectedConditions.elementToBeClickable(element)).click();
        }
        catch (Throwable e) {
            //log que não conseguiu clicar
            relatorio.fail("Não conseguiur clicar no elemento " + element);
        }
    }

    public String obterTexto(WebElement element) {
        try {
            //wait até elemento aparecer

            //clica no elemento
            //  return getDriver().findElement(by).getText();

            //log que conseguiu escrever
        }
        catch (Throwable e) {
            //log que não conseguiu escrever

        }
        return  "";
    }


   /* public void clicarTexto(String texto) {
        clicar(By.xpath("//*[@text='"+texto+"']"));
    }

    public void selecionarCombo(By by, String valor) {
        getDriver().findElement(by).click();
        clicarTexto(valor);
    }

    public boolean isCheckMarcado(By by) {
        return getDriver().findElement(by).getAttribute("checked").equals("true");
    }


    public String obterTituloAlerta() {
        return obterTexto(By.id("alertTitle"));
    }

    public String obterMensageAlerta() {
        return obterTexto(By.id("id/message"));
    }

    public void esperar(int num) throws InterruptedException {
        Thread.sleep(num);
    }*/


}
