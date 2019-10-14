package com.company;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;

public class Main {


    public static void main(String[] args) throws Exception  {

        System.setProperty("webdriver.chrome.driver","C:\\Path-to\\chromedriver.exe");
        WebDriver driver ; // = new ChromeWebDriver();
        driver = new ChromeDriver();

        String baseUrl = "https://stampboards.com/viewtopic.php?SomeThread";

        driver.get("https://stampboards.com/ucp.php?mode=login");
        System.out.println("After you login, press enter on the console  ..");
        System.in.read();

        int startingNumber = 60000;
        int inc = 23;
        int endNumbre = 65000;
        Random rand = new Random();

        WebDriverWait wait = new WebDriverWait(driver, 20);

        for(int i=startingNumber; i<=endNumbre; i+= inc) {
            System.out.println("Posting >>>>>>  "+i);

            driver.get(baseUrl);
//        element= driver.findElement(By.id("gwt-uid-13"));
            WebElement input_user=driver.findElement(By.xpath("//*[@name='message']"));

            input_user.click();
            input_user.sendKeys(String.valueOf(i));
//        input_user.("value",String.valueOf(startingNumber);
            WebElement submitButton = driver.findElement(By.xpath("//*[@value='Submit']"));
            submitButton.click();

//            By repyButton = By.xpath("//img[@title='Reply to topic']");
//            wait.until(ExpectedConditions.visibilityOfElementLocated(repyButton));
            int delay = rand.nextInt(5)+12; // 8 - 13 seconds range
            System.out.println("Waiting "+delay+" seconds");
            Thread.sleep(delay*1000);
            System.out.println("Found the element for Replying .... ");
            System.out.println("Proceedin ....");
        }



        System.out.println("Enter to exit the program ...");
        System.in.read();
        driver.close();

    }

}