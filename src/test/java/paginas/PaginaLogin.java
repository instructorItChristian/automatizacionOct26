package paginas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaginaLogin {

//elementos

@FindBy(id="login-email")
WebElement txtEmail;

@FindBy(xpath = "//*[@id=\"login-password\"]")
WebElement txtpass;

@FindBy(css = "#login-submit")
WebElement botonIngresar;

//constructor


public PaginaLogin(WebDriver driver){
    PageFactory.initElements(driver, this);
    }

//acciones

//1 - completar email

public void EscribirEmail(String email){
txtEmail.sendKeys(email);

}

//2 - completar pass

public void EscribirPass(String pass){

    txtpass.sendKeys(pass);
}

//3 - boton
public void ClickBotonIngresar(){
botonIngresar.click();

}



}
