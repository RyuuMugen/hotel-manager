package btljava;

import java.awt.BorderLayout;
import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;
import java.sql.*;
import javax.swing.*;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CustomerInfo extends JFrame {
    Connection conn = null;
    private JPanel contentPane;
    private JLabel lblId;
    private JLabel lblNewLabel;
    private JLabel lblGender;
    private JTable table;
    private JLabel lblCountry;
    private JLabel lblRoom;
    private JLabel lblStatus;
    private JLabel lblNewLabel_1;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CustomerInfo frame = new CustomerInfo();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    public void close()
    {
        this.dispose();
    }
    /**
     * Create the frame.
     * @throws SQLException
     */
    public CustomerInfo() throws SQLException {
        //conn = Javaconnect.getDBConnection();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(530, 200, 900, 600);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);


        JButton btnExit = new JButton("Trở Lại");
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Reception().setVisible(true);
                setVisible(false);
            }
        });
        btnExit.setBounds(450, 510, 120, 30);
        btnExit.setBackground(Color.BLACK);
        btnExit.setForeground(Color.WHITE);
        contentPane.add(btnExit);

        JButton btnLoadData = new JButton("Cập Nhật");
        btnLoadData.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                try{
                    Connect c  = new Connect();

                    String displayCustomersql = "select * from Customer";
                    ResultSet rs = c.s.executeQuery(displayCustomersql);
                    table.setModel(DbUtils.resultSetToTableModel(rs));
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
            }


        });
        btnLoadData.setBounds(300, 510, 120, 30);
        btnLoadData.setBackground(Color.BLACK);
        btnLoadData.setForeground(Color.WHITE);
        contentPane.add(btnLoadData);

        lblId = new JLabel("ID");
        lblId.setBounds(31, 11, 35, 14);
        contentPane.add(lblId);


        lblNewLabel = new JLabel("Tên");
        lblNewLabel.setBounds(160, 11, 65, 14);
        contentPane.add(lblNewLabel);

        lblGender = new JLabel("Giới Tính");
        lblGender.setBounds(270, 11, 70, 14);
        contentPane.add(lblGender);

        table = new JTable();
        table.setBounds(0, 40, 900, 450);
        contentPane.add(table);

        lblCountry = new JLabel("Quê Quán");
        lblCountry.setBounds(390, 11, 70, 14);
        contentPane.add(lblCountry);

        lblRoom = new JLabel("Phòng");
        lblRoom.setBounds(530   , 11, 46, 14);
        contentPane.add(lblRoom);

        lblStatus = new JLabel("Check-in Status");
        lblStatus.setBounds(650, 11, 100, 14);
        contentPane.add(lblStatus);



        lblNewLabel_1 = new JLabel("Tiền Đã Trả");
        lblNewLabel_1.setBounds(780, 11, 100, 14);
        contentPane.add(lblNewLabel_1);

        getContentPane().setBackground(Color.WHITE);
    }
}