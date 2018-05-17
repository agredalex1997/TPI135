/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.edu.sv.tpi135.servicioRest;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Path;
import ues.edu.sv.mantenimientoLib.Calendario;
import ues.edu.sv.mantenimientoTPI.acceso.AbstractFacadeInterface;
import ues.edu.sv.mantenimientoTPI.acceso.CalendarioFacadeLocal;

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
        return (AbstractFacadeInterface<Calendario>) calendarioEJB;
    }

    @Override
    protected Calendario nuevo() {
        return new Calendario();
    }

   
}
