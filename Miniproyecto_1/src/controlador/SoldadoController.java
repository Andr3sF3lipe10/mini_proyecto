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
    }

    private void configurarEventos() {
        mainFrame.getBtnAsignarMision().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                asignarMision();
            }
        });

        mainFrame.getBtnRealizarAccion().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                realizarAccion();
            }
        });

        mainFrame.getBtnCrearSoldado().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CrearSoldadoDialog dialog = new CrearSoldadoDialog(mainFrame, true, modeloSoldados);
                dialog.setLocationRelativeTo(mainFrame);
                dialog.setVisible(true);
            }
        });

        mainFrame.getBtnReset().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cargarSoldadosPorDefecto();
            }
        });

        mainFrame.getMenuItemSalir().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
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
}