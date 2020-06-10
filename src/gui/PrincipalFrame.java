/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Excepciones.AlumnoExistenteException;
import controller.Controlador;
import intefaces.AlumnoListener;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javafx.scene.layout.Border;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import objects.Alumno;
import objects.Carrera;
import objects.Fecha;

/**
 *
 * @author -----
 */
public class PrincipalFrame extends JFrame {
    
    private EncabezadoPanel pnlEncabezado;
    private WorkPanel pnlWork;
    private BusquedaPanel pnlBusqueda;
    
    private Controlador controlador;
    
    private AlumnoDialog dlgAlumno;
    
    public PrincipalFrame(){
        super("Control Escolar");
        super.setLayout(new BorderLayout());
        super.setSize(800, 500);
        super.setLocationRelativeTo(null); //centra la ventana
        
        dlgAlumno = new AlumnoDialog(this);
        dlgAlumno.setListener(new AlumnoListener() {
            @Override
            public void aceptarButtonClick(Alumno alumno) {
                try {
                    controlador.addAlumno(alumno);
                    dlgAlumno.setVisible(false);
                } catch (AlumnoExistenteException ex) {
                    JOptionPane.showMessageDialog(PrincipalFrame.this, 
                            "La matrícula ya ha sido insertada anteriormente", 
                            "Matrícula inválida", 
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        controlador = new Controlador();
        cargaInicial();
        
        pnlEncabezado = new EncabezadoPanel();
        
        pnlWork = new WorkPanel(controlador);
        
        pnlBusqueda = new BusquedaPanel();
        
        //Agregar componentes
        //ubicaciones de los paneles en la ventana
        super.add(pnlEncabezado, BorderLayout.NORTH);
        super.add(pnlWork, BorderLayout.CENTER);
        super.add(pnlBusqueda, BorderLayout.SOUTH);
        
        super.setJMenuBar(createMenu());
        
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setVisible(true);
    }
    
    private void cargaInicial(){
        Alumno a = new Alumno("99160977", "Daniel Karim", "Ricardez", "Ortiz", new Fecha(4, 9, 1981), Carrera.SISTEMAS);
        Alumno b = new Alumno("b");
        Alumno c = new Alumno("c");
        Alumno d = new Alumno("d");
        Alumno e = new Alumno("e");
        
        try{
            controlador.addAlumno(a);
            controlador.addAlumno(b);
            controlador.addAlumno(c);
            controlador.addAlumno(d);
            controlador.addAlumno(e);
        }catch(AlumnoExistenteException ex){
            ex.printStackTrace();
        }
    }
    
    private JMenuBar createMenu(){
        JMenuBar mbMain = new JMenuBar();
        
        JMenu mmArchivo = new JMenu("Archivo");
        JMenuItem miNuevo = new JMenuItem("Nuevo alumno...");
        miNuevo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                dlgAlumno.setVisible(true);
            }
        });
        JMenuItem miSalir = new JMenuItem("Salir");
        miSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                System.exit(0);
            }
        });
        mmArchivo.add(miNuevo);
        mmArchivo.addSeparator();
        mmArchivo.add(miSalir);
        
        JMenu mmAyuda = new JMenu("Ayuda");
        JMenuItem miAcerca = new JMenuItem("Acerca de...");
        mmAyuda.add(miAcerca);
        
        mbMain.add(mmArchivo);
        mbMain.add(mmAyuda);
        return mbMain;
    }
    
}
