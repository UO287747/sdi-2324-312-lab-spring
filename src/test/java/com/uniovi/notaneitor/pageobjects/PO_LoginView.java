package com.uniovi.notaneitor.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PO_LoginView extends PO_NavView {

    public static void fillLoginForm(WebDriver driver, String usernamep, String passp) {

        WebElement username = driver.findElement(By.name("username"));
        username.click();
        username.clear();
        username.sendKeys(usernamep);

        WebElement pass = driver.findElement(By.name("password"));
        pass.click();
        pass.clear();
        pass.sendKeys(passp);

        //Pulsar el boton de Login.
        By boton = By.className("btn");
        driver.findElement(boton).click();
    }

    public static void clickLogout(WebDriver driver) {

        //Pulsar el boton de Login.
        By boton = By.xpath("/html/body/nav/div/ul[2]/li[2]/a");
        driver.findElement(boton).click();
    }
}
