package testClass;

import org.openqa.selenium.WebDriver;
import page.CargaInformacion;
import page.Login;

import java.text.ParseException;

public class Logeo {

    private Login login;

    private CargaInformacion cargaInformacion;

    WebDriver webDriver;

//    public Logeo(WebDriver webDriver){
//        this.webDriver = webDriver;
//    }

    public Logeo(){

    }

    public void CasoLogin1(String usuario, String clave) throws ParseException {
        login = new Login();
        cargaInformacion = new CargaInformacion();
        login.ingresarUsuario(usuario);
        login.ingresarClave(clave);
        login.clickBtnIngresar();
        cargaInformacion.recuperarTitulo();
        cargaInformacion.rellenarCampoTexto("Testeo CAFB");
        cargaInformacion.rellenarCampoMail("prueba@testeo.cl");
        cargaInformacion.rellenarCampoAreaTexto("Prueba de testeo automatizacion Java con Selenium.");
        //cargaInformacion.seleccionarFechaCalendario("2023/10/12");
        cargaInformacion.rellenarCampoFecha("12/10/2023");
        cargaInformacion.rellenarCampoLista("valor 3");
        //cargaInformacion.seleccionMultiple(2);
        cargaInformacion.seleccionMultiple2("2,3");
        cargaInformacion.comboRadio(1);
        cargaInformacion.clickBtnEnviar();
    }
}
