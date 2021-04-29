import javax.swing.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginPageModel {



    public Object[] selLog(Connection connection,JTextField textFieldUN,JPasswordField passwordField) throws Exception{
        String query = "select * from Login where Username=? and Password=?";
        PreparedStatement pst = connection.prepareStatement(query);
        pst.setString(1, textFieldUN.getText());
        pst.setString(2, passwordField.getText());

        ResultSet rs = pst.executeQuery();

        Object [] arr = {pst,rs};
        return arr;

    }


}

