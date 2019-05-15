import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class GlassWorkflow extends JiraPOM{

    public String getURL() {
        return URL;
    }

    private final String URL = "https://jira2.codecool.codecanvas.hu/projects/KEC?selectedItem=com.codecanvas.glass:glass";

    public GlassWorkflow(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void open() {
        driver.get(URL);
    }
}
