package testSuite;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import testClass.Logeo;
import utils.Constants.Navegador;
import utils.DriverContext;
import utils.Reporte.PdfQaNovaReports;

import java.text.ParseException;

public class Prueba {

    ChromeDriver webDriver;

    //String url = "https://google.cl";
    String url = "http://www.qanovagroup.com/piloto";
    //private utils.Constants.Navegador Navegador;

//    @BeforeTest
//    public void setUp(){
//    System.setProperty("webdriver.chrome.driver","driverNavegador/chromedriver");
//    webDriver = new ChromeDriver();
//    webDriver.get(url);
//    }

    @BeforeTest
    public void setUp(){
        DriverContext.setUp(Navegador.Chrome,url);
        PdfQaNovaReports.createPDF();
    }

    @AfterTest
    public void closeDriver(){
        //DriverContext.closeDriver();

    }

    @Test
    public void pruebaLogin() throws ParseException {
        Logeo logeo = new Logeo();
        logeo.CasoLogin1("nvivas","qanova");
        PdfQaNovaReports.closePDF();
    }
}
