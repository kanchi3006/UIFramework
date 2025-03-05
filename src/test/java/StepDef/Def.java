package StepDef;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.messages.Messages;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.*;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;


public class Def {

    Helper helper;

    public Def() {
        this.helper = new Helper();
    }

    @Given("Navigate to Google")
    public void Navigate() throws IOException {
        System.out.println("inside StepDef");
        helper.getDriver().get("https://practice-automation.com/broken-links/");
        File screenshot = ((TakesScreenshot)helper.getDriver()).getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(screenshot,new File("target/screenshots/s.png"));




    }

    @And("click on {string}")
    public void clickOn(String locator) throws NoSuchFieldException, IllegalAccessException {
        helper.clickOnObject(locator);

    }


    @And("switch to new window")
    public void switchToNewWindow() {
        Set<String> windowHandles = helper.getDriver().getWindowHandles();

        Iterator<String> itr = windowHandles.iterator();

        String windowHandleCurrent = helper.getDriver().getWindowHandle();
        Set<String> unvisitedWindowHandles = windowHandles.stream().filter(handle -> !handle.equalsIgnoreCase(windowHandleCurrent)).collect(Collectors.toSet());

        helper.getDriver().switchTo().window(unvisitedWindowHandles.iterator().next());


        System.out.println(helper.getDriver().getCurrentUrl());
        helper.getDriver().switchTo().window(windowHandleCurrent);
        System.out.println(helper.getDriver().getCurrentUrl());


    }

    @And("close the Alert")
    public void closeTheAlert() {

        Alert alert = helper.getDriver().switchTo().alert();

        System.out.println(alert.getText());
        alert.dismiss();
    }

    @And("switch to frame")
    public void switchToFrame() throws NoSuchFieldException, IllegalAccessException, IOException {

//        helper.getDriver().switchTo().frame(0);
//
//        System.out.println(helper.getDriver().findElement(By.id("sampleHeading")).getText());

        Actions action = new Actions(helper.getDriver());

        action.dragAndDrop(helper.getElement("One"), helper.getElement("Four")).build().perform();


        helper.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(helper.getDriver(), 10);

        FluentWait<WebDriver> fluent = new FluentWait<>(helper.getDriver())
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class);

        String url = "https://googl";
        URL link = new URL(url);
        HttpURLConnection httpConnect = (HttpURLConnection) link.openConnection();
        httpConnect.setRequestMethod("HEAD");
        httpConnect.connect();
        httpConnect.getResponseCode();

        





    }

    @And("user copy and paste through action")
    public void userCopyAndPasteThroughAction() throws NoSuchFieldException, IllegalAccessException, IOException {

        Actions action = new Actions(helper.getDriver());

        helper.getElement("CurrentAdd").sendKeys("addresss to copied");

        action.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).build().perform();
        action.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).build().perform();

        action.sendKeys(Keys.TAB).build().perform();

        action.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).build().perform();
        System.out.println(helper.getElement("PermanentAdd").getText());
         File screenshot = ((TakesScreenshot) helper.getDriver()).getScreenshotAs(OutputType.FILE);

         FileUtils.copyFile(screenshot,new File("/target/screenshot9/screenshot.png"));


    }

    @And("find broken links")
    public void findBrokenLinks() throws IOException, NoSuchFieldException, IllegalAccessException {


        List<WebElement> e = helper.getDriver().findElements(By.xpath("//a"));

        Set<String> links = new HashSet<>();

        for(WebElement el : e)
        {
            links.add(el.getAttribute("href"));
        }

        for(String link : links)
        {
            URL urls = new URL(link);
             HttpURLConnection url = ( HttpURLConnection) urls.openConnection();

             url.connect();

             if(url.getResponseCode()==200)
                 System.out.println("link is working" + link);
             else {
                 System.out.println("link not working" + link + url.getResponseCode());
                 helper.createBorder("BrokenLink");
                 helper.takeScreenshot();

             }

        }


    }

    @Given("Open browserStack")
    public void openBrowserStack(DataTable data) {

       List< Map<String,String>> datas = data.asMaps(String.class,String.class);

        System.out.println(datas.get(0));



    }
}
