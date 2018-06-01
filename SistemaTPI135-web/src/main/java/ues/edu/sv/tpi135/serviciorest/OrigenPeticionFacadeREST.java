/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.edu.sv.tpi135.serviciorest;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Path;
import ues.edu.sv.mantenimientolib.OrigenPeticion;
import ues.edu.sv.mantenimientotpi.acceso.AbstractFacadeInterface;
import ues.edu.sv.mantenimientotpi.acceso.OrigenPeticionFacadeLocal;

/**
 *
 * @author mateo
 */
@Stateless
@Path("origenPeticion")
public class OrigenPeticionFacadeREST extends AbstractRest<OrigenPeticion> {

   @EJB
    protected OrigenPeticionFacadeLocal origenEJB;

    @Override
    protected AbstractFacadeInterface<OrigenPeticion> entity() {
        return origenEJB;
    }

    @Override
    protected OrigenPeticion nuevo() {
        return new OrigenPeticion();
    }

    
}
