package btljava;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class HotelManagementSystem extends JFrame implements ActionListener{

    JLabel l1;
    JButton b1;

    public HotelManagementSystem() {

        setSize(900,430);
        setLayout(null);
        setLocation(300,300);

        l1 = new JLabel("");
        b1 = new JButton("Đăng Nhập");

        b1.setBackground(Color.WHITE);
        b1.setForeground(Color.BLACK);



        ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("btljava/icons/HotelManager.jpg"));
        Image i3 = i1.getImage().getScaledInstance(900, 390,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        l1 = new JLabel(i2);


        JLabel lid=new JLabel("Hệ Thống Quản Lý Khách Sạn");
        lid.setBounds(60,30,500,70);
        lid.setFont(new Font("serif",Font.PLAIN,30));
        lid.setForeground(Color.red);
        l1.add(lid);

        b1.setBounds(700,325,100,50);
        l1.setBounds(0, 0, 900, 390);

        l1.add(b1);
        add(l1);

        b1.addActionListener(this);
        setVisible(true);

        while(true){
            lid.setVisible(false); // lid =  j label
            try{
                Thread.sleep(500); //1000 = 1 second
            }catch(Exception e){}
            lid.setVisible(true);
            try{
                Thread.sleep(500);
            }catch(Exception e){}
        }
    }

    public void actionPerformed(ActionEvent ae){
        new Login().setVisible(true);
        this.setVisible(false);

    }

    public static void main(String[] args) {
        HotelManagementSystem window = new HotelManagementSystem();
        window.setVisible(true);
    }
}
