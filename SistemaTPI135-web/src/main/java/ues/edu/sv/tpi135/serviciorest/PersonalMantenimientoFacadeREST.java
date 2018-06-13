/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.edu.sv.tpi135.serviciorest;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import ues.edu.sv.mantenimientolib.PersonalMantenimiento;
import ues.edu.sv.mantenimientotpi.acceso.AbstractFacadeInterface;
import ues.edu.sv.mantenimientotpi.acceso.PersonalMantenimientoFacadeLocal;

/**
 *
 * @author mateo
 */
@Stateless
@Path("personalMantenimiento")
public class PersonalMantenimientoFacadeREST extends AbstractRest<PersonalMantenimiento> {

   @EJB
    protected PersonalMantenimientoFacadeLocal pmEJB;

    @Override
    protected AbstractFacadeInterface<PersonalMantenimiento> entity() {
        return pmEJB;
    }

    @Override
    protected PersonalMantenimiento nuevo() {
        return new PersonalMantenimiento();
    }
    
    @Path("/findByName/{name}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<PersonalMantenimiento> findByName(@PathParam("name") String name) {
        List listaPm = null;

        if (pmEJB != null) {
            listaPm = pmEJB.findByName(name);
        }

        return listaPm;
    }

    
}
