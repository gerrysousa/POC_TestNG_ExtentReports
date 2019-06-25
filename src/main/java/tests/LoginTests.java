package tests;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MinhaVisaoPage;

//import static base.DriverFactory.getDriver;

public class LoginTests extends BaseTests {

    //private LoginPage login;


    @Test (priority = 1, description = "Testa login com sucesso")
    public void deveLogarComSucesso() throws InterruptedException{
        //login = new LoginPage();
        new LoginPage().preencherEmail("administrator");
        new LoginPage().clicarBotaoLogin();
        new LoginPage().preencherSenha("administrator");
        new LoginPage().clicarBotaoLogin();

        Assert.assertTrue(new MinhaVisaoPage().verificarSeAcessouMinhaVisao());
    }

    /*@Test (priority = 1, description = "Testa login com falha")
    public void devefalhar() throws InterruptedException{
        login = new LoginPage();
        login.preencherEmail("administrator");
        login.clicarBotaoLogin();
        login.preencherSenha("errada");
        login.clicarBotaoLogin();

        Assert.assertTrue(getDriver().getTitle().contains("Minha Visão - MantisBT"));
    }*/

}
