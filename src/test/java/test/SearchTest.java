package test;
import base.CommonAPI;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SearchResultPage;

import java.util.ArrayList;
import java.util.List;

public class SearchTest extends CommonAPI {


    @Test
    public void searchJavaBook(){
        HomePage homePage = new HomePage(getDriver());
        SearchResultPage searchResultPage = new SearchResultPage(getDriver());
        homePage.searchElement("java book");
        homePage.clickSearchBtn();
        String expectedJavaPageTitle = "Amazon.com : java book";
        Assert.assertEquals(expectedJavaPageTitle, searchResultPage.getSearchPageTitle());
    }

    @Test
    public void searchSeleniumBook(){
        HomePage homePage = new HomePage(getDriver());
        SearchResultPage searchResultPage = new SearchResultPage(getDriver());
        homePage.searchElementAndEnter("selenium book");
        String expectedSeleniumPageTitle = "Amazon.com : selenium book";
        Assert.assertEquals(expectedSeleniumPageTitle, searchResultPage.getSearchPageTitle());
    }

    @Test
    public void searchJunitBook(){
        HomePage homePage = new HomePage(getDriver());
        SearchResultPage searchResultPage = new SearchResultPage(getDriver());
        homePage.searchElement("junit book");
        homePage.clickSearchBtn();
        String expectedJunitPageTitle = "Amazon.com : junit book";
        Assert.assertEquals(expectedJunitPageTitle, searchResultPage.getSearchPageTitle());
    }

    public List<String> items(){
        List<String> items = new ArrayList<>();
        items.add("ps5");
        items.add("mouse");
        items.add("keyboard");
        items.add("monitor");
        items.add("ds");
        return items;
    }

    @Test
    public void searchMultipleItems(){
        HomePage homePage = new HomePage(getDriver());
        for (String item: items()) {
            homePage.searchElementAndEnter(item);
            homePage.clearSearchField();
        }

    }

}


