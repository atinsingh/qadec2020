package io.pragra.learning.framework.pages;

import io.pragra.learning.framework.pages.meeting.ContactSales;
import io.pragra.learning.framework.pages.meeting.JoinAMeetingPage;
import io.pragra.learning.framework.pages.meeting.Solutions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import javax.swing.*;

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

    @FindBy(xpath = "//div[@class='navbar-collapse collapse']//ul//li/a")
    private WebElement solutions;
    @FindBy(xpath = "//*[@id=\"navbar\"]/ul[1]/li[7]/a")
    private WebElement pp;
    @FindBy(xpath ="//*[@id=\"navbar\"]/ul[1]/li[9]/a" )
    private WebElement contactSales;
   @FindBy(xpath = "//div[@class='navbar-collapse collapse']//ul//li//a[@id='btnJoinMeeting']")
private WebElement join;

//   @FindBy(xpath = "//div[@class='navbar-collapse collapse']//ul[@role='navigation']//li[@class='dropdown mobile-hide']//a[@id='btnSolutions']")
//   private WebElement solutions;
   @FindBy(xpath = "//*[@id=\"first-col-nav\"]/div/ul/li[1]/a")
   private WebElement meeting;




    public TopNav(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver,this);
    }

    public RequestADemoPage clickRequest() {
        this.reqDemoLink.click();
        return new RequestADemoPage(webDriver);
    }

    public ContactSales clickRequest3(){
        this.contactSales.click();
        return new ContactSales(webDriver);
    }

  /*  public JoinAMeetingPage clickRequest4(){
        this.join.click();
        return new JoinAMeetingPage(webDriver);
    }*/
    public JoinAMeetingPage clickRequest4(){
        this.join.click();
        return new JoinAMeetingPage(webDriver);
    }
    public Solutions clickRequest5(){
      Actions ac=new Actions(webDriver);
      ac.moveToElement(solutions).moveToElement(meeting).click().build().perform();
        return new Solutions(webDriver);
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
