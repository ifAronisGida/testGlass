import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestGlassWorkflow {

    private JiraLogin login;
    private JiraLogout logout;
    private GlassWorkflow workflow;

    @BeforeEach
    void setUp() {
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
        assertEquals(workflow.getURL(), workflow.getDriver().getCurrentUrl());
    }
}
