package com.automatizacion;
//obejetivo registrarnos en qa-mark

import java.time.Duration;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ejer4 {


String url="file:///D:/educacionIT2/Cursos/seleniumWEBdriver/2026/QA-mart/login.html";
WebDriver driver;

@Test 
public void RegistrarUsuario(){

   driver= new ChromeDriver();

    driver.navigate().to(url);
/*
comenetario bloque

*/

//ingresar el nombre

driver.findElement(By.id("pre-username")).sendKeys("test9654785214521321");


//ingresar el email

driver.findElement(By.cssSelector("#pre-email")).sendKeys("test9654785214521321@test.com");

//boton "comenzar registro"

driver.findElement(By.xpath("//*[@id=\"preregister-submit\"]")).click();

//la linea39 es equivalente a la 36
//driver.findElement(By.xpath("//button[@id=\"preregister-submit\"]")).click();

// espera para que la pagina del formulario cargue completamente

WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

WebElement btn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("signup-title-mrs")));

//----------------formulario de carga-----------------------------------

//escribir el titulo

driver.findElement(By.id("signup-title-mrs")).click();
//escribir la pass
/* 
este es el xpath del chrome
//*[@id="signup-password"]
*/
driver.findElement(By.xpath("//input[@data-qa=\"signup-password\"]")).sendKeys("test1234");

//seleccionar el dia de nacimiento
Select dia = new Select(driver.findElement(By.cssSelector("#dob-day")));
dia.selectByVisibleText("15");

//seleccionar el mes de nacimiento

Select mes = new Select (driver.findElement(By.id("dob-month")));
mes.selectByValue("7");

//seleccionar el año de nacimiento
Select year = new Select (driver.findElement(By.xpath("//*[@id=\"dob-year\"]")));
year.selectByIndex(17);


// botones de novedades

driver.findElement(By.cssSelector("#signup-newsletter")).click();

// ingresar el nombre //*[@id="signup-firstname"]

driver.findElement(By.xpath("//*[@id=\"signup-firstname\"]")).sendKeys("pepe");

//ingresar el apellido signup-lastname
driver.findElement(By.id("signup-lastname")).sendKeys("Argento");

//ingresar la empresa

driver.findElement(By.cssSelector("#signup-company")).sendKeys("QA-Automatizacion");

//ingresar direccion1 signup-address1
driver.findElement(By.id("signup-address1")).sendKeys("calle QA 1234");

//ingresar direccion2 signup-address2

driver.findElement(By.id("signup-address2")).sendKeys("es una casa");
//seleccionar pais

Select pais = new Select(driver.findElement(By.xpath("//select[@data-qa=\"signup-country\"]")));
pais.selectByVisibleText("México");

//ingresar provincia/estasdo
driver.findElement(By.cssSelector("#signup-state")).sendKeys("provincia QA");
//ingresar codigo postal

driver.findElement(By.id("signup-zip")).sendKeys("1234");

//ingresar nro de telefono

driver.findElement(By.cssSelector("#signup-phone")).sendKeys("11112222");
//boton crear cuenta

driver.findElement(By.xpath("//*[@id=\"signup-submit\"]")).click();


WebElement modal = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("custom-alert-close")));



//ventana modal

driver.findElement(By.id("custom-alert-close")).click();

//cerrar la ventana y la conectividad con el navegador
driver.quit();



}


}
