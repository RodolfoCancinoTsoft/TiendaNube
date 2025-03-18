package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import utilidades.ClaseBase;

public class DatosClientePage extends ClaseBase {

    public DatosClientePage(WebDriver driver) {
        super(driver);
    }

    By locatorIngresaMailoURL = By.xpath("//input[@id='user-mail']");
    By locatorContraseña = By.xpath("//input[@id='pass']");
    By locatorIngresoATienda = By.xpath("//input[@value='Ingresar a mi tienda']");
    By locatorIngresoVentas = By.xpath("//p[contains(text(),'Ventas')]");
    By locatorBuscarPorCliente = By.xpath("//input[@placeholder='Buscar por número o monto exacto de la venta, nombre o e-mail del cliente, nombre de quien retira']");
    By locatorNumeroVenta = By.xpath("//a[contains(text(),'#1843')]");
    By locatorMail = By.xpath("//a[contains(text(),'crownro213')]");
    By locatorIngresoAsunto = By.xpath("//input[@id='input_subject']");
    By locatorIngresoMensaje = By.xpath("//textarea[@id='input_content']");
    By locatorBtncancelar = By.xpath("//button[contains(text(),'Cancelar')]");
    By locatorContacto = By.xpath("//a[contains(text(),'962545')]");

    public void navegacionYEnvioDeCorreo(String mail, String pass, String nombre, String asunto, String mensaje) {
        agregarTexto2(esperarPorElementoAClikear(locatorIngresaMailoURL), mail);
        agregarTexto2(esperarPorElementoAClikear(locatorContraseña), pass);
        click2(esperarPorPrecenciaElemento(locatorIngresoATienda));
        click2(esperarPorPrecenciaElemento(locatorIngresoVentas));
        agregarTexto2(esperarPorElementoAClikear(locatorBuscarPorCliente), nombre);
        agregarEnteraUnTexto(locatorBuscarPorCliente, Keys.ENTER);
        click2(esperarPorPrecenciaElemento(locatorNumeroVenta));
        click2(esperarPorPrecenciaElemento(locatorMail));
        agregarTexto2(esperarPorElementoAClikear(locatorIngresoAsunto), asunto);
        agregarTexto2(esperarPorElementoAClikear(locatorIngresoMensaje), mensaje);
        click2(esperarPorPrecenciaElemento(locatorBtncancelar));

    }

    public String numeroContacto() {
        return obtenerTexto(esperarPorPrecenciaElemento(locatorContacto));
    }


}
