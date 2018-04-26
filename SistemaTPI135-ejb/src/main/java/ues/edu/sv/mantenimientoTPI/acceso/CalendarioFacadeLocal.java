/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.edu.sv.mantenimientoTPI.acceso;

import java.util.List;
import javax.ejb.Local;
import ues.edu.sv.mantenimientoLib.Calendario;

/**
 *
 * @author esperanza
 */
@Local
public interface CalendarioFacadeLocal {

    void create(Calendario calendario);

    void edit(Calendario calendario);

    void remove(Calendario calendario);

    Calendario find(Object id);

    List<Calendario> findAll();

    List<Calendario> findRange(int[] range);

    int count();
    
    List<Calendario> findRange(int lower, int higher);
    
    List<Calendario> findByName(String nombre);
    
}
