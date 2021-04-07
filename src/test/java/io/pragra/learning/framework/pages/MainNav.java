package io.pragra.learning.framework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainNav {
        private WebDriver webDriver;

        @FindBy(xpath = "//*[@id='btnSolutions']")
        private WebElement solutions;

        @FindBy(xpath = "//*[@id='navbar']/ul[1]/li[7]/a")
        private WebElement planPricing;


        @FindBy(xpath = "//*[@id='navbar']/ul[1]/li[9]/a")
        private WebElement contactSales;

        public MainNav(WebDriver webDriver) {
            this.webDriver = webDriver;
            PageFactory.initElements(webDriver,this);
        }

        public ContactSales clickRequest() {
            this.contactSales.click();
            return new ContactSales(webDriver);
        }

    public WebElement getSolutions() {
        return solutions;
    }

    public WebElement getPlanPricing() {
        return planPricing;
    }

    public WebElement getContactSales() {
        return contactSales;
    }
}
