import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AdminLoginModel {





    public Object[] getLogin(Connection connection,JTextField textField_user,JPasswordField passwordField) throws Exception {
        String query = "select * from AdminLogin where Username=? and Password=?";
        PreparedStatement pst = connection.prepareStatement (query);
        pst.setString(1, textField_user.getText());
        pst.setString(2, passwordField.getText());

        ResultSet rs = pst.executeQuery();

        Object [] arr = {pst,rs};

        return arr;
    }

}
