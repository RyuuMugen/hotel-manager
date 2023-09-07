package btljava;

import javax.swing.*;

import java.sql.*;
import java.awt.event.*;
import java.awt.*;

public class Reception extends JFrame {

    private JPanel contentPane;

    public static void main(String[] args) {
        new Reception();
    }

    public Reception(){

        setBounds(530, 200, 850, 570);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("btljava/icons/Reception.jpg"));
        Image i3 = i1.getImage().getScaledInstance(500, 500,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel l1 = new JLabel(i2);
        l1.setBounds(250,30,500,470);
        add(l1);

        JButton btnNewCustomerForm = new JButton("Thêm Khách Hàng Mới");
        btnNewCustomerForm.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try{
                    NewCustomer custom = new NewCustomer();
                    custom.setVisible(true);
                    setVisible(false);
                }catch(Exception e1){
                    e1.printStackTrace();
                }
            }
        });
        btnNewCustomerForm.setBounds(10, 90, 200, 30);
        btnNewCustomerForm.setBackground(Color.BLACK);
        btnNewCustomerForm.setForeground(Color.WHITE);
        contentPane.add(btnNewCustomerForm);

        JButton btnNewButton = new JButton("Thông Tin Phòng");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                try{
                    Room room = new Room();
                    room.setVisible(true);
                    setVisible(false);
                }
                catch(Exception e){
                    e.printStackTrace();
                }

            }
        });
        btnNewButton.setBounds(10, 130, 200, 30);
        btnNewButton.setBackground(Color.BLACK);
        btnNewButton.setForeground(Color.WHITE);

        contentPane.add(btnNewButton);


        JButton btnNewButton_2 = new JButton("Thông Tin Nhân Viên");
        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try{
                    Employee em = new Employee();
                    em.setVisible(true);
                    setVisible(false);
                }
                catch (Exception e1){
                    e1.printStackTrace();
                }
            }
        });
        btnNewButton_2.setBounds(10, 170, 200, 30);
        btnNewButton_2.setBackground(Color.BLACK);
        btnNewButton_2.setForeground(Color.WHITE);

        contentPane.add(btnNewButton_2);

        JButton btnNewButton_3 = new JButton("Thông Tin Khách Hàng");
        btnNewButton_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try{
                    CustomerInfo customer = new CustomerInfo();
                    customer.setVisible(true);
                    setVisible(false);
                }
                catch (Exception e1){
                    e1.printStackTrace();
                }
            }
        });
        btnNewButton_3.setBounds(10, 210, 200, 30);
        btnNewButton_3.setBackground(Color.BLACK);
        btnNewButton_3.setForeground(Color.WHITE);

        contentPane.add(btnNewButton_3);



        JButton btnNewButton_4 = new JButton("Check Out");
        btnNewButton_4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CheckOut check;
                try {
                    check = new CheckOut();
                    check.setVisible(true);
                    setVisible(false);
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });
        btnNewButton_4.setBounds(10, 255, 200, 30);
        btnNewButton_4.setBackground(Color.BLACK);
        btnNewButton_4.setForeground(Color.WHITE);

        contentPane.add(btnNewButton_4);

        JButton btnNewButton_5 = new JButton("Update Check Status");
        btnNewButton_5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try{
                    UpdateCheck update = new UpdateCheck();
                    update.setVisible(true);
                    setVisible(false);
                }
                catch(Exception e1){
                    e1.printStackTrace();
                }
            }
        });
        btnNewButton_5.setBounds(10, 295, 200, 30);
        btnNewButton_5.setBackground(Color.BLACK);
        btnNewButton_5.setForeground(Color.WHITE);

        contentPane.add(btnNewButton_5);

        JButton btnNewButton_6 = new JButton("Câp Nhật Thông Tin Phòng");
        btnNewButton_6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try{
                    UpdateRoom room = new UpdateRoom();
                    room.setVisible(true);
                    setVisible(false);
                }catch(Exception s)
                {
                    s.printStackTrace();
                }
            }
        });
        btnNewButton_6.setBounds(10, 340, 200, 30);
        btnNewButton_6.setBackground(Color.BLACK);
        btnNewButton_6.setForeground(Color.WHITE);

        contentPane.add(btnNewButton_6);

        JButton btnSearchRoom = new JButton("Tìm Phòng");
        btnSearchRoom.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    SearchRoom search = new SearchRoom();
                    search.setVisible(true);
                    setVisible(false);
                }
                catch (Exception ss){
                    ss.printStackTrace();
                }
            }
        });
        btnSearchRoom.setBounds(10, 385, 200, 30);
        btnSearchRoom.setBackground(Color.BLACK);
        btnSearchRoom.setForeground(Color.WHITE);

        contentPane.add(btnSearchRoom);

        JButton btnNewButton_7 = new JButton("Đăng Xuất");
        btnNewButton_7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                try {
                    new Login().setVisible(true);
                    setVisible(false);

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });
        btnNewButton_7.setBounds(10, 430, 200, 30);
        btnNewButton_7.setBackground(Color.BLACK);
        btnNewButton_7.setForeground(Color.WHITE);

        contentPane.add(btnNewButton_7);
        getContentPane().setBackground(Color.WHITE);

        setVisible(true);
    }
}
