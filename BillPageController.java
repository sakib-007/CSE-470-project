

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;


public class BillPageController extends JFrame {

    BillPageModel bpm = new BillPageModel();
    BillPageView bpv = new BillPageView();
    Connection connection = null;
    //PurchaseController Purchase = new PurchaseController();
    static BillPageController frame = null;
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    BillPageController frame = new BillPageController();
                    frame.bpv.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public BillPageController( ){

        connection=sqliteConnection.dbConnector();
        bpv.initialize(bpm,connection);

    }



}
