import org.junit.Before;
import org.junit.Test;

import javax.swing.*;

import static org.junit.Assert.*;

public class PanelModelTest {
    PanelModel pm;
    @Before
    public void setUp() throws Exception{
        pm = new PanelModel();
    }
    @Test
    public void callHelp() {
        pm.callHelp();
        System.out.println("callHelp passed without any error");
    }

    @Test
    public void callPurchase() {
        pm.callPurchase();
        System.out.println("callPurchase passed without any error");
    }

    @Test
    public void callEInfo() {
        pm.callEInfo();
        System.out.println("callEInfo passed without any error");
    }

    @Test
    public void callPList() {
        pm.callPList();
        System.out.println("callPList passed without any error");
    }

    @Test
    public void callAdminLogin() {
        pm.callAdminLogin();
        System.out.println("callAdminLogin passed without any error");
    }

    @Test
    public void callExit() {
        //noframe no work
    }

    @Test
    public void callPwCngLogin() {
        pm.callPwCngLogin();
        System.out.println("callPwCngLogin passed without any error");
    }
}