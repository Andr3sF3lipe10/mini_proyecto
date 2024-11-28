
import militar.rangos.Rango;
import militar.soldados.*;
import javax.swing.*;
import java.awt.*;

/**
 * Diálogo para crear un nuevo soldado.
 */
public class CrearSoldadoDialog extends JDialog {

    private DefaultListModel<Rango> modeloSoldados;

    private JLabel lblTipoSoldado, lblNombre, lblID, lblUnidad, lblCantidadSoldados, lblEstrategia;
    private JComboBox<String> cmbTipoSoldado;
    private JTextField txtNombre, txtID, txtUnidad, txtCantidadSoldados, txtEstrategia;
    private JButton btnCrear, btnCancelar;

    public CrearSoldadoDialog(Frame parent, boolean modal, DefaultListModel<Rango> modeloSoldados) {
        super(parent, modal);
        this.modeloSoldados = modeloSoldados;
        inicializarComponentes();
        configurarEventos();
    }

    /**
     * Inicializa los componentes del diálogo.
     */
    private void inicializarComponentes() {
        setTitle("Crear Nuevo Soldado");
        setSize(400, 300);
        setLayout(new GridLayout(0, 2));

        lblTipoSoldado = new JLabel("Tipo de Soldado:");
        cmbTipoSoldado = new JComboBox<>(new String[]{"Soldado Raso", "Teniente", "Capitán", "Coronel"});

        lblNombre = new JLabel("Nombre:");
        txtNombre = new JTextField();

        lblID = new JLabel("ID:");
        txtID = new JTextField();

        lblUnidad = new JLabel("Unidad:");
        txtUnidad = new JTextField();

        lblCantidadSoldados = new JLabel("Cantidad de Soldados:");
        txtCantidadSoldados = new JTextField();

        lblEstrategia = new JLabel("Estrategia:");
        txtEstrategia = new JTextField();

        btnCrear = new JButton("Crear");
        btnCancelar = new JButton("Cancelar");

        add(lblTipoSoldado);
        add(cmbTipoSoldado);
        add(lblNombre);
        add(txtNombre);
        add(lblID);
        add(txtID);
        add(lblUnidad);
        add(txtUnidad);
        add(lblCantidadSoldados);
        add(txtCantidadSoldados);
        add(lblEstrategia);
        add(txtEstrategia);
        add(btnCrear);
        add(btnCancelar);

        // Ocultar campos específicos al inicio
        actualizarCamposEspecificos();
    }

    /**
     * Configura los eventos de los componentes.
     */
    private void configurarEventos() {
        // Evento al cambiar el tipo de soldado
        cmbTipoSoldado.addItemListener(e -> actualizarCamposEspecificos());

        // Botón Crear
        btnCrear.addActionListener(e -> crearSoldado());

        // Botón Cancelar
        btnCancelar.addActionListener(e -> dispose());
    }

    /**
     * Actualiza la visibilidad de los campos específicos según el tipo de soldado.
     */
    private void actualizarCamposEspecificos() {
        String tipoSoldado = (String) cmbTipoSoldado.getSelectedItem();
        lblUnidad.setVisible(false);
        txtUnidad.setVisible(false);
        lblCantidadSoldados.setVisible(false);
        txtCantidadSoldados.setVisible(false);
        lblEstrategia.setVisible(false);
        txtEstrategia.setVisible(false);

        switch (tipoSoldado) {
            case "Teniente":
                lblUnidad.setVisible(true);
                txtUnidad.setVisible(true);
                break;
            case "Capitán":
                lblCantidadSoldados.setVisible(true);
                txtCantidadSoldados.setVisible(true);
                break;
            case "Coronel":
                lblEstrategia.setVisible(true);
                txtEstrategia.setVisible(true);
                break;
        }
    }

    /**
     * Crea un nuevo soldado y lo agrega al modelo.
     */
    private void crearSoldado() {
        String tipoSoldado = (String) cmbTipoSoldado.getSelectedItem();
        String nombre = txtNombre.getText().trim();
        String id = txtID.getText().trim();

        if (nombre.isEmpty() || id.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nombre y ID son obligatorios.");
            return;
        }

        Rango nuevoSoldado = null;

        switch (tipoSoldado) {
            case "Soldado Raso":
                nuevoSoldado = new SoldadoRaso(nombre, id);
                break;
            case "Teniente":
                String unidad = txtUnidad.getText().trim();
                if (unidad.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Unidad es obligatoria para un Teniente.");
                    return;
                }
                nuevoSoldado = new Teniente(nombre, id, unidad);
                break;
            case "Capitán":
                String cantidadStr = txtCantidadSoldados.getText().trim();
                if (cantidadStr.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Cantidad de soldados es obligatoria para un Capitán.");
                    return;
                }
                int cantidadSoldados;
                try {
                    cantidadSoldados = Integer.parseInt(cantidadStr);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Cantidad de soldados debe ser un número entero.");
                    return;
                }
                nuevoSoldado = new Capitan(nombre, id, cantidadSoldados);
                break;
            case "Coronel":
                String estrategia = txtEstrategia.getText().trim();
                if (estrategia.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Estrategia es obligatoria para un Coronel.");
                    return;
                }
                nuevoSoldado = new Coronel(nombre, id, estrategia);
                break;
        }

        // Agregar el nuevo soldado al modelo
        modeloSoldados.addElement(nuevoSoldado);
        JOptionPane.showMessageDialog(this, "Soldado creado exitosamente.");
        dispose();
    }
}
