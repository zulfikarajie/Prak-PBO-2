/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tugas7_123220035;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author apang
 */
public class MovieController {
    private final MovieView view;
    private final MovieDAO dao;

    public MovieController(MovieView view, MovieDAO dao) {
        this.view = view;
        this.dao = dao;

        view.getAddButton().addActionListener(new AddActionListener());
        view.getUpdateButton().addActionListener(new UpdateActionListener());
        view.getDeleteButton().addActionListener(new DeleteActionListener());
        view.getExitButton().addActionListener(new ExitActionListener());
        view.getTable().getSelectionModel().addListSelectionListener(this::tableSelectionChanged);

        loadTableData();
    }

    private void loadTableData() {
        DefaultTableModel model = view.getModel();
        model.setRowCount(0);
        try {
            List<Movie> movies = dao.getAllMovies();
            for (Movie movie : movies) {
                model.addRow(new Object[]{movie.getJudul(), movie.getAlur(), movie.getPenokohan(), movie.getAkting(), movie.getNilai()});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void tableSelectionChanged(ListSelectionEvent e) {
        int selectedRow = view.getTable().getSelectedRow();
        if (selectedRow >= 0) {
            view.getNameField().setText(view.getModel().getValueAt(selectedRow, 0).toString());
            view.getStorylineField().setText(view.getModel().getValueAt(selectedRow, 1).toString());
            view.getContentField().setText(view.getModel().getValueAt(selectedRow, 2).toString());
            view.getCreativityField().setText(view.getModel().getValueAt(selectedRow, 3).toString());
        }
    }

    private class AddActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                String judul = view.getNameField().getText();
                double alur = Double.parseDouble(view.getStorylineField().getText());
                double penokohan = Double.parseDouble(view.getContentField().getText());
                double akting = Double.parseDouble(view.getCreativityField().getText());
                double nilai = (alur + penokohan + akting) / 3;

                Movie movie = new Movie(judul, alur, penokohan, akting, nilai);
                dao.addMovie(movie);
                JOptionPane.showMessageDialog(null, "Data Berhasil ditambahkan");
                clearTextFields();
                loadTableData();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    private class UpdateActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                String judul = view.getNameField().getText();
                double alur = Double.parseDouble(view.getStorylineField().getText());
                double penokohan = Double.parseDouble(view.getContentField().getText());
                double akting = Double.parseDouble(view.getCreativityField().getText());
                double nilai = (alur + penokohan + akting) / 3;

                Movie movie = new Movie(judul, alur, penokohan, akting, nilai);
                dao.updateMovie(movie);
                JOptionPane.showMessageDialog(null, "Data Berhasil diupdate");
                clearTextFields();
                loadTableData();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    private class DeleteActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                String judul = view.getNameField().getText();
                dao.deleteMovie(judul);
                JOptionPane.showMessageDialog(null, "Data Berhasil dihapus");
                clearTextFields();
                loadTableData();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    private class ExitActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            view.setVisible(false);
            // Logic to return to FirstMenu goes here
        }
    }

    private void clearTextFields() {
        view.getNameField().setText("");
        view.getStorylineField().setText("");
        view.getContentField().setText("");
        view.getCreativityField().setText("");
    }
}