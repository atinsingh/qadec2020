package io.pragra.learning.framework.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Signup {
    private WebDriver webDriver;
    @FindBy(className = "btn cta-bgyellow signupfree")
    private WebElement signupButton;

    public Signup(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public WebElement getSignupButton() {
        return signupButton;
    }

    public RequestSignUp clickSignup() {
        this.signupButton.click();
        return new RequestSignUp(webDriver);
    }
}
