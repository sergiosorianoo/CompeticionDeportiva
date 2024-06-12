package com.politecnicomalaga.competicionDeportiva;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Equipo {
    private String codigo;
    private String descripcion;
    private String responsable;
    private String ciudad;
    private String email;
    private String telefono;
    private Map<String, Jugador> jugadores;

    public Equipo(String codigo, String descripcion, String responsable, String ciudad, String email, String telefono) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.responsable = responsable;
        this.ciudad = ciudad;
        this.email = email;
        this.telefono = telefono;
        this.jugadores = new HashMap<>();
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getResponsable() {
        return responsable;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefono() {
        return telefono;
    }

    public Map<String, Jugador> getJugadores() {
        return jugadores;
    }

    public boolean agregarJugador(Jugador jugador) {
        if (jugadores.containsKey(jugador.getDni())) {
            return false;
        }
        jugadores.put(jugador.getDni(), jugador);
        return true;
    }

    public boolean eliminarJugador(String dni) {
        return jugadores.remove(dni) != null;
    }

    public boolean cambiarDisponibilidad(String dniJugador, boolean disponible) {
        Jugador jugador = jugadores.get(dniJugador);
        if (jugador != null) {
            jugador.setDisponible(disponible);
            return true;
        }
        return false;
    }

    public List<Jugador> listarJugadores(boolean activos) {
        List<Jugador> resultado = new ArrayList<>();
        for (Jugador jugador : jugadores.values()) {
            if (jugador.isDisponible() == activos) {
                resultado.add(jugador);
            }
        }
        return resultado;
    }
}
