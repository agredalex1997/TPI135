/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.edu.sv.mantenimientoTPI.acceso;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import ues.edu.sv.mantenimientoLib.Peticion;

/**
 *
 * @author kevin
 */
@Stateless
public class PeticionFacade extends AbstractFacade<Peticion> implements PeticionFacadeLocal {

    @PersistenceContext(unitName = "ues.edu.sv.tpi135_SistemaTPI135-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PeticionFacade() {
        super(Peticion.class);
    }
    
}
