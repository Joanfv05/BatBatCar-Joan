/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.progcipfpbatoi.model.entities.types;

import es.progcipfpbatoi.model.entities.Reserva;
import es.progcipfpbatoi.model.entities.Usuario;
import java.util.List;

/**
 *
 * @author joan
 */
public class ViajeExclusivo extends Viaje {

    public ViajeExclusivo(int codi, Usuario propietario, String ruta, int durada, int placesOfertades, int preu, List<Reserva> reserves) {
        super(codi, propietario, ruta, durada, placesOfertades, preu, reserves);
    }

   

}
