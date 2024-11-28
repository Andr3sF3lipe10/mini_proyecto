import militar.rangos.Rango;
import militar.soldados.*;
import java.awt.*;
import javax.swing.*;

/**
 * Clase principal que representa la interfaz gráfica de la aplicación.
 */
public class MainFrame extends JFrame {

    // Componentes de la interfaz
    private JList<Rango> listSoldados;
    private DefaultListModel<Rango> modeloSoldados;
    private JLabel lblNombre, lblID, lblRango, lblInfoEspecifica;
    private JTextField txtMision;
    private JTextArea txtAreaAcciones;
    private JButton btnAsignarMision, btnRealizarAccion, btnCrearSoldado, btnReset;
    private JCheckBox chkPrepararse;
    private JRadioButton rbtnReporteEstado;

    private JMenuBar menuBar;
    private JMenu menuArchivo;
    private JMenuItem menuItemSalir;
    private JSplitPane splitPane;

    // Lista por defecto de soldados
    private java.util.List<Rango> listaSoldadosPorDefecto;

    public MainFrame() {
        inicializarComponentes();
        cargarSoldadosPorDefecto();
        configurarEventos();
        aplicarLookAndFeel();
    }

    /**
     * Inicializa los componentes de la interfaz gráfica.
     */
    private void inicializarComponentes() {
        setTitle("Sistema Militar");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);

        // Menú
        menuBar = new JMenuBar();
        menuArchivo = new JMenu("Archivo");
        menuItemSalir = new JMenuItem("Salir");
        menuArchivo.add(menuItemSalir);
        menuBar.add(menuArchivo);
        setJMenuBar(menuBar);

        // Panel izquierdo (lista de soldados)
        modeloSoldados = new DefaultListModel<>();
        listSoldados = new JList<>(modeloSoldados);
        JScrollPane scrollPaneList = new JScrollPane(listSoldados);

        // Panel derecho (detalles y acciones)
        JPanel panelDerecho = new JPanel();
        panelDerecho.setLayout(new BoxLayout(panelDerecho, BoxLayout.Y_AXIS));
        lblNombre = new JLabel("Nombre:");
        lblID = new JLabel("ID:");
        lblRango = new JLabel("Rango:");
        lblInfoEspecifica = new JLabel("Info Específica:");
        txtMision = new JTextField();
        txtAreaAcciones = new JTextArea(5, 20);
        txtAreaAcciones.setEditable(false);
        JScrollPane scrollPaneTextArea = new JScrollPane(txtAreaAcciones);
        btnAsignarMision = new JButton("Asignar Misión");
        btnRealizarAccion = new JButton("Realizar Acción");
        btnCrearSoldado = new JButton("Crear Nuevo Soldado");
        btnReset = new JButton("Resetear");
        chkPrepararse = new JCheckBox("Prepararse para la misión");
        rbtnReporteEstado = new JRadioButton("Reportar Estado");

        // Agregar componentes al panel derecho
        panelDerecho.add(lblNombre);
        panelDerecho.add(lblID);
        panelDerecho.add(lblRango);
        panelDerecho.add(lblInfoEspecifica);
        panelDerecho.add(new JLabel("Misión:"));
        panelDerecho.add(txtMision);
        panelDerecho.add(btnAsignarMision);
        panelDerecho.add(btnRealizarAccion);
        panelDerecho.add(chkPrepararse);
        panelDerecho.add(rbtnReporteEstado);
        panelDerecho.add(btnCrearSoldado);
        panelDerecho.add(btnReset);

