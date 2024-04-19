package es.progcipfpbatoi.model.entities;

/**
 *
 * Clase que representa a un usuario de la aplicación
 */
public class Usuario {
    
    private String nombre;
    private String contrasena;

    public Usuario(String nombre, String contraseña) {
        this.nombre = nombre;
        this.contrasena = contraseña;
    }

    public Usuario() {
    }
    

    public String getNombre() {
        return nombre;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    
    
    
    
    
}
