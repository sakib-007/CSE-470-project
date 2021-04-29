import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PwCngAdminModel extends JFrame {





    public Object[] selectLogin(Connection connection,JTextField textOldu,JTextField textOldpw) throws Exception{
        String query = "select * from AdminLogin where Username=? and Password=?";
        PreparedStatement pst= connection.prepareStatement (query);
        pst.setString(1, textOldu.getText());
        pst.setString(2, textOldpw.getText());

        ResultSet rs = pst.executeQuery();
        Object [] arr = {pst,rs};
        return arr;

    }

    public PreparedStatement updateLogin(Connection connection,JTextField textOldu,JTextField txtUsername,JTextField passwordField_1) throws Exception{
        String query1 = "Update AdminLogin set Username='"+txtUsername.getText()+"' , Password='"+passwordField_1.getText()+"' where Username='"+textOldu.getText()+"' ";
        PreparedStatement pst1= connection.prepareStatement (query1);
        pst1.execute();
        return pst1;

    }




}
