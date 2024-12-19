package vista;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import modelo.rangos.Rango;
import modelo.soldados.*;

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
    private JSplitPane splitPane;
    private JMenuBar menuBar;
    private JMenu menuArchivo;
    private JMenuItem menuItemSalir;
    private JPopupMenu popupMenu;
    private JMenuItem menuItemVerDetalles, menuItemEliminar;

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
        // Cambiar el Look and Feel
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }

        setTitle("Sistema Militar");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        // Menú
        menuBar = new JMenuBar();
        menuArchivo = new JMenu("Archivo");
        menuItemSalir = new JMenuItem("Salir");
        menuArchivo.add(menuItemSalir);
        menuBar.add(menuArchivo);
        setJMenuBar(menuBar);

        // Modelo y lista de soldados
        modeloSoldados = new DefaultListModel<>();
        listSoldados = new JList<>(modeloSoldados);
        listSoldados.setBackground(new Color(240, 240, 240));
        listSoldados.setForeground(new Color(40, 54, 24));
        listSoldados.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listSoldados.setBorder(new EmptyBorder(5, 5, 5, 5));

        JScrollPane scrollPaneList = new JScrollPane(listSoldados);
        scrollPaneList.getViewport().setBackground(new Color(96, 108, 56)); // Fondo visible
        scrollPaneList.setBorder(new TitledBorder(new EmptyBorder(5, 5, 5, 5), "Soldados", TitledBorder.CENTER,
                TitledBorder.TOP, new Font("Arial", Font.BOLD, 12), new Color(254, 250, 224)));
        scrollPaneList.setPreferredSize(new Dimension(250, 0));

        scrollPaneList.setBackground(new Color(96, 108, 56));

        // Panel derecho con diseño GridBagLayout
        JPanel panelDerecho = new JPanel(new GridBagLayout());
        panelDerecho.setBorder(new EmptyBorder(10, 10, 10, 10));
        panelDerecho.setBackground(new Color(254, 250, 224));
        panelDerecho.setPreferredSize(new Dimension(300, 0));
        panelDerecho.setMaximumSize(new Dimension(300, Integer.MAX_VALUE));
        panelDerecho.setMinimumSize(new Dimension(300, 0));
        panelDerecho.setBorder(new TitledBorder(new EmptyBorder(10, 10, 10, 10), "Detalles del Soldado",
                TitledBorder.CENTER, TitledBorder.TOP, new Font("Arial", Font.BOLD, 12), new Color(0, 0, 0)));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Espaciado entre componentes
        gbc.anchor = GridBagConstraints.WEST; // Alineación a la izquierda
        gbc.fill = GridBagConstraints.HORIZONTAL; // Expansión horizontal
        gbc.weightx = 1.0; // Peso de expansión

        // Crear y agregar componentes
        lblNombre = new JLabel("Nombre: ");
        lblNombre.setFont(new Font("Arial", Font.BOLD, 12));
        lblID = new JLabel("ID: ");
        lblID.setFont(new Font("Arial", Font.BOLD, 12));
        lblRango = new JLabel("Rango: ");
        lblRango.setFont(new Font("Arial", Font.BOLD, 12));
        lblInfoEspecifica = new JLabel("Info Específica: ");
        lblInfoEspecifica.setFont(new Font("Arial", Font.BOLD, 12));
        txtMision = new JTextField(20);
        txtAreaAcciones = new JTextArea(5, 20);
        txtAreaAcciones.setLineWrap(true);
        txtAreaAcciones.setEditable(false);
        JScrollPane scrollPaneTextArea = new JScrollPane(txtAreaAcciones);
        scrollPaneTextArea.setBorder(new TitledBorder(new EmptyBorder(5, 5, 5, 5), "Acciones", TitledBorder.CENTER,
                TitledBorder.TOP, new Font("Arial", Font.BOLD, 12), new Color(0, 0, 0)));
        btnAsignarMision = new JButton("Asignar Misión");
        btnAsignarMision.setBackground(new Color(254, 250, 224));
        btnRealizarAccion = new JButton("Realizar Acción");
        btnRealizarAccion.setBackground(new Color(254, 250, 224));
        btnCrearSoldado = new JButton("Crear Nuevo Soldado");
        btnCrearSoldado.setBackground(new Color(254, 250, 224));
        btnReset = new JButton("Resetear");
        btnReset.setBackground(new Color(254, 250, 224));
        chkPrepararse = new JCheckBox("Prepararse para la misión");
        chkPrepararse.setBackground(new Color(254, 250, 224));
        rbtnReporteEstado = new JRadioButton("Reportar Estado");
        rbtnReporteEstado.setBackground(new Color(254, 250, 224));

        // Agregar componentes al pane l derecho
        gbc.gridx = 0;
        gbc.gridy = 0;
        panelDerecho.add(lblNombre, gbc);
        gbc.gridy = 1;
        panelDerecho.add(lblID, gbc);
        gbc.gridy = 2;
        panelDerecho.add(lblRango, gbc);
        gbc.gridy = 3;
        panelDerecho.add(lblInfoEspecifica, gbc);
        gbc.gridy = 4;
        panelDerecho.add(new JLabel("Misión: "), gbc);
        gbc.gridy = 5;
        panelDerecho.add(txtMision, gbc);
        gbc.gridy = 6;
        panelDerecho.add(btnAsignarMision, gbc);
        gbc.gridy = 7;
        panelDerecho.add(btnRealizarAccion, gbc);
        gbc.gridy = 8;
        panelDerecho.add(chkPrepararse, gbc);
        gbc.gridy = 9;
        panelDerecho.add(rbtnReporteEstado, gbc);
        gbc.gridy = 10;
        panelDerecho.add(btnCrearSoldado, gbc);
        gbc.gridy = 11;
        panelDerecho.add(btnReset, gbc);

        // SplitPane con panel izquierdo y derecho
        splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, scrollPaneList, panelDerecho);
        splitPane.setDividerLocation(250);
        splitPane.setOneTouchExpandable(true);
        splitPane.setResizeWeight(0.5);
        splitPane.setBorder(null);
        splitPane.setBackground(new Color(254, 250, 224));

        // Agregar componentes al frame
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(splitPane, BorderLayout.CENTER);
        getContentPane().add(scrollPaneTextArea, BorderLayout.SOUTH);
        getContentPane().setBackground(new Color(254, 250, 224));
        getContentPane().setPreferredSize(getPreferredSize());

         // Configuración del JPopupMenu
         popupMenu = new JPopupMenu();
         menuItemEliminar = new JMenuItem("Eliminar Soldado");
 
         popupMenu.add(menuItemEliminar);
 
         // Asocia el JPopupMenu a la lista de soldados
         listSoldados.setComponentPopupMenu(popupMenu);
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
        listSoldados.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                Rango soldadoSeleccionado = listSoldados.getSelectedValue();
                mostrarDetallesSoldado(soldadoSeleccionado);
            }
        });
        btnAsignarMision.addActionListener(e -> asignarMision());
        btnRealizarAccion.addActionListener(e -> realizarAccion());
        chkPrepararse.addActionListener(e -> prepararseParaMision());
        rbtnReporteEstado.addActionListener(e -> reportarEstado());
        btnCrearSoldado.addActionListener(e -> {
            CrearSoldadoDialog dialog = new CrearSoldadoDialog(this, true, modeloSoldados);
            dialog.setLocationRelativeTo(this);
            dialog.setVisible(true);
        });
        btnReset.addActionListener(e -> cargarSoldadosPorDefecto());

        // Menú Salir

        menuItemSalir.addActionListener(e -> System.exit(0));

        // Acción "Eliminar Soldado"
        menuItemEliminar.addActionListener(e -> {
            Rango soldadoSeleccionado = listSoldados.getSelectedValue();
            if (soldadoSeleccionado != null) {
                modeloSoldados.removeElement(soldadoSeleccionado);
                txtAreaAcciones.append("Soldado eliminado: " + soldadoSeleccionado.getNombre() + "\n");
            } else {
                JOptionPane.showMessageDialog(this, "Seleccione un soldado para eliminar.");
            }
        });
    }

    /**
     * Muestra los detalles del soldado seleccionado.
     */
    private void mostrarDetallesSoldado(Rango soldado) {
        if (soldado != null) {
            lblNombre.setText("Nombre: " + soldado.getNombre());
            lblID.setText("ID: " + soldado.getId());
            lblRango.setText("Rango: " + soldado.getRango());
            lblInfoEspecifica.setText("");

            if (soldado instanceof Capitan) {
                lblInfoEspecifica
                        .setText("Soldados bajo mando: " + ((Capitan) soldado).getCantidadSoldadosBajoSuMando());
            } else if (soldado instanceof Teniente) {
                lblInfoEspecifica.setText("Unidad: " + ((Teniente) soldado).getUnidad());
            } else if (soldado instanceof Coronel) {
                lblInfoEspecifica.setText("Estrategia: " + ((Coronel) soldado).getEstrategia());
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
                txtAreaAcciones.append(soldadoSeleccionado.asignarMision(mision) + "\n");
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
            txtAreaAcciones.append(soldadoSeleccionado.realizarAccion() + "\n");
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

    public JButton getBtnAsignarMision() {
        return btnAsignarMision;
    }

    public JButton getBtnRealizarAccion() {
        return btnRealizarAccion;
    }

    public JButton getBtnCrearSoldado() {
        return btnCrearSoldado;
    }

    public JButton getBtnReset() {
        return btnReset;
    }

    public JMenuItem getMenuItemSalir() {
        return menuItemSalir;
    }

    public JList<Rango> getListSoldados() {
        return listSoldados;
    }

    public JTextField getTxtMision() {
        return txtMision;
    }

    public JTextArea getTxtAreaAcciones() {
        return txtAreaAcciones;
    }

    public JCheckBox getChkPrepararse() {
        return chkPrepararse;
    }

    public JRadioButton getRbtnReporteEstado() {
        return rbtnReporteEstado;
    }

    public void setModeloSoldados(DefaultListModel<Rango> modelo) {
        this.modeloSoldados = modelo;
        listSoldados.setModel(modelo); // Configura el JList con el modelo compartido
        listSoldados.repaint(); // Fuerza la actualización de la lista
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