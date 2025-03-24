package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pages.DatosClientePage;
import pages.HomePage;
import pages.LoginPage;
import pages.NavegacionPage;
import pages.SalirPage;
import utilidades.DataDriven;
import utilidades.PropertiesDriven;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class Tests1 {

    private WebDriver driver;
    private DataDriven data;
    private List<String> datosCP;
    private WebDriverWait wait;
    private PropertiesDriven properties;

    private String rutaDriver;
    private String property;
    private String browser;

    private HomePage homePage;
    private LoginPage loginPage;
    private SalirPage salirPage;
    private NavegacionPage navegacionPage;
    private DatosClientePage datosClientePage;


    @BeforeSuite
    public void inicioSuitesDePreubas() {
        properties = new PropertiesDriven();
        System.out.println("Inicio de suites de pruebas");

    }

    @BeforeClass
    public void preparacionClase() {
        //WebDriverManager.chromedriver().setup();
        //WebDriver driver = new ChromeDriver();


        //Se crea String ruta proyecto y ase le asigna la variable de sistema user.dir
        //String rutaProyecto = System.getProperty("user.dir"); se elimina
        //Se crea variable rutaDriver con variable anterior mas extracto del path con la referencia del driver de google chrome
        //rutaDriver = rutaProyecto + "\\src\\test\\resources\\drivers\\chromedriver.exe";  se elimina
        //property = "webdriver.chrome.driver";se elimina
        //browser = "chrome";se elimina
        data = new DataDriven();


    }

    @BeforeMethod
    public void preparacionTests() {
        homePage = new HomePage(driver);
        homePage.conexionDriver(properties.obtenerUnaProperties("rutaDriver"), properties.obtenerUnaProperties("browserProperty"), properties.obtenerUnaProperties("browser"));
        homePage.prepararDriver(Duration.ofSeconds(20));
        loginPage = new LoginPage(homePage.getDriver());
        salirPage = new SalirPage(homePage.getDriver());
        navegacionPage = new NavegacionPage(homePage.getDriver());
        datosClientePage = new DatosClientePage(homePage.getDriver());


        String url = properties.obtenerUnaProperties("url");
        homePage.cargarPagina(url);
        homePage.maximizarVentana();

    }

    @Test
    public void CP001_ingresoLogin() throws IOException {
        datosCP = data.obtenerDatosPrueba("CP001_ingresoLogin");
        homePage.accederAMiPanel();
        loginPage.formularioIngresoIncorrecto(datosCP.get(1), datosCP.get(2));

        Assert.assertEquals(loginPage.mensajeError(), datosCP.get(3));

        //String resultadoEsperado = "Tu email o contraseña son incorrectos. Revisalos y volvé a intentar.";
        //String resltadoActual = pageDosLogin.mensajeError();
    }

    @Test
    public void CP002_ingresoLoginCorrecto() throws IOException {
        datosCP = data.obtenerDatosPrueba("CP002_ingresoLoginCorrecto");
        homePage.accederAMiPanel();
        loginPage.formularioIngresoCprrecto(datosCP.get(1), datosCP.get(2));

        Assert.assertEquals(loginPage.mensajeInicio(), datosCP.get(3));

        //String resultadoActual = pageDosLogin.mensajeInicio();
        //String resultadoEsperado = "¿Cuánto cuesta tener una Tiendanube?";
        //String resultadoActual = pageTres.informacionTiendaNube();
    }

    //termina luego la wea po oeee :D
    @Test
    public void CP003_salirDePockeStop() throws IOException {
        datosCP = data.obtenerDatosPrueba("CP003_salirDePockeStop");
        homePage.accederAMiPanel();
        salirPage.salirDePockeStop(datosCP.get(1), datosCP.get(2));

        Assert.assertEquals(salirPage.mensajeLogin(), datosCP.get(3));

    }

    @Test
    public void CP004_buscarPorNombre() throws IOException {
        datosCP = data.obtenerDatosPrueba("CP004_buscarPorNombre");
        homePage.accederAMiPanel();
        navegacionPage.navegacionDentroDeTiendaNube(datosCP.get(1), datosCP.get(2), datosCP.get(3));

        Assert.assertEquals(navegacionPage.mensajeVenta(), datosCP.get(4));


    }

    @Test
    public void CP005_datosCliente() throws IOException {
        datosCP = data.obtenerDatosPrueba("CP005_datosCliente");
        homePage.accederAMiPanel();
        datosClientePage.navegacionYEnvioDeCorreo(datosCP.get(1), datosCP.get(2), datosCP.get(3), datosCP.get(4), datosCP.get(5));

        Assert.assertEquals(datosClientePage.numeroContacto(), datosCP.get(6));

    }

    @AfterMethod
    public void after() {
        homePage.cerrarVentana();


    }
}
