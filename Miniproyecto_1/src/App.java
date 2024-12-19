import controlador.SoldadoController;
import vista.MainFrame;
import controlador.ConsolaController;
import modelo.rangos.*;
import javax.swing.DefaultListModel;
import java.util.Scanner;

public class App {
    private static final DefaultListModel<Rango> modeloSoldados = new DefaultListModel<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion = -1;

        while (opcion != 3) {
            System.out.println("\nSeleccione el modo de ejecución:");
            System.out.println("1. Consola");
            System.out.println("2. Interfaz gráfica");
            System.out.println("3. Salir");
            System.out.print("Ingrese su opción: ");
            
            try {
                opcion = Integer.parseInt(scanner.nextLine());
                switch (opcion) {
                    case 1 -> ejecutarModoConsola();
                    case 2 -> ejecutarModoGrafico();
                    case 3 -> System.out.println("Saliendo del programa. ¡Hasta luego!");
                    default -> System.out.println("Opción no válida. Intente de nuevo.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Por favor, ingrese un número válido.");
            }
        }
        
        scanner.close(); // Cerrar el scanner al finalizar
    }

    private static void ejecutarModoConsola() {
        ConsolaController consolaController = new ConsolaController(modeloSoldados);
        consolaController.iniciarConsola();
    }

    private static void ejecutarModoGrafico() {
        java.awt.EventQueue.invokeLater(() -> {
            MainFrame mainFrame = new MainFrame();
            mainFrame.setModeloSoldados(modeloSoldados); // Modelo compartido
            new SoldadoController(mainFrame, modeloSoldados); // Pasa el modelo
            mainFrame.setVisible(true);
        });
    }
    
}
