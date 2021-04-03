package io.pragra.learning.framework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RequestADemoPage {
    WebDriver webDriver;

    @FindBy(xpath = "//div[@id='support_contact']/div/div/h2[1]")
    private WebElement pageHeading;

    @FindBy(name = "email")
    private WebElement email;


    @FindBy(name = "company")
    private WebElement compay;

    @FindBy(name = "first_name")
    private WebElement first_name;


    @FindBy(name = "last_name")
    private WebElement last_name;



    public RequestADemoPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver,this);
    }

    public RequestADemoPage keyInEmail(String email) {
        this.email.sendKeys(email);
        return this;
    }

    public RequestADemoPage keyInCompany(String company) {
        this.compay.sendKeys(company);
        return this;
    }

    public RequestADemoPage keyFirstName(String fname) {
        this.first_name.sendKeys(fname);
        return this;
    }
    public RequestADemoPage keyLastName(String lname) {
        this.last_name.sendKeys(lname);
        return this;
    }

    public WebElement getPageHeading() {
        return pageHeading;
    }

    public WebElement getEmail() {
        return email;
    }

    public WebElement getCompay() {
        return compay;
    }

    public WebElement getFirst_name() {
        return first_name;
    }

    public WebElement getLast_name() {
        return last_name;
    }
}
