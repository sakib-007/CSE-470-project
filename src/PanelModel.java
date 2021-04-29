import javax.swing.*;

public class PanelModel extends JFrame {
    public void callHelp() {
        HelpController help;
        help = new HelpController();
        help.hv.setVisible(true);
    }

    public void callPurchase() {
        PurchaseController purchase;
        purchase = new PurchaseController();
        purchase.pcv.setVisible(true);
    }


    public void callEInfo() {
        EmployeeInfoController einfo;
        einfo = new EmployeeInfoController();
        einfo.eiv.setVisible(true);

    }

    public void callPList() {
        ProductListController pl;
        pl = new ProductListController();
        pl.plv.setVisible(true);
    }

    public void callAdminLogin() {
        AdminLoginController adminlogin;
        adminlogin = new AdminLoginController();
        adminlogin.Alv.setVisible(true);
    }

    public void callExit() {
        System.exit(JFrame.EXIT_ON_CLOSE);
    }

    public void callPwCngLogin() {
        try {
            //frame.dispose();
            PwCngLoginController  pwcnglogin;
            pwcnglogin = new PwCngLoginController();
            pwcnglogin.pwclv.setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
