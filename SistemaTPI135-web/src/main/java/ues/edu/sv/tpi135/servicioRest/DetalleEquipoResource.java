
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
import ues.edu.sv.mantenimientoTPI.acceso.DetalleEquipoFacadeLocal;
import ues.edu.sv.mantenimientoLib.DetalleEquipo;

/**
 *
 * @author mateo
 */

@Path("/detalleEquipo")
public class DetalleEquipoResource implements Serializable{
    @EJB
    private DetalleEquipoFacadeLocal ejbDetalleEquipo;
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<DetalleEquipo> findAll(){
        List listaPasos = null;
        if(ejbDetalleEquipo != null){
            return ejbDetalleEquipo.findAll();
        }
        return listaPasos;
    }
    
    @Path("/count")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Integer count(){
        int count = 0;
        if(ejbDetalleEquipo != null){
            count = ejbDetalleEquipo.count();
        }
        return count;
    }
    
    @Path("/{idEquipo}/{idHardware}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public DetalleEquipo findById(@PathParam("idEqipo") int idEquipo, @PathParam("idHardware") int idHardware){
        if(ejbDetalleEquipo != null){
            DetalleEquipo detalleEquipo = new DetalleEquipo(idEquipo, idHardware);
            return ejbDetalleEquipo.find(detalleEquipo);
        }
        return new DetalleEquipo();
    }
    
    @Path("/create/{idEquipo}/{idHardware}")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(@PathParam("idEqipo") int idEquipo, @PathParam("idHardware") int idHardware){
        Response respuesta = Response.status(Response.Status.NOT_FOUND).build();
        if(ejbDetalleEquipo != null){
            DetalleEquipo newDetalleEquipo = new DetalleEquipo(idEquipo, idHardware);
            ejbDetalleEquipo.create(newDetalleEquipo);
            respuesta = Response.status(Response.Status.CREATED).entity(newDetalleEquipo).build();
        }
        
        return respuesta;
    } 
    
    @Path("/remove/{idEquipo}/{idHardware}")
    @DELETE
    public Response remove(@PathParam("idEqipo") int idEquipo, @PathParam("idHardware") int idHardware){
        Response respuesta = Response.status(Response.Status.NOT_FOUND).build();
        if(ejbDetalleEquipo != null){
            DetalleEquipo removeDetalleEquipo = new DetalleEquipo(idEquipo, idHardware);
            ejbDetalleEquipo.remove(removeDetalleEquipo);
            respuesta = Response.status(Response.Status.OK).build();
        }
        return respuesta;
    }
    
    @Path("/{lower}/{higher}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<DetalleEquipo> findRange(@PathParam("lower") int lower, @PathParam("higher") int higher) {
      List listaDetalleEquipo = null;
      if (ejbDetalleEquipo != null) {
        listaDetalleEquipo = ejbDetalleEquipo.findRange(lower, higher);
      }
      return listaDetalleEquipo;
    }
    
    @Path("/findByName/{name}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<DetalleEquipo> findByName(@PathParam("name") String name) {
      List listaDetalleEquipo = null;
      
      if (ejbDetalleEquipo != null) {
        listaDetalleEquipo = ejbDetalleEquipo.findByName(name);
      }
      
      return listaDetalleEquipo;
    }
}
