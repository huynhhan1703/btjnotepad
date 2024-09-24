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
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.spi.CurrencyNameProvider;
import javax.swing.filechooser.FileSystemView;

public class JNotepad extends JFrame {

    private JTextArea textArea;
    public JFontDialog dialog;
    private JToolBar toolBar;
    private JCheckBoxMenuItem itemWarp, itemStatusBar;
    private JButton btNew, btOpen, btSave;
    private JMenuItem itemfont;

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
        JMenuItem pagesetupMenuItem = new JMenuItem("Page Setup...");
        JMenuItem printMenuItem = new JMenuItem("Print...");
        JMenuItem exitMenuItem = new JMenuItem("Exit");

        JMenuItem editMenuItem = new JMenuItem("Edit");
        JMenuItem copyMenuItem = new JMenuItem("Copy");
        JMenuItem pasteMenuItem = new JMenuItem("Paste");
        itemfont = new JMenuItem("Font");

        newMenuItem.setAccelerator(KeyStroke.getKeyStroke('N', java.awt.event.InputEvent.CTRL_DOWN_MASK));

        openMenuItem.setAccelerator(KeyStroke.getKeyStroke('O', java.awt.event.InputEvent.CTRL_DOWN_MASK));

        saveMenuItem.setAccelerator(KeyStroke.getKeyStroke('S', java.awt.event.InputEvent.CTRL_DOWN_MASK));

//                
//        openMenuItem.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                // Xử lý sự kiện khi nhấn Open
//
//                JFileChooser jfc = new JFileChooser();
//                int ret = jfc.showOpenDialog(null);
//                if (ret == JFileChooser.APPROVE_OPTION) {
//                    File fyl = jfc.getSelectedFile();
//                    OpenFile(fyl.getAbsolutePath());
//                    fnamecontair = fyl;
////            if (ret == JFileChooser.APPROVE_OPTION) {
////            File selectedFile = jfc.getSelectedFile();
////            System.out.println(selectedFile.getAbsolutePath());
//
//                }
//            }
//
//            private void OpenFile(String absolutePath) {
//                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//            }
//
//            private void setTitle(String string) {
//                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//            }
//        });
        saveMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

//                JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
//                jfc.setDialogTitle("Chọn thư mục: ");
//                jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
//                int returnValue = jfc.showSaveDialog(null);
//                if (returnValue == JFileChooser.APPROVE_OPTION) {
//                    if (jfc.getSelectedFile().isDirectory()) {
//                        System.out.println("Bạn đã chọn: " + jfc.getSelectedFile());
//                    }
//                }
//            }
                JFileChooser fc = new JFileChooser();
                // Invoke the showsSaveDialog function to show the save dialog
                int r = fc.showSaveDialog(null);
                if (r == JFileChooser.APPROVE_OPTION) {
                    File fi = new File(fc.getSelectedFile().getAbsolutePath());
                    try {
                        // Create a file writer
                        FileWriter wr = new FileWriter(fi, false);
                        // Create buffered writer to write
                        BufferedWriter w = new BufferedWriter(wr);
                        // Write
                        w.write(textArea.getText());
                        w.flush();
                        w.close();
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(fc, ex.getMessage());
                    }
                }

            }

        });

        newMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Xử lý sự kiện khi nhấn New JFileChooser jfc = new JFileChooser();                        
                textArea.setText("");

            }

        });
        openMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Xử lý sự kiện khi nhấn OpenJFileChooser fileChooser = new JFileChooser();
                JFileChooser fc = new JFileChooser("D:");
                int r = fc.showOpenDialog(null);
                if (r == JFileChooser.APPROVE_OPTION) {
                    File fi = new File(fc.getSelectedFile().getAbsolutePath());
                    try {
                        // String
                        String s1 = "", sl = "";
                        // File reader
                        FileReader fr = new FileReader(fi);
                        // Buffered reader
                        BufferedReader br = new BufferedReader(fr);

                        // Initialize sl
                        sl = br.readLine();

                        // Take the input from the file
                        while ((s1 = br.readLine()) != null) {
                            sl = sl + "\n" + s1;
                        }

                        // Set the text
                        textArea.setText(sl);
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(fc, ex.getMessage());
                    }

                } // If the user cancelled the operation
                else {
                    JOptionPane.showMessageDialog(fc, "the user cancelled the operation");
                }

            }
        });

        fileMenu.add(newMenuItem);
        fileMenu.add(openMenuItem);
        fileMenu.add(saveMenuItem);
        fileMenu.add(saveasMenuItem);
        fileMenu.addSeparator();
        fileMenu.add(pagesetupMenuItem);
        fileMenu.add(printMenuItem);
        fileMenu.addSeparator();
        fileMenu.add(exitMenuItem);

        var JMenu = menuBar.add(fileMenu);

        editMenu.add(editMenuItem);
        editMenu.add(copyMenuItem);
        editMenu.add(pasteMenuItem);
        JMenu = menuBar.add(editMenu);
        formatMenu.add(itemfont);
        JMenu = menuBar.add(formatMenu);
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

        itemfont.addActionListener((e)
                -> {
            dialog = new JFontDialog(this, true);
            dialog.setVisible(true);
        });

        itemWarp.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (itemWarp.isSelected()) {
                    textArea.setLineWrap(true);
                } else {
                    textArea.setLineWrap(false);
                }
            }
        }
        );

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JNotepad notepad = new JNotepad();
        });
    }
}
