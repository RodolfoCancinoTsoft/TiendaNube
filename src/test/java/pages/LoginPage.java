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
    By locatorSalirPocke = By.xpath("//p[contains(text(),'PokeStop')]");
    By locatorCerrarSesion = By.xpath("//body/div[@id='nimbus-popover-floating']/div[@id=':rf:']/div[1]/div[1]/div[2]/div[1]/button[1]/div[1]/p[1]");
    By locatorMensajeLogin = By.xpath("//h1[contains(text(),'Login')]");
    By locatorVentas = By.xpath("//p[contains(text(),'Ventas')]");

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

    public void salirDePockeStop(String mail, String pass) {
        agregarTexto2(esperarPorElementoAClikear(locatorIngresaMailoURL), mail);
        agregarTexto2(esperarPorElementoAClikear(locatorContraseña), pass);
        click2(esperarPorPrecenciaElemento(locatorIngresoATienda));
        click2(esperarPorPrecenciaElemento(locatorSalirPocke));
        click2(esperarPorElementoAClikear(locatorCerrarSesion));
    }

    public String mensajeLogin() {
        return obtenerTexto(esperarPorPrecenciaElemento(locatorMensajeLogin));
    }

    public String mensajeError() {
        return obtenerTexto(esperarPorPrecenciaElemento(locatorMensajeError));
    }

    public String mensajeInicio() {
        return obtenerTexto((esperarPorPrecenciaElemento(locatorMensajeInicio)));
    }
}
