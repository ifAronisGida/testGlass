import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GlassWorkflow extends JiraPOM{

    private final String URL = "https://jira2.codecool.codecanvas.hu/projects/KEC?selectedItem=com.codecanvas.glass:glass";

    @FindBy(xpath = "//li[@id='glass-workflow-nav']//div[@class='aui-dropdown2-trigger']")
    WebElement issueTypesNav;

    @FindBy(xpath = "//aui-dropdown-menu[@id='dropdown-issuetypes']//aui-section[@role='presentation']/div/aui-item-link[1]/a[@role='menuitem']")
    WebElement issueTypeTask;

    @FindBy(xpath = "//div[@id='glass-workflow-transitions']/table[@class='aui aui-table-sortable transition-table']/tbody/tr[1]/td[@class='transition-name']")
    WebElement menuItemCreate;

    @FindBy(xpath = "//h2[@id='glass-workflow-transitions-title']/span[.='Workflow Transitions']")
    WebElement workflowLabel;

    @FindBy(css = ".transition-details-row:nth-of-type(2) aui-badge")
    WebElement postFunctionCount;

    public GlassWorkflow(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String getURL() {
        return URL;
    }

    public void open() {
        driver.get(URL);
    }

    public boolean validateAvailability() {
        return workflowLabel.isDisplayed();
    }

    public void navigateToWorkflows() {
        issueTypesNav.click();
        issueTypeTask.click();
    }

    public void seePostFunctions() {
        navigateToWorkflows();
        waitForElementClickable(menuItemCreate);
        menuItemCreate.click();
    }



    public boolean validatePostFunctionCount() {
        int postFunctionCountInt = Integer.parseInt(postFunctionCount.getText());
        System.out.println("pause");
        return  postFunctionCountInt > 0;
    }

}
