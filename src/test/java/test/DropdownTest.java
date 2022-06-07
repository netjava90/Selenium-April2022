package test;
import base.CommonAPI;
import org.testng.annotations.Test;
import pages.HomePage;

public class DropdownTest extends CommonAPI {

    @Test(enabled = false)
    public void selectBabyOption(){
        HomePage homePage = new HomePage(getDriver());
        homePage.searchElement("flash mcqueen cars");
        homePage.clickSearchBtn();
        homePage.selectOptionFromMenuDropdown("Baby");
        waitFor(5);
    }

    @Test(enabled = false)
    public void getDropdownList(){
        HomePage homePage = new HomePage(getDriver());
        for (String str:homePage.getHomePageDropdownOptions()) {
            System.out.println(str);
        }
    }
    @Test(enabled = false)
    public void selectKindleStoreOptionFromDropdown(){
        HomePage homePage = new HomePage(getDriver());
        homePage.selectOptionFromMenuDropdownWithSelectOptions("Kindle Store");
        waitFor(5);
    }
    @Test
    public void selectAlexaSkillsOptionFromDropdown(){
        HomePage homePage = new HomePage(getDriver());
        homePage.selectOptionFromMenuDropdownWithGivenText("Alexa Skills");
        waitFor(5);
    }
}
