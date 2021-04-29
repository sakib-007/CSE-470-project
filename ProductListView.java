import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;


public class ProductListView extends JFrame {

    public JPanel contentPane;
    public JLabel lblProductId;
    public JLabel lblProductName;
    public JLabel lblProductCatagory;
    public JLabel lblProductPrice;
    public JButton btnAddProduct;
    public JButton btnDeleteProduct;
    public JButton btnUpdate;
    public JLabel label_1;
    public JLabel label_2;
    public JLabel label_3;
    public JLabel label_4;
    public JLabel label_5;
    public JLabel lblUnit;
    public JScrollPane scrollPane;
    public JTable table;
    public JComboBox comboBox;
    public JTextField txtSearchProducts;
    public JTextField textField_id;
    public JTextField textField_name;
    public JTextField textField_catagory;
    public JTextField textField_price;
    public JTextField textField_unit;


    public void initialize(ProductListModel plm, Connection connection){
        setResizable(false);
        setForeground(UIManager.getColor("ToolBar.dockingForeground"));
        setIconImage(Toolkit.getDefaultToolkit().getImage("Icons\\shopping_bag.png"));
        setTitle("Product List");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 735, 484);
        contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        comboBox = new JComboBox();
        comboBox.setFont(new Font("Verdana", Font.BOLD, 11));
        comboBox.setBackground(UIManager.getColor("ComboBox.buttonBackground"));
        comboBox.setModel(new DefaultComboBoxModel(new String[] {"p_id", "p_name", "p_catagory"}));
        comboBox.setBounds(57, 11, 101, 41);
        contentPane.add(comboBox);

