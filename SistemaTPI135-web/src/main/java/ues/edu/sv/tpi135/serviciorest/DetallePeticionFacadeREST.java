/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.edu.sv.tpi135.serviciorest;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Path;
import ues.edu.sv.mantenimientolib.DetallePeticion;
import ues.edu.sv.mantenimientotpi.acceso.AbstractFacadeInterface;
import ues.edu.sv.mantenimientotpi.acceso.DetallePeticionFacadeLocal;

/**
 *
 * @author mateo
 */
@Stateless
@Path("detallePeticion")
public class DetallePeticionFacadeREST extends AbstractRest<DetallePeticion> {

   @EJB
    protected DetallePeticionFacadeLocal detallePEJB;

    @Override
    protected AbstractFacadeInterface<DetallePeticion> entity() {
        return  detallePEJB;
    }

    @Override
    protected DetallePeticion nuevo() {
        return new DetallePeticion();
    }
    
}
