/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.progcipfpbatoi.controller;

import es.progcipfpbatoi.model.entities.Reserva;
import es.progcipfpbatoi.model.entities.Usuario;
import es.progcipfpbatoi.model.entities.types.Viaje;
import es.progcipfpbatoi.model.managers.ReservasManager;
import es.progcipfpbatoi.model.managers.ViajesManager;
import es.progcipfpbatoi.views.GestorIO;
import java.util.List;

/**
 *
 * @author joan
 */
public class ReservaController {

    private ReservasManager reservasManager;
    private ViajesManager viajesManager;
    private ViajesController viajesController;

    public ReservaController(ReservasManager reservasManager, ViajesManager viajesManager, ViajesController viajesController) {
        this.reservasManager = reservasManager;
        this.viajesManager = viajesManager;
        this.viajesController = viajesController;
    }

    public void realizarReserva(Usuario usuario) {
        if (usuario == null) {
            System.out.println("Error: No se ha establecido un usuario.");
            return;
        }

        List<Viaje> viajesReservables = viajesManager.buscarViajeReservableUsuario(usuario);
        if (viajesReservables.isEmpty()) {
            System.out.println("No hay viajes reservables disponibles para este usuario.");
            return;
        }

        System.out.println("Lista de viajes reservables:");
        for (Viaje viaje : viajesReservables) {
            System.out.println(viaje.getCodi());
        }

        int codigoViaje = GestorIO.getInt("Introduzca el código del viaje a seleccionar:");

        if (!viajesManager.esViajeReservable(codigoViaje, usuario)) {
            System.out.println("Error: Código de viaje inválido o no reservable.");
            return;
        }

        int numPlazas = GestorIO.getInt("Introduzca el número de plazas a reservar:");

        Reserva reserva = new Reserva(codigoViaje, usuario, numPlazas);
        reservasManager.anyadirReserva(reserva);

        System.out.println("Reserva realizada con éxito:");
        System.out.println("===================================");
        System.out.println("Código de reserva: " + reserva.getCodigo());
        System.out.println("Usuario: " + reserva.getUsuario().getNombre());
        System.out.println("Número de plazas reservadas: " + reserva. getNombrePlaces());
        System.out.println("===================================");
    }
}