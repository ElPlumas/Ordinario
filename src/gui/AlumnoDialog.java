/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import intefaces.AlumnoListener;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import objects.Alumno;
import objects.Carrera;
import objects.Fecha;

/**
 *
 * @author -----
 */
public class AlumnoDialog extends JDialog{
    
    private JPanel pnlWork;
    private JPanel pnlBotones;
    
    private JButton btnAceptar;
    private JButton btnCancelar;
    
    private AlumnoListener listener;
    
    public AlumnoDialog(JFrame owner){
        super(owner, "Datos del Alumno", true/*modal, si es true no deja avanzar hasta que se cierre de alguna manera el diálogo*/);
        super.setSize(400, 300);
        super.setLayout(new BorderLayout());
        super.setLocationRelativeTo(owner);
        
        btnAceptar = new JButton("Aceptar");
        btnAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                Alumno alumno = new Alumno("99160967", "Julieta", "Venegas", "Sosa", new Fecha(15, 12, 1979), Carrera.PSICOLOGIA);
                listener.aceptarButtonClick(alumno);
            }
        });
        btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                AlumnoDialog.this.setVisible(false);
            }
        });
        
        pnlWork = new JPanel();
        pnlBotones = new JPanel();
        pnlBotones.setLayout(new FlowLayout(FlowLayout.RIGHT));//ubica a la derecha los botones en el panel
        pnlBotones.setBackground(Color.red);
        pnlBotones.add(btnAceptar);
        pnlBotones.add(btnCancelar);
        
        super.add(pnlBotones, BorderLayout.SOUTH);
        super.add(pnlWork, BorderLayout.CENTER);
        
        super.setVisible(false);
    }
    
    public void setListener(AlumnoListener listener){
        this.listener = listener;
    }
    
}
