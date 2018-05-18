/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.edu.sv.mantenimientoTPI.acceso;

import java.util.List;
import javax.ejb.Local;
import ues.edu.sv.mantenimientoLib.ExcepcionCalendario;

/**
 *
 * @author esperanza
 */
@Local
public interface ExcepcionCalendarioFacadeLocal extends AbstractFacadeInterface<ExcepcionCalendario>{

    
    List<ExcepcionCalendario> findRange(int lower, int higher);
    
    List<ExcepcionCalendario> findByName(String nombre);
    
}
