import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import net.proteanit.sql.DbUtils;

public class AdminPageModel extends JFrame {




    public void refreshTable (Connection connection,JTable table)
    {
        try {
            String query = "select * from Billpay";
            PreparedStatement pst = connection.prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    public void update(Connection connection,JTable table,JTextField textField_id,JTextField textField_name,JTextField textField_sname,JTextField textField_contact,JTextField textField_address) throws Exception{
        String query1 = "Update Billpay set bill_id='"+textField_id.getText()+"', c_name='"+textField_name.getText()+"' , c_sname='"+textField_sname.getText()+"' , c_contact='"+textField_contact.getText()+"', c_address='"+textField_address.getText()+"' where bill_id='"+textField_id.getText()+"' ";
        PreparedStatement pst = connection.prepareStatement(query1);

        pst.execute();
        JOptionPane.showMessageDialog(null, "Data Edited");
        pst.close();

    }

    public void delete(Connection connection,JTable table,JTextField textField_id) throws Exception{
        String query = "Delete from Billpay where bill_id='"+textField_id.getText()+"'";
        PreparedStatement pst = connection.prepareStatement(query);

        pst.execute();
        JOptionPane.showMessageDialog(null, "Data Deleted");
        pst.close();

    }

    public void click(Connection connection,JTable table,JTextField textField_date,JTextField textField_contact,JTextField textField_name,JTextField textField_sname,JTextField textField_id,JTextField textField_address) throws Exception{
        int row = table.getSelectedRow();
        String id_=(table.getModel().getValueAt(row, 0)).toString();
        String query = "select * from Billpay where id='"+id_+"' ";
        PreparedStatement pst = connection.prepareStatement(query);
        ResultSet rs=pst.executeQuery();

        while (rs.next())
        {
            textField_date.setText(rs.getString("date"));
            textField_id.setText(rs.getString("bill_id"));
            textField_name.setText(rs.getString("c_name"));
            textField_sname.setText(rs.getString("c_sname"));
            textField_contact.setText(rs.getString("c_contact"));
            textField_address.setText(rs.getString("c_address"));
        }
    }

    public void release(Connection connection,JComboBox comboBox,JTextField textFieldsrch,JTable table) throws Exception{
        String selection= (String)comboBox.getSelectedItem();
        String query = "select *  from Billpay where "+selection+"=?";
        PreparedStatement pst = connection.prepareStatement(query);
        pst.setString(1, textFieldsrch.getText());
        ResultSet rs = pst.executeQuery();
        table.setModel(DbUtils.resultSetToTableModel(rs));
        pst.close();

    }

    public ResultSet loadCartHistory(Connection connection)throws Exception{

        String query = "select * from Billpay";
        PreparedStatement pst = connection.prepareStatement(query);
        ResultSet rs = pst.executeQuery();
        return rs;
    }




}
