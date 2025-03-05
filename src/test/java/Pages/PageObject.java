package Pages;

import org.openqa.selenium.By;

public interface PageObject {


    public static By BrowerWindows = By.xpath("//*[text()='Browser Windows']");
    public static By Alert = By.xpath("//*[text()='Alerts']");
    public static By Frames = By.xpath("//*[text()='Frames']");
    public static By Alertbtn = By.xpath("//*[@id='alertButton']");
    public static By NewTab = By.xpath("//*[text()='New Tab']");
    public static By Sortable = By.xpath("//*[text()='Sortable']");
    public static By One = By.xpath("//*[text()='One']");
    public static By Four = By.xpath("//*[text()='Four']");
    public static By Interactions = By.xpath("//*[text()='Interactions']");

    public By CurrentAdd = By.id("currentAddress");
    public By PermanentAdd = By.id("permanentAddress");
    public By BrokenLink = By.xpath("//*[@href='https://practice-automation.com/broken-links/missing-page.html']");


}
