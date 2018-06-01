/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.edu.sv.tpi135.serviciorest;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Path;
import ues.edu.sv.mantenimientolib.Peticion;
import ues.edu.sv.mantenimientotpi.acceso.AbstractFacadeInterface;
import ues.edu.sv.mantenimientotpi.acceso.PeticionFacadeLocal;

/**
 *
 * @author mateo
 */
@Stateless
@Path("peticion")
public class PeticionFacadeREST extends AbstractRest<Peticion> {

    @EJB
    protected PeticionFacadeLocal peticionEJB;

    @Override
    protected AbstractFacadeInterface<Peticion> entity() {
        return peticionEJB;
    }

    @Override
    protected Peticion nuevo() {
        return new Peticion();
    }

}
