package pages;

import base.BasePage;

public class MinhaVisaoPage extends BasePage {

    public boolean verificarSeAcessouMinhaVisao() {
        boolean existe =  verificarSeExisteTextoNoTituloDaPagina("MantisBT");
        return existe;
    }
}
