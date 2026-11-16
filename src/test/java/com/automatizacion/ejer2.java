package com.automatizacion;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//objetivo prueba sitio web local


public class ejer2 {
//ojo con la linea 15, la direccion debe ser la suya propia
    String url ="file:///D:/educacionIT2/Cursos/seleniumWEBdriver/2026/QA-mart/index.html";
WebDriver driver;

//acciones - metodos
@Test 
public void BuscarPalAbraChrome_sitioLocal(){

//1 - abrir el navegador
driver = new ChromeDriver();

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



