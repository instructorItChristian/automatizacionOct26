package paginas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaginaInicio {

//elementos=localizadors
@FindBy(linkText="Signup/Login")
WebElement linkSignup;

@FindBy(id= "nav-logout")
WebElement botonLogOut;

///elementos de buscar palabra

@FindBy(id="search-input")
WebElement txtBuscardor;

@FindBy(id="search-input")
WebElement BotonBuscador;

//constructor

public PaginaInicio(WebDriver driver){
    PageFactory.initElements(driver, this);
    }

//acciones

public void HacerClickSignUp(){
linkSignup.click();

}


public void hacerLogOut()
{
botonLogOut.click();
    }


    public void EscribirPalabraABuscar(String palabra){
        txtBuscardor.sendKeys(palabra);
    }

    public void BotonPalabraABuscar(){
        BotonBuscador.click();
    }


}
