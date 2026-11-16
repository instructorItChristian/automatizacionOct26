package com.automatizacion;

//objetivo : dataprovider desde el excel

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utilities.DatosExcel;
import paginas.PaginaInicio;
import paginas.PaginaLogin;

public class ejer13 {

    String url ="file:///D:/educacionIT2/Cursos/seleniumWEBdriver/2026/QA-mart/index.html";

    WebDriver driver;

    @BeforeTest 
    public void setup(){
driver = new ChromeDriver();
driver.get(url);

        }

        @Test (dataProvider ="datos login excel", groups= "DP002")
        public void Login (String email, String password){

            PaginaInicio inicio = new PaginaInicio (driver);
            inicio.HacerClickSignUp();

            PaginaLogin login = new PaginaLogin(driver);
                //estos datos son para la base del profe christian
            login.EscribirEmail(email);
            login.EscribirPass(password);
            login.ClickBotonIngresar();

            WebDriverWait wait = new WebDriverWait (driver, Duration.ofSeconds(10));
        WebElement btn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nav-logout")));

            Assert.assertEquals(driver.getCurrentUrl(), "file:///D:/educacionIT2/Cursos/seleniumWEBdriver/2026/QA-mart/index.html");

         inicio.hacerLogOut();

                         }  


                         @DataProvider (name="datos login excel")
                         public Object [][] obtenerDatos() throws Exception{
                            return DatosExcel.leerExcel("Datos\\datos_Login.xlsx", "Hoja1");
                            
                            }

}

