

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;


public class ProductListController extends JFrame {

    ProductListModel plm = new ProductListModel();
    ProductListView plv = new ProductListView();



    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ProductListController frame = new ProductListController();
                    frame.plv.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    Connection connection = null;

    public ProductListController(){

        connection = sqliteConnection.dbConnector();
        plv.initialize(plm, connection);

    }

}
