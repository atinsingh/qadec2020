package io.pragra.learning.framework.pages.meeting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ContactSales {
    WebDriver webDriver;
    @FindBy(xpath = "//*[@id=\"email\"]")
    private WebElement workEmail;
    @FindBy(xpath = "//*[@id=\"company\"]")
    private WebElement companyName;
    @FindBy(xpath = "//*[@id=\"first_name\"]")
    private WebElement firstName;
    @FindBy(xpath = "//*[@id=\"last_name\"]")
    private WebElement lastName;
    @FindBy(xpath = "//*[@id=\"employee_count\"]")
    private WebElement employeeCount;
    @FindBy(xpath = "//*[@id=\"phone\"]")
    private WebElement phone;
    @FindBy(xpath = "//*[@id=\"country\"]")
    private WebElement country;
    @FindBy(xpath = "//*[@id=\"state\"]")
    private WebElement state;
    @FindBy(xpath = "//*[@id=\"city\"]")
    private WebElement headquarters;
    @FindBy(xpath = "//*[@id=\"description\"]")
    private WebElement additional;
    @FindBy(xpath = "//*[@id=\"gdpr-optin\"]")
    private WebElement input;
    @FindBy(xpath = "//*[@id=\"btnSubmit\"]")
    private  WebElement submit;

    public ContactSales(WebDriver webDriver){
        this.webDriver=webDriver;
        PageFactory.initElements(webDriver,this);

    }
    public ContactSales workMail(String workEmail){
        this.workEmail.sendKeys(workEmail);
        return this;
    }
    public ContactSales cN(String companyName){
        this.companyName.sendKeys(companyName);
        return this;
    }
    public ContactSales fN(String firstName){
        this.firstName.sendKeys(firstName);
        return this;
    }
    public ContactSales lN(String lastName){
        this.lastName.sendKeys(lastName);
        return this;
    }
    public ContactSales employee(String employeeCount){
        WebElement employeeCount1 = this.employeeCount;
        Select ss=new Select(employeeCount1);
        ss.selectByVisibleText(employeeCount);
        return this;

    }
    public ContactSales phone(String phone){
        this.phone.sendKeys(phone);
        return this;
    }
    public ContactSales country(String country){
        WebElement country1 = this.country;
        Select ss=new Select(country1);
        ss.selectByVisibleText(country);
        return this;
    }
    public ContactSales state(String state){
        WebElement state1 = this.state;
        Select ss=new Select(state1);
        ss.selectByVisibleText(state);
        return this;
    }
    public ContactSales head(String headquarters){
        this.headquarters.sendKeys(headquarters);
        return this;
    }
    public ContactSales add(String additional){
        this.additional.sendKeys(additional);
        return this;
    }
    public ContactSales in(){
        this.input.click();
        return this;
    }
    public ContactSales sub(){
        this.submit.click();
        return this;
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }

    public WebElement getWorkEmail() {
        return workEmail;
    }

    public WebElement getCompanyName() {
        return companyName;
    }

    public WebElement getFirstName() {
        return firstName;
    }

    public WebElement getLastName() {
        return lastName;
    }

    public WebElement getEmployeeCount() {
        return employeeCount;
    }

    public WebElement getPhone() {
        return phone;
    }

    public WebElement getCountry() {
        return country;
    }

    public WebElement getState() {
        return state;
    }

    public WebElement getHeadquarters() {
        return headquarters;
    }

    public WebElement getAdditional() {
        return additional;
    }

    public WebElement getInput() {
        return input;
    }

    public WebElement getSubmit() {
        return submit;
    }
}
