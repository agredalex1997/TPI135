
package ues.edu.sv.tpi135.servicioRest;

import java.io.Serializable;
import java.util.Date;
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
import ues.edu.sv.mantenimientoTPI.acceso.CalendarioFacadeLocal;
import ues.edu.sv.tpi135.entidades.Calendario;
import ues.edu.sv.tpi135.entidades.CalendarioPK;

/**
 *
 * @author mateo
 */
@Path("/calendario")
public class CalendarioResource implements Serializable{
    @EJB
    private CalendarioFacadeLocal ejbCalendario;
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Calendario> findAll(){
        List listaPasos = null;
        if(ejbCalendario != null){
            return ejbCalendario.findAll();
        }
        return listaPasos;
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
    
    @Path("/{fecha}/{idEquipo}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Calendario findById(@PathParam("fecha") Date fecha, @PathParam("idEquipo") int idEquipo){
        if(ejbCalendario != null){
            CalendarioPK calendarioPk = new CalendarioPK(fecha, idEquipo);
            return ejbCalendario.find(calendarioPk);
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
    
    @Path("/remove/{fecha}/{idEquipo}")
    @DELETE
    public Response remove(@PathParam("fecha") Date fecha, @PathParam("idEquipo") int idEquipo){
        Calendario removeCalendario = new Calendario(fecha, idEquipo);
        Response respuesta = Response.status(Response.Status.NOT_FOUND).build();
        if(ejbCalendario != null){
            ejbCalendario.remove(removeCalendario);
            respuesta = Response.status(Response.Status.OK).build();
        }
        return respuesta;
    }
}
