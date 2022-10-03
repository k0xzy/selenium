package ru.netology;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


class CallbackTest {

    private WebDriver driver;


    @BeforeAll
    static void setUpAll() {
        WebDriverManager.chromedriver().setup();;
    }

    @BeforeEach
    void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--no-sandbox");
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
        driver.get("http://localhost:9999");

    }

    @AfterEach
    void tearsDown() {
        driver.quit();
        driver = null;
    }

    @Test
    void test() {
        driver.get("http://localhost:9999");
//        List<WebElement> elements = driver.findElements(By.className("input__control"));
//        elements.get(0).sendKeys("Андрей");
//        elements.get(1).sendKeys("+79999991111");

        driver.findElement(By.cssSelector("[type=\"text\"]")).sendKeys("Андрей");
        driver.findElement(By.cssSelector("[type=\"tel\"]")).sendKeys("+79999991111");

        driver.findElement(By.cssSelector(".checkbox__box")).click();
        driver.findElement(By.cssSelector(".button__text")).click();
        String text = driver.findElement(By.className("paragraph")).getText();
        assertEquals("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.", text.trim());
    }

}
