/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.progcipfpbatoi.model.managers;

import es.progcipfpbatoi.model.entities.Usuario;
import es.progcipfpbatoi.views.GestorIO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author joan
 */
public class UsuarioManager {
    private List<Usuario> usuarios;

    public UsuarioManager() {
        this.usuarios = new ArrayList<>();
        init();
    }

    public boolean comprobacionUsuarios(Usuario usuario) {
        for (Usuario u : usuarios) {
            if (u.getNombre().equals(usuario.getNombre())) {
                return true;
            }
        }
        return false;
    }

    public boolean comprobacionContraseña(Usuario usuario) {
        for (Usuario u : usuarios) {
            if (u.getContrasena().equals(usuario.getContrasena())) {
                return true;
            }
        }
        return false;
    }

    public void add(Usuario usuario) {
        this.usuarios.add(usuario);
    }

    public void remove(Usuario usuario) {
        this.usuarios.remove(usuario);
    }

    private void init() {
        this.add(new Usuario("Joan", "1234"));
    }

}
