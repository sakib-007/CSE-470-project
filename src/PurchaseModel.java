import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PurchaseModel extends JFrame {


    public void maxBill(Connection connection,int billId) throws Exception{

        String query1 = "select max(bill_id) from Billpay";
        PreparedStatement pst1 = connection.prepareStatement(query1);
        ResultSet rs1=pst1.executeQuery();
        rs1.next();
        billId = Integer.valueOf(rs1.getString(1));
        billId++;
        pst1.execute();
        pst1.close();
    }

    public void mClick(Connection connection,JTable table,JTextField textField_name,JTextField textField_catagory,JTextField textField_price,JTextField textField_unit) throws Exception{
        int row = table.getSelectedRow();
        String p_name_=(table.getModel().getValueAt(row, 1)).toString();
        String query = "select * from Product where p_name='"+p_name_+"' ";
        //String query = "hello";
        PreparedStatement pst = connection.prepareStatement(query);
        ResultSet rs=pst.executeQuery();

        while (rs.next())
        {

            textField_name.setText(rs.getString("p_name"));
            textField_catagory.setText(rs.getString("p_catagory"));
            textField_price.setText(rs.getString("p_price"));
            textField_unit.setText(rs.getString("p_unit"));
        }

    }

    public void kRel(Connection connection,JTable table,JComboBox comboBox,JTextField textSearchProducts) throws Exception{
        String selection= (String)comboBox.getSelectedItem();
        String query = "select *  from Product where "+selection+"=?";
        PreparedStatement pst = connection.prepareStatement(query);
        pst.setString(1, textSearchProducts.getText());
        ResultSet rs = pst.executeQuery();
        table.setModel(DbUtils.resultSetToTableModel(rs));
        pst.close();

    }

    public void aPur(Connection connection,int billId,JTextField textField_cname,JTextField textField_csname,JTextField textField_contact,JTextField textField_address,JTextField textField_name,JTextField textField_catagory,JTextField textField_unit,JTextField textField_price) throws Exception{
        String query = "insert into Billpay (id,bill_id,c_name,c_sname,c_contact,c_address,p_name,p_catagory,p_unit,p_price) values (?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement pst = connection.prepareStatement(query);

        pst.setString(1, null);
        pst.setString(2, String.valueOf(billId));
        pst.setString(3, textField_cname.getText());
        pst.setString(4, textField_csname.getText());
        pst.setString(5, textField_contact.getText());
        pst.setString(6, textField_address.getText());
        pst.setString(7, textField_name.getText());
        pst.setString(8, textField_catagory.getText());
        pst.setString(9, textField_unit.getText());
        pst.setString(10, textField_price.getText());


        pst.execute();
        pst.close();

    }

    public void lPurP(Connection connection,JTable table) throws Exception{

        String query = "select * from Product";
        PreparedStatement pst = connection.prepareStatement(query);
        ResultSet rs = pst.executeQuery();
        table.setModel(DbUtils.resultSetToTableModel(rs));
    }


}
