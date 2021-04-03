package io.pragra.learning.framework.testcases;

import io.pragra.learning.framework.config.Config;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FrameworkTest {

    @Test
    public void tc() {
        Assert.assertEquals(Config.getProperty("browser.name"),"chrome");
    }
}
