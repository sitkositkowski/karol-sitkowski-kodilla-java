package com.kodilla.testing2.crudapp;

import com.kodilla.testing2.config.WebDriverConfig;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CrudAppTestSuite {
    private static final String BASE_URL = "https://sitkositkowski.github.io/tasks_frontend";
    private WebDriver driver;
    private Random generator;

    @BeforeEach
    public void initTests() {
        driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.get(BASE_URL);
        generator = new Random();
    }

    @AfterEach
    public void cleanUpAfterTest() {
        driver.close();
    }

    private String createCrudAppTestTask() throws InterruptedException {
        final String XPATH_TASK_NAME = "//form[contains(@action,\"createTask\")]/fieldset[1]/input";
        final String XPATH_TASK_CONTENT = "//form[contains(@action,\"createTask\")]/fieldset[2]/textarea";
        final String XPATH_ADD_BUTTON = "//form[contains(@action,\"createTask\")]/fieldset[3]/button";
        String taskName = "Task number " + generator.nextInt(100000);
        String taskContent = taskName + " content";

        WebElement name = driver.findElement(By.xpath(XPATH_TASK_NAME));
        name.sendKeys(taskName);

        WebElement content = driver.findElement(By.xpath(XPATH_TASK_CONTENT));
        content.sendKeys(taskContent);

        WebElement addButton = driver.findElement(By.xpath(XPATH_ADD_BUTTON));
        addButton.click();
        Thread.sleep(2000);

        return taskName;
    }

    private void sendTestTaskToTrello(String taskName) throws InterruptedException {
        driver.navigate().refresh();                                         // [1]

        while(!driver.findElement(By.xpath("//select[1]")).isDisplayed());   // [2]

        driver.findElements(
                By.xpath("//form[@class=\"datatable__row\"]")).stream()           // [3]
                .filter(anyForm ->                                             // [4]
                        anyForm.findElement(By.xpath(".//p[@class=\"datatable__field-value\"]")) // [5]
                                .getText().equals(taskName))                        // [6]
                .forEach(theForm -> {                                          // [7]
                    WebElement selectElement = theForm.findElement(By.xpath(".//select[1]"));    // [8]
                    Select select = new Select(selectElement);                 // [9]
                    select.selectByIndex(1);                                   // [10]

                    WebElement buttonCreateCard =                              // [11]
                            theForm.findElement(By.xpath(".//button[contains(@class, \"card-creation\")]")); // [12]
                    buttonCreateCard.click();                                  // [13]

                });

        Thread.sleep(5000);                                                  // [15]
        Alert alt = driver.switchTo().alert();
        alt.accept();
    }


    private boolean checkTaskExistsInTrello(String taskName) throws InterruptedException {
        final String TRELLO_URL = "https://trello.com/login";
        boolean result = false;
        WebDriver driverTrello = WebDriverConfig.getDriver(WebDriverConfig.CHROME);	// [1]
        driverTrello.get(TRELLO_URL);                                                // [2]

        driverTrello.findElement(By.id("user")).sendKeys("username");		        // [3]
        driverTrello.findElement(By.id("password")).sendKeys("password");		    // [4]
        WebElement el = driverTrello.findElement(By.id("login"));
        el.submit();									                                // [5]

        Thread.sleep(4000);								                            // [6]

        driverTrello.findElement(By.id("password")).sendKeys("password");		    // [7]
        driverTrello.findElement(By.id("login-submit")).submit();

        Thread.sleep(4000);								                            // [8]

        driverTrello.findElements(By.xpath("//a[@class=\"board-tile\"]")).stream()
                .filter(aHref -> aHref.findElements(By.xpath(".//div[@title=\"Kodilla Aplication\"]")).size() > 0)
                .forEach(WebElement::click);

        Thread.sleep(4000);					                        // [11]	        // [12]

        result = driverTrello.findElements(By.xpath("//span")).stream()// [13]
                .anyMatch(theSpan ->theSpan.getText().equals(taskName));    		        // [14]

        System.out.println(taskName + " " + result);

        driverTrello.close();							                            // [15]

        return result;								                                // [16]
    }

    private void deleteTaskFromCrud(String taskName) throws InterruptedException {
        driver.get(BASE_URL);

        while(!driver.findElement(By.xpath("//select[1]")).isDisplayed());   // [2]

        driver.findElements(
                By.xpath("//form[@class=\"datatable__row\"]")).stream()           // [3]
                .filter(anyForm ->                                             // [4]
                        anyForm.findElement(By.xpath(".//p[@class=\"datatable__field-value\"]")) // [5]
                                .getText().equals(taskName))                        // [6]
                .forEach(theForm -> {
                    WebElement buttonCreateCard = theForm.findElement(By.xpath(".//button[4]")); // [12]
                    System.out.println(buttonCreateCard.getText());

                    buttonCreateCard.click();                                  // [13]
                });
        Thread.sleep(6000);
    }




    @Test
    public void shouldCreateTrelloCard() throws InterruptedException {
        String taskName = createCrudAppTestTask();
        System.out.println("task name: " + taskName);
        sendTestTaskToTrello(taskName);
        assertTrue(checkTaskExistsInTrello(taskName));   // [1]
        deleteTaskFromCrud(taskName);
    }

}

