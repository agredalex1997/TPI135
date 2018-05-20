/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.edu.sv.tpi135.serviciorest;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Path;
import ues.edu.sv.mantenimientolib.Hardware;
import ues.edu.sv.mantenimientotpi.acceso.AbstractFacadeInterface;
import ues.edu.sv.mantenimientotpi.acceso.HardwareFacadeLocal;

/**
 *
 * @author mateo
 */
@Stateless
@Path("hardware")
public class HardwareFacadeREST extends AbstractRest<Hardware> {

 @EJB
    protected HardwareFacadeLocal hardwareEJB;

    @Override
    protected AbstractFacadeInterface<Hardware> entity() {
        return  hardwareEJB;
    }

    @Override
    protected Hardware nuevo() {
        return new Hardware();
    }

}
