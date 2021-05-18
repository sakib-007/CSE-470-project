import net.proteanit.sql.DbUtils;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static org.mockito.Mockito.*;

public class PurchaseModelTest {
    Connection connection;
    int billId = 1;
    PreparedStatement pst;
    ResultSet rs;
    PurchaseModel pm;
    JTable table;
    JTable mtable;
    JComboBox comboBox;
    JTextField textSearchProducts;
    JTextField textField_cname;
    JTextField textField_csname;
    JTextField textField_contact;
    JTextField textField_address;
    JTextField textField_name;
    JTextField textField_catagory;
    JTextField textField_unit;
    JTextField textField_price;
    TableModel tm;
    Object obj;
    @Before
    public void setUp() throws Exception {
        connection = Mockito.mock(Connection.class);
        pst = Mockito.mock(PreparedStatement.class);
        rs = Mockito.mock(ResultSet.class);
        mtable = Mockito.mock(JTable.class);
        tm = Mockito.mock(TableModel.class);
        obj = Mockito.mock(Object.class);
        pm = new PurchaseModel();
        table = new JTable();
        comboBox = new JComboBox();
        textSearchProducts = new JTextField();
        textField_cname = new JTextField();
        textField_csname = new JTextField();
        textField_contact = new JTextField();
        textField_address = new JTextField();
        textField_name = new JTextField();
        textField_catagory = new JTextField();
        textField_unit = new JTextField();
        textField_price = new JTextField();
        table.setModel(tm);
        mtable.setModel(tm);
    }

    @Test
    public void maxBill() throws Exception {

        //contains call on a final class
        //Integer.valueOf(rs1.getString(1));

    }

    @Test
    public void mClick() throws Exception {

    }

    @Test
    public void kRel() throws Exception {
        //contains call on a static method
        //DbUtils.resultSetToTableModel(rs)
    }

    @Test
    public void aPur() throws Exception {
        when(connection.prepareStatement(any(String.class))).thenReturn(pst);
        pm.aPur(connection, billId, textField_cname, textField_csname, textField_contact, textField_address, textField_name, textField_catagory, textField_unit, textField_price);
        System.out.println("aPur worked without any error");
    }

    @Test
    public void lPurP() throws Exception {
        //contains call on a static method
        //DbUtils.resultSetToTableModel(rs)
    }
}