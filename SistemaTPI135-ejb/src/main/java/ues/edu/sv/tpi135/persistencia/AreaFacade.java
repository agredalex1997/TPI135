/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.edu.sv.tpi135.persistencia;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import ues.edu.sv.tpi135.entidades.Area;

/**
 *
 * @author esperanza
 */
@Stateless
public class AreaFacade extends AbstractFacade<Area> implements AreaFacadeLocal {

    @PersistenceContext(unitName = "mantenimientoUP")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AreaFacade() {
        super(Area.class);
    }
    
}
