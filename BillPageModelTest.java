import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class BillPageModelTest {
    Connection connection;
    PreparedStatement pst;
    ResultSet rs;
    BillPageModel bpm;
    double sum;
    @Before
    public void setUp() throws Exception {
        connection = Mockito.mock(Connection.class);
        pst = Mockito.mock(PreparedStatement.class);
        rs = Mockito.mock(ResultSet.class);
        bpm = new BillPageModel();
    }

    @Test
    public void maxBill() {
        //calls method of a final class
        //Integer.valueOf(rs1.getString(1))
    }

    @Test
    public void selectBill() throws Exception {
        Object arr[]={pst,rs};
        when(connection.prepareStatement(any(String.class))).thenReturn(pst);
        when(pst.executeQuery()).thenReturn(rs);
        assertEquals(arr[0].getClass().getName(),(bpm.selectBill(connection,sum,pst))[0].getClass().getName());
        assertEquals(arr[1].getClass().getName(),(bpm.selectBill(connection,sum,pst))[1].getClass().getName());
        System.out.println("selectBill is working without error");
    }

    @Test
    public void cInfo() throws Exception {
        Object arr[]={pst,rs};
        when(connection.prepareStatement(any(String.class))).thenReturn(pst);
        when(pst.executeQuery()).thenReturn(rs);
        assertEquals(arr[0].getClass().getName(),(bpm.cInfo(connection,pst))[0].getClass().getName());
        assertEquals(arr[1].getClass().getName(),(bpm.cInfo(connection,pst))[1].getClass().getName());
        System.out.println("cInfo is working without error");
    }
}