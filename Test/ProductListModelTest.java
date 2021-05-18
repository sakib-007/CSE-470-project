import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class ProductListModelTest {
    Connection connection;
    PreparedStatement pst;
    ResultSet rs;
    ProductListModel plm;
    JTextField textField_id;
    JTextField textField_name;
    JTextField textField_catagory;
    JTextField textField_price;
    JTextField textField_unit;


    @Before
    public void setUp() throws Exception {

        connection = Mockito.mock(Connection.class);
        pst = Mockito.mock(PreparedStatement.class);
        //rs = Mockito.mock(ResultSet.class);
        textField_id = new JTextField();
        textField_name = new JTextField();
        textField_catagory = new JTextField();
        textField_unit = new JTextField();
        textField_price = new JTextField();
        plm = new ProductListModel();

    }

    @Test
    public void rTabl() {
        //contains call on a static method
        //DbUtils.resultSetToTableModel(rs)
    }

    @Test
    public void kRel() {
        //contains call on a static method
        //DbUtils.resultSetToTableModel(rs)
    }

    @Test
    public void mCLick() {
    }

    @Test
    public void lProd() {
        //contains call on a static method
        //DbUtils.resultSetToTableModel(rs)
    }

    @Test
    public void aProd() throws Exception{
        when(connection.prepareStatement(any(String.class))).thenReturn(pst);
        plm.aProd(connection,textField_id,textField_name,textField_catagory,textField_price,textField_unit);
        System.out.println("aProd working without any error");
    }

    @Test
    public void uProd() throws Exception {
        when(connection.prepareStatement(any(String.class))).thenReturn(pst);
        plm.uProd(connection,textField_id,textField_name,textField_catagory,textField_price,textField_unit);
        System.out.println("uProd working without any error");
    }

    @Test
    public void dProd() throws Exception{
        when(connection.prepareStatement(any(String.class))).thenReturn(pst);
        plm.dProd(connection,textField_id);
        System.out.println("uProd working without any error");
    }

}