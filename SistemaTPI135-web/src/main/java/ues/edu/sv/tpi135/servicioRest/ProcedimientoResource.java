
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
import ues.edu.sv.mantenimientoTPI.acceso.ProcedimientoFacadeLocal;
import ues.edu.sv.mantenimientoLib.Procedimiento;

/**
 *
 * @author mateo
 */

@Path("/procedimiento")
public class ProcedimientoResource implements Serializable{
    @EJB
    private ProcedimientoFacadeLocal ejbProcedimiento;
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Procedimiento> FindAll(){
        List listaProcedimiento = null;
        if(ejbProcedimiento != null){
            listaProcedimiento = ejbProcedimiento.findAll();
        }
        return listaProcedimiento;
    }
    
    @Path("/count")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Integer count(){
        int count = 0;
        if(ejbProcedimiento != null){
            count = ejbProcedimiento.count();
        }
        return count;
    }
    
    @Path("/{idProcedimiento}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Procedimiento FindById(@PathParam("idProcedimiento") Integer idPocedimiento){
        if(ejbProcedimiento != null){
            return ejbProcedimiento.find(idPocedimiento);
        }
        return new Procedimiento();
    }
    
    @Path("/remove/{idProcedimiento}")
    @DELETE
    public Response remove(@PathParam("idProcedimiento") Integer idProcedimiento){
        Procedimiento removeProcedimiento = new Procedimiento(idProcedimiento);
        Response respuesta = Response.status(Response.Status.NOT_FOUND).build();
        if(ejbProcedimiento != null){
            ejbProcedimiento.remove(removeProcedimiento);
            respuesta = Response.status(Response.Status.OK).build();
        }
        return respuesta;
    }
    
    @Path("/create/{idProcedimiento}/{nombre}/{descripcion}")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(@PathParam("idProcedimiento") Integer idProcedimiento,@PathParam("nombre") String nombre, @PathParam("descripcion") String descripcion){
        Response respuesta = Response.status(Response.Status.NOT_FOUND).build();
        if(ejbProcedimiento != null){
            Procedimiento newProcedimiento = new Procedimiento(idProcedimiento, nombre, descripcion);
            ejbProcedimiento.create(newProcedimiento);
            respuesta = Response.status(Response.Status.CREATED).entity(newProcedimiento).build();
        }
        
        return respuesta;
    }
    
    @Path("/{lower}/{higher}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Procedimiento> findRange(@PathParam("lower") int lower, @PathParam("higher") int higher) {
      List listaProcedimiento = null;
      if (ejbProcedimiento != null) {
        listaProcedimiento = ejbProcedimiento.findRange(lower, higher);
      }
      
      return listaProcedimiento;
    }
    
    @Path("/findByName/{name}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Procedimiento> findByName(@PathParam("name") String name) {
      List listaProcedimiento = null;
      
      if (ejbProcedimiento != null) {
        listaProcedimiento = ejbProcedimiento.findByName(name);
      }
      
      return listaProcedimiento;
    }
}
