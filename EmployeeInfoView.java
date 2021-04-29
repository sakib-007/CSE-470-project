import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;


public class EmployeeInfoView extends JFrame {

    public JPanel contentPane;
    public JTable table;
    public JComboBox comboBoxSelection;
    public JTextField textFieldID;
    public JTextField textFieldName;
    public JTextField textFieldContact;
    public JTextField textFieldAdr;
    public JTextField textFieldSearch;

    public void initialize(EmployeeInfoModel eim,Connection connection){

        setBackground(new Color(255, 215, 0));
        setIconImage(Toolkit.getDefaultToolkit().getImage("Icons\\Office-Customer-Male-Light-icon.png"));
        setTitle("Load Employee Data");

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 742, 475);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(30, 144, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        JButton btnNewButton = new JButton("Load Employee Data");
        btnNewButton.setBounds(542, 38, 184, 45);
        btnNewButton.setForeground(new Color(255, 0, 0));
        btnNewButton.setBackground(new Color(255, 245, 238));
        btnNewButton.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    eim.lEm(connection,table);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }

            }
        });

        textFieldSearch = new JTextField();
        textFieldSearch.setBounds(128, 22, 165, 40);
        textFieldSearch.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent arg0) {
                try {
                    eim.kRel(connection, table, comboBoxSelection, textFieldSearch);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        contentPane.setLayout(null);

        comboBoxSelection = new JComboBox();
        comboBoxSelection.setBounds(10, 22, 106, 40);
        comboBoxSelection.setModel(new DefaultComboBoxModel(new String[] {"EID", "Name", "Contact", "Address"}));
        contentPane.add(comboBoxSelection);
        contentPane.add(textFieldSearch);
        textFieldSearch.setColumns(10);
        contentPane.add(btnNewButton);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(358, 83, 368, 354);

        table = new JTable();
        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent arg0) {
                try {
                    eim.mClick(connection, table, textFieldID, textFieldName, textFieldContact, textFieldAdr);

                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
        scrollPane.setViewportView(table);
        contentPane.add(scrollPane);

        JButton btnNewButton_1 = new JButton("Add");
        btnNewButton_1.setBackground(UIManager.getColor("Button.darkShadow"));
        btnNewButton_1.setBounds(10, 297, 106, 31);
        btnNewButton_1.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                try {

                    eim.adEm(connection, textFieldID, textFieldName, textFieldContact, textFieldAdr);

                    JOptionPane.showMessageDialog(null, "Data Saved");

                } catch (Exception e1) {
                    e1.printStackTrace();
                }
                try {
                    eim.rtable(connection,table);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
        contentPane.add(btnNewButton_1);

        JButton btnUpdate = new JButton("Update");
        btnUpdate.setBounds(10, 375, 106, 23);
        btnUpdate.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
        btnUpdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    eim.upEm(connection, textFieldID, textFieldName, textFieldContact, textFieldAdr);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
                try {
                    eim.rtable(connection,table);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });

        JButton btnDelete = new JButton("Delete");
        btnDelete.setBackground(UIManager.getColor("Button.background"));
        btnDelete.setBounds(10, 339, 106, 25);
        btnDelete.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
        btnDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                try {

                    eim.delEm(connection,textFieldID);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }

                try {
                    eim.rtable(connection,table);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
        contentPane.add(btnDelete);
        contentPane.add(btnUpdate);

        JLabel label = new JLabel("");
        label.setBounds(143, 297, 150, 129);
        label.setIcon(new ImageIcon("Icons\\Admin-icon.png"));
        contentPane.add(label);

        JDesktopPane desktopPane = new JDesktopPane();
        desktopPane.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "information", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 255, 255)));
        desktopPane.setBackground(new Color(0, 128, 0));
        desktopPane.setBounds(10, 84, 306, 191);
        contentPane.add(desktopPane);

        textFieldAdr = new JTextField();
        textFieldAdr.setBounds(108, 138, 165, 31);
        desktopPane.add(textFieldAdr);
        textFieldAdr.setColumns(10);

        textFieldContact = new JTextField();
        textFieldContact.setBounds(108, 107, 165, 20);
        desktopPane.add(textFieldContact);
        textFieldContact.setColumns(10);

        textFieldName = new JTextField();
        textFieldName.setBounds(108, 76, 165, 20);
        desktopPane.add(textFieldName);
        textFieldName.setColumns(10);

        textFieldID = new JTextField();
        textFieldID.setBounds(108, 45, 165, 20);
        desktopPane.add(textFieldID);
        textFieldID.setColumns(10);

        JLabel lblAddress = new JLabel("Address");
        lblAddress.setForeground(new Color(255, 255, 255));
        lblAddress.setBounds(10, 141, 85, 20);
        desktopPane.add(lblAddress);
        lblAddress.setHorizontalAlignment(SwingConstants.CENTER);
        lblAddress.setFont(new Font("Trebuchet MS", Font.BOLD, 15));

        JLabel lblContact = new JLabel("Contact");
        lblContact.setForeground(new Color(255, 255, 255));
        lblContact.setBounds(10, 105, 85, 20);
        desktopPane.add(lblContact);
        lblContact.setHorizontalAlignment(SwingConstants.CENTER);
        lblContact.setFont(new Font("Trebuchet MS", Font.BOLD, 15));

        JLabel lblName = new JLabel("Name");
        lblName.setForeground(new Color(255, 255, 255));
        lblName.setBounds(20, 74, 49, 20);
        desktopPane.add(lblName);
        lblName.setHorizontalAlignment(SwingConstants.CENTER);
        lblName.setFont(new Font("Trebuchet MS", Font.BOLD, 15));

        JLabel lblNewLabel = new JLabel("EID");
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setBounds(10, 44, 59, 19);
        desktopPane.add(lblNewLabel);
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 15));

        JLabel label_1 = new JLabel("");
        label_1.setHorizontalAlignment(SwingConstants.TRAILING);
        label_1.setBounds(0, 0, 726, 437);
        label_1.setIcon(new ImageIcon("Icons\\dark-blue-pattern-wallpapers-desktop-background.jpg"));
        contentPane.add(label_1);


    }
}
