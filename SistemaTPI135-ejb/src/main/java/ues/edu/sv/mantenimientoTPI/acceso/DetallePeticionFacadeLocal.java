/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.edu.sv.mantenimientoTPI.acceso;

import java.util.List;
import javax.ejb.Local;
import ues.edu.sv.mantenimientoLib.DetallePeticion;

/**
 *
 * @author esperanza
 */
@Local
public interface DetallePeticionFacadeLocal {

    void create(DetallePeticion detallePeticion);

    void edit(DetallePeticion detallePeticion);

    void remove(DetallePeticion detallePeticion);

    DetallePeticion find(Object id);

    List<DetallePeticion> findAll();

    List<DetallePeticion> findRange(int[] range);

    int count();
    
}
