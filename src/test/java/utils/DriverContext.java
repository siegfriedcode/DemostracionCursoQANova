package utils;

import utils.Constants.Navegador;
import org.openqa.selenium.WebDriver;

public class DriverContext {

    private static DriverManager driverManager = new DriverManager();
    private static Navegador tipoNavegador;
    private static String ambienteURL = "";

   public static void setUp(Navegador nav, String ambURL) {
        setTipoNavegador(nav);
        setAmbienteURL(ambURL);
        System.out.println("driver context");
        driverManager.resolveDriver(nav, ambURL);
   }

    public static String getAmbienteURL() {
        return ambienteURL;
    }

    public static void setAmbienteURL(String ambienteURL) {
        DriverContext.ambienteURL = ambienteURL;
    }

    public static void setTipoNavegador(Navegador tipoNavegador) {
        DriverContext.tipoNavegador = tipoNavegador;
    }

    public static WebDriver getDriver() {
        return driverManager.getDriver();
    }

    public static void closeDriver(){
       driverManager.closeDriver();
    }

    public static String getTipoNavegador() {
        return tipoNavegador.toString();
    }

}