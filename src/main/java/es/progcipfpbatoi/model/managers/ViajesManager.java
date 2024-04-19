package es.progcipfpbatoi.model.managers;

import es.progcipfpbatoi.model.entities.Usuario;
import es.progcipfpbatoi.model.entities.types.Viaje;
import es.progcipfpbatoi.model.entities.types.ViajeCancelable;
import es.progcipfpbatoi.model.entities.types.ViajeExclusivo;
import es.progcipfpbatoi.model.entities.types.ViajeFlexible;
import java.util.ArrayList;
import java.util.List;

/**
 * Gestor de viajes. Manejará la lista de los viajes tanto para almancenar nueva
 * información sobre ella como para recuperar la totalidad o parte de la
 * información como también información relacionada con dicha lista.
 *
 * @author batoi
 */
public class ViajesManager {

    private List<Viaje> viajes;

    public ViajesManager() {
        this.viajes = new ArrayList<>();
        init();
    }

    /**
     * Añade un nuevo viaje al repositorio
     *
     * @param viaje El viaje a añadir
     */
    public void add(Viaje viaje) {
        this.viajes.add(viaje);
    }

    /**
     * Cancela un viaje
     *
     * @param viaje El viaje a cancelar
     */
    public boolean cancel(Viaje viaje) {
        if (viaje instanceof ViajeCancelable || viaje instanceof ViajeExclusivo || viaje instanceof ViajeFlexible) {
            this.viajes.remove(viaje);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Obtiene el número de viajes actualmente registrados
     *
     * @return El número de viajes registrados
     */
    public int getNumViajes() {
        return this.viajes.size();
    }

    /**
     * Obtiene todos los viajes
     *
     * @return La lista de todos los viajes
     */
    public List<Viaje> findAll() {
        return viajes;
    }

    public Viaje buscarPorCodigo(int codigo) {
        for (Viaje viaje : viajes) {
            if (viaje.getCodi() == codigo) {
                return viaje;
            }
        }
        return null;
    }

    public List<Viaje> buscarViajeCancelableUsuario(Usuario usuario) {
        List<Viaje> cancelables = new ArrayList<>();
        for (Viaje viaje : viajes) {
            if (viaje.getPropietario().equals(usuario) && viaje instanceof ViajeCancelable) {
                cancelables.add(viaje);
            }
        }
        return cancelables;
    }

    private void init() {

        // añade a la colección "viajes" todos los viajes que creas necesario tener de inicio en tu sistema
        // this.add(new Viaje(....));
    }

    public boolean esViajeReservable(int codigoViaje, Usuario usuario) {
        Viaje viaje = buscarPorCodigo(codigoViaje);
        return viaje != null && viaje.isReservable() && !viaje.getPropietario().equals(usuario);
    }

    public List<Viaje> buscarViajeReservableUsuario(Usuario usuario) {
        List<Viaje> reservables = new ArrayList<>();
        for (Viaje viaje : viajes) {
            if (viaje.isReservable() && !viaje.getPropietario().equals(usuario)) {
                reservables.add(viaje);
            }
        }
        return reservables;
    }

}
