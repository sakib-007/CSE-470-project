import javax.swing.*;
import java.awt.*;
import java.sql.Connection;


public class AdminPageController extends JFrame {
    AdminPageModel apm = new AdminPageModel();
    AdminPageView apv = new AdminPageView();
    Connection connection = null;



    public AdminPageController(){

        connection = sqliteConnection.dbConnector();
        apv.initialize(apm,connection);
    }



    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AdminPageController frame = new AdminPageController();
                    frame.apv.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

}
