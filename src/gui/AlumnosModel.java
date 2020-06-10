/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import controller.Controlador;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import objects.Alumno;

/**
 *
 * @author -----
 */
public class AlumnosModel extends AbstractTableModel{ //abstracttablemodel ya implementa a tablemodel, ahorra generar código que esta vez no es necesario

    private Controlador oControlador;
    public AlumnosModel(Controlador controlador){
        oControlador = controlador;
    }
    
    @Override
    public int getRowCount() { //filas
        return oControlador.getAlumnosCount();
    }

    @Override
    public int getColumnCount() { //columnas
        return 6;
    }

    @Override
    public Object getValueAt(int arg0, int arg1) { //contenido de celdas
        Alumno a = oControlador.getAlumno(arg0);
        switch (arg1) {
            case 0:
                return a.getMatricula();
            case 1:
                return a.getNombre();
            case 2:
                return a.getPaterno();
            case 3:
                return a.getMaterno();
            case 4:
                return a.getFechaNacimiento();
            case 5:
                return a.getCarrera();
            default:
                throw new AssertionError();
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Matricula";
            case 1:
                return "Nombre";
            case 2:
                return "A.Paterno";
            case 3:
                return "A.Materno";
            case 4:
                return "Fecha Nacimiento";
            case 5:
                return "Carrera";
            default:
                throw new AssertionError();
        }
    }
    
    
    
}
