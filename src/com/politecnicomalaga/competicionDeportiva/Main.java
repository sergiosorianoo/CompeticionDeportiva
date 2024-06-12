package com.politecnicomalaga.competicionDeportiva;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static Competicion competicion;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            mostrarMenu();
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    proporcionarDatosCompeticion(scanner);
                    break;
                case 2:
                    agregarEquipo(scanner);
                    break;
                case 3:
                    eliminarEquipo(scanner);
                    break;
                case 4:
                    buscarEquiposPorCiudad(scanner);
                    break;
                case 5:
                    listarTodosLosEquipos();
                    break;
                case 6:
                    agregarJugador(scanner);
                    break;
                case 7:
                    eliminarJugador(scanner);
                    break;
                case 8:
                    cambiarDisponibilidadJugador(scanner);
                    break;
                case 9:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        }

        scanner.close();
    }

    private static void mostrarMenu() {
        System.out.println(" ");
        System.out.println("--- MENÚ ---");
        System.out.println("1. Proporcionar datos de la competición");
        System.out.println("2. Añadir un nuevo equipo");
        System.out.println("3. Eliminar un equipo existente");
        System.out.println("4. Buscar equipos de una localidad");
        System.out.println("5. Listar todos los equipos");
        System.out.println("6. Dar de alta un nuevo jugador en un equipo");
        System.out.println("7. Eliminar un jugador en un equipo");
        System.out.println("8. Cambiar estado/disponibilidad de un jugador de un equipo");
        System.out.println("9. Salir");
        System.out.print("Seleccione una opción: ");
        System.out.println(" ");
    }

    private static void proporcionarDatosCompeticion(Scanner scanner) {
        System.out.print("Ingrese el código de la competición: ");
        String codigo = scanner.nextLine();
        System.out.print("Ingrese la descripción de la competición: ");
        String descripcion = scanner.nextLine();
        System.out.print("Ingrese la provincia de realización: ");
        String provincia = scanner.nextLine();
        competicion = new Competicion(codigo, descripcion, provincia);
        System.out.println("Datos de la competición proporcionados correctamente.");
    }

    private static void agregarEquipo(Scanner scanner) {
        if (competicion == null) {
            System.out.println("Debe proporcionar primero los datos de la competición.");
            return;
        }

        System.out.print("Ingrese el código del equipo: ");
        String codigo = scanner.nextLine();
        System.out.print("Ingrese la descripción del equipo: ");
        String descripcion = scanner.nextLine();
        System.out.print("Ingrese el nombre y apellidos del responsable: ");
        String responsable = scanner.nextLine();
        System.out.print("Ingrese la ciudad de origen: ");
        String ciudad = scanner.nextLine();
        System.out.print("Ingrese el email de contacto: ");
        String email = scanner.nextLine();
        System.out.print("Ingrese el teléfono de contacto: ");
        String telefono = scanner.nextLine();

        Equipo equipo = new Equipo(codigo, descripcion, responsable, ciudad, email, telefono);
        if (competicion.agregarEquipo(equipo)) {
            System.out.println("Equipo agregado correctamente.");
        } else {
            System.out.println("El equipo ya existe en la competición.");
        }
    }

    private static void eliminarEquipo(Scanner scanner) {
        if (competicion == null) {
            System.out.println("Debe proporcionar primero los datos de la competición.");
            return;
        }

        System.out.print("Ingrese el código del equipo a eliminar: ");
        String codigo = scanner.nextLine();

        if (competicion.eliminarEquipo(codigo)) {
            System.out.println("Equipo eliminado correctamente.");
        } else {
            System.out.println("No se puede eliminar el equipo. Puede que no exista o tenga jugadores.");
        }
    }

    private static void buscarEquiposPorCiudad(Scanner scanner) {
        if (competicion == null) {
            System.out.println("Debe proporcionar primero los datos de la competición.");
            return;
        }

        System.out.print("Ingrese la ciudad de origen: ");
        String ciudad = scanner.nextLine();

        List<Equipo> equipos = competicion.buscarEquiposPorCiudad(ciudad);
        if (equipos.isEmpty()) {
            System.out.println("No se encontraron equipos en la ciudad especificada.");
        } else {
            System.out.println("Equipos encontrados:");
            for (Equipo equipo : equipos) {
                System.out.println(equipo.getDescripcion());
            }
        }
    }

    private static void listarTodosLosEquipos() {
        if (competicion == null) {
            System.out.println("Debe proporcionar primero los datos de la competición.");
            return;
        }

        List<Equipo> equipos = competicion.listarTodosLosEquipos();
        if (equipos.isEmpty()) {
            System.out.println("No hay equipos registrados.");
        } else {
            System.out.println("Listado de todos los equipos:");
            for (Equipo equipo : equipos) {
                System.out.println(equipo.getDescripcion());
            }
        }
    }

    private static void agregarJugador(Scanner scanner) {
        if (competicion == null) {
            System.out.println("Debe proporcionar primero los datos de la competición.");
            return;
        }

        System.out.print("Ingrese el código del equipo: ");
        String codigoEquipo = scanner.nextLine();
        Equipo equipo = buscarEquipoPorCodigo(codigoEquipo);

        if (equipo == null) {
            System.out.println("Equipo no encontrado.");
            return;
        }

        System.out.print("Ingrese el nombre del jugador: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese los apellidos del jugador: ");
        String apellidos = scanner.nextLine();
        System.out.print("Ingrese el dorsal del jugador: ");
        int dorsal = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Ingrese el DNI del jugador: ");
        String dni = scanner.nextLine();
        System.out.print("Ingrese el email del jugador: ");
        String email = scanner.nextLine();
        System.out.print("Ingrese el teléfono del jugador: ");
        String telefono = scanner.nextLine();

        Jugador jugador = new Jugador(nombre, apellidos, dorsal, dni, email, telefono);
        if (equipo.agregarJugador(jugador)) {
            System.out.println("Jugador agregado correctamente.");
        } else {
            System.out.println("El jugador ya existe en el equipo.");
        }
    }

    private static void eliminarJugador(Scanner scanner) {
        if (competicion == null) {
            System.out.println("Debe proporcionar primero los datos de la competición.");
            return;
        }

        System.out.print("Ingrese el código del equipo: ");
        String codigoEquipo = scanner.nextLine();
        Equipo equipo = buscarEquipoPorCodigo(codigoEquipo);

        if (equipo == null) {
            System.out.println("Equipo no encontrado.");
            return;
        }

        System.out.print("Ingrese el DNI del jugador a eliminar: ");
        String dni = scanner.nextLine();

        if (equipo.eliminarJugador(dni)) {
            System.out.println("Jugador eliminado correctamente.");
        } else {
            System.out.println("Jugador no encontrado.");
        }
    }

    private static void cambiarDisponibilidadJugador(Scanner scanner) {
        if (competicion == null) {
            System.out.println("Debe proporcionar primero los datos de la competición.");
            return;
        }

        System.out.print("Ingrese el código del equipo: ");
        String codigoEquipo = scanner.nextLine();
        Equipo equipo = buscarEquipoPorCodigo(codigoEquipo);

        if (equipo == null) {
            System.out.println("Equipo no encontrado.");
            return;
        }

        System.out.print("Ingrese el DNI del jugador: ");
        String dni = scanner.nextLine();
        System.out.print("Ingrese la nueva disponibilidad (true para disponible, false para no disponible): ");
        boolean disponible = scanner.nextBoolean();

        if (equipo.cambiarDisponibilidad(dni, disponible)) {
            System.out.println("Disponibilidad del jugador cambiada correctamente.");
        } else {
            System.out.println("Jugador no encontrado.");
        }
    }

    private static Equipo buscarEquipoPorCodigo(String codigo) {
        for (Equipo equipo : competicion.getEquipos()) {
            if (equipo.getCodigo().equals(codigo)) {
                return equipo;
            }
        }
        return null;
    }
}

