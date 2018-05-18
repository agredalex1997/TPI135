/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.edu.sv.mantenimientoTPI.acceso;

import java.util.List;
import javax.ejb.Local;
import ues.edu.sv.mantenimientoLib.DetalleEquipo;

/**
 *
 * @author esperanza
 */
@Local
public interface DetalleEquipoFacadeLocal extends AbstractFacadeInterface<DetalleEquipo>{

    
    List<DetalleEquipo> findRange(int lower, int higher);
    
    List<DetalleEquipo> findByName(String nombre);
    
}
