import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
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
            pom = new JiraGlassDocPom(login.driver);
            login.loginToJira(System.getenv("user"), System.getenv("password"));
    }

    @AfterEach
    void closeDriver() {
        logout.logout();
        login.closeDriver();
    }

    @Test
    void testIfSummaryQuicklinkNavigatesToSettingsOverview(){
        String expectedURL = "https://jira2.codecool.codecanvas.hu/secure/project/EditProject!default.jspa?pid=10006";

        pom.navigateToKecskeProject();
        pom.setGlassDocView();
        pom.openSummaryQuicklink();
        pom.switchToNewTab();

        String actualURL = pom.getURL();
        Assertions.assertEquals(expectedURL, actualURL);
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
