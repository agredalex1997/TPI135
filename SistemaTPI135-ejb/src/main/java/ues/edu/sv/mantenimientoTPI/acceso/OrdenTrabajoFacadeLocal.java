/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.edu.sv.mantenimientoTPI.acceso;

import java.util.List;
import javax.ejb.Local;
import ues.edu.sv.mantenimientoLib.OrdenTrabajo;

/**
 *
 * @author esperanza
 */
@Local
public interface OrdenTrabajoFacadeLocal extends AbstractFacadeInterface<OrdenTrabajo>{

    void create(OrdenTrabajo ordenTrabajo);

    void edit(OrdenTrabajo ordenTrabajo);

    void remove(OrdenTrabajo ordenTrabajo);

    OrdenTrabajo find(Object id);

    List<OrdenTrabajo> findAll();

    List<OrdenTrabajo> findRange(int[] range);

    int count();
    
    List<OrdenTrabajo> findRange(int lower, int higher);
    
    List<OrdenTrabajo> findByName(String nombre);
}
