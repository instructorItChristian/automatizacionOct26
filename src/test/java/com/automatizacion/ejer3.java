package com.automatizacion;

//objetivo : busqueda en firefox y chrome con webdriver

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ejer3 {
//ojo con la linea 15, la direccion debe ser la suya propia
    String url ="file:///D:/educacionIT2/Cursos/seleniumWEBdriver/2026/QA-mart/index.html";
    String firefoxpath="demo\\Drivers\\geckodriver0.37.1.exe";
    String chromebetapath="D:\\educacionIT2\\Cursos\\workspaceVSC\\cursoAutomatizacionOct2026\\demo\\Drivers\\chromedriver156.0.8078.47.exe";
WebDriver driver;

//acciones - metodos
@Test 
public void BuscarPalAbraChrome_sitioLocal_firefox(){
//la siguiente linea es accesoria, no es necesaria para ejecutar en firefox
System.setProperty("webdriver.firefox.driver", firefoxpath); 

//1 - abrir el navegador
driver = new FirefoxDriver();

//navega al sitio - escribir la url
driver.get(url);
//maximizar la pantalla
//driver.manage().window().maximize();

//pararnos en el campo -- escribir lo que quiero buscar

//pararnos en el campo 
WebElement txtbuscador = driver.findElement(By.id("search-input"));
//escribir lo que quiero buscar
txtbuscador.sendKeys("silla");

//hacer click en el boton buscar
WebElement boton = driver.findElement(By.id("search-submit"));
boton.sendKeys(Keys.ENTER);


}

@Test 
public void BuscarPalAbraChromeBeta_sitioLocal_CDriver(){

    //la linea 52 es para setear el driver es opcional hoy no se necesita
System.setProperty("webdriver.chrome.driver", chromebetapath);

ChromeOptions options = new ChromeOptions();
//le vamos a pasar la direccion fisica de instalacion del navegador
options.setBinary("C:\\Program Files\\Google\\Chrome Beta\\Application\\chrome.exe");

//agregamos otra caracteristica a las opciones
options.addArguments("incognito");

//1 - abrir el navegador
driver = new ChromeDriver(options);

//navega al sitio - escribir la url
driver.get(url);
//maximizar la pantalla
//driver.manage().window().maximize();

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




