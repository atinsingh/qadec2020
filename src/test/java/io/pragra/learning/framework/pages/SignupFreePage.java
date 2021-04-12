package io.pragra.learning.framework.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SignupFreePage {
    WebDriver webDriver;
    @FindBy(id = "email")
    private WebElement emailAddress;

    public WebElement getEmailAddress() {
        return emailAddress;
    }

    public SignupFreePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
    public SignupFreePage KeyEmail (String emailAddress) {
        this.emailAddress.sendKeys(emailAddress);
        return this;
    }
}
