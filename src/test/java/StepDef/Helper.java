package StepDef;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;

public class Helper extends DriverSetup{

    ExtractPages page;
    Helper() {
        System.out.println("Inside helper");
        this.page = new ExtractPages();}

    public void clickOnObject(String locataor) throws NoSuchFieldException, IllegalAccessException {

        getDriver().findElement(page.getXpath(locataor)).click();

    }

    public WebElement getElement(String locator) throws NoSuchFieldException, IllegalAccessException {
        return getLocal().findElement(page.getXpath(locator));
    }


    public void JsClick(String locator) throws NoSuchFieldException, IllegalAccessException {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();

        js.executeScript("argument[0].click();" , getElement(locator));
        js.executeScript("window.scrollintoview();");
    }
    public void createBorder(String locator) throws NoSuchFieldException, IllegalAccessException {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();

        js.executeScript("arguments[0].style.border='30px solid red'", getElement(locator));
      }

      public void takeScreenshot() throws NoSuchFieldException, IllegalAccessException, IOException {
          File screenshot = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
          FileUtils.copyFile(screenshot,new File("target/links/notworking.jpeg"));

      }
    public  WebDriver getDriver()
    {
        return getLocal();
    }
}
