package steps

import io.cucumber.java.en.Given
import io.cucumber.java.en.When
import io.cucumber.java.en.Then
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.edge.EdgeDriver


class SignupSteps {
    private val driver: WebDriver = EdgeDriver()

    @Given("^I am on the Google sign-up page$")
    fun navigateToSignUpPage() {
        driver.get("https://accounts.google.com/SignUp")
    }

    @When("^I fill in the sign-up form with valid information$")
    fun fillSignUpForm() {
        driver.findElement(By.id("firstName")).sendKeys("John")
        driver.findElement(By.id("lastName")).sendKeys("Doe")
    }

    @When("^I submit the form$")
    fun submitForm() {
        driver.findElement(By.id("submitBtn")).click()
    }

    @Then("^I should be redirected to the Google account confirmation page$")
    fun verifyConfirmationPage() {
        val currentUrl = driver.currentUrl
        assert(currentUrl.contains("https://accounts.google.com/confirmation"))
    }
}