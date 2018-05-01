
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
import ues.edu.sv.mantenimientoTPI.acceso.CalendarioFacadeLocal;
import ues.edu.sv.mantenimientoLib.Calendario;

/**
 *
 * @author mateo
 */
@Path("/calendario")
public class CalendarioResource implements Serializable{
    @EJB
    private CalendarioFacadeLocal ejbCalendario;
    
    @Path("/findAll")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Calendario> findAll(){
        List listaCalendario = null;
        if(ejbCalendario != null){
            listaCalendario =  ejbCalendario.findAll();
        }
        return listaCalendario;
    }
    
    @Path("/count")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Integer count(){
        int count = 0;
        if(ejbCalendario != null){
            count = ejbCalendario.count();
        }
        return count;
    }
    
    @Path("/{idCalendario}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Calendario findById(@PathParam("idCalendario") int idCalendario){
        if(ejbCalendario != null){
            Calendario calendario = new Calendario(idCalendario);
            return ejbCalendario.find(calendario);
        }
        return new Calendario();
    }
    
    @Path("/create/{fecha}/{idEquipo}")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(@PathParam("fecha") Date fecha, @PathParam("idEquipo") int idEquipo){
        Response respuesta = Response.status(Response.Status.NOT_FOUND).build();
        if(ejbCalendario != null){
            Calendario newCalendario = new Calendario(fecha, idEquipo);
            ejbCalendario.create(newCalendario);
            respuesta = Response.status(Response.Status.CREATED).entity(newCalendario).build();
        }
        
        return respuesta;
    } 
    
    @Path("/remove/{idCalendario}")
    @DELETE
    public Response remove(@PathParam("idEquipo") int idCalendario){
        Calendario removeCalendario = new Calendario(idCalendario);
        Response respuesta = Response.status(Response.Status.NOT_FOUND).build();
        if(ejbCalendario != null){
            ejbCalendario.remove(removeCalendario);
            respuesta = Response.status(Response.Status.OK).build();
        }
        return respuesta;
    }
    
    @Path("/{lower}/{higher}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Calendario> findRange(@PathParam("lower") int lower, @PathParam("higher") int higher) {
      List listaCalendario = null;
      if (ejbCalendario != null) {
        listaCalendario = ejbCalendario.findRange(lower, higher);
      }
      
      return listaCalendario;
    }
    
    @Path("/findByName/{name}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Calendario> findByName(@PathParam("name") String name) {
      List listaCalendario = null;
      
      if (ejbCalendario != null) {
        listaCalendario = ejbCalendario.findByName(name);
      }
      
      return listaCalendario;
    }
    
    @Path("/edit/{fecha}/{idEquipo}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response edit(@PathParam("fecha") Date fecha, @PathParam("idEquipo") int idEquipo){
        Response respuesta = Response.status(Response.Status.NOT_FOUND).build();
        if(ejbCalendario != null){
            Calendario editCalendario = new Calendario(fecha, idEquipo);
            ejbCalendario.edit(editCalendario);
            respuesta = Response.status(Response.Status.OK).build();
        }
        return respuesta;
    }
}
