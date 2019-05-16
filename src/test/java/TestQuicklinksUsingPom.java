import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;

import static org.junit.jupiter.api.Assertions.*;

public class TestQuicklinksUsingPom {

    private JiraLogout logout;
    private JiraLogin login;
    private JiraGlassDocPom pom;

    @BeforeEach
    void setup() throws MalformedURLException {
            login = new JiraLogin(new Driver().getDriver());
            logout = new JiraLogout(login.getDriver());
            pom = new JiraGlassDocPom(login.getDriver());
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
        String oldUrl = pom.getCurrentTab();
        pom.openSummaryQuicklink();

        String actualURL = pom.getNewTabUrl(oldUrl);
        assertEquals(expectedURL, actualURL);
    }

    @Test
    void testIfComponentsQuicklinkNavigatesToComponentSettings(){
        String expectedURL = "https://jira2.codecool.codecanvas.hu/plugins/servlet/project-config/KEC/administer-components";

        pom.navigateToKecskeProject();
        pom.setGlassDocView();
        String oldUrl = pom.getCurrentTab();
        pom.openComponentsQuicklink();


        String actualURL = pom.getNewTabUrl(oldUrl);
        assertEquals(expectedURL, actualURL);
    }

    @Test
    void testIfVersionsQuicklinkNavigatesToVersionSettings(){
        String expectedURL = "https://jira2.codecool.codecanvas.hu/plugins/servlet/project-config/KEC/administer-versions";

        pom.navigateToKecskeProject();
        pom.setGlassDocView();
        String oldUrl = pom.getCurrentTab();
        pom.openVersionsQuicklink();

        String actualURL = pom.getNewTabUrl(oldUrl);
        assertEquals(expectedURL, actualURL);
    }

    @Test
    void testIfPeopleQuicklinkNavigatesToPeopleSettings(){
        String expectedURL = "https://jira2.codecool.codecanvas.hu/plugins/servlet/project-config/KEC/roles";

        pom.navigateToKecskeProject();
        pom.setGlassDocView();
        String oldUrl = pom.getCurrentTab();
        pom.openPeopleQuicklink();

        String actualURL = pom.getNewTabUrl(oldUrl);
        assertEquals(expectedURL, actualURL);
    }

    @Test
    void testIfSchemesQuicklinkNavigatesToSchemeSettings(){
        String expectedURL = "https://jira2.codecool.codecanvas.hu/plugins/servlet/project-config/KEC/summary";

        pom.navigateToKecskeProject();
        pom.setGlassDocView();
        String oldUrl = pom.getCurrentTab();
        pom.openSchemesQuicklink();

        String actualURL = pom.getNewTabUrl(oldUrl);
        assertEquals(expectedURL, actualURL);
    }

    @Test
    void testIfPermissionsQuicklinkNavigatesToPermissionSettings(){
        String expectedURL = "https://jira2.codecool.codecanvas.hu/plugins/servlet/project-config/KEC/permissions";

        pom.navigateToKecskeProject();
        pom.setGlassDocView();
        String oldUrl = pom.getCurrentTab();
        pom.openPermissionQuickLink();

        String actualURL = pom.getNewTabUrl(oldUrl);
        assertEquals(expectedURL, actualURL);
    }


}
