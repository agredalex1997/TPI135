/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.edu.sv.tpi135.servicioRest;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Path;
import ues.edu.sv.mantenimientoLib.DetalleEquipo;
import ues.edu.sv.mantenimientoTPI.acceso.AbstractFacadeInterface;
import ues.edu.sv.mantenimientoTPI.acceso.DetalleEquipoFacadeLocal;

/**
 *
 * @author mateo
 */
@Stateless
@Path("detalleEquipo")
public class DetalleEquipoFacadeREST extends AbstractRest<DetalleEquipo> {

    @EJB
    protected DetalleEquipoFacadeLocal detalleequipoEJB;

    @Override
    protected AbstractFacadeInterface<DetalleEquipo> entity() {
        return detalleequipoEJB;
    }

    @Override
    protected DetalleEquipo nuevo() {
        return new DetalleEquipo();
    }

}
