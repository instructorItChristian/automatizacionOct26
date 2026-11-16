package com.automatizacion;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import paginas.PaginaInicio;
import paginas.PaginaLogin;

public class ejer9 {

    String url ="file:///D:/educacionIT2/Cursos/seleniumWEBdriver/2026/QA-mart/index.html";

    WebDriver driver;

    @BeforeTest 
    public void setup(){
driver = new ChromeDriver();
driver.get(url);

        }

        @Test 
        public void Login (){

            PaginaInicio inicio = new PaginaInicio (driver);
            inicio.HacerClickSignUp();

            PaginaLogin login = new PaginaLogin(driver);
                //estos datos son para la base del profe christian
            login.EscribirEmail("test@test.com");
            login.EscribirPass("test1234");
            login.ClickBotonIngresar();

            WebDriverWait wait = new WebDriverWait (driver, Duration.ofSeconds(10));
            WebElement btn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nav-logout")));

            Assert.assertEquals(driver.getCurrentUrl(), "file:///D:/educacionIT2/Cursos/seleniumWEBdriver/2026/QA-mart/index.html");

            inicio.hacerLogOut();

                         }  



@Test 
public void BuscarPalabra(){

    PaginaInicio inicio = new PaginaInicio(driver);
    inicio.EscribirPalabraABuscar("silla");
    inicio.BotonPalabraABuscar();

}  

}
