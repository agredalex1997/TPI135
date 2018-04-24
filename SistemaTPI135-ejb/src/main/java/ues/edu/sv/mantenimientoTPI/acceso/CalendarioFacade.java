/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.edu.sv.mantenimientoTPI.acceso;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import ues.edu.sv.mantenimientoLib.Calendario;

/**
 *
 * @author esperanza
 */
@Stateless
public class CalendarioFacade extends AbstractFacade<Calendario> implements CalendarioFacadeLocal {

    @PersistenceContext(unitName = "ues.edu.sv.tpi135_SistemaTPI135-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CalendarioFacade() {
        super(Calendario.class);
    }
    
}
