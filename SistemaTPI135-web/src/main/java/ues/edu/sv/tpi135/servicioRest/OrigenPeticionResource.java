
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
import ues.edu.sv.tpi135.entidades.OrigenPeticion;
import ues.edu.sv.tpi135.persistencia.OrigenPeticionFacadeLocal;

/**
 *
 * @author mateo
 */

@Path("/origenPeticion")
public class OrigenPeticionResource implements Serializable{
    @EJB
    private OrigenPeticionFacadeLocal ejbOrigenPeticion;
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<OrigenPeticion> findAll(){
        List listaOrigenPeticion = null;
        if(ejbOrigenPeticion != null){
            return ejbOrigenPeticion.findAll();
        }
        return listaOrigenPeticion;
    }
    
    @Path("/count")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Integer count(){
        int count = 0;
        if(ejbOrigenPeticion != null){
            count =  ejbOrigenPeticion.count();
        }
        return count;
    }
    
    @Path("/{idOrigenPeticion}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public OrigenPeticion findById(@PathParam("idOrigenPeticion") Integer idOrigenPeticion){
        if(ejbOrigenPeticion != null){
            return ejbOrigenPeticion.find(idOrigenPeticion);
        }
        return new OrigenPeticion();
    }
    
    @Path("/remove/{idOrigen}")
    @DELETE
    public Response remove(@PathParam("idOrigen") Integer idOrigen){
        Response respuesta = Response.status(Response.Status.NOT_FOUND).build();
        if(ejbOrigenPeticion != null){
            OrigenPeticion removeOrigenPeticion = new OrigenPeticion(idOrigen);
            ejbOrigenPeticion.remove(removeOrigenPeticion);
            respuesta = Response.status(Response.Status.OK).build();
        }
        return respuesta;
    }
    
    @Path("/create/{idOrigen}/{nombre}")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(@PathParam("idOrigen") Integer idOrigen, @PathParam("nombre") String nombre){
        Response respuesta = Response.status(Response.Status.NOT_FOUND).build();
        if(ejbOrigenPeticion != null){
            OrigenPeticion newOrigenPeticion = new OrigenPeticion(idOrigen, nombre);
            ejbOrigenPeticion.create(newOrigenPeticion);
            respuesta = Response.status(Response.Status.CREATED).entity(newOrigenPeticion).build();
        }
        return respuesta;
    }
}
