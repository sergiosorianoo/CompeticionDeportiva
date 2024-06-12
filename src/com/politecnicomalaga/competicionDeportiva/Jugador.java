package com.politecnicomalaga.competicionDeportiva;

public class Jugador {
    private String nombre;
    private String apellidos;
    private int dorsal;
    private String dni;
    private String email;
    private String telefono;
    private boolean disponible;

    public Jugador(String nombre, String apellidos, int dorsal, String dni, String email, String telefono) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dorsal = dorsal;
        this.dni = dni;
        this.email = email;
        this.telefono = telefono;
        this.disponible = true;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public int getDorsal() {
        return dorsal;
    }

    public String getDni() {
        return dni;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefono() {
        return telefono;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
}

