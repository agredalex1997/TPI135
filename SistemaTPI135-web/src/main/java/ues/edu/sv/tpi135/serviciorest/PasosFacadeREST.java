/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.edu.sv.tpi135.serviciorest;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Path;
import ues.edu.sv.mantenimientolib.Pasos;
import ues.edu.sv.mantenimientotpi.acceso.AbstractFacadeInterface;
import ues.edu.sv.mantenimientotpi.acceso.PasosFacadeLocal;

/**
 *
 * @author mateo
 */
@Stateless
@Path("pasos")
public class PasosFacadeREST extends AbstractRest<Pasos> {

   @EJB
    protected PasosFacadeLocal pasosEJB;

    @Override
    protected AbstractFacadeInterface<Pasos> entity() {
        return pasosEJB;
    }

    @Override
    protected Pasos nuevo() {
        return new Pasos();
    }

    
}
