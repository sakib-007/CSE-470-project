
import javax.swing.*;
import java.awt.*;

import java.sql.Connection;


public class PurchaseController extends JFrame {

    PurchaseModel pcm = new PurchaseModel();
    PurchaseView pcv = new PurchaseView();


    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    PurchaseController frame = new PurchaseController();
                    frame.pcv.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    Connection connection = null;

    public PurchaseController(){

        setResizable(false);
        connection=sqliteConnection.dbConnector();

        try{
            pcm.maxBill(connection,pcv.billId);
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }

        pcv.initialize(pcm,connection);



    }




}
