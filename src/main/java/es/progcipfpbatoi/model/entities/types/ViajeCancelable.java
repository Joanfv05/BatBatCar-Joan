package es.progcipfpbatoi.model.entities.types;

import es.progcipfpbatoi.model.entities.Reserva;
import es.progcipfpbatoi.model.entities.Usuario;
import java.util.List;

public class ViajeCancelable extends Viaje {

    private boolean cancelable;

    public ViajeCancelable(int codi, Usuario propietario, String ruta, int durada, int placesOfertades, int preu, List<Reserva> reserves, boolean cancelable) {
        super(codi, propietario, ruta, durada, placesOfertades, preu, reserves);
        this.cancelable = false;
    }

    public boolean isCancelable() {
        return cancelable;
    }

    public void setCancelable(boolean cancelable) {
        this.cancelable = cancelable;
    }
    
    
}
