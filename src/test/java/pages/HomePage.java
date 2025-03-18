package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilidades.ClaseBase;

public class HomePage extends ClaseBase {


    public HomePage(WebDriver driver) {
        super(driver);
    }

    //Si quiero hacer una accion desde l apagina de inicio se debe de hacer desde aca(crear el boton de acceoso)
    By locatorBtnAccederAMiPanel = By.xpath("/html/body/header/div/div/nav/div[2]/div[2]/ul/li[2]/div[2]/a[1]");


    public void accederAMiPanel() {
        click2(esperarPorElementoAClikear(locatorBtnAccederAMiPanel));
    }


}
