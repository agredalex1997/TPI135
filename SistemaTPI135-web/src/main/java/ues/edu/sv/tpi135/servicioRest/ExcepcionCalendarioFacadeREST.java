/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.edu.sv.tpi135.servicioRest;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Path;
import ues.edu.sv.mantenimientoLib.ExcepcionCalendario;
import ues.edu.sv.mantenimientoTPI.acceso.AbstractFacadeInterface;
import ues.edu.sv.mantenimientoTPI.acceso.ExcepcionCalendarioFacadeLocal;

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
