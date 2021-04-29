import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class HelpView extends JFrame {

    public void initialize(JPanel contentPane){
        setIconImage(Toolkit.getDefaultToolkit().getImage("Icons\\Administrator-icon.png"));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 741, 477);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel label_1 = new JLabel("");
        label_1.setIcon(new ImageIcon("Icons\\rsz_1texture_288_by_sirius_sdz-d5cdbsb_copy_copy.jpg"));
        label_1.setBounds(10, 128, 219, 178);
        contentPane.add(label_1);

        JLabel label = new JLabel("");
        label.setIcon(new ImageIcon("Icons\\LadyHoldingHELPsign.jpg"));
        label.setBounds(207, 0, 392, 122);
        contentPane.add(label);

        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Developer", TitledBorder.LEADING, TitledBorder.TOP, null, Color.DARK_GRAY));
        panel.setBounds(273, 146, 266, 108);
        contentPane.add(panel);
        panel.setLayout(null);

        JTextArea txtrFazleRabbiAdor = new JTextArea();
        txtrFazleRabbiAdor.setEditable(false);
        txtrFazleRabbiAdor.setBounds(6, 16, 241, 78);
        panel.add(txtrFazleRabbiAdor);
        txtrFazleRabbiAdor.setFont(new Font("Century Gothic", Font.BOLD, 13));
        txtrFazleRabbiAdor.setText("Md.Sakib Hossain\r\nEmail: sakibhossain@gmail.com\r\nDepartment of CSE.\r\nBrac University.");

        JLabel lblName = new JLabel("imageback");
        lblName.setVerticalAlignment(SwingConstants.BOTTOM);
        lblName.setIcon(new ImageIcon("Icons\\Green-Grass-On-White-Background.-Matte-Channel..jpg"));
        lblName.setBounds(0, 0, 725, 439);
        contentPane.add(lblName);

    }

}
