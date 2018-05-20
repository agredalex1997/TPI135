/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.edu.sv.tpi135.serviciorest;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Path;
import ues.edu.sv.mantenimientolib.Calendario;
import ues.edu.sv.mantenimientotpi.acceso.AbstractFacadeInterface;
import ues.edu.sv.mantenimientotpi.acceso.CalendarioFacadeLocal;

/**
 *
 * @author mateo
 */
@Stateless
@Path("calendario")
public class CalendarioFacadeREST extends AbstractRest<Calendario> {
    @EJB
    protected CalendarioFacadeLocal calendarioEJB;
    
   @Override
    protected AbstractFacadeInterface<Calendario> entity() {
        return calendarioEJB;
    }

    @Override
    protected Calendario nuevo() {
        return new Calendario();
    }

   
}
