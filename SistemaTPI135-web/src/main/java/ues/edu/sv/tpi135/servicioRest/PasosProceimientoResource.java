
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
import ues.edu.sv.mantenimientoTPI.acceso.PasosProcedimientoFacadeLocal;
import ues.edu.sv.tpi135.entidades.PasosProcedimiento;

/**
 *
 * @author mateo
 */

@Path("pasosProcedimiento")
public class PasosProceimientoResource implements Serializable{
    @EJB
    private PasosProcedimientoFacadeLocal ejbPasosPrecedimiento;
    
    @Path("/findAll")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<PasosProcedimiento> findAll(){
        List listaPasosProcedimientos = null;
        
        if (ejbPasosPrecedimiento != null) {
            listaPasosProcedimientos =  ejbPasosPrecedimiento.findAll();
        }
        
        return listaPasosProcedimientos;
    }
    
    @Path("/count")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Integer count(){
        int count = 0;
        
        if (ejbPasosPrecedimiento != null) {
            count = ejbPasosPrecedimiento.count();
        }
        return count;
    }
    
    @Path("/{idProcedimineto}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public PasosProcedimiento findById(@PathParam("idProcedimiento") Integer idProcedimiento){
        if (ejbPasosPrecedimiento != null) {
            return ejbPasosPrecedimiento.find(idProcedimiento);
        }
        return new PasosProcedimiento();
    }
    
    @Path("/remove/{idProcedimineto}")
    @DELETE
    public Response remove(@PathParam("idProcedimiento") Integer idProcedimiento){
        Response respuesta = Response.status(Response.Status.NOT_FOUND).build();
        if (ejbPasosPrecedimiento != null) {
            PasosProcedimiento removePasosProcedimiento = new PasosProcedimiento(idProcedimiento);
            ejbPasosPrecedimiento.remove(removePasosProcedimiento);
            respuesta = Response.status(Response.Status.OK).build();
        }
        return respuesta;
    }
    
    @Path("/create/{idProcedimineto}/{idCorrelativo}")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(@PathParam("idProcedimiento") Integer idProcedimiento, @PathParam("idCorrelativo") int idCorrelativo){       
        Response respuesta = Response.status(Response.Status.NOT_FOUND).build();
        if(ejbPasosPrecedimiento != null){
            PasosProcedimiento newPasosProcedimiento = new PasosProcedimiento(idProcedimiento, idCorrelativo);
            ejbPasosPrecedimiento.create(newPasosProcedimiento);
            respuesta = Response.status(Response.Status.CREATED).entity(newPasosProcedimiento).build();
        }
        return respuesta;
    }
}
