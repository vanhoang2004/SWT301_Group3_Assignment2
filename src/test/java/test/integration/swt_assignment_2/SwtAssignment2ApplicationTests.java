package test.integration.swt_assignment_2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Duration;

@SpringBootTest
class SwtAssignment2ApplicationTests {

    @ParameterizedTest
    @CsvSource({
            "REGULAR, STANDARD, 0, NON_SALARIED, 0",
            "NON_REGULAR, STANDARD, 0, NON_SALARIED, 0",
            "NON_REGULAR, OTHER, 1000, NON_SALARIED, 100",
            "NON_REGULAR, OTHER, 10001, NON_SALARIED, 500.05",
            "NON_REGULAR, BONUS, 1000, NON_SALARIED, 100",
            "NON_REGULAR, BONUS, 1001, NON_SALARIED, 75",
            "NON_REGULAR, BONUS, 1000, SALARIED, 50",
            "NON_REGULAR, BONUS, 1001, SALARIED, 25",
            "NON_REGULAR, OTHER, 10000, SALARIED, 0",
            "NON_REGULAR, OTHER, 10001, SALARIED, 0"
    })
    public void checkCalculateCommission(String customerType, String itemType, double price, String employeeType, Double expected) {
        // 1. Create an instance of ChromeDriver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // 2. Access the home page of the application
        driver.get("http://localhost:8080/ahihi");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // 3. Wait for the customer type dropdown to be visible and input data into form
        WebElement customerTypeElm = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("customerType")));
        customerTypeElm.sendKeys(customerType);

        WebElement itemTypeElm = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("itemType")));
        itemTypeElm.sendKeys(itemType);

        WebElement priceElm = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("itemPrice")));
        priceElm.sendKeys(String.valueOf(price));

        WebElement employeeTypeElm = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("employeeType")));
        employeeTypeElm.sendKeys(employeeType);

        // Adding a small delay to ensure the inputs are processed
        try {
            Thread.sleep(5000); // sleep for 500 milliseconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 5. Wait for the submit button to be clickable and then click it
        WebElement submitBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[type='submit']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", submitBtn);

        // 6. Wait for the result to be visible and get the result
        WebElement resultElm = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("result")));
        double result = Double.parseDouble(resultElm.getAttribute("value"));

        // 7. Check result
        Assertions.assertEquals(expected, result);

        // Wait for 10 seconds after the result appears
        try {
            Thread.sleep(5000); // sleep for 10 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Close the browser
        driver.quit();
    }
}
