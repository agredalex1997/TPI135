/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.edu.sv.tpi135.serviciorest;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Path;
import ues.edu.sv.mantenimientolib.PasosProcedimiento;
import ues.edu.sv.mantenimientotpi.acceso.AbstractFacadeInterface;
import ues.edu.sv.mantenimientotpi.acceso.PasosProcedimientoFacadeLocal;

/**
 *
 * @author mateo
 */
@Stateless
@Path("pasosProcedimiento")
public class PasosProcedimientoFacadeREST extends AbstractRest<PasosProcedimiento> {

   @EJB
    protected PasosProcedimientoFacadeLocal ppEJB;

    @Override
    protected AbstractFacadeInterface<PasosProcedimiento> entity() {
        return ppEJB;
    }

    @Override
    protected PasosProcedimiento nuevo() {
        return new PasosProcedimiento();
    }

}
