
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
import ues.edu.sv.mantenimientoTPI.acceso.DiagnosticoSoftwareFacadeLocal;
import ues.edu.sv.tpi135.entidades.DiagnosticoSoftware;

/**
 *
 * @author mateo
 */

@Path("/diagnosticoSoftware")
public class DiagnosticoSoftwareResource implements Serializable{
    @EJB
    private DiagnosticoSoftwareFacadeLocal ejbDiagnosticoSoftware;
    
    @Path("/findAll")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<DiagnosticoSoftware> findAll(){
        List listaDIagnosticoSoftware = null;
        
        if (ejbDiagnosticoSoftware != null) {
            listaDIagnosticoSoftware =  ejbDiagnosticoSoftware.findAll();
        }
        
        return listaDIagnosticoSoftware;
    }
    
    @Path("/count")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Integer count(){
        int count = 0;
        
        if (ejbDiagnosticoSoftware != null) {
            count = ejbDiagnosticoSoftware.count();
        }
        return count;
    }
    
    @Path("/{idOrdenTrabajo}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public DiagnosticoSoftware findById(@PathParam("idordeTrabajo") Integer idOrdenTrabajo){
        if (ejbDiagnosticoSoftware != null) {
            DiagnosticoSoftware diagnosticoSoftware = new DiagnosticoSoftware(idOrdenTrabajo);
            return ejbDiagnosticoSoftware.find(diagnosticoSoftware);
        }
        return new DiagnosticoSoftware();
    }
    
    @Path("/remove/{idOrdenTrabajo}")
    @DELETE
    public Response remove(@PathParam("idordeTrabajo") Integer idOrdenTrabajo){
        Response respuesta = Response.status(Response.Status.NOT_FOUND).build();
        if (ejbDiagnosticoSoftware != null) {
            DiagnosticoSoftware removeDiagnosticoSoftware = new DiagnosticoSoftware(idOrdenTrabajo);
            ejbDiagnosticoSoftware.remove(removeDiagnosticoSoftware);
            respuesta = Response.status(Response.Status.OK).build();
        }
        return respuesta;
    }
    
    @Path("/create/{idOrdenTrabajo}/{diagnostico}")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(@PathParam("idOrdenTrabajo") Integer idOrdenTrabajo, @PathParam("diagnostico") String diagnostico){       
        Response respuesta = Response.status(Response.Status.NOT_FOUND).build();
        if(ejbDiagnosticoSoftware != null){
            DiagnosticoSoftware newDiagnosticoSoftware = new DiagnosticoSoftware(idOrdenTrabajo, diagnostico);
            ejbDiagnosticoSoftware.create(newDiagnosticoSoftware);
            respuesta = Response.status(Response.Status.CREATED).entity(newDiagnosticoSoftware).build();
        }
        return respuesta;
    }
}
