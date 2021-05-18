import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class PwCngLoginModelTest {
    Connection connection;
    JTextField textOldu;
    JTextField textOldpw;
    JTextField txtUsername;
    JTextField passwordField_1;
    PwCngLoginModel plm;
    PreparedStatement pst;
    ResultSet rs;
    @Before
    public void setUp() throws Exception {
        connection = Mockito.mock(Connection.class);
        pst = Mockito.mock(PreparedStatement.class);
        rs = Mockito.mock(ResultSet.class);
        plm = new PwCngLoginModel();
        textOldu = new JTextField();
        textOldpw = new JTextField();
        txtUsername = new JTextField();
        passwordField_1 =  new JTextField();
    }

    @Test
    public void sPwcL() throws Exception {
        Object arr[]={pst,rs};
        when(connection.prepareStatement(any(String.class))).thenReturn(pst);
        when(pst.executeQuery()).thenReturn(rs);
        assertEquals(arr[0].getClass().getName(),(plm.sPwcL(connection,textOldu,textOldpw))[0].getClass().getName());
        assertEquals(arr[1].getClass().getName(),(plm.sPwcL(connection,textOldu,textOldpw))[1].getClass().getName());
        System.out.println("sPwcL working without any error");
    }

    @Test
    public void uPwcL()throws Exception {
        when(connection.prepareStatement(any(String.class))).thenReturn(pst);
        assertEquals(pst.getClass().getName(),plm.uPwcL(connection,txtUsername,passwordField_1,textOldu).getClass().getName());
        System.out.println("uPwcL working without any error");
    }
}