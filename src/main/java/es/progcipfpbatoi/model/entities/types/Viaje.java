package es.progcipfpbatoi.model.entities.types;

import es.progcipfpbatoi.model.entities.Reserva;
import es.progcipfpbatoi.model.entities.Usuario;
import java.util.List;

/*
 * Clase que representa a un viaje estándar
 */
public class Viaje {

    private int codi;
    private Usuario propietario;
    private String ruta;
    private int durada;
    private int placesOfertades;
    private int placesReservades;
    private int preu;
    private boolean tancat;
    private List<Reserva> reserves;

    public Viaje(int codi, Usuario propietario, String ruta, int durada, int placesOfertades, int preu, List<Reserva> reserves) {
        this.codi = codi;
        this.propietario = propietario;
        this.ruta = ruta;
        this.durada = durada;
        this.placesOfertades = placesOfertades;
        this.placesReservades = 0;
        this.preu = preu;
        this.tancat = true;
        this.reserves = reserves;
    }

    public int getCodi() {
        return codi;
    }

    public void setCodi(int codi) {
        this.codi = codi;
    }

    public Usuario getPropietario() {
        return propietario;
    }

    public void setPropietario(Usuario propietario) {
        this.propietario = propietario;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public int getDurada() {
        return durada;
    }

    public void setDurada(int durada) {
        this.durada = durada;
    }

    public int getPlacesOfertades() {
        return placesOfertades;
    }

    public void setPlacesOfertades(int placesOfertades) {
        this.placesOfertades = placesOfertades;
    }

    public int getPlacesReservades() {
        return placesReservades;
    }

    public void setPlacesReservades(int placesReservades) {
        this.placesReservades = placesReservades;
    }

    public int getPreu() {
        return preu;
    }

    public void setPreu(int preu) {
        this.preu = preu;
    }

    public boolean isTancat() {
        return tancat;
    }

    public void setTancat(boolean tancat) {
        this.tancat = tancat;
    }

    public List<Reserva> getReserves() {
        return reserves;
    }

    public void setReserves(List<Reserva> reserves) {
        this.reserves = reserves;
    }

    public boolean isReservable() {
        return !isTancat() && (placesOfertades - placesReservades) > 0;
    }

}
