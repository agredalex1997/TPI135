/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.edu.sv.mantenimientoTPI.acceso;

import javax.ejb.Local;
import ues.edu.sv.mantenimientoLib.TipoMantenimiento;

/**
 *
 * @author esperanza
 */
@Local
public interface TipoMantenimientoFacadeLocal extends AbstractFacadeInterface<TipoMantenimiento>{

    
    List<TipoMantenimiento> findRange(int lower, int higher);
    
    List<TipoMantenimiento> findByName(String nombre);
    
}
