
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
import ues.edu.sv.mantenimientoTPI.acceso.DetallePeticionFacadeLocal;
import ues.edu.sv.mantenimientoLib.DetallePeticion;


/**
 *
 * @author mateo
 */
@Path("detalleOrden")
public class DetallePeticionResource implements Serializable{
    
    @EJB
    private DetallePeticionFacadeLocal ejbDetallePeticion;
    
    @Path("/findAll")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<DetallePeticion> findAll(){
        List listaDetallePeticion = null;
        
        if (ejbDetallePeticion != null) {
            listaDetallePeticion =  ejbDetallePeticion.findAll();
        }
        
        return listaDetallePeticion;
    }
    
    @Path("/count")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Integer count(){
        int count = 0;
        
        if (ejbDetallePeticion != null) {
            count = ejbDetallePeticion.count();
        }
        return count;
    }
    /**
    @Path("/{idPeticion}/{idEquipo}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public DetallePeticion findById(@PathParam("idPeticion") int idPeticion, @PathParam("idEquipo") int idEquipo){
        if (ejbDetallePeticion != null) {
            DetallePeticionPK idDetallePeticion = new DetallePeticionPK(idPeticion, idEquipo);
            return ejbDetallePeticion.find(idDetallePeticion);
        }
        return new DetallePeticion();
    }
    
    @Path("/remove/{idPeticion}/{idEquipo}")
    @DELETE
    public Response remove(@PathParam("idPeticion") int idPeticion, @PathParam("idEquipo") int idEquipo){
        Response respuesta = Response.status(Response.Status.NOT_FOUND).build();
        if (ejbDetallePeticion != null) {
            DetallePeticion removeDetallePeticion = new DetallePeticion(idPeticion, idEquipo);
            ejbDetallePeticion.remove(removeDetallePeticion);
            respuesta = Response.status(Response.Status.OK).build();
        }
        return respuesta;
    }
    
    @Path("/create/{idPeticion}/{idEquipo}")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(@PathParam("idPeticion") int idPeticion, @PathParam("idEquipo") int idEquipo){       
        Response respuesta = Response.status(Response.Status.NOT_FOUND).build();
        
        if(ejbDetallePeticion != null){
            DetallePeticion newDetallePeticion = new DetallePeticion(idPeticion, idEquipo);
            ejbDetallePeticion.create(newDetallePeticion);
            respuesta = Response.status(Response.Status.CREATED).entity(newDetallePeticion).build();
        }
        return respuesta;
    }
    **/
}