        // SplitPane
        splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, scrollPaneList, panelDerecho);
        splitPane.setDividerLocation(200);

        // Agregar componentes al frame
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(splitPane, BorderLayout.CENTER);
        getContentPane().add(scrollPaneTextArea, BorderLayout.SOUTH);
    }

    /**
     * Carga la lista por defecto de soldados.
     */
    private void cargarSoldadosPorDefecto() {
        // Crear soldados por defecto
        listaSoldadosPorDefecto = new java.util.ArrayList<>();
        listaSoldadosPorDefecto.add(new SoldadoRaso("Juan", "1"));
        listaSoldadosPorDefecto.add(new Teniente("Pedro", "2", "Alfa"));
        listaSoldadosPorDefecto.add(new Capitan("Luis", "3", 10));
        listaSoldadosPorDefecto.add(new Coronel("Carlos", "4", "Ofensiva"));

        // Agregar soldados al modelo
        modeloSoldados.clear();
        for (Rango soldado : listaSoldadosPorDefecto) {
            modeloSoldados.addElement(soldado);
        }
    }

    /**
     * Configura los eventos de los componentes.
     */
    private void configurarEventos() {
        // Evento al seleccionar un soldado
        listSoldados.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                Rango soldadoSeleccionado = listSoldados.getSelectedValue();
                mostrarDetallesSoldado(soldadoSeleccionado);
            }
        });

        // Botón Asignar Misión
        btnAsignarMision.addActionListener(e -> asignarMision());

        // Botón Realizar Acción
        btnRealizarAccion.addActionListener(e -> realizarAccion());

        // Checkbox Prepararse para la misión
        chkPrepararse.addActionListener(e -> prepararseParaMision());

        // RadioButton Reportar Estado
        rbtnReporteEstado.addActionListener(e -> reportarEstado());

        // Botón Crear Nuevo Soldado
        btnCrearSoldado.addActionListener(e -> {
            CrearSoldadoDialog dialog = new CrearSoldadoDialog(this, true, modeloSoldados);
            dialog.setLocationRelativeTo(this);
            dialog.setVisible(true);
        });

        // Botón Resetear
        btnReset.addActionListener(e -> cargarSoldadosPorDefecto());

        // Menú Salir

        menuItemSalir.addActionListener(e -> System.exit(0));
    }

    /**
     * Muestra los detalles del soldado seleccionado.
     */
    private void mostrarDetallesSoldado(Rango soldado) {
        if (soldado != null) {
            lblNombre.setText("Nombre: " + soldado.getNombre());
            lblID.setText("ID: " + soldado.getId());
            lblRango.setText("Rango: " + soldado.getRango());

            // Limpiar información específica
            lblInfoEspecifica.setText("");

            // Mostrar información específica según el tipo de soldado
            if (soldado instanceof Capitan) {
                Capitan capitan = (Capitan) soldado;
                lblInfoEspecifica.setText("Soldados bajo mando: " + capitan.getCantidadSoldadosBajoSuMando());
            } else if (soldado instanceof Teniente) {
                Teniente teniente = (Teniente) soldado;
                lblInfoEspecifica.setText("Unidad: " + teniente.getUnidad());
            } else if (soldado instanceof Coronel) {
                Coronel coronel = (Coronel) soldado;
                lblInfoEspecifica.setText("Estrategia: " + coronel.getEstrategia());
            }
        }
    }

    /**
     * Asigna una misión al soldado seleccionado.
     */
    private void asignarMision() {
        Rango soldadoSeleccionado = listSoldados.getSelectedValue();
        if (soldadoSeleccionado != null) {
            String mision = txtMision.getText();
            if (!mision.isEmpty()) {
                String mensaje = soldadoSeleccionado.asignarMision(mision);
                txtAreaAcciones.append(mensaje + "\n");
                txtMision.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "Ingrese una misión.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un soldado.");
        }
    }

    /**
     * El soldado seleccionado realiza su acción.
     */
    private void realizarAccion() {
        Rango soldadoSeleccionado = listSoldados.getSelectedValue();
        if (soldadoSeleccionado != null) {
            String accion = soldadoSeleccionado.realizarAccion();
            txtAreaAcciones.append(accion + "\n");
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un soldado.");
        }
    }

    /**
     * El soldado se prepara para la misión.
     */
    private void prepararseParaMision() {
        if (chkPrepararse.isSelected()) {
            Rango soldadoSeleccionado = listSoldados.getSelectedValue();
            if (soldadoSeleccionado != null) {
                soldadoSeleccionado.prepararseParaMision();
                txtAreaAcciones.append(soldadoSeleccionado.getNombre() + " se está preparando para la misión.\n");
            } else {
                JOptionPane.showMessageDialog(this, "Seleccione un soldado.");
            }
        }
    }

    /**
     * El soldado reporta su estado.
     */
    private void reportarEstado() {
        if (rbtnReporteEstado.isSelected()) {
            Rango soldadoSeleccionado = listSoldados.getSelectedValue();
            if (soldadoSeleccionado != null) {
                soldadoSeleccionado.reportarEstado();
                txtAreaAcciones.append(soldadoSeleccionado.getNombre() + " ha reportado su estado.\n");
                rbtnReporteEstado.setSelected(false);
            } else {
                JOptionPane.showMessageDialog(this, "Seleccione un soldado.");
            }
        }
    }

    /**
     * Aplica el look and feel al interfaz.
     */
    private void aplicarLookAndFeel() {
        try {
            // Establecer el look and feel del sistema
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            SwingUtilities.updateComponentTreeUI(this);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Método principal para ejecutar la aplicación.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            new MainFrame().setVisible(true);
        });
    }
}
