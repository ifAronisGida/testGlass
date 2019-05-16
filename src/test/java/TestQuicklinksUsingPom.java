import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestQuicklinksUsingPom {

    private JiraLogout logout;
    private JiraLogin login;
    private JiraGlassDocPom pom;

    @BeforeEach
    void setup() {
            login = new JiraLogin(new Driver().getDriver());
            logout = new JiraLogout(login.getDriver());
            login.loginToJira(System.getenv("user"), System.getenv("password"));
    }

    @AfterEach
    void closeDriver() {
        logout.logout();
        login.closeDriver();
    }

    @Test
    void testIfSummaryQuicklinkNavigatesToSettingsOverview(){
//        pom.navigateToKecskeProject();
        login.driver.get("https://jira2.codecool.codecanvas.hu/projects/KEC?selectedItem=com.codecanvas.glass:glass");
        pom.setGlassDocView();
        pom.openSummaryQuicklink();

    }

    @Test
    void testIfComponentsQuicklinkNavigatesToComponentSettings(){}

    @Test
    void testIfVersionsQuicklinkNavigatesToVersionSettings(){}

    @Test
    void testIfPeopleQuicklinkNavigatesToPeopleSettings(){}

    @Test
    void testIfSchemesQuicklinkNavigatesToSchemeSettings(){}

    @Test
    void testIfPermissionsQuicklinkNavigatesToPermissionSettings(){}


}
