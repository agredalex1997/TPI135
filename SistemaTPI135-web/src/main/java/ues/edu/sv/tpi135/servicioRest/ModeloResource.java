
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
import ues.edu.sv.mantenimientoTPI.acceso.ModeloFacadeLocal;
import ues.edu.sv.tpi135.entidades.Modelo;
import ues.edu.sv.tpi135.entidades.ModeloPK;

/**
 *
 * @author mateo
 */

@Path("/modelo")
public class ModeloResource implements Serializable{
    @EJB
    private ModeloFacadeLocal ejbModelo;
    
    @Path("/findAll")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Modelo> findAll(){
        List listaModelo = null;
        
        if (ejbModelo != null) {
            listaModelo =  ejbModelo.findAll();
        }
        
        return listaModelo;
    }
    
    @Path("/count")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Integer count(){
        int count = 0;
        
        if (ejbModelo != null) {
            count = ejbModelo.count();
        }
        return count;
    }
    
    @Path("/{idModelo}/{idMarca}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Modelo findById(@PathParam("idModelo") int idModelo, @PathParam("idMarca") int idMarca){
        if (ejbModelo != null) {
            ModeloPK modeloPk = new ModeloPK(idMarca, idMarca);
            return ejbModelo.find(modeloPk);
        }
        return new Modelo();
    }
    
    @Path("/remove/{idModelo}/{idMarca}")
    @DELETE
    public Response remove(@PathParam("idModelo") int idModelo, @PathParam("idMarca") int idMarca){
        Response respuesta = Response.status(Response.Status.NOT_FOUND).build();
        if (ejbModelo != null) {
            Modelo removeModelo = new Modelo(idMarca, idMarca);
            ejbModelo.remove(removeModelo);
            respuesta = Response.status(Response.Status.OK).build();
        }
        return respuesta;
    }
    
    @Path("/create/{idModelo}/{idMarca}/{nombre}")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(@PathParam("idModelo") int idModelo, @PathParam("idMarca") int idMarca, @PathParam("nombre") String nombre){       
        Response respuesta = Response.status(Response.Status.NOT_FOUND).build();
        if(ejbModelo != null){
            ModeloPK modeloPk = new ModeloPK(idMarca, idMarca);
            Modelo newModelo = new Modelo(modeloPk, nombre);
            ejbModelo.create(newModelo);
            respuesta = Response.status(Response.Status.CREATED).entity(newModelo).build();
        }
        return respuesta;
    }
}
