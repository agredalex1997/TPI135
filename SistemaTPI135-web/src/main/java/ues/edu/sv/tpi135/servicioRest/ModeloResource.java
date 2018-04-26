
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
import ues.edu.sv.mantenimientoLib.Marca;
import ues.edu.sv.mantenimientoTPI.acceso.ModeloFacadeLocal;
import ues.edu.sv.mantenimientoLib.Modelo;


/**
 *
 * @author mateo
 */

@Path("/modelo")
public class ModeloResource implements Serializable{
    @EJB
    private ModeloFacadeLocal ejbModelo;
    
    @Path("/findAll")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Modelo> findAll(){
        List listaModelo = null;
        
        if (ejbModelo != null) {
            listaModelo =  ejbModelo.findAll();
        }
        
        return listaModelo;
    }
    
    @Path("/count")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Integer count(){
        int count = 0;
        
        if (ejbModelo != null) {
            count = ejbModelo.count();
        }
        return count;
    }
    
    @Path("/{idModelo}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Modelo findById(@PathParam("idModelo") Integer idModelo){
        if (ejbModelo != null) {
            return ejbModelo.find(idModelo);
        }
        return new Modelo();
    }
    
    @Path("/remove/{idModelo}")
    @DELETE
    public Response remove(@PathParam("idModelo") Integer idModelo){
        Response respuesta = Response.status(Response.Status.NOT_FOUND).build();
        if (ejbModelo != null) {
            Modelo removeModelo = new Modelo(idModelo);
            ejbModelo.remove(removeModelo);
            respuesta = Response.status(Response.Status.OK).build();
        }
        return respuesta;
    }
    
    @Path("/create/{idModelo}/{idMarca}/{nombre}/{observaciones}")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(@PathParam("idModelo") Integer idModelo,@PathParam("idMarca") Marca idMarca, @PathParam("nombre") String nombre, @PathParam("observaciones") String observaciones){       
        Response respuesta = Response.status(Response.Status.NOT_FOUND).build();
        if(ejbModelo != null){
            Modelo newModelo = new Modelo(idModelo, idMarca, nombre, observaciones);
            ejbModelo.create(newModelo);
            respuesta = Response.status(Response.Status.CREATED).entity(newModelo).build();
        }
        return respuesta;
    }
    
    @Path("/{lower}/{higher}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Modelo> findRange(@PathParam("lower") int lower, @PathParam("higher") int higher) {
      List listaModelo = null;
      if (ejbModelo != null) {
        listaModelo = ejbModelo.findRange(lower, higher);
      }
      
      return listaModelo;
    }
    
    @Path("/findByName/{name}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Modelo> findByName(@PathParam("name") String name) {
      List listaModelo = null;
      
      if (ejbModelo != null) {
        listaModelo = ejbModelo.findByName(name);
      }
      
      return listaModelo;
    }
    
}
