
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
import ues.edu.sv.mantenimientoTPI.acceso.AreaFacadeLocal;
import ues.edu.sv.mantenimientoLib.Area;

/**
 *
 * @author mateo
 */

@Path("/area")
public class AreaResource implements Serializable{
    
    @EJB
    private AreaFacadeLocal ejbArea;
    
    @Path("/findAll")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Area> findAll(){
        List listaArea = null;
        
        if (ejbArea != null) {
            listaArea =  ejbArea.findAll();
        }
        
        return listaArea;
    }
    
    @Path("/count")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Integer count(){
        int count = 0;
        
        if (ejbArea != null) {
            count = ejbArea.count();
        }
        return count;
    }
    
    @Path("/{idArea}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Area findById(@PathParam("idArea") Integer idArea){
        if (ejbArea != null) {
            return ejbArea.find(idArea);
        }
        return new Area();
    }
    
    @Path("/remove/{idArea}")
    @DELETE
    public Response remove(@PathParam("idArea") Integer idArea){
        Response respuesta = Response.status(Response.Status.NOT_FOUND).build();
        if (ejbArea != null) {
            Area removedArea = new Area(idArea);
            ejbArea.remove(removedArea);
            respuesta = Response.status(Response.Status.OK).build();
        }
        return respuesta;
    }
    
    @Path("/create/{idArea}/{nombreArea}")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(@PathParam("idArea") int idArea, @PathParam("nombreArea") String nombreArea){       
        Response respuesta = Response.status(Response.Status.NOT_FOUND).build();
        if(ejbArea != null){
            Area newArea = new Area(idArea, nombreArea);
            ejbArea.create(newArea);
            respuesta = Response.status(Response.Status.CREATED).entity(newArea).build();
        }
        return respuesta;
    }
    
}
