import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static org.mockito.Mockito.*;

public class EmployeeInfoModelTest {
    Connection connection;
    PreparedStatement pst;
    ResultSet rs;
    EmployeeInfoModel eim;
    JTextField textFieldID;
    JTextField textFieldName;
    JTextField textFieldContact;
    JTextField textFieldAdr;
    @Before
    public void setUp() throws Exception {
        connection = Mockito.mock(Connection.class);
        pst = Mockito.mock(PreparedStatement.class);
        rs = Mockito.mock(ResultSet.class);
        eim = new EmployeeInfoModel();
        textFieldID = new JTextField();
        textFieldName = new JTextField();
        textFieldContact = new JTextField();
        textFieldAdr = new JTextField();
    }

    @Test
    public void rtable() {
        //contains call on a static method
        //DbUtils.resultSetToTableModel(rs)
    }

    @Test
    public void lEm() {
        //contains call on a static method
        //DbUtils.resultSetToTableModel(rs)
    }

    @Test
    public void adEm()throws Exception {
        when(connection.prepareStatement(any(String.class))).thenReturn(pst);
        eim.adEm(connection,textFieldID,textFieldName,textFieldContact,textFieldAdr);
        System.out.println("adEm working without any error");
    }

    @Test
    public void upEm()throws Exception {
        when(connection.prepareStatement(any(String.class))).thenReturn(pst);
        eim.upEm(connection,textFieldID,textFieldName,textFieldContact,textFieldAdr);
        System.out.println("upEm working without any error");
    }

    @Test
    public void delEm() throws Exception{
        when(connection.prepareStatement(any(String.class))).thenReturn(pst);
        eim.delEm(connection,textFieldID);
        System.out.println("upEm working without any error");
    }

    @Test
    public void mClick() {
    }

    @Test
    public void kRel() {
        //contains call on a static method
        //DbUtils.resultSetToTableModel(rs)
    }
}