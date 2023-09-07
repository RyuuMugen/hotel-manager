package btljava;

import java.awt.BorderLayout;
import java.awt.*;
import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;

import java.awt.Font;
import java.awt.Image;
import java.sql.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class NewCustomer extends JFrame {
    Connection conn = null;
    PreparedStatement pst = null;
    private JPanel contentPane;
    private JTextField t1,t2,t3,t4,t5,t6;
    JComboBox comboBox;
    JRadioButton r1,r2;
    Choice c1;
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    NewCustomer frame = new NewCustomer();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public NewCustomer() throws SQLException {

        setBounds(530, 200, 850, 550);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("btljava/icons/AddCustomer.jpg"));
        Image i3 = i1.getImage().getScaledInstance(300, 400,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel l1 = new JLabel(i2);
        l1.setBounds(480,10,300,500);
        add(l1);

        JLabel lblName = new JLabel("Thêm Khách Hàng Mới");
        lblName.setFont(new Font("Rale way", Font.PLAIN, 20));
        lblName.setBounds(118, 11, 260, 53);
        contentPane.add(lblName);


        JLabel l2 = new JLabel("ID Khách Hàng :");
        l2.setBounds(35, 111, 200, 14);
        contentPane.add(l2);

        t1 = new JTextField();
        t1.setBounds(271, 111, 150, 20);
        contentPane.add(t1);
        t1.setColumns(10);

        JLabel lblName_1 = new JLabel("Tên KH :");
        lblName_1.setBounds(35, 151, 200, 14);
        contentPane.add(lblName_1);

        t2 = new JTextField();
        t2.setBounds(271, 151, 150, 20);
        contentPane.add(t2);
        t2.setColumns(10);


        JLabel lblGender = new JLabel("Giới Tính :");
        lblGender.setBounds(35, 191, 200, 14);
        contentPane.add(lblGender);

        r1 = new JRadioButton("Nam");
        r1.setFont(new Font("Raleway", Font.BOLD, 14));
        r1.setBackground(Color.WHITE);
        r1.setBounds(271, 191, 80, 12);
        add(r1);

        r2 = new JRadioButton("Nữ");
        r2.setFont(new Font("Raleway", Font.BOLD, 14));
        r2.setBackground(Color.WHITE);
        r2.setBounds(350, 191, 100, 12);
        add(r2);

        JLabel lblCountry = new JLabel("Quê Quán :");
        lblCountry.setBounds(35, 231, 200, 14);
        contentPane.add(lblCountry);

        JLabel lblReserveRoomNumber = new JLabel("Chọn Phòng :");
        lblReserveRoomNumber.setBounds(35, 274, 200, 14);
        contentPane.add(lblReserveRoomNumber);

        c1 = new Choice();
        try{
            Connect c = new Connect();

            ResultSet rs = c.s.executeQuery("select * from room where availability = 'Chưa Đặt' ");
            while(rs.next()){
                c1.add(rs.getString("room_number"));
            }
        }catch(Exception e){ }
        c1.setBounds(271, 274, 150, 20);
        contentPane.add(c1);

        JLabel lblCheckInStatus = new JLabel("Checked-In :");
        lblCheckInStatus.setBounds(35, 316, 200, 14);
        contentPane.add(lblCheckInStatus);

        JLabel lblDeposite = new JLabel("Tiền Trả :");
        lblDeposite.setBounds(35, 359, 200, 14);
        contentPane.add(lblDeposite);


        t3 = new JTextField();
        t3.setBounds(271, 231, 150, 20);
        contentPane.add(t3);
        t3.setColumns(10);


        t5 = new JTextField();
        t5.setBounds(271, 316, 150, 20);
        contentPane.add(t5);
        t5.setColumns(10);

        t6 = new JTextField();
        t6.setBounds(271, 359, 150, 20);
        contentPane.add(t6);
        t6.setColumns(10);

        JButton btnNewButton = new JButton("Thêm");

        btnNewButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                String radio = null;
                if(r1.isSelected()){
                    radio = "Nam";
                }
                else if(r2.isSelected()){
                    radio = "Nữ";
                }
                String s6 = c1.getSelectedItem();
                try{
                    Connect c= new Connect();
                    String s2 =  t1.getText();
                    String s3 =  t2.getText();
                    String s4 =  radio;
                    String s5 =  t3.getText();
                    String s7 =  t5.getText();
                    String s8 =  t6.getText();

                    String q1 = "insert into customer values('"+s2+"','"+s3+"','"+s4+"','"+s5+"'," +
                            "'"+s6+"','"+s7+"','"+s8+"')";
                    String q2 = "update room set availability = 'Đã Đặt' where room_number = "+s6;
                    c.s.executeUpdate(q1);
                    c.s.executeUpdate(q2);

                    JOptionPane.showMessageDialog(null, "Thêm Thành Công");
                    new Reception().setVisible(true);
                    setVisible(false);
                }catch(SQLException e1){
                    System.out.println(e1.getMessage());
                }
                catch(NumberFormatException s){
                }
            }
        });
        btnNewButton.setBounds(100, 430, 120, 30);
        btnNewButton.setBackground(Color.BLACK);
        btnNewButton.setForeground(Color.WHITE);
        contentPane.add(btnNewButton);

        JButton btnExit = new JButton("Trở Lại");
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Reception().setVisible(true);
                setVisible(false);
            }
        });
        btnExit.setBounds(260, 430, 120, 30);
        btnExit.setBackground(Color.BLACK);
        btnExit.setForeground(Color.WHITE);
        contentPane.add(btnExit);

        getContentPane().setBackground(Color.WHITE);
    }
}