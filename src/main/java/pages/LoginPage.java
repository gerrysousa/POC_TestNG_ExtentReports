package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static base.DriverFactory.getDriver;


public class LoginPage extends BasePage {

    @FindBy(id = "username")
    private WebElement txtEmail;


    @FindBy(id = "password")
    private WebElement txtSenha;

    @FindBy(xpath = "//input[@type='submit']")
    private WebElement btnLogin;



    public void preencherEmail(String email) {
       escrever(txtEmail, email);
    }

    public void preencherSenha(String senha) {
        escrever(txtSenha, senha);
    }

    public void clicarBotaoLogin() {
        clicar(btnLogin);
    }



//    public boolean verficarSeLogouComSucesso() {
//        clicar(By.id("mn-dashboard"));
//        boolean existe = getDriver().getPageSource().contains("Processo Seletivo");
//
//        return	existe;
//    }
//
//    public boolean verificarAlerta(String alerta){
//        boolean existe = getDriver().getPageSource().contains(alerta);
//
//        return	existe;
//    }
}
