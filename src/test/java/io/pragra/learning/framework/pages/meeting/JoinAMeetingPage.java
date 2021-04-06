package io.pragra.learning.framework.pages.meeting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JoinAMeetingPage {
    WebDriver webDriver;
    @FindBy(xpath = "//*[@id=\"join-confno\"]")
    private WebElement id;
    @FindBy(xpath = "//*[@id=\"join-form\"]/div[2]/div")
    private  WebElement sub;
    public JoinAMeetingPage(WebDriver webDriver){
        this.webDriver=webDriver;
        PageFactory.initElements(webDriver,this);
    }
    public JoinAMeetingPage id(String id){
        this.id.sendKeys(id);
        return this;
    }
    public JoinAMeetingPage submitted(){
        this.sub.submit();
        return this;
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }

    public WebElement getId() {
        return id;
    }

    public WebElement getSub() {
        return sub;
    }
}
