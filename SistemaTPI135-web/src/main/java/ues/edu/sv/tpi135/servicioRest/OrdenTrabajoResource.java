
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
import ues.edu.sv.mantenimientoTPI.acceso.OrdenTrabajoFacadeLocal;
import ues.edu.sv.tpi135.entidades.OrdenTrabajo;

/**
 *
 * @author mateo
 */

@Path("/ordenTrabajo")
public class OrdenTrabajoResource implements Serializable{
    @EJB
    private OrdenTrabajoFacadeLocal ejbOrdenTrabajo;
    
    @Path("/findAll")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<OrdenTrabajo> findAll(){
        List listaOrdenTrabajo = null;
        
        if (ejbOrdenTrabajo != null) {
            listaOrdenTrabajo =  ejbOrdenTrabajo.findAll();
        }
        
        return listaOrdenTrabajo;
    }
    
    @Path("/count")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Integer count(){
        int count = 0;
        
        if (ejbOrdenTrabajo != null) {
            count = ejbOrdenTrabajo.count();
        }
        return count;
    }
    
    @Path("/{idOrdenTrabajo}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public OrdenTrabajo findById(@PathParam("idOrdenTrabajoPK") Integer idOrdenTrabajo){
        if (ejbOrdenTrabajo != null) {
            return ejbOrdenTrabajo.find(idOrdenTrabajo);
        }
        return new OrdenTrabajo();
    }
    
    @Path("/remove/{idOrdenTrabajo}")
    @DELETE
    public Response remove(@PathParam("idOrdenTrabajo") Integer idOrdenTrabajo){
        Response respuesta = Response.status(Response.Status.NOT_FOUND).build();
        if (ejbOrdenTrabajo != null) {
            OrdenTrabajo removedOrdenTrabajo = new OrdenTrabajo(idOrdenTrabajo);
            ejbOrdenTrabajo.remove(removedOrdenTrabajo);
            respuesta = Response.status(Response.Status.OK).build();
        }
        return respuesta;
    }
    @Path("/create/{idOrdenTrabajo}/{fecha}")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(@PathParam("idOrdenTrabajo") Integer idOrdenTrabajo, @PathParam("fecha") Date fecha){       
        Response respuesta = Response.status(Response.Status.NOT_FOUND).build();
        if(ejbOrdenTrabajo != null){
            OrdenTrabajo newOrdenTrabajo = new OrdenTrabajo(idOrdenTrabajo, fecha);
            ejbOrdenTrabajo.create(newOrdenTrabajo);
            respuesta = Response.status(Response.Status.CREATED).entity(newOrdenTrabajo).build();
        }
        
        return respuesta;
    }
}
