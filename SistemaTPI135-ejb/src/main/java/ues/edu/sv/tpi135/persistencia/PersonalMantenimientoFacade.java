/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.edu.sv.tpi135.persistencia;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import ues.edu.sv.tpi135.entidades.PersonalMantenimiento;

/**
 *
 * @author esperanza
 */
@Stateless
public class PersonalMantenimientoFacade extends AbstractFacade<PersonalMantenimiento> implements PersonalMantenimientoFacadeLocal {

    @PersistenceContext(unitName = "mantenimientoUP")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PersonalMantenimientoFacade() {
        super(PersonalMantenimiento.class);
    }
    
}
