import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class EmployeeInfoModel {




    public void rtable(Connection connection,JTable table) throws Exception{
        String query = "select * from EmployeeInfo";
        PreparedStatement pst = connection.prepareStatement(query);
        ResultSet rs = pst.executeQuery();
        table.setModel(DbUtils.resultSetToTableModel(rs));
    }

    public void lEm(Connection connection,JTable table) throws Exception{
        String query = "select * from EmployeeInfo";
        PreparedStatement pst = connection.prepareStatement(query);
        ResultSet rs = pst.executeQuery();
        table.setModel(DbUtils.resultSetToTableModel(rs));

    }
    public void adEm(Connection connection,JTextField textFieldID,JTextField textFieldName,JTextField textFieldContact,JTextField textFieldAdr) throws Exception{

        String query = "insert into EmployeeInfo (EID,Name,Contact,Address) values (?,?,?,?)";
        PreparedStatement pst = connection.prepareStatement(query);
        if (textFieldID.getText().equals(""))
        {
            pst.setString(1, null);

        }
        else {
            pst = connection.prepareStatement(query);
            pst.setString(1, textFieldID.getText());
        }

        pst.setString(2, textFieldName.getText());
        pst.setString(3, textFieldContact.getText());
        pst.setString(4, textFieldAdr.getText());

        pst.execute();
        pst.close();
    }

    public void upEm(Connection connection,JTextField textFieldID,JTextField textFieldName,JTextField textFieldContact,JTextField textFieldAdr) throws Exception{
        String query = "Update EmployeeInfo set EId='"+textFieldID.getText()+"' , Name='"+textFieldName.getText()+"' , Contact='"+textFieldContact.getText()+"' , Address='"+textFieldAdr.getText()+"' where Eid='"+textFieldID.getText()+"' ";
        PreparedStatement pst = connection.prepareStatement(query);

        pst.execute();
        JOptionPane.showMessageDialog(null, "Data updated");
        pst.close();



    }

    public void delEm(Connection connection,JTextField textFieldID) throws Exception{
        String query = "Delete from EmployeeInfo where EId='"+textFieldID.getText()+"'";
        PreparedStatement pst = connection.prepareStatement(query);

        pst.execute();
        JOptionPane.showMessageDialog(null, "Data Deleted");
        pst.close();
    }

    public void mClick(Connection connection,JTable table,JTextField textFieldID,JTextField textFieldName,JTextField textFieldContact,JTextField textFieldAdr) throws Exception{

        int row = table.getSelectedRow();
        String EID_=(table.getModel().getValueAt(row, 0)).toString();
        String query = "select * from EmployeeInfo where EID='"+EID_+"' ";
        PreparedStatement pst = connection.prepareStatement(query);
        ResultSet rs=pst.executeQuery();

        while (rs.next())
        {
            textFieldID.setText(rs.getString("EID"));
            textFieldName.setText(rs.getString("Name"));
            textFieldContact.setText(rs.getString("Contact"));
            textFieldAdr.setText(rs.getString("Address"));
        }
    }

    public void kRel(Connection connection,JTable table,JComboBox comboBoxSelection,JTextField textFieldSearch) throws Exception{
        String selection= (String)comboBoxSelection.getSelectedItem();
        String query = "select *  from EmployeeInfo where "+selection+"=? ";
        PreparedStatement pst = connection.prepareStatement(query);
        pst.setString(1, textFieldSearch.getText());
        ResultSet rs = pst.executeQuery();
        table.setModel(DbUtils.resultSetToTableModel(rs));
        pst.close();


    }



}
