import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BillPageModel extends JFrame {





    public void maxBill(Connection connection) throws  Exception{
        String query1 = "select max(bill_id) from Billpay";
        PreparedStatement pst1 = connection.prepareStatement(query1);
        ResultSet rs1=pst1.executeQuery();
        rs1.next();
        PurchaseView.billId = Integer.valueOf(rs1.getString(1));

        pst1.execute();
        pst1.close();
    }

    public Object[] selectBill(Connection connection,double sum,PreparedStatement pst) throws Exception{
        String query = "select p_name,p_catagory, p_unit,p_price,date from Billpay where bill_id='"+PurchaseView.billId+"' ";
        pst = connection.prepareStatement(query);
        ResultSet rs = pst.executeQuery();
        Object [] arr = {pst,rs};
        return arr;
    }

    public Object[] cInfo(Connection connection,PreparedStatement pst) throws  Exception{
        String query = "select c_name,c_sname, c_contact, c_address from Billpay where bill_id='"+PurchaseView.billId+"' ";
        pst = connection.prepareStatement(query);
        ResultSet rs = pst.executeQuery();
        rs.next();
        Object [] arr = {pst,rs};
        return arr;
    }

}
