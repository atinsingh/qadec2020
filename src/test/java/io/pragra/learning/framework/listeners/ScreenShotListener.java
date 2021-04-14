package io.pragra.learning.framework.listeners;

import io.pragra.learning.framework.drivermanager.DriverManager;
import io.pragra.learning.framework.utlis.ScreenShotType;
import io.pragra.learning.framework.utlis.Utils;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ScreenShotListener implements ITestListener {
    WebDriver driver = DriverManager.getDriver();
    @Override
    public void onTestSuccess(ITestResult result) {
        Utils.captureScreenShot(driver,result.getName(), ScreenShotType.PASS);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        Utils.captureScreenShot(driver,result.getName(), ScreenShotType.FAIL);
    }
}
