/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.edu.sv.tpi135.servicioRest;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Path;
import ues.edu.sv.mantenimientoLib.Procedimiento;
import ues.edu.sv.mantenimientoTPI.acceso.AbstractFacadeInterface;
import ues.edu.sv.mantenimientoTPI.acceso.ProcedimientoFacadeLocal;

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
        return (AbstractFacadeInterface<Procedimiento>) procEJB;
    }

    @Override
    protected Procedimiento nuevo() {
        return new Procedimiento();
    }

}
