package driver;

import org.openqa.selenium.Alert
import org.openqa.selenium.firefox.FirefoxProfile
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

//import org.openqa.selenium.htmlunit.HtmlUnitDriver;
//import org.openqa.selenium.ie.InternetExplorerDriver;

public class MySystemDriver {


    public static void main(String[] args) {
        /*
         * Firefox driver is cool, it supports javascript and offers a lot of
         * features You can also use the below drivers WebDriver driver = new
         * InternetExplorerDriver(); WebDriver driver = new HtmlUnitDriver();
         */

        FirefoxProfile profile = new FirefoxProfile();
        profile.setPreference("dom.max_chrome_script_run_time" , "999");
        profile.setPreference("dom.max_script_run_time" , "999");
        WebDriver driver = new FirefoxDriver(profile);


        try {

            // Go to Google Home Page
            driver.get("http://www.google.com");

            // Look for search textbox and enter search term there
            WebElement searchBox = driver.findElement(By.name("q"));

            searchBox.sendKeys("WebDriver API");

            // Click on 'Search'
            WebElement searchButton = driver.findElement(By.name("btnG"));
            searchButton.click();

            // Not required or recommended any where, but just wait for the last
            // click()
            // operation to get completed fine
            Thread.sleep(2000);

            System.out.println("What's the current Url: "
                    + driver.getCurrentUrl());

            // if you wish to take screenshot of this page, you can!
            File scrFile = ((TakesScreenshot) driver)
                    .getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File(
                    "/tmp/googlesearch-webdriverapi.png"));



//                driver.get("file:///Users/yamir/Sites/MySystem/mySystemBook.html");
//                WebDriverWait wait = new WebDriverWait(driver, 999);
//                boolean done = false;
//                while(!done){
//                    try{
//                        wait.until(ExpectedConditions.not(ExpectedConditions.alertIsPresent()))
//                        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("documentLoaded")));
//                        done = true;
//                    } catch (org.openqa.selenium.UnhandledAlertException e){
//                        WebDriverWait waitAlert = new WebDriverWait(driver, 10);
//                        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
////                        alert.accept();
//                        alert().dismiss();
//                    }
//
//                }
//            //Thread.sleep(240000);
//            String html = driver.getPageSource();
//            new File("/Users/yamir/test.html").write(html)

//
//            // Close the driver, once you're done.
            driver.close();
        } catch (Exception e) {
            e.printStackTrace(); // For debugging purposes
        }

    }

}