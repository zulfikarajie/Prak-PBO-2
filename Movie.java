/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tugas7_123220035;

/**
 *
 * @author apang
 */
public class Movie {
    private String judul;
    private double alur;
    private double penokohan;
    private double akting;
    private double nilai;

    // Constructor
    public Movie(String judul, double alur, double penokohan, double akting, double nilai) {
        this.judul = judul;
        this.alur = alur;
        this.penokohan = penokohan;
        this.akting = akting;
        this.nilai = nilai;
    }

    // Getters and setters
    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public double getAlur() {
        return alur;
    }

    public void setAlur(double alur) {
        this.alur = alur;
    }

    public double getPenokohan() {
        return penokohan;
    }

    public void setPenokohan(double penokohan) {
        this.penokohan = penokohan;
    }

    public double getAkting() {
        return akting;
    }

    public void setAkting(double akting) {
        this.akting = akting;
    }

    public double getNilai() {
        return nilai;
    }

    public void setNilai(double nilai) {
        this.nilai = nilai;
    }
}