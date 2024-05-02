package org.example

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.edge.EdgeDriver
import org.openqa.selenium.support.ui.Select

fun main() {
    val driver: WebDriver = EdgeDriver()
    driver.get("https://accounts.google.com/SignUp")



    driver.findElement(By.id("firstName")).sendKeys("John")
    driver.findElement(By.id("lastName")).sendKeys("Doe")

    // continue to the next signup page
    driver.findElement(By.xpath("//span[contains(text(), 'Далее')]/parent::button")).click()

    driver.findElement(By.name("day")).sendKeys("1")

    // fill more data
    //driver.findElement(By.id("day")).sendKeys("01")
    //driver.findElement(By.id("month")).sendKeys("January")
    //driver.findElement(By.id("year")).sendKeys("1990")

    // gender
    //val genderDropdown: WebElement = driver.findElement(By.id("gender"))
    //val selectGender = Select(genderDropdown)
    //selectGender.selectByVisibleText("Male")

    // continue
    //driver.findElement(By.xpath("//span[contains(text(), 'Next')]/parent::button")).click()

    // Verify redirection to confirmation page
    val currentUrl = driver.currentUrl
    if (currentUrl.contains("confirmation")) {
        println("Sign-up successful!")
    } else {
        println("Sign-up process failed.")
    }
}