package com.kodilla.testing2.facebook;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class FacebookTestingApp {
    public static final String XPATH_COOKIES= "/html/body/div[3]/div[2]/div/div/div/div/div[3]/button[2]"; // [1]
    public static final String XPATH_NEWACCOUNT = "//div[contains(@class, \"_6ltg\")]/a"; // [1]
    public static final String XPATH_BIRTHDAY = "//html/body/div[3]/div[2]/div/div/div[2]/div/div/div[1]/form/div[1]/div[5]/div[2]/span/span/select";

    public static void main(String[] args) {
        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.get("https://www.facebook.com/");                      // [2]

        WebElement cookiesField = driver.findElement(By.xpath(XPATH_COOKIES));    // [3]
        cookiesField.click();

        WebElement newAccountField = driver.findElement(By.xpath(XPATH_NEWACCOUNT));    // [3]
        newAccountField.click();

        while(!driver.findElement(By.xpath(XPATH_BIRTHDAY+"[1]")).isDisplayed());

        Select daySelectBoard = new Select(driver.findElement(By.xpath(XPATH_BIRTHDAY+"[1]")));
        Select monthSelectBoard = new Select(driver.findElement(By.xpath(XPATH_BIRTHDAY+"[2]")));
        Select yearSelectBoard = new Select(driver.findElement(By.xpath(XPATH_BIRTHDAY+"[3]")));

        daySelectBoard.selectByValue("31");
        monthSelectBoard.selectByValue("8");
        yearSelectBoard.selectByValue("1996");
    }
}
