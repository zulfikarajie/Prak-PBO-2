/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tugas7_123220035;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author apang
 */
public class MovieDAOImpl implements MovieDAO {
    private final String DBurl = "jdbc:mysql://localhost/movie_db";
    private final String DBUsername = "root";
    private final String DBPassword = "";
    private Connection connection;

    public MovieDAOImpl() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(DBurl, DBUsername, DBPassword);
            System.out.println("Koneksi Berhasil");
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
            System.out.println("Koneksi Gagal: " + ex.getMessage());
        }
    }

    @Override
    public void addMovie(Movie movie) throws SQLException {
        String query = "INSERT INTO movie (judul, alur, penokohan, akting, nilai) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, movie.getJudul());
            statement.setDouble(2, movie.getAlur());
            statement.setDouble(3, movie.getPenokohan());
            statement.setDouble(4, movie.getAkting());
            statement.setDouble(5, movie.getNilai());
            statement.executeUpdate();
        }
    }

    @Override
    public void updateMovie(Movie movie) throws SQLException {
        String query = "UPDATE movie SET alur = ?, penokohan = ?, akting = ?, nilai = ? WHERE judul = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setDouble(1, movie.getAlur());
            statement.setDouble(2, movie.getPenokohan());
            statement.setDouble(3, movie.getAkting());
            statement.setDouble(4, movie.getNilai());
            statement.setString(5, movie.getJudul());
            statement.executeUpdate();
        }
    }

    @Override
    public void deleteMovie(String judul) throws SQLException {
        String query = "DELETE FROM movie WHERE judul = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, judul);
            statement.executeUpdate();
        }
    }

    @Override
    public List<Movie> getAllMovies() throws SQLException {
        List<Movie> movies = new ArrayList<>();
        String query = "SELECT * FROM movie";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                String judul = resultSet.getString("judul");
                double alur = resultSet.getDouble("alur");
                double penokohan = resultSet.getDouble("penokohan");
                double akting = resultSet.getDouble("akting");
                double nilai = resultSet.getDouble("nilai");
                movies.add(new Movie(judul, alur, penokohan, akting, nilai));
            }
        }
        return movies;
    }
}