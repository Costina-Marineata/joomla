package com.endava;

import com.thoughtworks.selenium.webdriven.JavascriptLibrary;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.jws.WebResult;
import java.sql.Time;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by cmarineata on 8/18/2015.
 */
public class JoomlaPage {

    private WebDriver driver;

    @FindBy(xpath = "//*[@id='modlgn-username']")
    private WebElement usernameField;

    @FindBy(xpath = "//*[@id='modlgn-passwd']")
    private WebElement passwordField;

    @FindBy(xpath = "//*[@id='form-login-submit']/div/button")
    private WebElement loginButton;

    @FindBy(xpath = "//*[@id='aside']/div[3]/ul/li[2]/a")
    private WebElement submitArticleButton;

    @FindBy(xpath = "//input[contains(@id,'jform_title')]")
    private WebElement articleTitle;

    @FindBy(xpath = "//textarea[@id='jform_articletext']")
//textarea[contains(@id,'articletext')]")//"//textarea[contains(@aria-hidden,'true')]")
    private WebElement bodyArticle;

    @FindBy(xpath = "//a[@title='Toggle editor']")//"//span[contains(@class,'icon-eye')]")
    private WebElement toggleButton;

    @FindBy(xpath = "//button[@class='btn btn-primary']")
//"//*[@id='adminForm']/div/div[1]/button") //"//button[contains(.,'Save')]")
    private WebElement saveArticleButton;

    @FindBy(xpath = "//span[contains(.,'First Article for final project!v1')]")
    private WebElement accessArticle;

    @FindBy(xpath = "//div/a[@class='btn dropdown-toggle']")
    private WebElement dropDownForEdit;

    @FindBy(xpath = "//*[@id='content']/div[3]/div[2]/div/ul/li/a")
//"//div/ul/li[@class='edit-icon']")//"//div/ul/li[@class='edit-icon']/a")//"//a[contains(.,'Edit')]")
    private WebElement editButton;

    @FindBy(xpath = "//button[contains(@id,'mceu_27-open')]")
    private WebElement insertClick;

    @FindBy(xpath = "//div/i[@class='mce-ico mce-i-link']")
    private WebElement insertLink;

    @FindBy(xpath = "//div/input[@class='mce-textbox mce-placeholder']")
    private WebElement insertURLField;

    @FindBy(xpath = "//button[contains(.,'Ok')]")//"//div[@role='button']/button")
    private WebElement okButton;

    @FindBy(xpath = "//*[@id='editor-xtd-buttons']/a[2][@class='btn modal-button']")
    private WebElement insertImageButton;

//  @FindBy(xpath = "//ul/li[3]/a[@target='imageframe']/div[2][contains(.,'sampledata')]")//"//div[contains(.,'sampledata')]")//"//input[contains(@id,'upload-file')]")//"//input[@id='upload-file']")//input[contains(@name,'Filedata[]')]")//"//div/input[@type='file']")//"//input[@name='Filedata[]']")
//  private WebElement selectImage;

    @FindBy(xpath = "//ul/li[1]/a/span[@itemprop='name']")
    private WebElement lastArticle;

    @FindBy(xpath = "//input[@value='Log out']")
    private WebElement logoutButton;


    public JoomlaPage(WebDriver driver) {
        this.driver = driver;
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://192.168.31.1:8081/joomla/");
        driver.manage().window().maximize();
    }

    public SiteAdmin connectToPage(String user, String pssw) {
        usernameField.sendKeys(user);
        passwordField.sendKeys(pssw);
        loginButton.submit();

        SiteAdmin site = PageFactory.initElements(driver, SiteAdmin.class);
        return site;

    }

    public void composeArticle(String title, String body) {
        submitArticleButton.click();
        articleTitle.sendKeys(title);
        toggleButton.click();
        bodyArticle.sendKeys(body);
        saveArticleButton.click();
    }

    public void editArticle(String url) {
        accessArticle.click();
        dropDownForEdit.click();
        editButton.click();
//      insertImageButton.click();
//      selectImage.click();
        insertClick.click();
        insertLink.click();
        insertURLField.sendKeys(url);
        okButton.click();
        saveArticleButton.click();
    }

    public void addImage() {
        accessArticle.click();
        dropDownForEdit.click();
        editButton.click();
        insertImageButton.click();
//      selectImage.click();
    }

    public void checkLastArticle() {
        String subjectText = lastArticle.getText();
//      return subjectText;  //pt verificare ca returneaza numele corect - vezi PageObj
        assertTrue(subjectText.contains("Article"));
    }

    public void logOut() {
        logoutButton.click();
    }
}
