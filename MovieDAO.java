/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tugas7_123220035;

import java.sql.SQLException;
import java.util.List;
/**
 *
 * @author apang
 */
public interface MovieDAO {
    void addMovie(Movie movie) throws Exception;
    void updateMovie(Movie movie) throws Exception;
    void deleteMovie(String judul) throws Exception;
    List<Movie> getAllMovies() throws Exception;
}
