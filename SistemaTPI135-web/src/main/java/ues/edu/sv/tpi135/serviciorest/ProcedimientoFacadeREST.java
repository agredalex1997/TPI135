/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.edu.sv.tpi135.serviciorest;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Path;
import ues.edu.sv.mantenimientolib.Procedimiento;
import ues.edu.sv.mantenimientotpi.acceso.AbstractFacadeInterface;
import ues.edu.sv.mantenimientotpi.acceso.ProcedimientoFacadeLocal;

/**
 *
 * @author mateo
 */
@Stateless
@Path("procedimiento")
public class ProcedimientoFacadeREST extends AbstractRest<Procedimiento> {

   @EJB
    protected ProcedimientoFacadeLocal procEJB;

    @Override
    protected AbstractFacadeInterface<Procedimiento> entity() {
        return procEJB;
    }

    @Override
    protected Procedimiento nuevo() {
        return new Procedimiento();
    }

}
