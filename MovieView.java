/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tugas7_123220035;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
/**
 *
 * @author apang
 */
public class MovieView extends JFrame {
    private JTable table;
    private JButton exitButton, updateButton, addButton, deleteButton;
    private DefaultTableModel model;
    private JTextField nameField, storylineField, contentField, creativityField;

    public MovieView() {
        setTitle("Movie APP");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        // Initialize the table model
        String[] columnNames = {"Nama", "Alur", "Penokohan", "Akting", "Nilai"};
        model = new DefaultTableModel(columnNames, 0);
        table = new JTable(model);
        
        // Initialize text fields for input
        nameField = new JTextField(15);
        storylineField = new JTextField(15);
        contentField = new JTextField(15);
        creativityField = new JTextField(15);

        // Initialize the buttons
        exitButton = new JButton("Exit");
        updateButton = new JButton("Update");
        addButton = new JButton("Add");
        deleteButton = new JButton("Delete");

        // Input panel setup
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(0, 2, 10, 10));
        inputPanel.add(new JLabel("Judul:"));
        inputPanel.add(nameField);
        inputPanel.add(new JLabel("Alur Cerita:"));
        inputPanel.add(storylineField);
        inputPanel.add(new JLabel("Penokohan :"));
        inputPanel.add(contentField);
        inputPanel.add(new JLabel("Akting :"));
        inputPanel.add(creativityField);

        // Button panel setup
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        buttonPanel.add(addButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(exitButton);

        // Add components to the frame
        add(inputPanel, BorderLayout.NORTH);
        add(new JScrollPane(table), BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        // Display the frame
        setVisible(true);
    }

    // Getters for components
    public JTable getTable() {
        return table;
    }

    public DefaultTableModel getModel() {
        return model;
    }

    public JTextField getNameField() {
        return nameField;
    }

    public JTextField getStorylineField() {
        return storylineField;
    }

    public JTextField getContentField() {
        return contentField;
    }

    public JTextField getCreativityField() {
        return creativityField;
    }

    public JButton getExitButton() {
        return exitButton;
    }

    public JButton getUpdateButton() {
        return updateButton;
    }

    public JButton getAddButton() {
        return addButton;
    }

    public JButton getDeleteButton() {
        return deleteButton;
    }
}