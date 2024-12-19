import controlador.SoldadoController;
import vista.MainFrame;
import javax.swing.DefaultListModel;
import modelo.rangos.*;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Seleccione el modo de ejecución:");
        System.out.println("1. Consola");
        System.out.println("2. Interfaz gráfica");
        int opcion = scanner.nextInt();
        scanner.close();
        if (opcion == 1) {
            ejecutarModoConsola();
        } else if (opcion == 2) {
            ejecutarModoGrafico();
        } else {
            System.out.println("Opción no válida.");
        }
    }

    private static void ejecutarModoConsola() {
        // Implementar la lógica para el modo consola aquí
        System.out.println("Modo consola no implementado.");
    }

    private static void ejecutarModoGrafico() {
        java.awt.EventQueue.invokeLater(() -> {
            DefaultListModel<Rango> modeloSoldados = new DefaultListModel<>();
            MainFrame mainFrame = new MainFrame();
            mainFrame.setModeloSoldados(modeloSoldados); // Sincronizar modelo con vista
            new SoldadoController(mainFrame, modeloSoldados);
            mainFrame.setVisible(true);
        });
    }
    
    
}