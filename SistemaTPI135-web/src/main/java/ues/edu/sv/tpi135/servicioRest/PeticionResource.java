
package ues.edu.sv.tpi135.servicioRest;

import java.io.Serializable;
import java.util.Date;
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
import ues.edu.sv.mantenimientoTPI.acceso.PeticionFacadeLocal;
import ues.edu.sv.tpi135.entidades.Peticion;

/**
 *
 * @author mateo
 */

@Path("/peticion")
public class PeticionResource implements Serializable{
    @EJB
    private PeticionFacadeLocal ejbPeticion;
    
    @Path("/findAll")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Peticion> findAll(){
        List listaPeticion = null;
        
        if (ejbPeticion != null) {
            listaPeticion =  ejbPeticion.findAll();
        }
        
        return listaPeticion;
    }
    
    @Path("/count")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Integer count(){
        int count = 0;
        
        if (ejbPeticion != null) {
            count = ejbPeticion.count();
        }
        return count;
    }
    
    @Path("/{idPeticion}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Peticion findById(@PathParam("idPeticion") Integer idPeticion){
        if (ejbPeticion != null) {
            return ejbPeticion.find(idPeticion);
        }
        return new Peticion();
    }
    
    @Path("/remove/{idPeticion}}")
    @DELETE
    public Response remove(@PathParam("idPeticion") Integer idPeticion){
        Response respuesta = Response.status(Response.Status.NOT_FOUND).build();
        if (ejbPeticion != null) {
            Peticion removedPeticion = new Peticion(idPeticion);
            ejbPeticion.remove(removedPeticion);
            respuesta = Response.status(Response.Status.OK).build();
        }
        return respuesta;
    }
    @Path("/create/{idPeticion}/{fecha}")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(@PathParam("idPeticion") Integer idPeticion, @PathParam("fecha") Date fecha){       
        Response respuesta = Response.status(Response.Status.NOT_FOUND).build();
        if(ejbPeticion != null){
            Peticion newPeticion = new Peticion(idPeticion, fecha);
            ejbPeticion.create(newPeticion);
            respuesta = Response.status(Response.Status.CREATED).entity(newPeticion).build();
        }
        
        return respuesta;
    }
}
