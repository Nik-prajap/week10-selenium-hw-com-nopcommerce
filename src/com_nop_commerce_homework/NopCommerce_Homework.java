package com_nop_commerce_homework;

/**
 *   Project -  1
 *   BaseUrl = https://demo.nopcommerce.com/login?returnUrl=%2F
 *   1. Setup Chrome browser.
 *   2. Open URL.
 *   3. Print the title of the page.
 *   4. Print the current url.
 *   5. Print the page source.
 *   6. Navigate to Url: 'https://demo.nopcommerce.com/login?returnUrl=%2F'
 *   7. Print the current url.
 *   8. Navigate back to the home page.
 *   9. Navigate to the login page.
 *   10. Print the current url.
 *   11. Refresh the page.
 *   12. Enter the email to email field.
 *   13. Enter the password to password field.
 *   14. Click on Login Button.
 *   15. Close the browser.
 */


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class NopCommerce_Homework {

    // Variables declared as static for direct use
    static String baseUrl = "https://demo.nopcommerce.com/";
    static WebDriver driver;
    static String browser = "Chrome";

    public static void main(String[] args) throws InterruptedException {

        // Browser launch - using if-else method
        if (browser.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        } else {
            System.out.println("Wrong Browser name");
        }

        driver.get(baseUrl);                                                            // get the base URL
        driver.manage().window().maximize();                                            // maximise the window
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));              // implicitly wait of driver


        String title = driver.getTitle();                                               //
        System.out.println(title);                                                      // Print the title

        String currentUrl = driver.getCurrentUrl();                                     //
        String pageSource = driver.getPageSource();                                     //
        System.out.println(currentUrl);                                                 //
        System.out.println("Page Source is : " + pageSource);                           //

        driver.navigate().to("https://demo.nopcommerce.com/login?returnUrl=%2F");   //
        String loginUrl = driver.getCurrentUrl();                                       //
        System.out.println(loginUrl);                                                   //navigate to Url
        Thread.sleep(5000);                                                       //

        driver.navigate().back();                                                       //
        Thread.sleep(5000);                                                       //

        driver.navigate().to("https://demo.nopcommerce.com/login?returnUrl=%2F");   //
        String loginUrl1 = driver.getCurrentUrl();                                      //
        System.out.println(loginUrl1);                                                  //
        Thread.sleep(5000);                                                       //

        driver.navigate().refresh();                                                    //
        Thread.sleep(2000);                                                       //

        // Find Email Field element and type the Email
        WebElement emailField = driver.findElement(By.id("Email"));
        emailField.sendKeys("Prime@gmail.com");

        // Find Password Field Element and type the password
        WebElement passwordField = driver.findElement(By.name("Password"));
        passwordField.sendKeys("123Prime");

        WebElement loginButton = driver.findElement(By.linkText("Log in"));
        loginButton.click();

        driver.quit();

    }
}
