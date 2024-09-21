/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.baitap;

/**
 *
 * @author HUYNH ANH
 */
import java.awt.Component;
import java.awt.PopupMenu;
import java.awt.desktop.OpenFilesEvent;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.spi.CurrencyNameProvider;
import javax.swing.filechooser.FileSystemView;


public class JNotepad extends JFrame {

    private JTextArea textArea;
    File fnamecontair;

    public JNotepad() {
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenu editMenu = new JMenu("Edit");
        JMenu formatMenu = new JMenu("Format");
        JMenu viewMenu = new JMenu("View");
        JMenu helpMenu = new JMenu("Help");

        JMenuItem newMenuItem = new JMenuItem("New");
        JMenuItem openMenuItem = new JMenuItem("Open");
        JMenuItem saveMenuItem = new JMenuItem("Save");
        JMenuItem saveasMenuItem = new JMenuItem("SaveAs");

        openMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Xử lý sự kiện khi nhấn Open

                JFileChooser jfc = new JFileChooser();
                int returnvalue = jfc.showOpenDialog(null);
                if (returnvalue == JFileChooser.APPROVE_OPTION) {
                    File fyl = jfc.getSelectedFile();
                    System.out.println(fyl.getAbsolutePath());        


//int rVal = e.showOpenDialog(null);
//               if (rVal == JFileChooser.APPROVE_OPTION) {
//     String filename = e.getSelectedFile().getName();
//     String dir = e.getCurrentDirectory().toString();
//            if (ret == JFileChooser.APPROVE_OPTION) {
//            File selectedFile = jfc.getSelectedFile();
//            System.out.println(selectedFile.getAbsolutePath());

                }
            }

            private void OpenFile(String absolutePath) {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }

            private void setTitle(String string) {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        });

        saveMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Xử lý sự kiện khi nhấn Save          
                JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
                jfc.setDialogTitle("Chọn thư mục: ");
                jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                int returnValue = jfc.showSaveDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    if (jfc.getSelectedFile().isDirectory()) {
                        System.out.println("Bạn đã chọn: " + jfc.getSelectedFile());
                    }
                }
            }

        });

        newMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Xử lý sự kiện khi nhấn New JFileChooser jfc = new JFileChooser();                        
                textArea.setText("");
                fnamecontair = null;
            }
        });
      
        fileMenu.add(newMenuItem);
        fileMenu.add(openMenuItem);
        fileMenu.add(saveMenuItem);
        fileMenu.add(saveasMenuItem);
        var JMenu = menuBar.add(fileMenu);
        /*add*/
        menuBar.add(editMenu);
        menuBar.add(formatMenu);
        menuBar.add(viewMenu);
        menuBar.add(helpMenu);

        textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);

        this.setJMenuBar(menuBar);
        this.add(scrollPane);
        this.setSize(800, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JNotepad notepad = new JNotepad();
        });
    }
}
