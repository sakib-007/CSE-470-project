import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AdminLoginController extends JFrame {
    AdminLoginModel Alm = new AdminLoginModel();
    AdminLoginView Alv = new AdminLoginView();
    Connection connection = null;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AdminLoginController frame = new AdminLoginController();
                    frame.Alv.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


    public AdminLoginController() {
        connection = sqliteConnection.dbConnector();
        Alv.initialize(Alm,connection);

    }


}
