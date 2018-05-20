/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.edu.sv.tpi135.serviciorest;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Path;
import ues.edu.sv.mantenimientolib.Equipo;
import ues.edu.sv.mantenimientotpi.acceso.AbstractFacadeInterface;
import ues.edu.sv.mantenimientotpi.acceso.EquipoFacadeLocal;

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
        return equipoEJB;
    }

    @Override
    protected Equipo nuevo() {
        return new Equipo();
    }

}
