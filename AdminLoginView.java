import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class AdminLoginView extends JFrame{

    public JPanel contentPane;
    public JButton btnResetPassword;
    public JTextField textField_user;
    public JPasswordField passwordField;



    public void initialize(AdminLoginModel Alm, Connection connection){
        setBounds(100, 100, 655, 486);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 255, 0));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        textField_user = new JTextField();
        textField_user.setBackground(new Color(153, 255, 51));
        textField_user.setBounds(216, 162, 211, 44);
        contentPane.add(textField_user);
        textField_user.setColumns(10);

        AdminLoginView frame = AdminLoginView.this;

        JButton btnLogin = new JButton("Login");
        btnLogin.setForeground(new Color(255, 255, 255));
        btnLogin.setFont(new Font("Segoe UI Symbol",Font.BOLD, 15));
        btnLogin.setBackground(new Color(204, 0, 0));
        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Object[] arr = Alm.getLogin(connection,textField_user,passwordField);
                    PreparedStatement pst = (PreparedStatement)arr[0];
                    ResultSet rs = (ResultSet)arr[1];
                    int count = 0;
                    while (rs.next())
                    {
                        count = count+1;
                    }
                    if (count==1)
                    {
                        frame.dispose();
                        JOptionPane.showMessageDialog(null, "Username & Password is correct");
                        AdminPageController adminpage;
                        adminpage = new AdminPageController();
                        adminpage.apv.setVisible(true);
                    }
                    else if (count>1)
                    {
                        JOptionPane.showMessageDialog(null, "Duplicate Username & Password\n Try again");
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Username & Password is not correct");
                    }
                    rs.close();
                    pst.close();

                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(null, e1);
                }

            }
        });
        btnLogin.setBounds(255, 277, 136, 51);
        contentPane.add(btnLogin);

        passwordField = new JPasswordField();
        passwordField.setBackground(new Color(255, 102, 51));
        passwordField.setBounds(216, 222, 211, 44);
        contentPane.add(passwordField);

        btnResetPassword = new JButton("Reset password");
        btnResetPassword.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PwCngAdminController pwcngadmin;
                pwcngadmin = new PwCngAdminController();
                frame.dispose();
                pwcngadmin.pwcav.setVisible(true);
            }
        });
        btnResetPassword.setBackground(new Color(255, 69, 0));
        btnResetPassword.setForeground(new Color(255, 255, 255));
        btnResetPassword.setBounds(255, 353, 136, 23);
        contentPane.add(btnResetPassword);

        JLabel label = new JLabel("");
        label.setIcon(new ImageIcon("Icons\\free-login-form-psd.jpg"));
        label.setBounds(0, 0, 646, 448);
        contentPane.add(label);

    }



}
