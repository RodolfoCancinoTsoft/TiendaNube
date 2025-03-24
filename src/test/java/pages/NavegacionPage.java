package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import utilidades.ClaseBase;

public class NavegacionPage extends ClaseBase {

    public NavegacionPage(WebDriver driver) {
        super(driver);
    }

    By locatorIngresaMailoURL = By.xpath("//input[@id='user-mail']");
    By locatorContraseña = By.xpath("//input[@id='pass']");
    By locatorIngresoATienda = By.xpath("//input[@value='Ingresar a mi tienda']");
    By locatorIngresoVentas = By.xpath("//p[contains(text(),'Ventas')]");
    By locatorBuscarPorCliente = By.xpath("//input[@placeholder='Buscar']");
    By locatorEncontarPorNombre = By.xpath("//input[@value='rodolfo']");
    //By locatorLupa = By.xpath("//button[@data-testid='icon-search']");
    By locatorContenedorBusqueda = By.xpath("//div[contains(@class, 'nimbus-input_appearance')]");
    By locatorMensajeEstadoVenta = By.xpath("//p[contains(text(),'Venta cancelada')]");

    public void navegacionDentroDeTiendaNube(String mail, String pass, String nombre) {
        agregarTexto2(esperarPorElementoAClikear(locatorIngresaMailoURL), mail);
        agregarTexto2(esperarPorElementoAClikear(locatorContraseña), pass);
        click2(esperarPorPrecenciaElemento(locatorIngresoATienda));
        click2(esperarPorPrecenciaElemento(locatorIngresoVentas));
        agregarTexto2(esperarPorElementoAClikear(locatorBuscarPorCliente), nombre);
        agregarEnteraUnTexto(locatorEncontarPorNombre, Keys.ENTER);

        //agregarEnteraUnTexto(locatorBuscarPorCliente, Keys.ENTER);


        //click2(esperarPorPrecenciaElemento(locatorLupa));
        //click2(esperarPorElementoAClikear(locatorBuscarPorCliente));

    }

    public String mensajeVenta() {
        return obtenerTexto(esperarPorPrecenciaElemento(locatorMensajeEstadoVenta));
    }

}
