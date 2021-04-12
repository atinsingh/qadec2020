package io.pragra.learning.framework.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.Set;

public class ContactSales {
   private static final Logger log=LogManager.getLogger(ContactSales.class);
    private WebDriver webDriver;

    @FindBy(xpath = "//div[@class='page-header']/h1")
    private WebElement page_Heading;

    @FindBy(name = "email")
    private WebElement e_mail;


    @FindBy(name = "company")
    private WebElement company1;

    @FindBy(name = "first_name")
    private WebElement firstname;


    @FindBy(name = "last_name")
    private WebElement lastname;

    @FindBy(xpath = "//div/select[@id='employee_count']/option[@value='Just Me']")
    private WebElement emp_count;

    @FindBy(xpath = "//div/input[@id='phone']")
    private WebElement phone;


    @FindBy(xpath = "//div/select[@id='country']")
    private WebElement country_name;

    @FindBy(xpath = "//div/select[@id='state']")
    private WebElement state_name;


    @FindBy(xpath = "//div/input[@id='city']")
    private WebElement headQuarterZip;


    @FindBy(xpath = "//div/textarea")
    private WebElement additionalInfo;

    @FindBy(xpath = "//div[@class='form-group  gdpr-compliance hideme']/p")
    private WebElement subscriptionText;

    @FindBy(xpath = "//div/fieldset/label/input[@value='0']")
    private WebElement radio;

    @FindBy(xpath = "//p/a[@href='/privacy']")
    private WebElement privacyPolicy;

    @FindBy(xpath = "//div/button[@id='btnSubmit']")
    private WebElement submitButton;

    @FindBy(xpath = "//div/a[@href='/livedemo']")
    private WebElement requestADemo;

    public ContactSales(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver,this);
    }
    public ContactSales heading() {
        try {
            this.page_Heading.equals("Contact Sales");

        }
        catch (InvalidArgumentException e){
            log.error("The content of the element does not match with the expected outcome");
            e.printStackTrace();
        }
        return this;
    }

    public ContactSales keyInEmail(String email) {
        try {
            this.e_mail.sendKeys(email);

        }
        catch (ElementNotInteractableException e){
            log.warn("The element is not interactable and cannot be performed any actions on it");
            e.getMessage();

        }
        return this;
    }

    public ContactSales keyInCompany(String company) {
        try {
            this.company1.sendKeys(company);

        }
        catch (ElementNotSelectableException e){
            log.warn("Kindly check the address of the element before performing the necessary action");
            e.printStackTrace();
        }
        return this;
    }

    public ContactSales keyFirstName(String fname) {
        this.firstname.sendKeys(fname);
        return this;
    }
    public ContactSales keyLastName(String lname) {
        this.lastname.sendKeys(lname);
        return this;
    }
    public ContactSales keyInEmpCount() {
        try {
            this.emp_count.click();

        }
        catch (ElementClickInterceptedException e){
            log.error("Unable to perform the click operation on the given address of the element",emp_count);
            e.getMessage();
        }
        return this;
    }

        public ContactSales keyInPhone(String phoneNo){
            this.phone.sendKeys(phoneNo);
            return this;
        }

    public ContactSales keyInCountry() throws InterruptedException {
        try {
            this.country_name.click();
            Select countryName = new Select(webDriver.findElement(By.id("country")));
            countryName.selectByVisibleText("Canada");
            Thread.sleep(2000);

        }
        catch (InvalidSelectorException e){
            log.error("The address of the element[{}] is invalid", country_name);
            e.printStackTrace();
        }
        return this;
    }

    public ContactSales keyInState() throws InterruptedException {
        log.debug("searching for the element [{}] and selecting the required data",state_name,"ontario");

            this.state_name.click();
            Select stateName = new Select(webDriver.findElement(By.id("state")));
            stateName.selectByVisibleText("Ontario");
            Thread.sleep(2000);
        return this;
    }
    public ContactSales keyInHQZip(String zip) {
        this.headQuarterZip.sendKeys(zip);
        return this;
    }

    public ContactSales keyInAddInfo(String info) {
        this.additionalInfo.sendKeys(info);
        return this;
    }
    public ContactSales keyInText(String text) {
        this.subscriptionText.equals(text);
        return this;
    }

    public ContactSales selectRadio() {
        this.radio.click();
        return this;
    }

    public ContactSales privacy() throws InterruptedException {
        this.privacyPolicy.click();
        try {
            Set<String> windowHandles = webDriver.getWindowHandles();
            String currentWindow = webDriver.getWindowHandle();
            for (String window : windowHandles) {
                if (!window.equals(currentWindow)) {
                    webDriver.switchTo().window(window);
                    break;
                }

            }
            Thread.sleep(5000);
            webDriver.switchTo().window(currentWindow);

        }
        catch (NoSuchWindowException e){
            log.fatal("There is no such window to perform the switch option, invalid operation", webDriver.getWindowHandle());
            e.getLocalizedMessage();
        }

        return this;
    }

    public ContactSales submit() {
        this.submitButton.click();
        return this;
    }

    public RequestADemoPage requestDemo() {
        this.requestADemo.click();
        return new RequestADemoPage(webDriver);
    }

    public WebElement getFirst_name() {
        return firstname;
    }

    public WebElement getLast_name() {
        return lastname;
    }

    public WebElement getEmp_count() {
        return emp_count;
    }

    public WebElement getPhone() {
        return phone;
    }

    public WebElement getPage_Heading() {
        return page_Heading;
    }

    public WebElement getE_mail() {
        return e_mail;
    }

    public WebElement getCompany1() {
        return company1;
    }

    public WebElement getFirstname() {
        return firstname;
    }

    public WebElement getLastname() {
        return lastname;
    }

    public WebElement getCountry_name() {
        return country_name;
    }

    public WebElement getState_name() {
        return state_name;
    }

    public WebElement getHeadQuarterZip() {
        return headQuarterZip;
    }

    public WebElement getAdditionalInfo() {
        return additionalInfo;
    }

    public WebElement getSubscriptionText() {
        return subscriptionText;
    }

    public WebElement getRadio() {
        return radio;
    }

    public WebElement getPrivacyPolicy() {
        return privacyPolicy;
    }

    public WebElement getSubmitButton() {
        return submitButton;
    }

    public WebElement getRequestADemo() {
        return requestADemo;
    }
}


