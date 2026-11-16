package com.automatizacion;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ejer8 {

    //ojo con la linea 15, la direccion debe ser la suya propia
    String url ="file:///D:/educacionIT2/Cursos/seleniumWEBdriver/2026/QA-mart/index.html";
WebDriver driver;


//if (condicion) {accionV} else {accionF}
@Parameters("navegador")
@BeforeTest 
public void setup(String navegador){

    if(navegador.equalsIgnoreCase("chrome"))
{driver = new ChromeDriver();} 
    
    else if (navegador.equalsIgnoreCase("firefox"))

{driver = new FirefoxDriver();} 

driver.get(url);

}


//acciones - metodos
@Test (groups = "099")
public void BuscarPalAbraChrome_sitioLocal(){

//pararnos en el campo -- escribir lo que quiero buscar

//pararnos en el campo 
WebElement txtbuscador = driver.findElement(By.id("search-input"));
//escribir lo que quiero buscar
txtbuscador.sendKeys("silla");

//hacer click en el boton buscar
WebElement boton = driver.findElement(By.id("search-submit"));
boton.sendKeys(Keys.ENTER);


}



}
