/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.edu.sv.tpi135.persistencia;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import ues.edu.sv.tpi135.entidades.OrigenPeticion;

/**
 *
 * @author esperanza
 */
@Stateless
public class OrigenPeticionFacade extends AbstractFacade<OrigenPeticion> implements OrigenPeticionFacadeLocal {

    @PersistenceContext(unitName = "mantenimientoUP")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OrigenPeticionFacade() {
        super(OrigenPeticion.class);
    }
    
}