        txtSearchProducts = new JTextField();
        txtSearchProducts.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent arg0) {
                try {

                    plm.kRel(connection, table, comboBox, txtSearchProducts);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        txtSearchProducts.setBounds(57, 56, 101, 30);
        txtSearchProducts.setToolTipText("Search Product s");
        contentPane.add(txtSearchProducts);
        txtSearchProducts.setColumns(10);

        JButton btnLoadProducts = new JButton("Load Products");
        btnLoadProducts.setForeground(Color.DARK_GRAY);
        btnLoadProducts.setSelectedIcon(new ImageIcon("Icons\\package_installed_updated.png"));
        btnLoadProducts.setBackground(SystemColor.menu);
        btnLoadProducts.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        btnLoadProducts.setIcon(new ImageIcon("Icons\\santa_s_bag.png"));
        btnLoadProducts.setBounds(528, 47, 191, 47);
        btnLoadProducts.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                try {
                    plm.lProd(connection,table);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        contentPane.add(btnLoadProducts);

        textField_id = new JTextField();
        textField_id.setBounds(117, 127, 109, 20);
        contentPane.add(textField_id);
        textField_id.setColumns(10);

        scrollPane = new JScrollPane();
        scrollPane.setToolTipText("");
        scrollPane.setViewportBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "Products Table", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
        scrollPane.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {
                try {
                    plm.mCLick(connection, table, textField_id, textField_name, textField_catagory, textField_price, textField_unit);

                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
        scrollPane.setBounds(333, 97, 386, 349);
        contentPane.add(scrollPane);

        table = new JTable();
        table.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {
                try {
                    plm.mCLick(connection, table, textField_id, textField_name, textField_catagory, textField_price, textField_unit);

                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
        scrollPane.setViewportView(table);

        textField_name = new JTextField();
        textField_name.setBounds(117, 159, 109, 20);
        textField_name.setColumns(10);
        contentPane.add(textField_name);

        textField_catagory = new JTextField();
        textField_catagory.setBounds(117, 193, 109, 20);
        textField_catagory.setColumns(10);
        contentPane.add(textField_catagory);

        textField_unit = new JTextField();
        textField_unit.setColumns(10);
        textField_unit.setBounds(117, 261, 109, 20);
        contentPane.add(textField_unit);

        btnAddProduct = new JButton("Add");
        btnAddProduct.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnAddProduct.setBounds(5, 318, 88, 44);
        btnAddProduct.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try{
                    plm.aProd(connection, textField_id, textField_name, textField_catagory, textField_price, textField_unit);
                    JOptionPane.showMessageDialog(null, "Data Saved");

                } catch (Exception e1) {
                    e1.printStackTrace();
                }
                try {
                    plm.rTabl(connection,table);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });

        textField_price = new JTextField();
        textField_price.setBounds(117, 227, 109, 20);
        textField_price.setColumns(10);
        contentPane.add(textField_price);

        label_1 = new JLabel("");
        label_1.setIcon(new ImageIcon("Icons\\plus.png"));
        label_1.setBounds(28, 362, 48, 46);
        contentPane.add(label_1);
        contentPane.add(btnAddProduct);

        btnUpdate = new JButton("Update");
        btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnUpdate.setBounds(103, 317, 88, 46);
        btnUpdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    plm.uProd(connection, textField_id, textField_name, textField_catagory, textField_price, textField_unit);


                } catch (Exception e1) {
                    e1.printStackTrace();
                }
                try {
                    plm.rTabl(connection,table);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });

        btnDeleteProduct = new JButton("Delete");
        btnDeleteProduct.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnDeleteProduct.setBounds(203, 317, 88, 46);
        btnDeleteProduct.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    plm.dProd(connection,textField_id);

                } catch (Exception e1) {
                    e1.printStackTrace();
                }

                try {
                    plm.rTabl(connection,table);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });

        label_3 = new JLabel("");
        label_3.setIcon(new ImageIcon("Icons\\bt_remove.png"));
        label_3.setBounds(226, 362, 48, 46);
        contentPane.add(label_3);
        contentPane.add(btnDeleteProduct);

        label_2 = new JLabel("");
        label_2.setIcon(new ImageIcon("Icons\\system_software_update.png"));
        label_2.setBounds(127, 362, 48, 46);
        contentPane.add(label_2);
        contentPane.add(btnUpdate);

        JLabel label = new JLabel("");
        label.setIcon(new ImageIcon("Icons\\shopping_bag.png"));
        label.setBounds(273, 11, 48, 58);
        contentPane.add(label);

        JLabel lblProductList = new JLabel("Product List");
        lblProductList.setFont(new Font("Footlight MT Light", Font.BOLD, 17));
        lblProductList.setBounds(333, 22, 123, 47);
        contentPane.add(lblProductList);

        label_4 = new JLabel("");
        label_4.setIcon(new ImageIcon("Icons\\find.png"));
        label_4.setBounds(5, 50, 46, 47);
        contentPane.add(label_4);

        JDesktopPane desktopPane = new JDesktopPane();
        desktopPane.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "Product Data", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 128)));
        desktopPane.setBackground(new Color(102, 204, 102));
        desktopPane.setBounds(3, 97, 286, 210);
        contentPane.add(desktopPane);

        lblProductId = new JLabel("Product ID");
        lblProductId.setBounds(10, 26, 80, 24);
        desktopPane.add(lblProductId);
        lblProductId.setFont(new Font("Siyam Rupali", Font.BOLD, 15));

        lblProductName = new JLabel("Name");
        lblProductName.setBounds(10, 52, 42, 30);
        desktopPane.add(lblProductName);
        lblProductName.setFont(new Font("Siyam Rupali", Font.BOLD, 15));

        lblProductCatagory = new JLabel("Catagory");
        lblProductCatagory.setBounds(10, 90, 107, 29);
        desktopPane.add(lblProductCatagory);
        lblProductCatagory.setFont(new Font("Siyam Rupali", Font.BOLD, 15));

        lblProductPrice = new JLabel("Price");
        lblProductPrice.setBounds(10, 125, 107, 29);
        desktopPane.add(lblProductPrice);
        lblProductPrice.setFont(new Font("Siyam Rupali", Font.BOLD, 15));

        lblUnit = new JLabel("Unit");
        lblUnit.setBounds(10, 160, 107, 29);
        desktopPane.add(lblUnit);
        lblUnit.setFont(new Font("Siyam Rupali", Font.BOLD, 15));

        label_5 = new JLabel("");
        label_5.setIcon(new ImageIcon("Icons\\default.jpg"));
        label_5.setBounds(1, 0, 728, 456);
        contentPane.add(label_5);

    }


}
