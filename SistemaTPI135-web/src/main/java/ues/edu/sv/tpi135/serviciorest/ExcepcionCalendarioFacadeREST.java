/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.edu.sv.tpi135.serviciorest;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Path;
import ues.edu.sv.mantenimientolib.ExcepcionCalendario;
import ues.edu.sv.mantenimientotpi.acceso.AbstractFacadeInterface;
import ues.edu.sv.mantenimientotpi.acceso.ExcepcionCalendarioFacadeLocal;

/**
 *
 * @author mateo
 */
@Stateless
@Path("excepcionCalendario")
public class ExcepcionCalendarioFacadeREST extends AbstractRest<ExcepcionCalendario> {

    @EJB
    protected ExcepcionCalendarioFacadeLocal ecalendarioEJB;

    @Override
    protected AbstractFacadeInterface<ExcepcionCalendario> entity() {
        return  ecalendarioEJB;
    }

    @Override
    protected ExcepcionCalendario nuevo() {
        return new ExcepcionCalendario();
    }

    
}
