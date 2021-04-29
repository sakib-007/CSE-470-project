import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import javax.swing.*;
import static org.mockito.Mockito.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static org.junit.Assert.*;

public class AdminLoginModelTest {
    public AdminLoginModel adm;
    PreparedStatement pst;
    ResultSet rs;
    Connection conn;
    sqliteConnection db;


    JTextField textField_user;
    JPasswordField passwordField;

    @Before
    public void setUp() throws Exception {
        conn = Mockito.mock(Connection.class);
        pst = Mockito.mock(PreparedStatement.class);
        rs = Mockito.mock(ResultSet.class);
        adm = new AdminLoginModel();
        textField_user = new JTextField();
        passwordField = new JPasswordField();

    }
    @Test
    public void testGetLogin()throws Exception{
        Object arr[]={pst,rs};
        when(conn.prepareStatement(any(String.class))).thenReturn(pst);
        when(pst.executeQuery()).thenReturn(rs);

        assertEquals(arr[0].getClass().getName(),(adm.getLogin(conn,textField_user,passwordField))[0].getClass().getName());
        assertEquals(arr[1].getClass().getName(),(adm.getLogin(conn,textField_user,passwordField))[1].getClass().getName());
        System.out.println("TestGetLogin working without any error");
    }
}