import javax.swing.*;
import java.awt.*;
import java.sql.Connection;

public class PwCngAdminController extends JFrame {
    PwCngAdminModel pwcam = new PwCngAdminModel();
    PwCngAdminView pwcav = new PwCngAdminView();

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    PwCngAdminController frame = new PwCngAdminController();
                    frame.pwcav.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    Connection connection = null;

    public PwCngAdminController(){
        connection = sqliteConnection.dbConnector();
        pwcav.initialize(pwcam,connection);
    }




}
