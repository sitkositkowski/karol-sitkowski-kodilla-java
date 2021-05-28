package com.kodilla.testing2.facebook;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FacebookTestingApp {
    public static final String XPATH_COOKIES= "/html/body/div[3]/div[2]/div/div/div/div/div[3]/button[2]"; // [1]
    public static final String XPATH_NEWACCOUNT = "//div[contains(@class, \"_6ltg\")]/a"; // [1]
    public static final String XPATH_BIRTHDAY = "//html/body/div[3]/div[2]/div/div/div[2]/div/div/div[1]/form/div[1]/div[5]/div[2]/span/span/select";

    public static final String ID_WAIT_FOR = "reg_form_box";
    public static final String XPATH_BIRTHDAYFIELD = "//div[contains(@class, \"_5k_5\")]/span/span/select[1]";
    public static final String XPATH_MONTHFIELD = "//div[contains(@class, \"_5k_5\")]/span/span/select[2]";
    public static final String XPATH_YEARFIELD = "//div[contains(@class, \"_5k_5\")]/span/span/select[3]";

    public static void main(String[] args) {
        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.get("https://www.facebook.com/");                      // [2]

        WebElement cookiesField = driver.findElement(By.xpath(XPATH_COOKIES));    // [3]
        cookiesField.click();

        WebElement newAccountField = driver.findElement(By.xpath(XPATH_NEWACCOUNT));    // [3]
        newAccountField.click();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id(ID_WAIT_FOR)));

        WebElement birthdayField = driver.findElement(By.xpath(XPATH_BIRTHDAYFIELD));
        Select selectBirthday = new Select(birthdayField);
        selectBirthday.selectByIndex(3);

        WebElement monthField = driver.findElement(By.xpath(XPATH_MONTHFIELD));
        Select selectMonth = new Select(monthField);
        selectMonth.selectByIndex(1);

        WebElement yearField = driver.findElement(By.xpath(XPATH_YEARFIELD));
        Select selectYear = new Select(yearField);
        selectYear.selectByIndex(23);
    }
}
