/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.edu.sv.tpi135.serviciorest;


import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Path;
import ues.edu.sv.mantenimientolib.Estado;
import ues.edu.sv.mantenimientotpi.acceso.AbstractFacadeInterface;
import ues.edu.sv.mantenimientotpi.acceso.EstadoFacadeLocal;

/**
 *
 * @author mateo
 */
@Stateless
@Path("estado")
public class EstadoFacadeREST extends AbstractRest<Estado> {

    @EJB
    protected EstadoFacadeLocal estadoEJB;

    @Override
    protected AbstractFacadeInterface<Estado> entity() {
        return estadoEJB;
    }

    @Override
    protected Estado nuevo() {
        return new Estado();
    }

}
