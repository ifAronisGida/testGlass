import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;

import static org.junit.jupiter.api.Assertions.*;

public class TestGlassWorkflow {

    private JiraLogin login;
    private JiraLogout logout;
    private GlassWorkflow workflow;

    @BeforeEach
    void setUp() throws MalformedURLException {
        login = new JiraLogin(new Driver().getDriver());
        logout = new JiraLogout(login.getDriver());
        workflow = new GlassWorkflow(logout.getDriver());
        login.loginToJira(System.getenv("user"), System.getenv("password"));
    }

    @AfterEach
    void tearDown() {
        logout.logout();
        logout.closeDriver();
    }

    @Test
    void TestIfWorkflowDocIsAvailable() {
        workflow.open();
        workflow.navigateToWorkflows();
        assertTrue(workflow.validateAvailability());
    }

    @Test
    void TestIfYouCanCheckPostFunctions() {
        workflow.open();
        workflow.seePostFunctions();
        assertTrue(workflow.validatePostFunctionCount());
    }
}
