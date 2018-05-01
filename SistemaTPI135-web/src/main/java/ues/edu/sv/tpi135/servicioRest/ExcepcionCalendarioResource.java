
package ues.edu.sv.tpi135.servicioRest;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import ues.edu.sv.mantenimientoTPI.acceso.ExcepcionCalendarioFacadeLocal;
import ues.edu.sv.mantenimientoLib.ExcepcionCalendario;

/**
 *
 * @author mateo
 */

@Path("/excepcionCalendario")
public class ExcepcionCalendarioResource implements Serializable{
    @EJB
    private ExcepcionCalendarioFacadeLocal ejbExcepcionCalendario;
    
    @Path("/findAll")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<ExcepcionCalendario> findAll(){
        List listaExcepcion = null;
        
        if (ejbExcepcionCalendario != null) {
            listaExcepcion =  ejbExcepcionCalendario.findAll();
        }
        
        return listaExcepcion;
    }
    
    @Path("/count")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Integer count(){
        int count = 0;
        
        if (ejbExcepcionCalendario != null) {
            count = ejbExcepcionCalendario.count();
        }
        return count;
    }
    
    @Path("/{fecha}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ExcepcionCalendario findById(@PathParam("fecha") Date fecha){
        if (ejbExcepcionCalendario != null) {
            return ejbExcepcionCalendario.find(fecha);
        }
        return new ExcepcionCalendario();
    }
    
    @Path("/remove/{fecha}")
    @DELETE
    public Response remove(@PathParam("fecha") Date fecha){
        Response respuesta = Response.status(Response.Status.NOT_FOUND).build();
        if (ejbExcepcionCalendario != null) {
            ExcepcionCalendario removeExcepcionCalendario = new ExcepcionCalendario(fecha);
            ejbExcepcionCalendario.remove(removeExcepcionCalendario);
            respuesta = Response.status(Response.Status.OK).build();
        }
        return respuesta;
    }
    
    @Path("/create/{fecha}/{descripcion}")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(@PathParam("fecha") Date fecha, @PathParam("descripcion") String descripcion){       
        Response respuesta = Response.status(Response.Status.NOT_FOUND).build();
        if(ejbExcepcionCalendario != null){
            ExcepcionCalendario newExcepcionCalendario = new ExcepcionCalendario(fecha, descripcion);
            ejbExcepcionCalendario.create(newExcepcionCalendario);
            respuesta = Response.status(Response.Status.CREATED).entity(newExcepcionCalendario).build();
        }
        return respuesta;
    }
    
    @Path("/{lower}/{higher}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<ExcepcionCalendario> findRange(@PathParam("lower") int lower, @PathParam("higher") int higher) {
      List listaExcepcionCalendario = null;
      if (ejbExcepcionCalendario != null) {
        listaExcepcionCalendario = ejbExcepcionCalendario.findRange(lower, higher);
      }
      
      return listaExcepcionCalendario;
    }
    
    @Path("/findByName/{name}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<ExcepcionCalendario> findByName(@PathParam("name") String name) {
      List listaExcepcionCalendario = null;
      
      if (ejbExcepcionCalendario != null) {
        listaExcepcionCalendario = ejbExcepcionCalendario.findByName(name);
      }
      
      return listaExcepcionCalendario;
    }
    
    @Path("/edit/{fecha}/{descripcion}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response edit(@PathParam("fecha") Date fecha, @PathParam("descripcion") String descripcion){       
        Response respuesta = Response.status(Response.Status.NOT_FOUND).build();
        if(ejbExcepcionCalendario != null){
            ExcepcionCalendario editExcepcionCalendario = new ExcepcionCalendario(fecha, descripcion);
            ejbExcepcionCalendario.edit(editExcepcionCalendario);
            respuesta = Response.status(Response.Status.OK).build();
        }
        return respuesta;
    }
}
