import net.proteanit.sql.DbUtils;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static org.mockito.Mockito.*;

public class AdminPageModelTest {
    Connection connection;
    JTable table;
    JTable mtable;
    JTextField textField_id;
    JTextField textField_name;
    JTextField textField_sname;
    JTextField textField_contact;
    JTextField textField_address;
    JTextField textField_date;
    JComboBox comboBox;
    JComboBox comboBoxm;
    JTextField textFieldsrch;
    AdminPageModel apm;
    PreparedStatement pst;
    PreparedStatement psts;
    ResultSet rs;
    DbUtils ddb;
    DefaultTableModel dtm;
    TableModel tbm;


    @Before
    public void setUp() throws Exception {
        connection = Mockito.mock(Connection.class);
        pst = Mockito.mock(PreparedStatement.class);
        pst = Mockito.spy(PreparedStatement.class);
        rs = Mockito.mock(ResultSet.class);
        ddb = Mockito.mock(DbUtils.class);
        mtable = Mockito.mock(JTable.class);
        tbm = Mockito.mock(TableModel.class);
        comboBoxm = Mockito.mock(JComboBox.class);
        apm = new AdminPageModel();
        table = new JTable();
        textField_id = new JTextField();
        textField_name = new JTextField();
        textField_sname = new JTextField();
        textField_contact = new JTextField();
        textField_address = new JTextField();

    }

    @Test
    public void testRefreshTable() throws Exception{
        //this method contains static call
        //DbUtils.resultSetToTableModel(rs)

    }

    @Test
    public void testUpdate() throws Exception {
        when(connection.prepareStatement(any(String.class))).thenReturn(pst);
        apm.update(connection,table,textField_id,textField_name,textField_sname,textField_contact,textField_address);
        System.out.println("Update is working without error");
    }

    @Test
    public void testDelete() throws Exception {
        when(connection.prepareStatement(any(String.class))).thenReturn(pst);
        apm.delete(connection,table,textField_id);
        System.out.println("Delete is working without error");
    }

    @Test
    public void TestClick() throws Exception {

   }

    @Test
    public void TestRelease() throws Exception {
        //this method contains static call which cant be mock with mockito
        //DbUtils.resultSetToTableModel(rs)
    }

    @Test
    public void TestloadCartHistory() throws Exception {
        when(connection.prepareStatement(any(String.class))).thenReturn(pst);
        when(pst.executeQuery()).thenReturn(rs);
        apm.loadCartHistory(connection);
        System.out.println("loadCartHistory is working without error");
    }
}