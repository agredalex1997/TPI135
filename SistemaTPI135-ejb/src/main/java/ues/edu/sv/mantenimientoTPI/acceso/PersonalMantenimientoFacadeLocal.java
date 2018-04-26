/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.edu.sv.mantenimientoTPI.acceso;

import java.util.List;
import javax.ejb.Local;
import ues.edu.sv.mantenimientoLib.PersonalMantenimiento;

/**
 *
 * @author esperanza
 */
@Local
public interface PersonalMantenimientoFacadeLocal {

    void create(PersonalMantenimiento personalMantenimiento);

    void edit(PersonalMantenimiento personalMantenimiento);

    void remove(PersonalMantenimiento personalMantenimiento);

    PersonalMantenimiento find(Object id);

    List<PersonalMantenimiento> findAll();

    List<PersonalMantenimiento> findRange(int[] range);

    int count();
    
    List<PersonalMantenimiento> findRange(int lower, int higher);
    
    List<PersonalMantenimiento> findByName(String nombre);
    
}
