package pages;
import base.CommonAPI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends CommonAPI {

    @FindBy(css = "#twotabsearchtextbox")
    private WebElement searchField;

    @FindBy(css = "#nav-search-submit-button")
    private WebElement searchBtn;

    @FindBy(css = "#searchDropdownBox")
    private WebElement menuDropdown;

    @FindBy(css = "#nav-link-accountList-nav-line-1")
    private WebElement floatingMenu;

    @FindBy(xpath = "//*[text()='Sign in']")
    private WebElement signInBtn;

    @FindBy(css = "#searchDropdownBox option")
    private List<WebElement> menuDropdownOptions;

    public HomePage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    //reusable steps
    public void searchElement(String item){type(searchField, item);}
    public void clickSearchBtn(){click(searchBtn);}
    public void clearSearchField(){clear(searchField);}
    public void searchElementAndEnter(String item){typeAndEnter(searchField, item);}
    public void selectOptionFromMenuDropdown(String option){selectFromDropdown(menuDropdown, option);}
    public List<String> getHomePageDropdownOptions(){
        List<String> options = new ArrayList<>();
        List<WebElement> elements = getDropDownOptions(menuDropdown);
        for (WebElement element:elements) {
            options.add(element.getText());
        }
        return options;
    }
    public void selectOptionFromMenuDropdownWithSelectOptions(String option){
        List<WebElement> elements = getDropDownOptions(menuDropdown);
        for (WebElement element:elements) {
            if (element.getText().equalsIgnoreCase(option)){
                element.click();
            }
        }
    }
    public void selectOptionFromMenuDropdownWithGivenText(String option){
        List<WebElement> elements = menuDropdownOptions;
        for (WebElement element :elements) {
            if (element.getText().equalsIgnoreCase(option)){
                element.click();
            }
        }
    }
    public void hoverOverFloatingMenu(WebDriver driver){hoverOver(driver, floatingMenu);}
    public void clickOnLoginBtn(){click(signInBtn);}
}