package com.automatizacion;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

//objetivo : annotations testng -- completar el form contact us

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ejer5 {


WebDriver driver;
String url="file:///D:/educacionIT2/Cursos/seleniumWEBdriver/2026/QA-mart/index.html";

    @BeforeSuite
public void beforesuite(){
System.out.println("beforesuite");

driver= new ChromeDriver();
                            }

	@BeforeTest
    public void beforetest(){
    driver.navigate().to(url);
    System.out.println("beforetest");
                            }
		@BeforeClass
    public void beforeclass(){
        System.out.println("beforeclass");
    
                            }

			@BeforeMethod
    public void beforemethod(){
        System.out.println("beforemethod");
    
                                }

			@Test (priority = 5, description = "CP002 - completar form contact us", groups = "01")
            public void formContactUs (){

//click en contact us

driver.findElement(By.linkText("Contact Us")).click(); 

//-------------------formulario

//completar el nombre

driver.findElement(By.xpath("//*[@id=\"contact-name\"]")).sendKeys("pepe");

//completar el email

driver.findElement(By.cssSelector("#contact-email")).sendKeys("test@test.com");

//completar el asunto

driver.findElement(By.id("contact-subject")).sendKeys("testing QA");

//completar el msj

driver.findElement(By.cssSelector("#contact-message")).sendKeys("Msj de prueba");

//adjuntar archivo

driver.findElement(By.xpath("//*[@id=\"contact-file\"]")).sendKeys("C:\\testenvio.txt");

//boton "enviar msj"

driver.findElement(By.cssSelector("#contact-submit")).click();

            }

 @Test (priority = 10, description = "CP005 - buscar palabra chrome local", groups = "01")
public void BuscarPalAbraChrome_sitioLocal(){

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




			@AfterMethod
                public void aftermethod(){
        System.out.println("afteremethod");
    
}
		@AfterClass
                 public void afterclass(){
        System.out.println("afterclass");
    
}
	@AfterTest

               public void aftertest(){
        System.out.println("aftertest");

      //  driver.close();
    
}
@AfterSuite
          public void aftersuite(){
        System.out.println("aftersuite");
    
}

}
