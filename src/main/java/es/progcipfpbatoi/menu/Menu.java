package es.progcipfpbatoi.menu;

import es.progcipfpbatoi.controller.ReservaController;
import es.progcipfpbatoi.controller.UsuarioController;
import es.progcipfpbatoi.controller.ViajesController;
import es.progcipfpbatoi.model.entities.Usuario;
import es.progcipfpbatoi.model.managers.ReservasManager;
import es.progcipfpbatoi.model.managers.UsuarioManager;
import es.progcipfpbatoi.model.managers.ViajesManager;
import es.progcipfpbatoi.views.GestorIO;

/**
 * Clase que gestiona el menú de opciones. A partir de esta clase se ejecutan
 * las diferentes opciones del menú (casos de uso).
 *
 * @author batoi
 */
public class Menu {

    private static final int OPCION_SALIR = 9;

    private ViajesController viajesController;
    private UsuarioController usuarioController;
    private ReservaController reservasController;

    public Menu() {
        this.viajesController = new ViajesController();
        this.usuarioController = new UsuarioController();
         this.reservasController = new ReservaController(new ReservasManager(), new ViajesManager(), viajesController); 
    }

    public void iniciar() {

        int opcionSeleccionada = 0;

        do {
            System.out.println();
            System.out.println("BatBatCar");
            System.out.println("=========");

            mostrarOpciones();
            opcionSeleccionada = solicitarOpcion();
            ejecutarOpcion(opcionSeleccionada);

        } while (opcionSeleccionada != OPCION_SALIR);

    }

    private void mostrarOpciones() {
        System.out.println("1. Establecer usuario (login)");
        System.out.println("2. Listar todos los viajes");
        System.out.println("3. Añadir viaje");
        System.out.println("4. Cancelar viaje");
        System.out.println("5. Realizar reserva");
        System.out.println("6. Modificar reserva");
        System.out.println("7. Cancelar reserva");
        System.out.println("8. Buscar viaje y relizar reserva");
        System.out.println("9. Salir");
    }

    private int solicitarOpcion() {
        // Implementar método para solicitar la opción al usuario
        return GestorIO.getInt("Seleccione una opción [1-9]", 1, 9);
    }

    private void ejecutarOpcion(int opcionSeleccionada) {
        switch (opcionSeleccionada) {
            case 1:
                viajesController.setUsuario(usuarioController.login());
                break;
            case 2:
                viajesController.listarViajes();
                break;
            case 3:
                viajesController.anyadirViaje();
                break;
            case 4:
                viajesController.cancelarViaje();
                break;
            case 5:
                reservasController.realizarReserva(viajesController.getUsuario());
                break;
            case 6:
                // Lógica para modificar reserva
                break;
            case 7:
                // Lógica para cancelar reserva
                break;
            case 8:
                // Lógica para buscar viaje y realizar reserva
                break;
            case OPCION_SALIR:
                System.out.println("Saliendo del programa...");
                System.exit(0);
                break;
            default:
                System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
                break;
        }
    }

}
