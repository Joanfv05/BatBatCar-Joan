package es.progcipfpbatoi.controller;

import es.progcipfpbatoi.model.entities.Usuario;
import es.progcipfpbatoi.model.entities.types.Viaje;
import es.progcipfpbatoi.model.entities.types.ViajeCancelable;
import es.progcipfpbatoi.model.entities.types.ViajeExclusivo;
import es.progcipfpbatoi.model.entities.types.ViajeFlexible;
import es.progcipfpbatoi.model.managers.ViajesManager;
import es.progcipfpbatoi.views.GestorIO;
import es.progcipfpbatoi.views.ListadoViajesView;
import java.util.List;

public class ViajesController {

    private Usuario usuario;
    private ViajesManager viajesManager;

    public ViajesController() {
        this.viajesManager = new ViajesManager();

        /* Por defecto, no hay establecido ningún usuario. Se deberá establecer a posteriori
         Si no quieres realizar el caso de uso 1 hasta el final puedes establecer un usuario
         por defecto. Por ejemplo: this.usuario = new Usuario("roberto1979", "12345"); */
        this.usuario = null;
    }

    /**
     * Lista todos los viajes del sistema.
     */
    public void listarViajes() {
        List<Viaje> viajes = viajesManager.findAll();
        (new ListadoViajesView(viajes)).visualizar();
    }

    /**
     * Añade un viaje al sistema, preguntando previamente por toda la
     * información necesaria para crearlo.
     */
    public void anyadirViaje() {
        if (this.usuario == null) {
            System.out.println("Error: No se ha establecido un usuario.");
            return;
        }

        System.out.println("1- Viaje Estándar\n"
                + "2- Viaje Cancelable\n"
                + "3- Viaje Exclusivo\n"
                + "4- Viaje Flexible");
        int opcionSeleccionada = 0;
        do {
            opcionSeleccionada = GestorIO.getInt("Seleccione el tipo de viaje: ");

            String ruta = GestorIO.getString("Introduzca la ruta a realizar (Ej: Alcoy-Alicante): ");
            int duracion = GestorIO.getInt("Introduzca la duración del viaje en minutos: ");
            int precio = GestorIO.getInt("Introduzca el precio de cada plaza: ");
            int plazas = GestorIO.getInt("Introduzca el número de plazas disponibles: ");

            switch (opcionSeleccionada) {
                case 1:
                    Viaje viajeEstandar = new Viaje(viajesManager.getNumViajes() + 1, this.usuario, ruta, duracion, plazas, precio, null);
                    viajesManager.add(viajeEstandar);
                    System.out.println("Viaje de tipo Estándar del propietario " + this.usuario.getNombre() + " con código " + viajeEstandar.getCodi() + " y ruta " + ruta + " con " + plazas + " plazas ofertadas añadido con éxito.");
                    break;
                case 2:
                    ViajeCancelable viajeCancelable = new ViajeCancelable(viajesManager.getNumViajes() + 1, this.usuario, ruta, duracion, plazas, precio, null, false);
                    viajesManager.add(viajeCancelable);
                    System.out.println("Viaje de tipo Cancelable del propietario " + this.usuario.getNombre() + " con código " + viajeCancelable.getCodi() + " y ruta " + ruta + " con " + plazas + " plazas ofertadas añadido con éxito.");
                    break;
                case 3:
                    ViajeExclusivo viajeExclusivo = new ViajeExclusivo(viajesManager.getNumViajes() + 1, this.usuario, ruta, duracion, plazas, precio, null);
                    viajesManager.add(viajeExclusivo);
                    System.out.println("Viaje de tipo Exclusivo del propietario " + this.usuario.getNombre() + " con código " + viajeExclusivo.getCodi() + " y ruta " + ruta + " con " + plazas + " plazas ofertadas añadido con éxito.");
                    break;
                case 4:
                    ViajeFlexible viajeFlexible = new ViajeFlexible(viajesManager.getNumViajes() + 1, this.usuario, ruta, duracion, plazas, precio, null, false);
                    viajesManager.add(viajeFlexible);
                    System.out.println("Viaje de tipo Flexible del propietario " + this.usuario.getNombre() + " con código " + viajeFlexible.getCodi() + " y ruta " + ruta + " con " + plazas + " plazas ofertadas añadido con éxito.");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
                    break;
            }
        } while (opcionSeleccionada < 1 || opcionSeleccionada > 4);

    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void cancelarViaje() {
        if (usuario == null) {
            System.out.println("Error: No se ha establecido un usuario.");
            return;
        }

        List<Viaje> viajesCancelables = viajesManager.buscarViajeCancelableUsuario(usuario);

        if (viajesCancelables.isEmpty()) {
            System.out.println("No hay viajes cancelables para este usuario.");
            return;
        }

        int codigoViaje = GestorIO.getInt("Introduzca el código del viaje a cancelar");

        Viaje viajeCancelar = viajesManager.buscarPorCodigo(codigoViaje);

        if (viajeCancelar == null || !(viajeCancelar instanceof ViajeCancelable) && !(viajeCancelar instanceof ViajeExclusivo) && !(viajeCancelar instanceof ViajeFlexible)) {
            System.out.println("Error: Código de viaje inválido o no cancelable.");
            return;
        }

        viajesManager.cancel(viajeCancelar);
        System.out.println("El viaje se ha cancelado correctamente.");
    }

    public Usuario getUsuario() {
        return this.usuario;
    }

}
