/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.edu.sv.tpi135.serviciorest;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Path;
import ues.edu.sv.mantenimientolib.TipoMantenimiento;
import ues.edu.sv.mantenimientotpi.acceso.AbstractFacadeInterface;
import ues.edu.sv.mantenimientotpi.acceso.TipoMantenimientoFacadeLocal;

/**
 *
 * @author mateo
 */
@Stateless
@Path("tipoMantenimiento")
public class TipoMantenimientoFacadeREST extends AbstractRest<TipoMantenimiento> {

  @EJB
    protected TipoMantenimientoFacadeLocal tipoEJB;

    @Override
    protected AbstractFacadeInterface<TipoMantenimiento> entity() {
        return tipoEJB;
    }

    @Override
    protected TipoMantenimiento nuevo() {
        return new TipoMantenimiento();
    }

    
}
