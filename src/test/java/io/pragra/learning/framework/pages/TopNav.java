package io.pragra.learning.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TopNav {
    private WebDriver webDriver;

    @FindBy(xpath = "//div[@id='black-topbar']/div/ul/li[1]")
    private WebElement reqDemoLink;

    @FindBy(xpath = "//div[@id='black-topbar']/div/ul/li[2]")
    private WebElement oneHundredLink;


    @FindBy(xpath = "//div[@id='black-topbar']/div/ul/li[3]")
    private WebElement resources;

    @FindBy(xpath = "//div[@id='black-topbar']/div/ul/li[4]")
    private WebElement support;

    public TopNav(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver,this);
    }

    public RequestADemoPage clickRequest() {
        this.reqDemoLink.click();
        return new RequestADemoPage(webDriver);
    }

    public WebElement getReqDemoLink() {
        return reqDemoLink;
    }

    public WebElement getOneHundredLink() {
        return oneHundredLink;
    }

    public WebElement getResources() {
        return resources;
    }

    public WebElement getSupport() {
        return support;
    }
}
