package StepDef;

import Pages.PageObject;
import org.openqa.selenium.By;

public class ExtractPages implements PageObject {

    ExtractPages()
    {
        System.out.println("Inside Extract Pages");
    }
    public By getXpath(String locator) throws NoSuchFieldException, IllegalAccessException {
        By ele = (By) ExtractPages.class.getField(locator).get(new ExtractPages());
        return ele;
    }
}
