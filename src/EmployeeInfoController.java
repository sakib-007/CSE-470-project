
import javax.swing.*;
import java.awt.*;
import java.sql.Connection;


public class EmployeeInfoController extends JFrame {

    EmployeeInfoModel eim = new EmployeeInfoModel();
    EmployeeInfoView eiv =  new EmployeeInfoView();



    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    EmployeeInfoController frame = new EmployeeInfoController();
                    frame.eiv.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    Connection connection = null;

    public EmployeeInfoController(){

        connection=sqliteConnection.dbConnector();
        eiv.initialize(eim,connection);

    }


}
