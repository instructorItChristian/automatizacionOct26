package com.automatizacion;

//objetivo : data provider desde una base de datos MySQL -- metodo login

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utilities.DatosBD;
import paginas.PaginaInicio;
import paginas.PaginaLogin;

public class ejer15 {
 String url = "file:///D:/educacionIT2/Cursos/seleniumWEBdriver/2026/QA-mart/index.html";
    WebDriver driver;

    // --- Datos de conexion (los mismos de ejer13) ---
    String dbUrl = "jdbc:mysql://192.168.56.101:3306/digitalers2023";
    String dbUsuario = "root2";
    String dbClave = "@DjvjhWfTYRl(NIE";

    // Solo traemos los usuarios activos, en el orden en que se cargaron
    String query = "SELECT email, password FROM usuarios WHERE activo = 1 ORDER BY id;";

    @BeforeTest
    public void setup() {
        driver = new ChromeDriver();
        driver.get(url);
    }

    @Test(dataProvider = "datos login bd", groups = "g1")
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

    @DataProvider(name = "datos login bd")
    public Object[][] obtenerDatos() throws Exception {
        Object[][] datos = DatosBD.leerBD(dbUrl, dbUsuario, dbClave, query);

        // Si la tabla viene vacia, fallamos con un mensaje claro
        // (si no, TestNG ejecutaria 0 tests y pareceria que "paso" todo)
        Assert.assertTrue(datos.length > 0, "La consulta no devolvio usuarios para el login");

        return datos;
    }

    @AfterTest
    public void cerrar() {
        if (driver != null) {
            driver.quit();
        }
    }
}
