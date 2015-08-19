package com.endava;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.junit.Assert.assertEquals;

/**
 * Created by cmarineata on 8/19/2015.
 */
public class SiteAdmin {

    @FindBy(xpath = "//a[contains(@href,'/joomla/administrator')]")
    private WebElement accessSiteAdmin;

    @FindBy(xpath = "//input[@name='username']")
    private WebElement usernameField;

    @FindBy(xpath = "//input[@name='passwd']")
    private WebElement passwField;

    @FindBy(xpath = "//button[@tabindex='3']")
    private WebElement siteloginButton;

    @FindBy(xpath = "//div/ul[1]/li[2]/a/span[2][@class='j-links-link']")
    private WebElement articleManagerButton;

    @FindBy(xpath = "//*[@id='articleList']/tbody/tr[1]/td[3]/div/button")
    private WebElement dropDownButton;

    @FindBy(xpath = "//*[@id='articleList']/tbody/tr[1]/td[3]/div/ul/li[2]/a")
    private WebElement trashButton;

    @FindBy(xpath = "//*[@id='menu']/li[2]/a")
    private WebElement userMenuDropDown;

    @FindBy(xpath = "//*[@id='menu']/li[2]/ul/li[1]/a")
    private WebElement userManagerButton;

    @FindBy(xpath = "//h1[contains(.,'Article Manager: Articles')]")
    private WebElement titleHeader;

    @FindBy(xpath = "//*[@id='toolbar-new']/button")
    private WebElement newUserButton;

    @FindBy(xpath ="//input[@name='jform[name]']")
    private WebElement nameUserField;

    @FindBy(xpath = "//ul[2][@class='nav nav-user pull-right']/li/a")
    private WebElement logoutDropDown;

    @FindBy(xpath = "//a[contains(.,'Logout')]")
    private WebElement logoutBut;

    WebDriver driver;

    public SiteAdmin() {
        this.driver = driver;
    }

    public void siteAccess() {
        accessSiteAdmin.click();
        usernameField.sendKeys("Costina");
        passwField.sendKeys("justsouknow1992");
        siteloginButton.click();
        articleManagerButton.click();
        dropDownButton.click();
        trashButton.click();
    }

    public void addUser() {
        userMenuDropDown.click();
        userManagerButton.click();
        newUserButton.click();
//        nameUserField.sendKeys("Ion");
    }

    public void checkAuthor() {
        String element = titleHeader.getText();
//      return element;  //pentru verificare ca returneaza textul asteptat
        assertEquals("Article Manager: Articles", element);
    }

    public void logOutMethod() {
        logoutDropDown.click();
        logoutBut.click();
    }
}
