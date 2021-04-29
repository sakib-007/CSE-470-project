

import java.awt.*;

import java.sql.Connection;



public class LoginPageController {

    LoginPageView lov = new LoginPageView();
    LoginPageModel lom = new LoginPageModel();
    Connection connection = null;


    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    LoginPageController frame = new LoginPageController();
                    frame.lov.frame.setVisible(true);


                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


    public LoginPageController() {
          connection = sqliteConnection.dbConnector();
          lov.initialize(lom,connection);
    }




}