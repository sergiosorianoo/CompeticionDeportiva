package com.politecnicomalaga.competicionDeportiva;

import java.util.ArrayList;
import java.util.List;


public class Competicion {
    private String codigo;
    private String descripcion;
    private String provincia;
    private List<Equipo> equipos;

    public Competicion(String codigo, String descripcion, String provincia) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.provincia = provincia;
        this.equipos = new ArrayList<>();
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getProvincia() {
        return provincia;
    }

    public List<Equipo> getEquipos() {
        return equipos;
    }

    public boolean agregarEquipo(Equipo equipo) {
        for (Equipo e : equipos) {
            if (e.getCodigo().equals(equipo.getCodigo())) {
                return false;
            }
        }
        equipos.add(equipo);
        return true;
    }

    public boolean eliminarEquipo(String codigo) {
        for (Equipo e : equipos) {
            if (e.getCodigo().equals(codigo)) {
                if (e.getJugadores().isEmpty()) {
                    equipos.remove(e);
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }

    public List<Equipo> buscarEquiposPorCiudad(String ciudad) {
        List<Equipo> resultado = new ArrayList<>();
        for (Equipo e : equipos) {
            if (e.getCiudad().equalsIgnoreCase(ciudad)) {
                resultado.add(e);
            }
        }
        return resultado;
    }

    public List<Equipo> listarTodosLosEquipos() {
        return new ArrayList<>(equipos);
    }
}
