import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class LoginPageModelTest {
    LoginPageModel lpm;
    Connection connection;
    PreparedStatement pst;
    ResultSet rs;
    JTextField textFieldUN;
    JPasswordField passwordField;
    @Before
    public void setUp() throws Exception {
        connection = Mockito.mock(Connection.class);
        pst = Mockito.mock(PreparedStatement.class);
        rs  = Mockito.mock(ResultSet.class);
        lpm = new LoginPageModel();
        textFieldUN = new JTextField();
        passwordField = new JPasswordField();
    }

    @Test
    public void selLog()throws Exception {
        Object[]arr = {pst,rs};
        when(connection.prepareStatement(any(String.class))).thenReturn(pst);
        when(pst.executeQuery()).thenReturn(rs);
        assertEquals(arr[0].getClass().getName(),lpm.selLog(connection,textFieldUN,passwordField)[0].getClass().getName());
        assertEquals(arr[1].getClass().getName(),lpm.selLog(connection,textFieldUN,passwordField)[1].getClass().getName());
        System.out.println("selLog working without any error");
    }
}