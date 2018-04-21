
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
import ues.edu.sv.tpi135.entidades.Marca;
import ues.edu.sv.tpi135.persistencia.MarcaFacadeLocal;

/**
 *
 * @author esperanza
 */

@Path("/marca")
public class MarcaResources implements Serializable{
    @EJB
    private MarcaFacadeLocal ejbMarca;
    
    @Path("/findAll")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Marca> findAll(){
        List listaMarca = null;
        
        if (ejbMarca != null) {
            listaMarca =  ejbMarca.findAll();
        }
        
        return listaMarca;
    }
    
    @Path("/count")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Integer count(){
        int count = 0;
        
        if (ejbMarca != null) {
            count = ejbMarca.count();
        }
        return count;
    }
    
    @Path("/{idMarca}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Marca findById(@PathParam("idMarca") int idMarca){
        if (ejbMarca != null) {
            return ejbMarca.find(idMarca);
        }
        return new Marca();
    }
    
    @Path("/remove/{idMarca}")
    @DELETE
    public Response remove(@PathParam("idMarca") int idMarca){
        Response respuesta = Response.status(Response.Status.NOT_FOUND).build();
        if (ejbMarca != null) {
            Marca removeMarca = new Marca(idMarca);
            ejbMarca.remove(removeMarca);
            respuesta = Response.status(Response.Status.OK).build();
        }
        return respuesta;
    }
    
    @Path("/create/{idMarca}/{nombre}/{activo}")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(@PathParam("idMarca") int idMarca, @PathParam("nombre") String nombre, @PathParam("activo") boolean activo){       
        Response respuesta = Response.status(Response.Status.NOT_FOUND).build();
        if(ejbMarca != null){
            Marca newMarca = new Marca(idMarca, nombre, activo);
            ejbMarca.create(newMarca);
            respuesta = Response.status(Response.Status.CREATED).entity(newMarca).build();
        }
        return respuesta;
    }
}
