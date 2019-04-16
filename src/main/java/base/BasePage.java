package base;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static base.DriverFactory.getDriver;
import static utils.Constantes.urlBase;

public class BasePage {
    private static ExtentTest log;
    private static WebDriverWait wait;

    public BasePage() {
        this.log = BaseTests.log;
        wait =  new WebDriverWait(getDriver(), 10);
        PageFactory.initElements(getDriver(), this);
    }

    public void escrever(WebElement element, String texto) {
        String metodoChamada = Thread.currentThread().getStackTrace()[2].getMethodName();
        try {
           log.info("Ação: '" + metodoChamada + "' com o valor: '"+texto+"'");
           wait.until(ExpectedConditions.elementToBeClickable(element)).clear();
           element.sendKeys(texto);
       }
        catch (Exception e){
            log.fail("Não conseguiu executar a ação: '"+ metodoChamada+"'");
            try {
               // log.fail("", MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot.captureScreen()).build());
                log.error(e.toString());
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }

    public void clicar(WebElement element) {
        String metodoChamada = Thread.currentThread().getStackTrace()[2].getMethodName();
        try {
            log.info("Ação: '"+ metodoChamada+"'");
            wait.until(ExpectedConditions.elementToBeClickable(element)).click();
        }
        catch (Throwable e) {
            //log que não conseguiu clicar
            log.fail("Não conseguiu executar a ação: '"+ metodoChamada+"'");
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
