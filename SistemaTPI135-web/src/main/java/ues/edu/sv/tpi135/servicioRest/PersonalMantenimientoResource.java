
package ues.edu.sv.tpi135.servicioRest;

import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import ues.edu.sv.mantenimientoTPI.acceso.PersonalMantenimientoFacadeLocal;
import ues.edu.sv.mantenimientoLib.PersonalMantenimiento;

/**
 *
 * @author mateo
 */

@Path("/personalMantenimiento")
public class PersonalMantenimientoResource implements Serializable{
    @EJB
    private PersonalMantenimientoFacadeLocal ejbPersonalMantenimiento;
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<PersonalMantenimiento> findAll(){
        List listaPersonalMantenimineto = null;
        if(ejbPersonalMantenimiento != null){
            listaPersonalMantenimineto = ejbPersonalMantenimiento.findAll();
        }
        return listaPersonalMantenimineto;
    }
    
    @Path("/count")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Integer count(){
        int count = 0;
        if(ejbPersonalMantenimiento != null){
            count = ejbPersonalMantenimiento.count();
        }
        return count;
    }
    
    @Path("/{dui}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public PersonalMantenimiento findById(@PathParam("dui") Integer dui){
        if(ejbPersonalMantenimiento != null){
            return ejbPersonalMantenimiento.find(dui);
        }
        return new PersonalMantenimiento();
    }
                                          
    @Path("/remove/{dui}")
    @DELETE
    public Response remove(@PathParam("dui") Integer dui){
        PersonalMantenimiento removePersonalMantenimiento = new PersonalMantenimiento(dui);
        Response respuesta = Response.status(Response.Status.NOT_FOUND).build();
        if(ejbPersonalMantenimiento != null){
            ejbPersonalMantenimiento.remove(removePersonalMantenimiento);
            respuesta = Response.status(Response.Status.OK).build();
        }
        return respuesta;
    }
    
    @Path("/create/{dui}/{nombre}/{apellido}/{telefono}/{email}")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(@PathParam("dui") Integer dui, @PathParam("nombre") String nombre, 
            @PathParam("apellido") String apellido, @PathParam("telefono") String telefono,
            @PathParam("email") String email){
        Response respuesta = Response.status(Response.Status.NOT_FOUND).build();
        if(ejbPersonalMantenimiento != null){
            PersonalMantenimiento newPersonalMantenimiento = new PersonalMantenimiento(dui, nombre, apellido, telefono, email);
            respuesta = Response.status(Response.Status.CREATED).entity(newPersonalMantenimiento).build();
        }
        
        return respuesta;
    }
    
    @Path("/{lower}/{higher}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<PersonalMantenimiento> findRange(@PathParam("lower") int lower, @PathParam("higher") int higher) {
      List listaPersonalMantenimiento = null;
      if (ejbPersonalMantenimiento != null) {
        listaPersonalMantenimiento = ejbPersonalMantenimiento.findRange(lower, higher);
      }
      
      return listaPersonalMantenimiento;
    }
    
    @Path("/findByName/{name}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<PersonalMantenimiento> findByName(@PathParam("name") String name) {
      List listaPersonalMantenimiento = null;
      
      if (ejbPersonalMantenimiento != null) {
        listaPersonalMantenimiento = ejbPersonalMantenimiento.findByName(name);
      }
      
      return listaPersonalMantenimiento;
    }
}
