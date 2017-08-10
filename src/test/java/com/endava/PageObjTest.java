package com.endava;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by cmarineata on 8/18/2015.
 */
public class PageObjTest {

    WebDriver driver;
    JoomlaPage page;

    @Before
    public void before() {
        driver = new FirefoxDriver();
        page = PageFactory.initElements(driver, JoomlaPage.class);
    }

    @After
    public void after() {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.close();
    }

    @Test
    //Pentru metoda addUser() , cand inserez user in field-ul de Username imi pica testul la xpathul de newUserButton. Altfel, daca nu inserez nimic merge.
    //Daca voi comenta metoda de logout nu mai pica butonul de addUser si daca fac as comenta metoda de addUser trece testul :)

    public void test() {
        String articleTitle = " First Article for final project!v1 ";
//        page.connectToPage("Costina", "");
//        page.composeArticle("First Article for final project!v1", "Hello,\n Here we test the body for our new article.\n\nHave a nice day!v1");
//        page.editArticle("https://www.youtube.com/watch?v=Z81hsLIY1sQ&index=242&list=PLIc7sG7swGriUp4U-U-86-XLc6DZOEuJ5");//,"Melodie random");
//        page.addImage();  //pentru adaugarea de imagine - mai trebuie analizata partea de xpath-uri pt ca nu le recunoaste
//        System.out.println(page.checkLastArticle());  //pentru verificare ca imi returneaza numele corect

        SiteAdmin site = page.connectToPage("Costina", "");
        page.composeArticle("First Article for final project!v1", "Hello,\n Here we test the body for our new article.\n\nHave a nice day!v1");
        page.editArticle("https://www.youtube.com/watch?v=Z81hsLIY1sQ&index=242&list=PLIc7sG7swGriUp4U-U-86-XLc6DZOEuJ5");//,"Melodie random");
//        System.out.println(site.checkAuthor());  //pt verificare ca returneaza textul asteptat
        page.checkLastArticle();
        site.siteAccess();
        site.checkAuthor();
        site.addUser();
//        page.logOut();
        site.logOutMethod();
    }

}
