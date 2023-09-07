package btljava;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class Dashboard extends JFrame{

    public static void main(String[] args) {
        new Dashboard().setVisible(true);
    }

    public Dashboard() {
        super("Hệ Thống Quản Lý Khách Sạn");

        setForeground(Color.CYAN);
        setLayout(null);


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("btljava/icons/Dashboard.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000, 650,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel NewLabel = new JLabel(i3);
        NewLabel.setBounds(0, 0, 1000, 650);
        add(NewLabel);

        JLabel AirlineManagementSystem = new JLabel("Welcome to VINHOME");
        AirlineManagementSystem.setForeground(Color.WHITE);
        AirlineManagementSystem.setFont(new Font("Tahoma", Font.PLAIN, 36));
        AirlineManagementSystem.setBounds(300, 60, 950, 85);
        NewLabel.add(AirlineManagementSystem);


        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu AirlineSystem = new JMenu("Quản lí");
        AirlineSystem.setForeground(Color.BLUE);
        menuBar.add(AirlineSystem);

        JMenuItem FlightDetails = new JMenuItem("Hệ Thống");
        AirlineSystem.add(FlightDetails);

        JMenu AirlineSystemHello = new JMenu("ADMIN");
        AirlineSystemHello.setForeground(Color.RED);
        menuBar.add(AirlineSystemHello);

        JMenuItem FlightDetailshello1 = new JMenuItem("Thêm Nhân Viên");
        AirlineSystemHello.add(FlightDetailshello1);

        FlightDetailshello1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try{
                    new AddEmployee().setVisible(true);
                }catch(Exception e ){}
            }
        });


        JMenuItem FlightDetailshello2 = new JMenuItem("Thêm Phòng");
        AirlineSystemHello.add(FlightDetailshello2);

        FlightDetailshello2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try{
                    new AddRoom().setVisible(true);
                }catch(Exception e ){}
            }
        });


        FlightDetails.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                new Reception();
            }
        });

        setSize(1000,650);
        setVisible(true);
        getContentPane().setBackground(Color.WHITE);
    }
}