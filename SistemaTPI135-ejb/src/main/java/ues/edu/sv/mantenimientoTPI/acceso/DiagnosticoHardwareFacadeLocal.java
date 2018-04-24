/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.edu.sv.mantenimientoTPI.acceso;

import java.util.List;
import javax.ejb.Local;
import ues.edu.sv.mantenimientoLib.DiagnosticoHardware;

/**
 *
 * @author esperanza
 */
@Local
public interface DiagnosticoHardwareFacadeLocal {

    void create(DiagnosticoHardware diagnosticoHardware);

    void edit(DiagnosticoHardware diagnosticoHardware);

    void remove(DiagnosticoHardware diagnosticoHardware);

    DiagnosticoHardware find(Object id);

    List<DiagnosticoHardware> findAll();

    List<DiagnosticoHardware> findRange(int[] range);

    int count();
    
}
