import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;


public class PurchaseView extends JFrame {



    public JPanel contentPane;
    public JDesktopPane desktopPane;
    public JScrollPane scrollPane;
    public JLabel lblNewLabel;
    public JLabel lblCatagory;
    public JLabel lblUnit;
    public JLabel lblPrice;
    public JDesktopPane desktopPane_2;
    public JLabel label;
    public JDesktopPane desktopPane_1;
    public JScrollPane scrollPane_1;
    public JComboBox comboBox;
    public JTextField textField_cname;
    public JTextField textField_contact;
    public JTextField textField_csname;
    public JTextField textField_address;
    public JTextField textField_name;
    public JTextField textField_catagory;
    public JTextField textField_unit;
    public JTextField textField_price;
    public JTable table;
    public JTextField textSearchProducts;
    public static int billId = 1;


    public void initialize(PurchaseModel pcm, Connection connection){

        setBackground(new Color(204, 102, 51));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 723, 482);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 153, 0));
        contentPane.setForeground(Color.LIGHT_GRAY);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblPurchasStation = new JLabel("Purchas Station");
        lblPurchasStation.setForeground(new Color(255, 255, 255));
        lblPurchasStation.setIcon(new ImageIcon("Icons\\santa_s_bag.png"));
        lblPurchasStation.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 18));
        lblPurchasStation.setBounds(298, 0, 180, 62);
        contentPane.add(lblPurchasStation);



        JLabel lblName = new JLabel("Name");
        lblName.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
        lblName.setBounds(21, 73, 54, 21);
        contentPane.add(lblName);

        textField_cname = new JTextField();
        textField_cname.setBounds(75, 74, 70, 20);
        contentPane.add(textField_cname);
        textField_cname.setColumns(10);

        JLabel lblContact = new JLabel("Contact");
        lblContact.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
        lblContact.setBounds(21, 107, 46, 14);
        contentPane.add(lblContact);

        textField_contact = new JTextField();
        textField_contact.setColumns(10);
        textField_contact.setBounds(75, 105, 150, 20);
        contentPane.add(textField_contact);

        textField_csname = new JTextField();
        textField_csname.setColumns(10);
        textField_csname.setBounds(155, 74, 70, 20);
        contentPane.add(textField_csname);

        JLabel lblAddress = new JLabel("Address");
        lblAddress.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
        lblAddress.setBounds(21, 143, 46, 14);
        contentPane.add(lblAddress);

        textField_address = new JTextField();
        textField_address.setColumns(10);
        textField_address.setBounds(75, 141, 150, 20);
        contentPane.add(textField_address);

        desktopPane = new JDesktopPane();
        desktopPane.setBorder(new TitledBorder(null, "Customer Data", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 255)));
        desktopPane.setBackground(Color.LIGHT_GRAY);
        desktopPane.setBounds(10, 50, 223, 118);
        contentPane.add(desktopPane);

        scrollPane = new JScrollPane();
        scrollPane.setViewportBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Customer Data", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 255)));
        scrollPane.setBounds(10, 60, 223, 106);
        contentPane.add(scrollPane);

        lblCatagory = new JLabel("Catagory");
        lblCatagory.setFont(new Font("Proxima Nova Rg", Font.PLAIN, 13));
        lblCatagory.setBounds(21, 237, 54, 23);
        contentPane.add(lblCatagory);

        lblUnit = new JLabel("Unit");
        lblUnit.setFont(new Font("Proxima Nova Rg", Font.PLAIN, 13));
        lblUnit.setBounds(21, 271, 54, 23);
        contentPane.add(lblUnit);

        lblPrice = new JLabel("Price");
        lblPrice.setFont(new Font("Proxima Nova Rg", Font.PLAIN, 13));
        lblPrice.setBounds(21, 305, 54, 17);
        contentPane.add(lblPrice);

        textField_catagory = new JTextField();
        textField_catagory.setColumns(10);
        textField_catagory.setBounds(96, 238, 108, 20);
        contentPane.add(textField_catagory);

        textField_unit = new JTextField();
        textField_unit.setColumns(10);
        textField_unit.setBounds(96, 272, 108, 20);
        contentPane.add(textField_unit);

        textField_price = new JTextField();
        textField_price.setColumns(10);
        textField_price.setBounds(96, 303, 108, 20);
        contentPane.add(textField_price);

        textField_name = new JTextField();
        textField_name.setBounds(96, 208, 108, 20);
        contentPane.add(textField_name);
        textField_name.setColumns(10);

        lblNewLabel = new JLabel("Name");
        lblNewLabel.setBounds(21, 208, 54, 21);
        contentPane.add(lblNewLabel);
        lblNewLabel.setFont(new Font("Proxima Nova Rg", Font.PLAIN, 13));

        desktopPane_1 = new JDesktopPane();
        desktopPane_1.setBorder(new TitledBorder(null, "Product Data", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
        desktopPane_1.setBackground(Color.LIGHT_GRAY);
        desktopPane_1.setBounds(10, 189, 223, 157);
        contentPane.add(desktopPane_1);

        scrollPane_1 = new JScrollPane();
        scrollPane_1.setBounds(434, 144, 263, 300);
        contentPane.add(scrollPane_1);

        table = new JTable();
        table.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent arg0) {
                try {
                    pcm.mClick(connection,table, textField_name, textField_catagory, textField_price, textField_unit);

                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
        scrollPane_1.setViewportView(table);

        textSearchProducts = new JTextField();
        textSearchProducts.addKeyListener(new KeyAdapter() {

            public void keyReleased(KeyEvent arg0) {
                try {

                    pcm.kRel(connection, table, comboBox, textSearchProducts);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        textSearchProducts.setBounds(444, 93, 119, 37);
        contentPane.add(textSearchProducts);
        textSearchProducts.setColumns(10);

        comboBox = new JComboBox();
        comboBox.setFont(new Font("Malgun Gothic", Font.BOLD, 13));
        comboBox.setModel(new DefaultComboBoxModel(new String[] {"p_id", "p_name", "p_catagory"}));
        comboBox.setBounds(573, 93, 108, 37);
        contentPane.add(comboBox);

        JButton btnAddToCurt = new JButton("Add");
        btnAddToCurt.setBackground(Color.WHITE);
        btnAddToCurt.setIcon(new ImageIcon("Icons\\shopping_cart.png"));
        btnAddToCurt.setFont(new Font("Vrinda", Font.BOLD, 15));
        btnAddToCurt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {

                System.out.println("Bill id"+billId);
                try{

                    pcm.aPur(connection, billId, textField_cname, textField_csname, textField_contact, textField_address, textField_name, textField_catagory, textField_unit, textField_price);
                    JOptionPane.showMessageDialog(null, "Added to tha curt!");

                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
        btnAddToCurt.setBounds(277, 222, 135, 66);
        contentPane.add(btnAddToCurt);

        JButton btnNewButton = new JButton("");
        btnNewButton.addActionListener(new ActionListener() {

            PurchaseView frame = PurchaseView.this;
            public void actionPerformed(ActionEvent arg0) {

                frame.dispose();
                BillPageController billPage;
                billPage = new BillPageController();
                billPage.bpv.setVisible(true);
            }

        });
        btnNewButton.setForeground(new Color(0, 204, 0));
        btnNewButton.setBackground(new Color(255, 255, 0));
        btnNewButton.setIcon(new ImageIcon("Icons\\shop-icon.png"));
        btnNewButton.setBounds(10, 367, 223, 66);
        contentPane.add(btnNewButton);

        desktopPane_2 = new JDesktopPane();
        desktopPane_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Search Items", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 128)));
        desktopPane_2.setBackground(UIManager.getColor("Button.shadow"));
        desktopPane_2.setBounds(434, 73, 263, 66);
        contentPane.add(desktopPane_2);
        try {
            pcm.lPurP(connection,table);
            JButton btnLoadProductData = new JButton("Load Products");
            btnLoadProductData.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    try {
                        pcm.lPurP(connection,table);
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                }
            });
            btnLoadProductData.setFont(new Font("Segoe Print", Font.BOLD, 12));
            btnLoadProductData.setBounds(562, 17, 135, 45);
            contentPane.add(btnLoadProductData);

            label = new JLabel("");
            label.setIcon(new ImageIcon("Icons\\1.jpg"));
            label.setBounds(0, 0, 707, 463);
            contentPane.add(label);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

}
