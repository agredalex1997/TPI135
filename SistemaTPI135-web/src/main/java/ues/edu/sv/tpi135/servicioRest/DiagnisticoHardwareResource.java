
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
import ues.edu.sv.mantenimientoTPI.acceso.DiagnosticoHardwareFacadeLocal;
import ues.edu.sv.mantenimientoLib.DiagnosticoHardware;

/**
 *
 * @author mateo
 */

@Path("/diagnosticoHardware")
public class DiagnisticoHardwareResource implements Serializable{
    @EJB
    private DiagnosticoHardwareFacadeLocal ejbDiagnosticoHardware;
    
    @Path("/findAll")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<DiagnosticoHardware> findAll(){
        List listaDIagnosticoHardware = null;
        
        if (ejbDiagnosticoHardware != null) {
            listaDIagnosticoHardware =  ejbDiagnosticoHardware.findAll();
        }
        
        return listaDIagnosticoHardware;
    }
    
    @Path("/count")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Integer count(){
        int count = 0;
        
        if (ejbDiagnosticoHardware != null) {
            count = ejbDiagnosticoHardware.count();
        }
        return count;
    }
    
    @Path("/{idOrdenTrabajo}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public DiagnosticoHardware findById(@PathParam("idordeTrabajo") Integer idOrdenTrabajo){
        if (ejbDiagnosticoHardware != null) {
            DiagnosticoHardware diagnosticoHardware = new DiagnosticoHardware(idOrdenTrabajo);
            return ejbDiagnosticoHardware.find(diagnosticoHardware);
        }
        return new DiagnosticoHardware();
    }
    
    @Path("/remove/{idOrdenTrabajo}")
    @DELETE
    public Response remove(@PathParam("idordeTrabajo") Integer idOrdenTrabajo){
        Response respuesta = Response.status(Response.Status.NOT_FOUND).build();
        if (ejbDiagnosticoHardware != null) {
            DiagnosticoHardware removeDiagnosticoHardware = new DiagnosticoHardware(idOrdenTrabajo);
            ejbDiagnosticoHardware.remove(removeDiagnosticoHardware);
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
        if(ejbDiagnosticoHardware != null){
            DiagnosticoHardware newDiagnosticoHardware = new DiagnosticoHardware(idOrdenTrabajo, diagnostico);
            ejbDiagnosticoHardware.create(newDiagnosticoHardware);
            respuesta = Response.status(Response.Status.CREATED).entity(newDiagnosticoHardware).build();
        }
        return respuesta;
    }
}
