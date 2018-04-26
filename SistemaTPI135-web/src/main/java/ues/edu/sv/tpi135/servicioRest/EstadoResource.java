
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
import ues.edu.sv.mantenimientoTPI.acceso.EstadoFacadeLocal;
import ues.edu.sv.mantenimientoLib.Estado;

/**
 *
 * @author mateo
 */

@Path("/estado")
public class EstadoResource implements Serializable{
    @EJB
    private EstadoFacadeLocal ejbEstado;
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Estado> findAll(){
        List listaEstado = null;
        if(ejbEstado != null){
            listaEstado = ejbEstado.findAll();
        }
        return listaEstado;
    }
    
    @Path("/count")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Integer count(){
        int count = 0;
        if(ejbEstado != null){
            count = ejbEstado.count();
        }
        return count;
    }
    
    @Path("/{idEstado}")
    @GET 
    @Produces(MediaType.APPLICATION_JSON)
    public Estado findById(@PathParam("idEstado") int idEstado){
        if(ejbEstado != null){
            return ejbEstado.find(idEstado);
        }
        return new Estado();
    }
    
    @Path("/create/{idEstado}/{nombre}/{descripcion}")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(@PathParam("idEstado") int idEstado, @PathParam("nombre") String nombre, @PathParam("descripcion") String descripcion){
        Response respuesta = Response.status(Response.Status.NOT_FOUND).build();
        if(ejbEstado != null){
            Estado newEstado = new Estado(idEstado, nombre, descripcion);
            ejbEstado.create(newEstado);
            respuesta = Response.status(Response.Status.CREATED).entity(newEstado).build();
        }
        return respuesta;
    }
    
    @Path("/remove/{idEstado}")
    @DELETE
    public Response remove(@PathParam("idEstado") int idEstado){
        Response respuesta = Response.status(Response.Status.NOT_FOUND).build();
        if(ejbEstado != null){
            Estado removeEstado = new Estado(idEstado);
            ejbEstado.remove(removeEstado);
            respuesta = Response.status(Response.Status.OK).build();
        }
        return respuesta;
    }
    
    @Path("/{lower}/{higher}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Estado> findRange(@PathParam("lower") int lower, @PathParam("higher") int higher) {
      List listaEstado = null;
      if (ejbEstado != null) {
        listaEstado = ejbEstado.findRange(lower, higher);
      }
      
      return listaEstado;
    }
    
    @Path("/findByName/{name}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Estado> findByName(@PathParam("name") String name) {
      List listaEstado = null;
      
      if (ejbEstado != null) {
        listaEstado = ejbEstado.findByName(name);
      }
      
      return listaEstado;
    }
}
