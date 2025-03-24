package utilidades;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ClaseBase {

    private WebDriver driver;
    private WebDriverWait wait;

    //Contructor

    public ClaseBase(WebDriver driver) {
        this.driver = driver;
        //this.wait = wait;
    }

    //Get and Set
    public WebDriver getDriver() {
        return driver;
    }

    public WebDriverWait getWait() {
        return wait;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public void setWait(WebDriverWait wait) {
        this.wait = wait;
    }


    //Metodos
    public WebElement buscarElementoWeb(By localizador) {
        return driver.findElement(localizador);
    }

    public List<WebElement> buscarElementosWeb(By localizador) {
        return driver.findElements(localizador);
    }

    //Click
    public void click(By localizador) {
        this.driver.findElement(localizador).click();
    }

    public void click2(WebElement elemento) {
        elemento.click();
    }

    //Agregar Texto
    public void agregarTexto(By localizador, String texto) {
        this.driver.findElement(localizador).sendKeys(texto);
    }

    public void agregarTexto2(WebElement elemento, String texto) {
        elemento.sendKeys(texto);
    }

    //agregar Conbinacion Teclas
    public void agregarEnteraUnTexto(By localizador, Keys key) {
        //this.driver.findElement(localizador).sendKeys(key);
        esperarPorPrecenciaElemento(localizador).sendKeys(key);
    }

    //Otener Un texto
    public String obtenerTexto(By localizador) {
        return this.driver.findElement(localizador).getText();
    }

    public String obtenerTexto(WebElement elemento) {
        return elemento.getText();
    }

    //Cargar Pagina
    public void cargarPagina(String url) {
        this.driver.get(url);
    }

    //Espera Fija segundos fijos de espera
    public void esperarXsegundos(int milisegundos) {
        try {
            Thread.sleep(milisegundos);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //Espera Explicita
    public WebElement esperarPorPrecenciaElemento(By localizador) {
        wait = new WebDriverWait(this.driver, Duration.ofSeconds(20));

        return wait.until(ExpectedConditions.presenceOfElementLocated(localizador));
    }

    public WebElement esperarPorElementoAClikear(By localizador) {
        wait = new WebDriverWait(this.driver, Duration.ofSeconds(20));

        return wait.until(ExpectedConditions.elementToBeClickable(localizador));
    }

    public WebDriver conexionDriver(String ruta, String property, String browser) {
        switch (browser) {
            case "chrome":
                System.setProperty(property, ruta);
                this.driver = new ChromeDriver();
                return driver;
            case "firefox":
                System.setProperty(property, ruta);
                this.driver = new FirefoxDriver();
                return driver;
            case "edge":
                System.setProperty(property, ruta);
                this.driver = new EdgeDriver();
                return driver;
            default:
                return driver;
            //WebDriver driver = new ChromeDriver();
        }
    }

    //Maximizar la ventana
    public void maximizarVentana() {
        this.driver.manage().window().maximize();
    }

    //Cerrar la ventana
    public void cerrarVentana() {
        this.driver.close();
    }

    //Iframames REVISAR
    public int contarIframes(By localizador) {
        List<WebElement> frames = this.driver.findElements(localizador);
        return frames.size();
    }

    public void irAFramesByIndex(int index) {
        this.driver.switchTo().frame(index);
    }

    public void irAFramesByIdOName(String nameOrID) {
        this.driver.switchTo().frame(nameOrID);
    }

    public void prepararDriver(Duration tiempoSegundos) {
        this.driver.manage().timeouts().pageLoadTimeout(tiempoSegundos);
        this.driver.manage().timeouts().implicitlyWait(tiempoSegundos);
        this.driver.manage().timeouts().scriptTimeout(tiempoSegundos);

    }

    public void irA(String url) {
        this.driver.navigate().to(url);
    }
}
