/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.edu.sv.tpi135.persistencia;

import java.util.List;
import javax.ejb.Local;
import ues.edu.sv.tpi135.entidades.Pasos;

/**
 *
 * @author esperanza
 */
@Local
public interface PasosFacadeLocal {

    void create(Pasos pasos);

    void edit(Pasos pasos);

    void remove(Pasos pasos);

    Pasos find(Object id);

    List<Pasos> findAll();

    List<Pasos> findRange(int[] range);

    int count();
    
}
