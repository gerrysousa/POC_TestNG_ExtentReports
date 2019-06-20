package pages;

import base.BasePage;

import static base.DriverFactory.getDriver;

public class MinhaVisaoPage extends BasePage {

    public boolean verificarSeAcessouMinhaVisao() {
        boolean existe =  verificarSeExisteTextoNoTituloDaPagina("MantisBT");
        return existe;
    }
}
