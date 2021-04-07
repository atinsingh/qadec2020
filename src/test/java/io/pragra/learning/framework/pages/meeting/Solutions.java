package io.pragra.learning.framework.pages.meeting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.security.cert.X509Certificate;

public class Solutions {
    WebDriver webDriver;
    @FindBy(xpath = "//*[@id=\"meetings-and-chat\"]/section[1]/div/div/div/a")
    private WebElement report;
    @FindBy(xpath = "//*[@id=\"email\"]")
    private WebElement mail;
    @FindBy(xpath = "//*[@id=\"first_name\"]")
    private WebElement first_name;
    @FindBy(xpath = "//*[@id=\"last_name\"]")
    private WebElement last_name;
    @FindBy(xpath = "//*[@id=\"company\"]")
    private WebElement company_name;
    @FindBy(xpath = "//*[@id=\"emp_count\"]")
    private WebElement employee_count;
    @FindBy(xpath = "//*[@id=\"country\"]")
    private WebElement country;
    @FindBy(xpath = "//*[@id=\"state\"]")
    private WebElement state;
    @FindBy(xpath = "//*[@id=\"city\"]")
    private WebElement city;
    @FindBy(xpath = "//*[@id=\"gdpr-optin\"]")
    private WebElement in;
    @FindBy(xpath = "//*[@id=\"btnSubmit\"]")
    private WebElement sub;
    public Solutions(WebDriver webDriver){
        this.webDriver=webDriver;
        PageFactory.initElements(webDriver,this);

    }
    public Solutions click1(){
        this.report.click();
        return this;
    }
    public Solutions click2(String mail){
        this.mail.sendKeys(mail);
        return this;
    }
    public Solutions click3(String first_name){
        this.first_name.sendKeys(first_name);
        return this;
    }
    public Solutions click4(String last_name){
        this.last_name.sendKeys(last_name);
        return this;
    }
    public Solutions click5(String company_name){
        this.company_name.sendKeys(company_name);
        return this;
    }
    public Solutions click6(){
        Select ss=new Select(employee_count);
            ss.selectByVisibleText("10001+");
            return this;

    }
    public Solutions click7(){
        Select ss=new Select(country);
        ss.selectByVisibleText("United States");
        return this;
    }
    public Solutions click8(){
        Select ss=new Select(state);
        ss.selectByVisibleText("California");
        return this;
    }
    public Solutions click9(String city){
        this.city.sendKeys(city);
        return this;
    }
    public Solutions click10(){
        this.in.click();
        return this;
    }
    public Solutions click11(){
        this.sub.submit();
        return this;
    }

    public WebElement getMail() {
        return mail;
    }

    public WebElement getFirst_name() {
        return first_name;
    }

    public WebElement getLast_name() {
        return last_name;
    }

    public WebElement getCompany_name() {
        return company_name;
    }

    public WebElement getEmployee_count() {
        return employee_count;
    }

    public WebElement getCountry() {
        return country;
    }

    public WebElement getState() {
        return state;
    }

    public WebElement getCity() {
        return city;
    }

    public WebElement getIn() {
        return in;
    }

    public WebElement getSub() {
        return sub;
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }


    public WebElement getReport() {
        return report;
    }
}
