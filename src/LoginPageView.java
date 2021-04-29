import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginPageView extends JFrame {
    public JFrame frame;
    public JTextField textFieldUN;
    public JPasswordField passwordField;


    public void initialize(LoginPageModel lom, Connection connection) {

        frame = new JFrame();
        frame.setResizable(false);
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage("Icons\\shop-icon.png"));
        frame.setBackground(new Color(153, 153, 204));
        frame.setBounds(100, 100, 727, 469);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon("Icons\\Office-Customer-Male-Light-icon.png"));
        lblNewLabel.setBounds(210, 172, 61, 64);
        frame.getContentPane().add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon("Icons\\Security-Password-2-icon.png"));
        lblNewLabel_1.setVerifyInputWhenFocusTarget(false);
        lblNewLabel_1.setBounds(415, 172, 61, 64);
        frame.getContentPane().add(lblNewLabel_1);

        textFieldUN = new JTextField();
        textFieldUN.setFont(new Font("Tw Cen MT", Font.BOLD, 15));
        textFieldUN.setBounds(176, 247, 135, 42);
        frame.getContentPane().add(textFieldUN);
        textFieldUN.setColumns(10);

        JButton btnLogin = new JButton("");

        btnLogin.setIcon(new ImageIcon("Icons\\160_F_7270311_iwRCdBvGmJuovg13PLhhMAUnxvPvHesp.jpg"));
        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                try {
                    Object [] arr = lom.selLog(connection,textFieldUN,passwordField);
                    PreparedStatement pst = (PreparedStatement)arr[0];
                    ResultSet rs = (ResultSet)arr[1];
                    int count = 0;
                    while (rs.next()) {

                        count = count + 1;
                    }
                    if (count == 1) {
                        JOptionPane.showMessageDialog(null, "Username & Password is correct");
                        frame.dispose();
                        PanelController panel = new PanelController();
                        panel.pv.setVisible(true);
                    } else if (count > 1) {
                        JOptionPane.showMessageDialog(null, "Duplicate Username & Password\n Try again");
                    } else {
                        JOptionPane.showMessageDialog(null, "Username & Password is not correct");
                    }
                    rs.close();
                    pst.close();

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);
                }
            }
        });




        btnLogin.setBounds(301, 314, 87, 35);
        frame.getContentPane().add(btnLogin);

        passwordField = new JPasswordField();
        passwordField.setBounds(382, 248, 135, 42);
        frame.getContentPane().add(passwordField);

        JLabel label = new JLabel("");
        label.setIcon(new ImageIcon("Icons\\supershop-logo.png"));
        label.setBounds(132, 0, 412, 109);
        frame.getContentPane().add(label);

        JLabel lblNewLabel_total = new JLabel("Login Page");
        lblNewLabel_total.setFont(new Font("Monospaced", Font.BOLD, 13));
        lblNewLabel_total.setVerticalAlignment(SwingConstants.BOTTOM);
        lblNewLabel_total.setForeground(Color.ORANGE);
        lblNewLabel_total.setBackground(Color.ORANGE);
        lblNewLabel_total.setIcon(new ImageIcon("Icons\\cool-light-blue-backgrounds.jpg"));
        lblNewLabel_total.setBounds(0, 0, 721, 445);
        frame.getContentPane().add(lblNewLabel_total);


    }
}
