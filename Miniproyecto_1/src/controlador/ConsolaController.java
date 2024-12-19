package controlador;

import modelo.rangos.Rango;
import modelo.soldados.*;

import javax.swing.DefaultListModel;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsolaController {
    private DefaultListModel<Rango> modeloSoldados;
    private Scanner scanner;

    public ConsolaController(DefaultListModel<Rango> modeloSoldados) {
        this.modeloSoldados = modeloSoldados; // Usa el modelo compartido
        this.scanner = new Scanner(System.in);
    }

    public void iniciarConsola() {
        Scanner scanner = new Scanner(System.in);
        int opcion = -1;
    
        while (opcion != 0) {
            mostrarMenu();
            try {
                opcion = Integer.parseInt(scanner.nextLine());
                if (opcion == 0) {
                    System.out.println("Saliendo del modo consola...");
                    break; // Sale del modo consola y regresa al menú principal
                }
                procesarOpcion(opcion, scanner);
            } catch (NumberFormatException e) {
                System.out.println("Por favor, ingrese un número válido.");
            }
        }
    }

    private void mostrarMenu() {
        System.out.println("\n--- Sistema Militar ---");
        System.out.println("1. Ver lista de soldados");
        System.out.println("2. Crear un nuevo soldado");
        System.out.println("3. Asignar misión");
        System.out.println("4. Realizar acción");
        System.out.println("5. Prepararse para la misión");
        System.out.println("6. Reportar estado");
        System.out.println("7. Resetear soldados");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private void procesarOpcion(int opcion, Scanner scanner) {
        switch (opcion) {
            case 1 -> verListaSoldados();
            case 2 -> crearSoldado(scanner);
            case 3 -> asignarMision(scanner);
            case 4 -> realizarAccion(scanner);
            case 5 -> prepararseParaMision(scanner);
            case 6 -> reportarEstado(scanner);
            case 7 -> resetearSoldados();
            case 0 -> System.out.println("Gracias por usar el sistema.");
            default -> System.out.println("Opción no válida. Intente de nuevo.");
        }
    }

    private void verListaSoldados() {
        System.out.println("\n--- Lista de Soldados ---");
        if (modeloSoldados.isEmpty()) {
            System.out.println("No hay soldados registrados.");
        } else {
            for (int i = 0; i < modeloSoldados.getSize(); i++) {
                System.out.println((i + 1) + ". " + modeloSoldados.getElementAt(i));
            }
        }
    }

    private void crearSoldado(Scanner scanner) {
        System.out.println("\n--- Crear Soldado ---");
        System.out.print("Ingrese el nombre del soldado: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el ID del soldado: ");
        String id = scanner.nextLine();

        System.out.println("Seleccione el tipo de soldado:");
        System.out.println("1. Soldado Raso");
        System.out.println("2. Teniente");
        System.out.println("3. Capitán");
        System.out.println("4. Coronel");
        int tipo = Integer.parseInt(scanner.nextLine());

        Rango nuevoSoldado = null;

        switch (tipo) {
            case 1 -> nuevoSoldado = new SoldadoRaso(nombre, id);
            case 2 -> {
                System.out.print("Ingrese la unidad: ");
                String unidad = scanner.nextLine();
                nuevoSoldado = new Teniente(nombre, id, unidad);
            }
            case 3 -> {
                System.out.print("Ingrese la cantidad de soldados bajo su mando: ");
                int cantidad = Integer.parseInt(scanner.nextLine());
                nuevoSoldado = new Capitan(nombre, id, cantidad);
            }
            case 4 -> {
                System.out.print("Ingrese la estrategia: ");
                String estrategia = scanner.nextLine();
                nuevoSoldado = new Coronel(nombre, id, estrategia);
            }
            default -> System.out.println("Tipo de soldado no válido.");
        }

        if (nuevoSoldado != null) {
            modeloSoldados.addElement(nuevoSoldado);
            System.out.println("Soldado creado exitosamente.");
        }
    }

    private void asignarMision(Scanner scanner) {
        Rango soldado = seleccionarSoldado(scanner);
        if (soldado != null) {
            System.out.print("Ingrese la misión a asignar: ");
            String mision = scanner.nextLine();
            System.out.println(soldado.asignarMision(mision));
        }
    }

    private void realizarAccion(Scanner scanner) {
        Rango soldado = seleccionarSoldado(scanner);
        if (soldado != null) {
            System.out.println(soldado.realizarAccion());
        }
    }

    private void prepararseParaMision(Scanner scanner) {
        Rango soldado = seleccionarSoldado(scanner);
        if (soldado != null) {
            soldado.prepararseParaMision();
            System.out.println(soldado.getNombre() + " se está preparando para la misión.");
        }
    }

    private void reportarEstado(Scanner scanner) {
        Rango soldado = seleccionarSoldado(scanner);
        if (soldado != null) {
            soldado.reportarEstado();
        }
    }

    private void resetearSoldados() {
        cargarSoldadosPorDefecto();
        System.out.println("Soldados reseteados a la configuración inicial.");
    }

    private void cargarSoldadosPorDefecto() {
        modeloSoldados.clear();
        modeloSoldados.addElement(new SoldadoRaso("Juan", "1"));
        modeloSoldados.addElement(new Teniente("Pedro", "2", "Alfa"));
        modeloSoldados.addElement(new Capitan("Luis", "3", 10));
        modeloSoldados.addElement(new Coronel("Carlos", "4", "Ofensiva"));
    }

    private Rango seleccionarSoldado(Scanner scanner) {
        verListaSoldados();
        System.out.print("Seleccione el número del soldado: ");
        int index = Integer.parseInt(scanner.nextLine()) - 1;

        if (index >= 0 && index < modeloSoldados.getSize()) {
            return modeloSoldados.get(index);
        } else {
            System.out.println("Selección no válida.");
            return null;
        }
    }
}
