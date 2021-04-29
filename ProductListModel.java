import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ProductListModel extends JFrame {







    public void rTabl(Connection connection,JTable table) throws Exception{
        String query = "select * from Product";
        PreparedStatement pst = connection.prepareStatement(query);
        ResultSet rs = pst.executeQuery();
        table.setModel(DbUtils.resultSetToTableModel(rs));

    }

    public void kRel(Connection connection,JTable table,JComboBox comboBox,JTextField txtSearchProducts) throws Exception{
        String selection= (String)comboBox.getSelectedItem();
        String query = "select *  from Product where "+selection+"=?";
        PreparedStatement pst = connection.prepareStatement(query);
        pst.setString(1, txtSearchProducts.getText());
        ResultSet rs = pst.executeQuery();
        table.setModel(DbUtils.resultSetToTableModel(rs));
        pst.close();

    }

    public void mCLick(Connection connection,JTable table,JTextField textField_id,JTextField textField_name,JTextField textField_catagory,JTextField textField_price,JTextField textField_unit) throws Exception{
        int row = table.getSelectedRow();
        String p_id_=(table.getModel().getValueAt(row, 0)).toString();
        String query = "select * from Product where p_id='"+p_id_+"' ";
        PreparedStatement pst = connection.prepareStatement(query);
        ResultSet rs=pst.executeQuery();

        while (rs.next())
        {
            textField_id.setText(rs.getString("p_id"));
            textField_name.setText(rs.getString("p_name"));
            textField_catagory.setText(rs.getString("p_catagory"));
            textField_price.setText(rs.getString("p_price"));
            textField_unit.setText(rs.getString("p_unit"));
        }

    }

    public void lProd(Connection connection,JTable table) throws Exception{
        String query = "select * from Product";
        PreparedStatement pst = connection.prepareStatement(query);
        ResultSet rs = pst.executeQuery();
        table.setModel(DbUtils.resultSetToTableModel(rs));

    }

    public void aProd(Connection connection,JTextField textField_id,JTextField textField_name,JTextField textField_catagory,JTextField textField_price,JTextField textField_unit) throws Exception{
        String query = "insert into Product (p_id,p_name,p_catagory,p_price,p_unit) values (?,?,?,?,?)";
        PreparedStatement pst = connection.prepareStatement(query);
        if (textField_id.getText().equals(""))
        {
            pst.setString(1, null);

        }
        else {
            pst = connection.prepareStatement(query);
            pst.setString(1, textField_id.getText());
        }

        pst.setString(2, textField_name.getText());
        pst.setString(3, textField_catagory.getText());
        pst.setString(4, textField_price.getText());
        pst.setString(5, textField_unit.getText());

        pst.execute();
        pst.close();

    }

    public void uProd(Connection connection,JTextField textField_id,JTextField textField_name,JTextField textField_catagory,JTextField textField_price,JTextField textField_unit) throws Exception{
        String query = "Update Product set p_id='"+textField_id.getText()+"' , p_name='"+textField_name.getText()+"' , p_catagory='"+textField_catagory.getText()+"' , p_price='"+textField_price.getText()+"', p_unit='"+textField_unit.getText()+"' where p_id='"+textField_id.getText()+"' ";
        PreparedStatement pst = connection.prepareStatement(query);

        pst.execute();
        JOptionPane.showMessageDialog(null, "Data updated");
        pst.close();

    }

    public void dProd(Connection connection,JTextField textField_id) throws Exception{
        String query = "Delete from Product where p_id='"+textField_id.getText()+"'";
        PreparedStatement pst = connection.prepareStatement(query);

        pst.execute();
        JOptionPane.showMessageDialog(null, "Data Deleted");
        pst.close();

    }






}
