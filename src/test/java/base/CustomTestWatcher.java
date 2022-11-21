package base;

import helpers.ScreenShotCreator;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;

import java.util.Optional;

public class CustomTestWatcher implements TestWatcher {
    @Override
    public void testDisabled(ExtensionContext context, Optional<String> reason) {
        WebDriverThreadLocal.teardown();
    }

    @Override
    public void testSuccessful(ExtensionContext context) {
        WebDriverThreadLocal.teardown();
    }

    @Override
    public void testAborted(ExtensionContext context, Throwable cause) {
        WebDriverThreadLocal.teardown();
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        ScreenShotCreator.takeScreenShot(WebDriverThreadLocal.getDriver());
        WebDriverThreadLocal.teardown();
    }
}


