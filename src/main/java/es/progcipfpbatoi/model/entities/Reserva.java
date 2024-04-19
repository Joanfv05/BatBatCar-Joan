/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.progcipfpbatoi.model.entities;

/**
 *
 * @author joan
 */
public class Reserva {

    private int codigo;
    private Usuario usuari;
    private int nombrePlaces;

    public Reserva(int codigo, Usuario usuari, int nombrePlaces) {
        this.codigo = codigo;
        this.usuari = usuari;
        this.nombrePlaces = nombrePlaces;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Usuario getUsuari() {
        return usuari;
    }

    public void setUsuari(Usuario usuari) {
        this.usuari = usuari;
    }

    public int getNombrePlaces() {
        return nombrePlaces;
    }

    public void setNombrePlaces(int nombrePlaces) {
        this.nombrePlaces = nombrePlaces;
    }

    public Usuario getUsuario() {
        return usuari;
    }

}
