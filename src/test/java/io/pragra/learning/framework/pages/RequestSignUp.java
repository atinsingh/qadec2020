package io.pragra.learning.framework.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RequestSignUp {
    WebDriver webDriver;

    @FindBy(xpath = "//div[id='age_gating_question']/div/h1")
    private WebElement pageHeading;

    @FindBy(xpath = "//span[@id='select-0']")
    private WebElement monthDropDown;

    @FindBy(xpath = "//span[@id='select-1']")
    private WebElement dayDropDown;

    @FindBy(xpath = "//span[@id='select-2']")
    private WebElement yearDropDown;

    @FindBy(className = "zm-button__slot")
    private WebElement continueButton;

    public RequestSignUp(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
    public RequestSignUp keyInMonth () {
        WebElement month = this.monthDropDown;
        Select s=new Select(month);
        s.selectByIndex(4);
        return this;
    }

    public WebElement getPageHeading() {
        return pageHeading;
    }

    public WebElement getMonthDropDown() {
        return monthDropDown;
    }

    public WebElement getDayDropDown() {
        return dayDropDown;
    }

    public WebElement getYearDropDown() {
        return yearDropDown;
    }

    public WebElement getContinueButton() {
        return continueButton;
    }

    public RequestSignUp keyInDay () {
        WebElement day = this.dayDropDown;
        Select s=new Select(day);
        s.selectByIndex(4);
        return this;
    }
    public RequestSignUp keyInYear () {
        WebElement year = this.yearDropDown;
        Select s=new Select(year);
        s.selectByIndex(4);
        return this;
    }
    public SignupFreePage keyInContinue () {
        this.continueButton.click();
        return new SignupFreePage(webDriver);
    }
}
