
public class App {
    public static void main(String[] args) {
        // Ejecutar la interfaz gráfica
        java.awt.EventQueue.invokeLater(() -> {
            new MainFrame().setVisible(true);
        });
    }
}