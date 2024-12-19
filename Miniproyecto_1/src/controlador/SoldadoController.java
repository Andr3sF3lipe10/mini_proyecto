package controlador;

import modelo.rangos.Rango;
import modelo.soldados.*;
import vista.MainFrame;
import vista.CrearSoldadoDialog;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SoldadoController {
    private MainFrame mainFrame;
    private DefaultListModel<Rango> modeloSoldados;

    public SoldadoController(MainFrame mainFrame, DefaultListModel<Rango> modeloSoldados) {
        this.mainFrame = mainFrame;
        this.modeloSoldados = modeloSoldados;
        configurarEventos();
        cargarSoldadosPorDefecto(); // Cargar los soldados predefinidos al iniciar
    }

    private void configurarEventos() {
        // Limpiar listeners existentes antes de asignar nuevos
        for (ActionListener al : mainFrame.getBtnAsignarMision().getActionListeners()) {
            mainFrame.getBtnAsignarMision().removeActionListener(al);
        }
        for (ActionListener al : mainFrame.getBtnRealizarAccion().getActionListeners()) {
            mainFrame.getBtnRealizarAccion().removeActionListener(al);
        }
        for (ActionListener al : mainFrame.getBtnReset().getActionListeners()) {
            mainFrame.getBtnReset().removeActionListener(al);
        }
        for (ActionListener al : mainFrame.getChkPrepararse().getActionListeners()) {
            mainFrame.getChkPrepararse().removeActionListener(al);
        }
        for (ActionListener al : mainFrame.getRbtnReporteEstado().getActionListeners()) {
            mainFrame.getRbtnReporteEstado().removeActionListener(al);
        }
    
        // Asignar nuevos listeners
        mainFrame.getBtnAsignarMision().addActionListener(e -> asignarMision());
        mainFrame.getBtnRealizarAccion().addActionListener(e -> realizarAccion());
        mainFrame.getBtnCrearSoldado().addActionListener(e -> {
            CrearSoldadoDialog dialog = new CrearSoldadoDialog(mainFrame, true, modeloSoldados);
            dialog.setLocationRelativeTo(mainFrame);
            dialog.setVisible(true);
        });
        mainFrame.getBtnReset().addActionListener(e -> cargarSoldadosPorDefecto());
    
        mainFrame.getChkPrepararse().addActionListener(e -> {
            Rango soldadoSeleccionado = mainFrame.getListSoldados().getSelectedValue();
            if (soldadoSeleccionado != null) {
                soldadoSeleccionado.prepararseParaMision();
                mainFrame.getTxtAreaAcciones().append(soldadoSeleccionado.getNombre() + " se está preparando para la misión.\n");
            } else {
                JOptionPane.showMessageDialog(mainFrame, "Seleccione un soldado.");
            }
        });
    
        mainFrame.getRbtnReporteEstado().addActionListener(e -> {
            Rango soldadoSeleccionado = mainFrame.getListSoldados().getSelectedValue();
            if (soldadoSeleccionado != null) {
                soldadoSeleccionado.reportarEstado();
                mainFrame.getTxtAreaAcciones().append(soldadoSeleccionado.getNombre() + " ha reportado su estado.\n");
                mainFrame.getRbtnReporteEstado().setSelected(false);
            } else {
                JOptionPane.showMessageDialog(mainFrame, "Seleccione un soldado.");
            }
        });
    }

    private void asignarMision() {
        Rango soldadoSeleccionado = mainFrame.getListSoldados().getSelectedValue();
        if (soldadoSeleccionado != null) {
            String mision = mainFrame.getTxtMision().getText();
            if (!mision.isEmpty()) {
                mainFrame.getTxtAreaAcciones().append(soldadoSeleccionado.asignarMision(mision) + "\n");
                mainFrame.getTxtMision().setText("");
            } else {
                JOptionPane.showMessageDialog(mainFrame, "Ingrese una misión.");
            }
        } else {
            JOptionPane.showMessageDialog(mainFrame, "Seleccione un soldado.");
        }
    }

    private void realizarAccion() {
        Rango soldadoSeleccionado = mainFrame.getListSoldados().getSelectedValue();
        if (soldadoSeleccionado != null) {
            mainFrame.getTxtAreaAcciones().append(soldadoSeleccionado.realizarAccion() + "\n");
        } else {
            JOptionPane.showMessageDialog(mainFrame, "Seleccione un soldado.");
        }
    }

    private void cargarSoldadosPorDefecto() {
        // Crear soldados por defecto
        List<Rango> listaSoldadosPorDefecto = new ArrayList<Rango>();
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

    private void configurarPopupMenu() {
        JPopupMenu popupMenu = new JPopupMenu();
        JMenuItem menuAsignarMision = new JMenuItem("Asignar Misión");
        JMenuItem menuPrepararMision = new JMenuItem("Prepararse para Misión");
        JMenuItem menuReportarEstado = new JMenuItem("Reportar Estado");
    
        popupMenu.add(menuAsignarMision);
        popupMenu.add(menuPrepararMision);
        popupMenu.add(menuReportarEstado);
    
        // Listener de clic derecho en la lista
        mainFrame.getListSoldados().addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                if (evt.isPopupTrigger()) { // Verifica clic derecho
                    mostrarPopup(evt);
                }
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                if (evt.isPopupTrigger()) {
                    mostrarPopup(evt);
                }
            }
            private void mostrarPopup(java.awt.event.MouseEvent evt) {
                if (!mainFrame.getListSoldados().isSelectionEmpty()) {
                    popupMenu.show(evt.getComponent(), evt.getX(), evt.getY());
                }
            }
        });
    
        // Acción Asignar Misión
        menuAsignarMision.addActionListener(e -> asignarMision());
        // Acción Prepararse para Misión
        menuPrepararMision.addActionListener(e -> {
            Rango soldado = mainFrame.getListSoldados().getSelectedValue();
            if (soldado != null) {
                soldado.prepararseParaMision();
                mainFrame.getTxtAreaAcciones().append(soldado.getNombre() + " se está preparando para la misión.\n");
            }
        });
        // Acción Reportar Estado
        menuReportarEstado.addActionListener(e -> {
            Rango soldado = mainFrame.getListSoldados().getSelectedValue();
            if (soldado != null) {
                soldado.reportarEstado();
                mainFrame.getTxtAreaAcciones().append(soldado.getNombre() + " ha reportado su estado.\n");
            }
        });
    }
    

    
}