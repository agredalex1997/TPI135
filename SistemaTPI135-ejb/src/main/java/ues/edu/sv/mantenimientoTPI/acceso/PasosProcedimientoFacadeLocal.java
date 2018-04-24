/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.edu.sv.mantenimientoTPI.acceso;

import java.util.List;
import javax.ejb.Local;
import ues.edu.sv.mantenimientoLib.PasosProcedimiento;

/**
 *
 * @author esperanza
 */
@Local
public interface PasosProcedimientoFacadeLocal {

    void create(PasosProcedimiento pasosProcedimiento);

    void edit(PasosProcedimiento pasosProcedimiento);

    void remove(PasosProcedimiento pasosProcedimiento);

    PasosProcedimiento find(Object id);

    List<PasosProcedimiento> findAll();

    List<PasosProcedimiento> findRange(int[] range);

    int count();
    
}
