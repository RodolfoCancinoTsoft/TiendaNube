package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilidades.ClaseBase;

public class LoginPage extends ClaseBase {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    By locatorIngresaMailoURL = By.xpath("//input[@id='user-mail']");
    By locatorContraseña = By.xpath("//input[@id='pass']");
    By locatorIngresoATienda = By.xpath("//input[@value='Ingresar a mi tienda']");
    By locatorMensajeError = By.xpath("//div[contains(text(),'Tu email o contraseña son incorrectos. Revisalos y')]");
    By locatorMensajeInicio = By.xpath("//h1[contains(text(),'Inicio')]");


    //Acciones de la pagina ingreso y boton
    public void formularioIngresoIncorrecto(String mail, String pass) {
        agregarTexto2(esperarPorElementoAClikear(locatorIngresaMailoURL), mail);
        agregarTexto2(esperarPorElementoAClikear(locatorContraseña), pass);
        click2(esperarPorPrecenciaElemento(locatorIngresoATienda));
    }

    public void formularioIngresoCprrecto(String mail, String pass) {
        agregarTexto2(esperarPorElementoAClikear(locatorIngresaMailoURL), mail);
        agregarTexto2(esperarPorElementoAClikear(locatorContraseña), pass);
        click2(esperarPorPrecenciaElemento(locatorIngresoATienda));
    }


    public String mensajeError() {
        return obtenerTexto(esperarPorPrecenciaElemento(locatorMensajeError));
    }

    public String mensajeInicio() {
        return obtenerTexto((esperarPorPrecenciaElemento(locatorMensajeInicio)));
    }
}
