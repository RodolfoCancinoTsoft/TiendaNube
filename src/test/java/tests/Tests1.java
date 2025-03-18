package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.NavegarPage;
import utilidades.DataDriven;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class Tests1 {

    private WebDriver driver;
    private DataDriven data;
    private List<String> datosCP;
    private WebDriverWait wait;

    private String rutaDriver;
    private String property;
    private String browser;

    private HomePage homePage;
    private LoginPage pageDosLogin;
    private NavegarPage pageTres;

    @BeforeSuite
    public void inicioSuitesDePreubas() {
        System.out.println("Inicio de suites de pruebas");

    }

    @BeforeClass
    public void preparacionClase() {
        //WebDriverManager.chromedriver().setup();
        //WebDriver driver = new ChromeDriver();

        //Se crea String ruta proyecto y ase le asigna la variable de sistema user.dir
        String rutaProyecto = System.getProperty("user.dir");
        //Se crea variable rutaDriver con variable anterior mas extracto del path con la referencia del driver de google chrome
        rutaDriver = rutaProyecto + "\\src\\test\\resources\\drivers\\chromedriver.exe";
        property = "webdriver.chrome.driver";
        browser = "chrome";

        data = new DataDriven();


    }

    @BeforeMethod
    public void preparacionTests() {
        homePage = new HomePage(driver);
        homePage.conexionDriver(rutaDriver, property, browser);
        homePage.prepararDriver(Duration.ofSeconds(20));


        pageDosLogin = new LoginPage(homePage.getDriver());
        pageTres = new NavegarPage(homePage.getDriver());
        String url = "https://www.tiendanube.com/";
        homePage.cargarPagina(url);
        homePage.maximizarVentana();

    }

    @Test
    public void CP001_ingresoLogin() throws IOException {
        datosCP = data.obtenerDatosPrueba("CP001_ingresoLogin");
        homePage.accederAMiPanel();
        pageDosLogin.formularioIngresoIncorrecto(datosCP.get(1), datosCP.get(2));
        //String resultadoEsperado = "Tu email o contraseña son incorrectos. Revisalos y volvé a intentar.";
        //String resltadoActual = pageDosLogin.mensajeError();

        Assert.assertEquals(pageDosLogin.mensajeError(), datosCP.get(3));
    }

    @Test
    public void CP002_ingresoLoginCorrecto() throws IOException {
        datosCP = data.obtenerDatosPrueba("CP002_ingresoLoginCorrecto");

        homePage.accederAMiPanel();
        pageDosLogin.formularioIngresoCprrecto(datosCP.get(1), datosCP.get(2));

        //String resultadoActual = pageDosLogin.mensajeInicio();

        Assert.assertEquals(pageDosLogin.mensajeInicio(), datosCP.get(3));

        //String resultadoEsperado = "¿Cuánto cuesta tener una Tiendanube?";
        //String resultadoActual = pageTres.informacionTiendaNube();


    }

    @Test
    public void CP003_salirDePockeStop() throws IOException {
        datosCP = data.obtenerDatosPrueba("CP003_salirDePockeStop");
        homePage.accederAMiPanel();
        pageDosLogin.salirDePockeStop(datosCP.get(1), datosCP.get(2));

        Assert.assertEquals(pageDosLogin.mensajeLogin(), datosCP.get(3));

    }

    @Test
    public void CP004() {

    }

    @Test
    public void CP005() {

    }

    @AfterMethod
    public void after() {
        homePage.cerrarVentana();


    }
}
