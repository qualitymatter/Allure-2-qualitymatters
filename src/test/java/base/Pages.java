package base;

import org.openqa.selenium.support.PageFactory;
import pages.Page;

public abstract class Pages extends TestBase {

    public <T extends Page> T at(Class<T> pageType) {
        return PageFactory.initElements(driver, pageType);
    }
}