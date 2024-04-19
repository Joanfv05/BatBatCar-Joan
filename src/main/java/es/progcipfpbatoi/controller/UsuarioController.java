/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.progcipfpbatoi.controller;

import es.progcipfpbatoi.menu.Menu;
import es.progcipfpbatoi.model.entities.Usuario;
import es.progcipfpbatoi.model.managers.UsuarioManager;
import es.progcipfpbatoi.views.GestorIO;

/**
 *
 * @author joan
 */
public class UsuarioController {

    UsuarioManager usuarioManager = new UsuarioManager();

    public Usuario login() {
        
        int contador = 0;
        do {
            Usuario usuario = new Usuario(GestorIO.getString("Username"), GestorIO.getString("Password"));
            boolean usuarioExiste = usuarioManager.comprobacionUsuarios(usuario);
            boolean contraseñaCorrecta = usuarioManager.comprobacionContraseña(usuario);

            if (usuarioExiste && contraseñaCorrecta) {
                System.out.println("Bienvenido " + usuario.getNombre());
                return usuario;
            } else if (usuarioExiste && !contraseñaCorrecta) {
                contador++;
                System.out.println("Error, la contraseña introducida es errónea");
            } else if (!usuarioExiste && contraseñaCorrecta) {
                contador++;
                System.out.println("Error, el usuario introducido no existe");
            } else {
                contador++;
                System.out.println("Usuario o contraseña incorrectos.");
            }
        } while (contador < 3);

        if (contador == 3) {
            System.out.println("Se ha alcanzado el número máximo de intentos. Adiós");
            System.exit(0);
        }
        return null;
    }
}
