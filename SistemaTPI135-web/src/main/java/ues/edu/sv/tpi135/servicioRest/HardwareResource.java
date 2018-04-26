
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
import ues.edu.sv.mantenimientoTPI.acceso.HardwareFacadeLocal;
import ues.edu.sv.mantenimientoLib.Hardware;

/**
 *
 * @author mateo
 */

@Path("/hardware")
public class HardwareResource implements Serializable{
    @EJB
    private HardwareFacadeLocal ejbHardware;
    
    @Path("/findAll")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Hardware> findAll(){
        List listaHardware = null;
        
        if (ejbHardware != null) {
            listaHardware =  ejbHardware.findAll();
        }
        
        return listaHardware;
    }
    
    @Path("/count")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Integer count(){
        int count = 0;
        
        if (ejbHardware != null) {
            count = ejbHardware.count();
        }
        return count;
    }
    
    @Path("/{idHardware}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Hardware findById(@PathParam("idHardware") int idHardware){
        if (ejbHardware != null) {
            return ejbHardware.find(idHardware);
        }
        return new Hardware();
    }
    
    @Path("/remove/{idHardware}")
    @DELETE
    public Response remove(@PathParam("idHardware") int idHardware){
        Response respuesta = Response.status(Response.Status.NOT_FOUND).build();
        if (ejbHardware != null) {
            Hardware removeHardware = new Hardware(idHardware);
            ejbHardware.remove(removeHardware);
            respuesta = Response.status(Response.Status.OK).build();
        }
        return respuesta;
    }
    
    @Path("/create/{idHardware}/{nombre}")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(@PathParam("idHardware") int idHardware, @PathParam("nombre") String nombre){       
        Response respuesta = Response.status(Response.Status.NOT_FOUND).build();
        if(ejbHardware != null){
            Hardware newHardware = new Hardware(idHardware, nombre);
            ejbHardware.create(newHardware);
            respuesta = Response.status(Response.Status.CREATED).entity(newHardware).build();
        }
        return respuesta;
    }
    
    @Path("/{lower}/{higher}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Hardware> findRange(@PathParam("lower") int lower, @PathParam("higher") int higher) {
      List listaHardware = null;
      if (ejbHardware != null) {
        listaHardware = ejbHardware.findRange(lower, higher);
      }
      
      return listaHardware;
    }
    
    @Path("/findByName/{name}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Hardware> findByName(@PathParam("name") String name) {
      List listaHradware = null;
      
      if (ejbHardware != null) {
        listaHradware = ejbHardware.findByName(name);
      }
      
      return listaHradware;
    }
}
