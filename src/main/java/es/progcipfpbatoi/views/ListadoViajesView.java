package es.progcipfpbatoi.views;

/**
 * Vista dedicada a los listados de viajes. De cada viaje se muestra su código,
 * ruta, precio, propietario, tipo de viaje, plazas disponibles y si está
 * cancelado.
 */
import de.vandermeer.asciitable.AsciiTable;
import de.vandermeer.skb.interfaces.transformers.textformat.TextAlignment;
import es.progcipfpbatoi.model.entities.Usuario;
import es.progcipfpbatoi.model.entities.types.Viaje;
import es.progcipfpbatoi.model.entities.types.ViajeCancelable;
import es.progcipfpbatoi.model.entities.types.ViajeExclusivo;
import es.progcipfpbatoi.model.entities.types.ViajeFlexible;
import java.util.List;

public class ListadoViajesView {

    private final List<Viaje> viajes;

    private static final int ANCHO_TABLA = 100;

    public ListadoViajesView(List<Viaje> viajes) {
        this.viajes = viajes;
    }

    private AsciiTable buildASCIITable() {

        AsciiTable view = new AsciiTable();
        view.addRule();
        view.addRow("*", "*", "*", "*", "*", "*", "*", "*");
        view.addRule();
        view.addRow(null, null, null, null, null, null, null, "Listado Viajes");
        view.addRule();
        view.addRow("Cod. Viaje", null, "Ruta", "Precio", "Propietario", "Tipo", "Plazas Disponibles", "Cancelado");
        view.addRule();
        generarFilasViajes(view);
        view.setTextAlignment(TextAlignment.CENTER);
        return view;
    }

    @Override
    public String toString() {
        return buildASCIITable().render(ANCHO_TABLA);
    }

    public void visualizar() {
        System.out.println(buildASCIITable().render(ANCHO_TABLA));
    }

    private void generarFilasViajes(AsciiTable tabla) {
        tabla.addRow(1, null, "Barcelona-Alicante", 45, "roberto1979", "Estándar", 3, "No");
        tabla.addRule();
        tabla.addRow(2, null, "Alcoy-Elche", 10, "sergio123", "Estándar", 5, "Sí");
        tabla.addRule();

        for (Viaje viaje : viajes) {
            String tipoViaje;
            if (viaje instanceof ViajeCancelable) {
                tipoViaje = "Cancelable";
            } else if (viaje instanceof ViajeExclusivo) {
                tipoViaje = "Exclusivo";
            } else if (viaje instanceof ViajeFlexible) {
                tipoViaje = "Flexible";
            } else {
                tipoViaje = "Estándar";
            }

            tabla.addRow(
                    viaje.getCodi(),
                    null,
                    viaje.getRuta(),
                    viaje.getPreu(),
                    viaje.getPropietario().getNombre(),
                    viaje instanceof ViajeFlexible ? "Flexible" : tipoViaje,
                    viaje.getPlacesOfertades() - viaje.getPlacesReservades(),
                    viaje instanceof ViajeCancelable && ((ViajeCancelable) viaje).isCancelable() ? "Sí" : "No"
            );
            tabla.addRule();
        }
    }

}
