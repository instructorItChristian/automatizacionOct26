package com.automatizacion;


import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

//objetivo : annotations testng -- completar el form contact us
// captura de evidencias - generacion de archivo doc individual


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Utilities.CapturaEvidencia;

public class ejer10 {

WebDriver driver;
String url="file:///D:/educacionIT2/Cursos/seleniumWEBdriver/2026/QA-mart/index.html";
String imagePath="Evidencias\\";
String docPaht="Evidencias\\documentoEvidenciasContacUs.docx";

File screen;

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
            public void formContactUs () throws InvalidFormatException, IOException, InterruptedException{


                WebDriverWait wait = new WebDriverWait (driver, Duration.ofSeconds(20));
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"product-grid\"]/div[1]")));

Date fecha = new Date();
Calendar cal = Calendar.getInstance();

cal.setTime(fecha);

int hora = cal.get(Calendar.HOUR_OF_DAY);
int min = cal.get(Calendar.MINUTE);

String docpath2 ="Evidencias\\documentoEvidenciasContacUs"+LocalDate.now()+"H"+hora+"M"+min+".docx";



                //CAPTURA DE EVIDENCIA

                CapturaEvidencia.escribirTituloEnDocumento(docpath2, "Documento Evidencia form contac us", 20);
                CapturaEvidencia.capturarPantallaEnDocumento(driver, imagePath+"img.jpg", docpath2, "pantalla principal");
//click en contact us

driver.findElement(By.linkText("Contact Us")).click(); 

//-------------------formulario

//CAPTURA DE EVIDENCIA
  CapturaEvidencia.capturarPantallaEnDocumento(driver, imagePath+"img.jpg", docpath2, "pantalla form contact us");


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

//CAPTURA DE EVIDENCIA
  CapturaEvidencia.capturarPantallaEnDocumento(driver, imagePath+"img.jpg", docpath2, "contact us completo");

//boton "enviar msj"

driver.findElement(By.cssSelector("#contact-submit")).click();


//CAPTURA DE EVIDENCIA

WebDriverWait wait2 = new WebDriverWait (driver, Duration.ofSeconds(10));
wait2.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#custom-alert-modal > div")));


  CapturaEvidencia.capturarPantallaEnDocumento(driver, imagePath+"img.jpg", docpath2, "resultado contact us");

            }



 @Test (priority = 10, description = "CP005 - buscar palabra chrome local", groups = "01")
public void BuscarPalAbraChrome_sitioLocal() throws IOException{

//navega al sitio - escribir la url
driver.get(url);

//este wait es para que cargue la pantalla y pueda tomar el screen shot correctamente
WebDriverWait wait = new WebDriverWait (driver, Duration.ofSeconds(20));
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"product-grid\"]/div[1]")));


/**CAPTURAR EVIDENCIA */

screen =((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
FileUtils.copyFile(screen, new File(imagePath+ "01PantallaInicial.jpg"));




//pararnos en el campo -- escribir lo que quiero buscar

//pararnos en el campo 
WebElement txtbuscador = driver.findElement(By.id("search-input"));
//escribir lo que quiero buscar
txtbuscador.sendKeys("cuchillos");

/**CAPTURAR EVIDENCIA */

screen =((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
FileUtils.copyFile(screen, new File(imagePath+ "02PantallaABuscar.jpg"));

//hacer click en el boton buscar
WebElement boton = driver.findElement(By.id("search-submit"));
boton.sendKeys(Keys.ENTER);


wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"product-grid\"]/div")));

/**CAPTURAR EVIDENCIA */

screen =((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
FileUtils.copyFile(screen, new File(imagePath+ "03resultado.jpg"));

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

