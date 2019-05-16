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
    void testIfComponentsQuicklinkNavigatesToComponentSettings(){
        String expectedURL = "https://jira2.codecool.codecanvas.hu/plugins/servlet/project-config/KEC/administer-components";

        pom.navigateToKecskeProject();
        pom.setGlassDocView();
        pom.openComponentsQuicklink();
        pom.switchToNewTab();

        String actualURL = pom.getURL();
        Assertions.assertEquals(expectedURL, actualURL);
    }

    @Test
    void testIfVersionsQuicklinkNavigatesToVersionSettings(){
        String expectedURL = "https://jira2.codecool.codecanvas.hu/plugins/servlet/project-config/KEC/administer-versions?status=unreleased";

        pom.navigateToKecskeProject();
        pom.setGlassDocView();
        pom.openVersionsQuicklink();
        pom.switchToNewTab();

        String actualURL = pom.getURL();
        Assertions.assertEquals(expectedURL, actualURL);
    }

    @Test
    void testIfPeopleQuicklinkNavigatesToPeopleSettings(){
        String expectedURL = "https://jira2.codecool.codecanvas.hu/plugins/servlet/project-config/KEC/roles";

        pom.navigateToKecskeProject();
        pom.setGlassDocView();
        pom.openPeopleQuicklink();
        pom.switchToNewTab();

        String actualURL = pom.getURL();
        Assertions.assertEquals(expectedURL, actualURL);
    }

    @Test
    void testIfSchemesQuicklinkNavigatesToSchemeSettings(){
        String expectedURL = "https://jira2.codecool.codecanvas.hu/plugins/servlet/project-config/KEC/summary";

        pom.navigateToKecskeProject();
        pom.setGlassDocView();
        pom.openSchemesQuicklink();
        pom.switchToNewTab();

        String actualURL = pom.getURL();
        Assertions.assertEquals(expectedURL, actualURL);
    }

    @Test
    void testIfPermissionsQuicklinkNavigatesToPermissionSettings(){
        String expectedURL = "https://jira2.codecool.codecanvas.hu/plugins/servlet/project-config/KEC/permissions";

        pom.navigateToKecskeProject();
        pom.setGlassDocView();
        pom.openPermissionQuickLink();
        pom.switchToNewTab();

        String actualURL = pom.getURL();
        Assertions.assertEquals(expectedURL, actualURL);
    }


}
