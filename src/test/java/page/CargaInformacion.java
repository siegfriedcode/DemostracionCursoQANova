package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CargaInformacion {

    @FindBy( xpath = "//*[@id=\"imPgTitle\"]")
    private WebElement titulo;

    WebDriver webDriver;

    public CargaInformacion(WebDriver webDriver){
        PageFactory.initElements(webDriver, this);
        this.webDriver = webDriver;
    }

    public String recuperarTitulo(){
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(titulo));
        String texto = titulo.getText();
        return texto;
    }
}
