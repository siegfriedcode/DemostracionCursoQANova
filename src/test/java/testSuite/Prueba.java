package testSuite;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import testClass.BusquedaAnimalesGoogle;

public class Prueba {

    ChromeDriver webDriver;

    String url = "https://google.cl";

    @BeforeTest
    public void setUp(){
    System.setProperty("webdriver.chrome.driver","driverNavegador/chromedriver");
    webDriver = new ChromeDriver();
    webDriver.get(url);
    }

    @AfterTest
    public void closeDriver(){
    //webDriver.close();
    }

    @Test
    public void buscarPerroEnGoogle(){
    BusquedaAnimalesGoogle busquedaAnimalesGoogle = new BusquedaAnimalesGoogle();
    busquedaAnimalesGoogle.busquedaPerro(webDriver);

    }
}
