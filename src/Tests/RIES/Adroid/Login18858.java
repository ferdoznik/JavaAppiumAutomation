package Tests.RIES.Adroid;

import lib.CoreTestCaseRIES;
import lib.PlatformRIES;
import lib.ui.RIESLoginPageObject;
import org.junit.Test;

public class Login18858 extends CoreTestCaseRIES
{
    @Test
    public void testLogin18858()
    {
        if (PlatformRIES.getInstance().isAndroid()){
            return;
        }
        RIESLoginPageObject RIESLogin = new RIESLoginPageObject(driver);
        RIESLogin.waitForLoginButton();
        RIESLogin.waitForLoginButton();
        RIESLogin.enterRIESLogin();
        RIESLogin.enterRIESPassword();
        RIESLogin.clickLOGINButton();
    }
}
