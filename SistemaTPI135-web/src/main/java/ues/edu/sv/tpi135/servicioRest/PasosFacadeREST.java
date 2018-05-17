/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.edu.sv.tpi135.servicioRest;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Path;
import ues.edu.sv.mantenimientoLib.Pasos;
import ues.edu.sv.mantenimientoTPI.acceso.AbstractFacadeInterface;
import ues.edu.sv.mantenimientoTPI.acceso.PasosFacadeLocal;

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
        return (AbstractFacadeInterface<Pasos>) pasosEJB;
    }

    @Override
    protected Pasos nuevo() {
        return new Pasos();
    }

    
}
