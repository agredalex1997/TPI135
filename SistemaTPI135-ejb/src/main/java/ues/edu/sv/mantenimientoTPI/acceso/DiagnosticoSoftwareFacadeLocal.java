/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.edu.sv.mantenimientoTPI.acceso;

import java.util.List;
import javax.ejb.Local;
import ues.edu.sv.mantenimientoLib.DiagnosticoSoftware;

/**
 *
 * @author esperanza
 */
@Local
public interface DiagnosticoSoftwareFacadeLocal {

    void create(DiagnosticoSoftware diagnosticoSoftware);

    void edit(DiagnosticoSoftware diagnosticoSoftware);

    void remove(DiagnosticoSoftware diagnosticoSoftware);

    DiagnosticoSoftware find(Object id);

    List<DiagnosticoSoftware> findAll();

    List<DiagnosticoSoftware> findRange(int[] range);

    int count();
    
    List<DiagnosticoSoftware> findRange(int lower, int higher);
    
    List<DiagnosticoSoftware> findByName(String nombre);
    
}
