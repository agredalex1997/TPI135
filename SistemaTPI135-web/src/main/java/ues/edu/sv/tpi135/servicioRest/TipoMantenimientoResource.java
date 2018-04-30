
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
import ues.edu.sv.mantenimientoTPI.acceso.TipoMantenimientoFacadeLocal;
import ues.edu.sv.mantenimientoLib.TipoMantenimiento;

/**
 *
 * @author mateo
 */

@Path("/tipoMantenimiento")
public class TipoMantenimientoResource implements Serializable{
    @EJB
    private TipoMantenimientoFacadeLocal ejbTipomantenimiento;
    
    @Path("/findAll")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<TipoMantenimiento> findAll(){
        List listaTipoMantenimiento = null;
        if(ejbTipomantenimiento != null){
            listaTipoMantenimiento = ejbTipomantenimiento.findAll();
        }
        return listaTipoMantenimiento;
    }
    
    @Path("/count")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Integer count(){
        int count = 0;
        if(ejbTipomantenimiento != null){
            count = ejbTipomantenimiento.count();
        }
        return count;
    }
    
    @Path("/{idTipoMantenimiento}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public TipoMantenimiento findById(@PathParam("idTipoMantenimiento") Integer idTipoMantenimiento){
        if(ejbTipomantenimiento != null){
            return ejbTipomantenimiento.find(idTipoMantenimiento);
        }
        return new TipoMantenimiento();
    }
    
    @Path("/create/{idTipoMantenimiento}/{nombre}/{descripcion}")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(@PathParam("idTipoMantenimiento") Integer idTipoMantenimiento, @PathParam("nombre") String nombre, @PathParam("descripcion") String descripcion){
        Response respuesta = Response.status(Response.Status.NOT_FOUND).build();
        if(ejbTipomantenimiento != null){
            TipoMantenimiento newTipoMtt = new TipoMantenimiento(idTipoMantenimiento, nombre, descripcion);
            ejbTipomantenimiento.create(newTipoMtt);
            respuesta = Response.status(Response.Status.CREATED).entity(newTipoMtt).build();
        }
        return respuesta;
    }
    
    @Path("/remove/{idTipoMantenimiento}")
    @DELETE
    public Response remove(@PathParam("idTipoMantenimiento") Integer idTipoMantenimiento){
        Response respuesta = Response.status(Response.Status.NOT_FOUND).build();
        if(ejbTipomantenimiento != null){
            TipoMantenimiento removeTipoMtt = new TipoMantenimiento(idTipoMantenimiento);
            ejbTipomantenimiento.remove(removeTipoMtt);
            respuesta = Response.status(Response.Status.OK).build();
        }
        return respuesta;
    }
    
    @Path("/{lower}/{higher}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<TipoMantenimiento> findRange(@PathParam("lower") int lower, @PathParam("higher") int higher) {
      List listaTipoMantenimiento = null;
      if (ejbTipomantenimiento != null) {
        listaTipoMantenimiento = ejbTipomantenimiento.findRange(lower, higher);
      }
      
      return listaTipoMantenimiento;
    }
    
    @Path("/findByName/{name}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<TipoMantenimiento> findByName(@PathParam("name") String name) {
      List listaTIpoMantenimiento = null;
      
      if (ejbTipomantenimiento != null) {
        listaTIpoMantenimiento = ejbTipomantenimiento.findByName(name);
      }
      
      return listaTIpoMantenimiento;
    }
}