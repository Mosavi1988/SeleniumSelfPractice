package com.self.practice.assignments;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class FaceBookVerification {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        // 1.Open Chrome browser
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // 2.Go to https://www.facebook.com
        driver.get("https://www.facebook.com");
    }




    @Test(priority = 1)
            public void faceBookTitleVerification(){
        //TC #1: Facebook title verification

        // 3.Verify title: Expected: “Facebook -Log In or Sign Up”
        String expectedResult = "Facebook - Log In or Sign Up";
        String actualResult = driver.getTitle();

        if(expectedResult.equals(actualResult)){
            System.out.println("Verification Passed!");
        }else {
            System.out.println("Verification Failed!!!");
        }


    }

    //TC #2: Facebook incorrect login title verification
    @Test(priority = 2)
    public void incorrectLogin()throws InterruptedException{
        // 3.Enter incorrect username
        WebElement username = driver.findElement(By.id("email"));
        username.sendKeys("Hassan.mosavi");
        // 4.Enter incorrect password
        WebElement password = driver.findElement(By.id("pass"));
        password.sendKeys("123");

        WebElement loginButton = driver.findElement(By.name("login"));
        loginButton.click();

        Thread.sleep(3000);

        // 5.Verify title changed to: Expected: “Log into Facebook | Facebook”
        String expectedResult1 = "Log into Facebook | Facebook";
        String actualResultModified = driver.getTitle();

        System.out.println("expectedResult1 = " + expectedResult1);
        System.out.println("actualResultModified = " + actualResultModified);

        if(expectedResult1.equals(actualResultModified)){
            System.out.println("Verification Passed!");
        }else {
            System.out.println("Verification Failed!!!");
        }
    }

    //TC #3: Facebook header verification
    @Test(priority = 3)
    public void headerVerification(){



        // 3.Verify header text is as expected: Expected: “Connect with friends and the world around you on Facebook.”
        String expectedHeaderText = "Connect with friends and the world around you on Facebook.";
        String actualHeaderText = driver.findElement(By.className("_8eso")).getText();

        if (actualHeaderText.equals(expectedHeaderText)){
            System.out.println("Verification Passed!");
        }else {
            System.out.println("Verification Failed!!!");
        }
    }

    //TC #4: Facebook header verification
    @Test(priority = 4)
    public void createPage(){

        // 3.Verify “Create a page” link href value contains text: Expected: “registration_form”
        String actualHREF = driver.findElement(By.linkText("Create a Page")).getAttribute("href");
        String expectedHREF = "registration_form";

        System.out.println("actualHREF = " + actualHREF);
        System.out.println("expectedHREF = " + expectedHREF);

        if(actualHREF.contains(expectedHREF)){
            System.out.println("Verification Passed!");
        }else {
            System.out.println("Verification Failed!!!");
        }

        driver.quit();



    }



}
