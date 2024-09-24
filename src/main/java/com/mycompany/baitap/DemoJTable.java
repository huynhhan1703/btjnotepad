/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.baitap;

/**
 *
 * @author Admin
 */
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DemoJTable extends JFrame {
    
    private JLabel lblAccount, lblName;
    private JTextField txtAccount, txtName, txtBalance;
    private JButton btnAdd, btnDelete;
    private JTable table;
    private DefaultTableModel tableModel;

    public DemoJTable() {
        // Thiết lập cửa sổ
        setTitle("Demo JTable");
        setSize(650, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Tạo các thành phần giao diện
        lblAccount = new JLabel("Tên tài khoản");
        lblName = new JLabel("Số tiền");

        txtAccount = new JTextField(20);
        txtName = new JTextField(20);
       

        btnAdd = new JButton("Thêm");
        btnDelete = new JButton("Xoá");

        
        tableModel = new DefaultTableModel(new Object[]{"Tên tài khoản", "Số tiền"}, 0);
        table = new JTable(tableModel);

        // Khởi tạo một số dòng dữ liệu
        tableModel.addRow(new Object[]{"Lê Thành Công", "15000000"});
        tableModel.addRow(new Object[]{"Trần Minh Khôi", "10000000"});

        // Thiết lập bố cục cho giao diện
        JPanel panelInput = new JPanel(new GridLayout(1, 1, 10, 10));
        panelInput.add(lblAccount);
        panelInput.add(txtAccount);
        panelInput.add(lblName);
        panelInput.add(txtName);
        panelInput.add(btnAdd);
        panelInput.add(btnDelete);

        
        JScrollPane scrollPane = new JScrollPane(table);

       
        setLayout(new BorderLayout());
        add(panelInput, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

 
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String account = txtAccount.getText();
                String name = txtName.getText();
                

                if (account.isEmpty() || name.isEmpty() ) {
                    JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                } else {
                    
                    tableModel.addRow(new Object[]{account, name});
                    
                    txtAccount.setText("");
                    txtName.setText("");
                    txtBalance.setText("");
                }
            }
        });

      
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow == -1) {
                    JOptionPane.showMessageDialog(null, "Vui lòng chọn dòng cần xoá!", "Thông báo", JOptionPane.WARNING_MESSAGE);
                } else {
                   
                    int confirmation = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xoá dòng này?", "Xác nhận", JOptionPane.YES_NO_OPTION);
                    if (confirmation == JOptionPane.YES_OPTION) {
                        tableModel.removeRow(selectedRow);
                    }
                }
            }
        });
    }

    public static void main(String[] args) {
       
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new DemoJTable().setVisible(true);
            }
        });
    }
}