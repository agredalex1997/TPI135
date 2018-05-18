/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.edu.sv.tpi135.servicioRest;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Path;
import ues.edu.sv.mantenimientoLib.Equipo;
import ues.edu.sv.mantenimientoTPI.acceso.AbstractFacadeInterface;
import ues.edu.sv.mantenimientoTPI.acceso.EquipoFacadeLocal;

/**
 *
 * @author mateo
 */
@Stateless
@Path("equipo")
public class EquipoFacadeREST extends AbstractRest<Equipo> {

    @EJB
    protected EquipoFacadeLocal equipoEJB;

    @Override
    protected AbstractFacadeInterface<Equipo> entity() {
        return (AbstractFacadeInterface<Equipo>) equipoEJB;
    }

    @Override
    protected Equipo nuevo() {
        return new Equipo();
    }

}
