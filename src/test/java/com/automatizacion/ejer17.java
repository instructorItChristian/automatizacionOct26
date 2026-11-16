package com.automatizacion;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

//objetivo : libreria boni garcia sin driver

public class ejer17 {

    String url = "https://bonigarcia.dev/software.html"; 
    WebDriver driver;

    @BeforeTest 
    public void setup(){
WebDriverManager.chromedriver().setup();
driver = new ChromeDriver();
driver.get(url);

        }

        @Test 
        public void test(){
System.out.println("prueba de automatizacion con boni garcia");

            }
}
