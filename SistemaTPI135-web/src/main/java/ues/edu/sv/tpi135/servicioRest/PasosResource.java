
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
import ues.edu.sv.tpi135.entidades.Pasos;
import ues.edu.sv.tpi135.persistencia.PasosFacadeLocal;

/**
 *
 * @author mateo
 */

@Path("/pasos")
public class PasosResource implements Serializable{
    @EJB
    private PasosFacadeLocal ejbPasos;
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Pasos> findAll(){
        List listaPasos = null;
        if(ejbPasos != null){
            return ejbPasos.findAll();
        }
        return listaPasos;
    }
    
    @Path("/count")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Integer count(){
        int count = 0;
        if(ejbPasos != null){
            count = ejbPasos.count();
        }
        return count;
    }
    
    @Path("/{idPaso}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Pasos findById(@PathParam("idPaso") Integer idPaso){
        if(ejbPasos != null){
            return ejbPasos.find(idPaso);
        }
        return new Pasos();
    }
    
    @Path("/create/{idPaso}/{nombre}/{descripcion}")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(@PathParam("idPaso") Integer idPaso, @PathParam("nombre") String nombre, @PathParam("descripcion") String descripcion){
        Response respuesta = Response.status(Response.Status.NOT_FOUND).build();
        if(ejbPasos != null){
            Pasos newPaso = new Pasos(idPaso, nombre, descripcion);
            ejbPasos.create(newPaso);
            respuesta = Response.status(Response.Status.CREATED).entity(newPaso).build();
        }
        return respuesta;
    } 
    
    @Path("/remove/{idPaso}")
    @DELETE
    public Response remove(@PathParam("idPaso") Integer idPaso){
        Response respuesta = Response.status(Response.Status.NOT_FOUND).build();
        if(ejbPasos != null){
            Pasos removePaso = new Pasos(idPaso);
            ejbPasos.remove(removePaso);
            respuesta = Response.status(Response.Status.OK).build();
        }
        return respuesta;
    }
}
