/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.edu.sv.tpi135.persistencia;

import java.util.List;
import javax.ejb.Local;
import ues.edu.sv.tpi135.entidades.Peticion;

/**
 *
 * @author esperanza
 */
@Local
public interface PeticionFacadeLocal {

    void create(Peticion peticion);

    void edit(Peticion peticion);

    void remove(Peticion peticion);

    Peticion find(Object id);

    List<Peticion> findAll();

    List<Peticion> findRange(int[] range);

    int count();
    
}
