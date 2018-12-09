package views;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ViewActions {

    public static AppiumDriver driver;
    protected final int defaultWait = 20;

    public ViewActions() {

    }

    public WebElement findElement(By locator){
        try {
            return new WebDriverWait(driver, defaultWait).until(ExpectedConditions.visibilityOfElementLocated(locator));
        }catch (org.openqa.selenium.TimeoutException timeException){
            return null;
        }
    }

    public WebElement findElement(By locator, int wait){
        try {
            return new WebDriverWait(driver, wait).until(ExpectedConditions.visibilityOfElementLocated(locator));
        }catch (org.openqa.selenium.TimeoutException timeException){
            return null;
        }
    }

    public Boolean isElementDisappeared(By locator, int wait){
        return new WebDriverWait(driver, wait).until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public Boolean click(By locator, int wait){
         try {
             new WebDriverWait(driver, wait).until(ExpectedConditions.visibilityOfElementLocated(locator)).click();
             return true;
         }catch (Exception e){
             return false;
         }
    }

    public Boolean click(By locator, By expectedLocator, int waitForExpected){
        try {
            new WebDriverWait(driver, defaultWait).until(ExpectedConditions.visibilityOfElementLocated(locator)).click();
            return findElement(expectedLocator, waitForExpected).isEnabled();
        }catch (Exception e){
            return false;
        }
    }

    public Boolean click(By locator, int waitForInvisibility, By disappearedLocator){
        try {
            new WebDriverWait(driver, defaultWait).until(ExpectedConditions.visibilityOfElementLocated(locator)).click();
            return isElementDisappeared(disappearedLocator, waitForInvisibility);
        }catch (Exception e){
            return false;
        }
    }
}
