/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.edu.sv.mantenimientoTPI.acceso;

import java.util.List;

/**
 *
 * @author kevin
 * @param <T>
 * 
 */
public interface AbstractFacadeInterface<T>{
    T create(T entity);

    T edit(T entity);

    T remove(T entity);

    boolean crear(T entity);

    boolean modificar(T entity);

    boolean eliminar(T entity);

    T find(Object id);

    List<T> findAll();

    List<T> findRange(int[] range);

    int count();
    
    List<T> findByName(String name);
    
    List<T> findRange(int min, int max);
}
