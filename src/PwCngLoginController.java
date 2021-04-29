import javax.swing.*;
import java.awt.Dialog.ModalExclusionType;
import java.awt.*;

import java.sql.Connection;


public class PwCngLoginController extends JFrame {
    PwCngLoginModel pwclm = new PwCngLoginModel();
    PwCngLoginView pwclv = new PwCngLoginView();

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    PwCngLoginController frame = new PwCngLoginController();
                    frame.pwclv.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    Connection connection = null;

    public PwCngLoginController(){
        setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
        connection=sqliteConnection.dbConnector();
        pwclv.initialize(pwclm,connection);
    }




}
