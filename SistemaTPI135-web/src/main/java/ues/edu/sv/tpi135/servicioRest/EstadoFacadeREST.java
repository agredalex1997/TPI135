/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.edu.sv.tpi135.servicioRest;


import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Path;
import ues.edu.sv.mantenimientoLib.Estado;
import ues.edu.sv.mantenimientoTPI.acceso.AbstractFacadeInterface;
import ues.edu.sv.mantenimientoTPI.acceso.EstadoFacadeLocal;

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
        return (AbstractFacadeInterface<Estado>) estadoEJB;
    }

    @Override
    protected Estado nuevo() {
        return new Estado();
    }

}
