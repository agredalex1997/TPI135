/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.edu.sv.tpi135.persistencia;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import ues.edu.sv.tpi135.entidades.Modelo;

/**
 *
 * @author esperanza
 */
@Stateless
public class ModeloFacade extends AbstractFacade<Modelo> implements ModeloFacadeLocal {

    @PersistenceContext(unitName = "mantenimientoUP")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ModeloFacade() {
        super(Modelo.class);
    }
    
}
