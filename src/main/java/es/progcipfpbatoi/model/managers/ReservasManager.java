/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.progcipfpbatoi.model.managers;

import es.progcipfpbatoi.model.entities.Reserva;
import es.progcipfpbatoi.model.entities.Usuario;
import es.progcipfpbatoi.model.entities.types.Viaje;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author joan
 */
public class ReservasManager {

    private List<Reserva> reservas;

    public ReservasManager() {
        this.reservas = new ArrayList<>();
    }

    public boolean hayReservas(Usuario usuario) {
        for (Reserva reserva : reservas) {
            if (reserva.getUsuari().equals(usuario)) {
                return true;
            }
        }
        return false;
    }

    public boolean esReservable(int codigoReserva, Usuario usuario) {
        Reserva reserva = buscarPorCodigo(codigoReserva);
        return reserva != null && reserva.getUsuario().equals(usuario);
    }

    public Reserva buscarPorCodigo(int codigo) {
        for (Reserva reserva : reservas) {
            if (reserva.getCodigo() == codigo) {
                return reserva;
            }
        }
        return null;
    }

    public void anyadirReserva(Reserva reserva) {
        reservas.add(reserva);
    }

}
