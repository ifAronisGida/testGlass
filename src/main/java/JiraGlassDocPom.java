import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;

public class JiraGlassDocPom extends JiraPOM {

    @FindBy(id = "browse_link")
    private WebElement projectsDropdown;

    @FindBy(xpath = "//*[@id=\"glass-general-panel\"]/div[1]/div[1]/div/h2/a")
    private WebElement summaryQuicklink;

    @FindBy(xpath = "//div[@id='glass-general-panel']//ul[@role='tablist']/li[1]/a[@role='tab']")
    private WebElement componentsSubTab;

    @FindBy(xpath = "//*[@id=\"glass-general-components-panel\"]/div/h2/a/span")
    private WebElement componentsQuicklink;

    @FindBy(id = "aui-uid-2")
    private WebElement versionsTab;

    @FindBy(xpath = "//*[@id=\"glass-general-versions-panel\"]/div/h2/a")
    private WebElement versionsQuicklink;

    @FindBy(id = "aui-uid-3")
    private WebElement schemesSubTab;

    @FindBy(xpath = "//div[@id='glass-general-schemes-panel']//a[@href='/plugins/servlet/project-config/KEC/summary']/span[@class='aui-icon aui-icon-small aui-iconfont-sidebar-link glass-middle-position']")
    private WebElement schemesQuicklink;

    @FindBy(id = "glass-permissions-nav")
    private WebElement permissionsTab;

    @FindBy(xpath = "//*[@id=\"glass-permissions-panel\"]/div/h2/a/span")
    private WebElement permissionsQuicklink;

    @FindBy(id = "glass-people-nav")
    private WebElement peopleTab;

    @FindBy(xpath = "//*[@id=\"glass-people-panel\"]/div/h2/a/span")
    private WebElement peopleQuicklink;

    @FindBy(id = "admin_main_proj_link_lnk")
    private WebElement kecskeProject;

    @FindBy(xpath = "/html//a[@id='admin_main_proj_link_lnk']")
    private WebElement xKecskeProject;

    @FindBy(xpath = "//section[@id='content']/div[1]//nav[@class='aui-navgroup aui-navgroup-vertical']//ul[@class='aui-nav']//a[@href='/projects/KEC?selectedItem=com.codecanvas.glass:glass']/span[@class='aui-icon aui-icon-large glass-project-icon']")
    private WebElement glassDocTab;

    @FindBy(xpath = "//li[@id='glass-general-nav']/a[@class='header-nav-item']")
    private WebElement generalTab;

    public JiraGlassDocPom(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(this.driver, this);
    }

    private void waitAndClick(WebElement element){
        waitForElement(element);
        element.click();
    }

    private void waitClickableAndClick(WebElement element){
        waitForElementClickable(element);
        element.click();
    }

    public void navigateToKecskeProject(){
        waitAndClick(projectsDropdown);
        waitAndClick(kecskeProject);
    }

    public void setGlassDocView(){
        waitAndClick(glassDocTab);
    }

    public void openSummaryQuicklink(){
        waitAndClick(generalTab);
        waitAndClick(summaryQuicklink);
    }

    public void openComponentsQuicklink(){
        waitAndClick(generalTab);
        waitAndClick(componentsSubTab);
        waitAndClick(componentsQuicklink);
    }

    public void openPeopleQuicklink(){
        waitAndClick(peopleTab);
        waitAndClick(peopleQuicklink);
    }

    public void openVersionsQuicklink(){
        waitAndClick(versionsTab);
        waitAndClick(versionsQuicklink);
    }

    public void openSchemesQuicklink(){
        waitClickableAndClick(generalTab);
        waitAndClick(schemesSubTab);
        waitAndClick(schemesQuicklink);
    }

    public void openPermissionQuickLink(){
        waitAndClick(permissionsTab);
        waitAndClick(permissionsQuicklink);
    }

    public String getURL(){
        return driver.getCurrentUrl();
    }

    public String getCurrentTab(){
        return driver.getWindowHandle();
    }

    public String getNewTabUrl(String oldUrl){
        ArrayList<String> newTab = new ArrayList<>(driver.getWindowHandles());
        String oldTab = oldUrl;
        newTab.remove(oldTab);
        driver.switchTo().window(newTab.get(0));
        String url = driver.getCurrentUrl();
        driver.close();
        driver.switchTo().window(oldTab);
        return url;
    }
}