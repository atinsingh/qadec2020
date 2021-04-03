package io.pragra.learning.framework.utlis;

import io.pragra.learning.framework.config.Config;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {
    //first util create dir structure
    private static void createDirs() {
        try {
            if (!Files.exists(Paths.get(((String) Config.getProperty("screenshot.pass.dir"))))) {
                Files.createDirectories(Paths.get(((String) Config.getProperty("screenshot.pass.dir"))));
            }
            if (!Files.exists(Paths.get(((String) Config.getProperty("screenshot.fail.dir"))))) {
                Files.createDirectories(Paths.get(((String) Config.getProperty("screenshot.fail.dir"))));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Path fileName(String testCaseName, ScreenShotType shotType) {
        SimpleDateFormat format = new SimpleDateFormat(((String) Config.getProperty("file.ts.format")));
        if(shotType == ScreenShotType.PASS) {
            Path path = Paths.get(((String) Config.getProperty("screenshot.pass.dir")) ,
                    testCaseName+"_"+format.format(new Date()) + ""+Config.getProperty("screenshot.ext"));
            return path;
        }else if(shotType == ScreenShotType.FAIL) {
            Path path = Paths.get(((String) Config.getProperty("screenshot.fail.dir")) ,
                    testCaseName+"_"+format.format(new Date()) + ""+Config.getProperty("screenshot.ext"));
            return path;
        }else {
            Path path = Paths.get(((String) Config.getProperty("screenshot.pass.dir")) ,
                    testCaseName+"_"+format.format(new Date()) + ""+Config.getProperty("screenshot.ext"));
            return path;
        }
    }

    public static String captureScreenShot(WebDriver driver, String testCaseName, ScreenShotType shotType) {
        createDirs();
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        Path path = fileName(testCaseName, shotType);
        try {
            Files.copy(screenshot.toPath(), path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return path.toString();
    }
    // generate file name
}
