import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class PwCngAdminModelTest {
    Connection connection;
    JTextField textOldu;
    JTextField textOldpw;
    JTextField txtUsername;
    JTextField passwordField_1;
    PwCngAdminModel pam;
    PreparedStatement pst;
    ResultSet rs;
    @Before
    public void setUp() throws Exception {
        connection = Mockito.mock(Connection.class);
        pst = Mockito.mock(PreparedStatement.class);
        rs = Mockito.mock(ResultSet.class);
        pam = new PwCngAdminModel();
        textOldu = new JTextField();
        textOldpw = new JTextField();
        txtUsername = new JTextField();
        passwordField_1 =  new JTextField();
    }

    @Test
    public void selectLogin() throws Exception {
        Object arr[]={pst,rs};
        when(connection.prepareStatement(any(String.class))).thenReturn(pst);
        when(pst.executeQuery()).thenReturn(rs);
        assertEquals(arr[0].getClass().getName(),(pam.selectLogin(connection,textOldu,textOldpw))[0].getClass().getName());
        assertEquals(arr[1].getClass().getName(),(pam.selectLogin(connection,textOldu,textOldpw))[1].getClass().getName());
        System.out.println("selectLogin working without any error");
    }

    @Test
    public void updateLogin() throws Exception{
        when(connection.prepareStatement(any(String.class))).thenReturn(pst);
        assertEquals(pst.getClass().getName(),pam.updateLogin(connection,textOldu,txtUsername,passwordField_1).getClass().getName());
        System.out.println("updateLogin working without any error");
    }
}