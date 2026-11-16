package com.automatizacion;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

//objetivo prueba sitio web internet

public class ejer1_1 {

    //comentario liniea

/*
comentario de bloque

*/

//variables

String url ="https://automationexercise.com/products";
WebDriver driver;

//acciones - metodos
@Test 
public void BuscarPalAbraChrome(){

//1 - abrir el navegador
driver = new ChromeDriver();

//navega al sitio - escribir la url
driver.get(url);
//maximizar la pantalla
//driver.manage().window().maximize();

//pararnos en el campo -- escribir lo que quiero buscar

//pararnos en el campo 
WebElement txtbuscador = driver.findElement(By.id("search_product"));
//escribir lo que quiero buscar
txtbuscador.sendKeys("dress");

//hacer click en el boton buscar
WebElement boton = driver.findElement(By.id("submit_search"));
boton.sendKeys(Keys.ENTER);


}







}
