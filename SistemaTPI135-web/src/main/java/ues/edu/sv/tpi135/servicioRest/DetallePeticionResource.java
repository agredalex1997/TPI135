
package ues.edu.sv.tpi135.servicioRest;

import java.io.Serializable;
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
import ues.edu.sv.mantenimientoTPI.acceso.DetallePeticionFacadeLocal;
import ues.edu.sv.mantenimientoLib.DetallePeticion;
import ues.edu.sv.mantenimientoLib.Equipo;
import ues.edu.sv.mantenimientoLib.Peticion;


/**
 *
 * @author mateo
 */
@Path("detallePeticion")
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
    
    @Path("/{idDetallePeticion}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public DetallePeticion findById(@PathParam("idDetallePeticion") int idDetallePeticion){
        if (ejbDetallePeticion != null) {
            return ejbDetallePeticion.find(idDetallePeticion);
        }
        return new DetallePeticion();
    }
    
    @Path("/remove/{idDetallePeticion}")
    @DELETE
    public Response remove(@PathParam("idDetallePeticion") int idDetallePeticion){
        Response respuesta = Response.status(Response.Status.NOT_FOUND).build();
        if (ejbDetallePeticion != null) {
            DetallePeticion removeDetallePeticion = new DetallePeticion(idDetallePeticion);
            ejbDetallePeticion.remove(removeDetallePeticion);
            respuesta = Response.status(Response.Status.OK).build();
        }
        return respuesta;
    }
    
    @Path("/create/{idDetallePeticionPeticion}/{idPeticion}/{idEquipo}/{observaciones}")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(@PathParam("idDetallePeticion") Integer idDetallePeticon,@PathParam("idPeticion") Peticion idPeticion, @PathParam("idEquipo") Equipo idEquipo, @PathParam("obsevaciones") String obsevaciones){       
        Response respuesta = Response.status(Response.Status.NOT_FOUND).build();
        
        if(ejbDetallePeticion != null){
            DetallePeticion newDetallePeticion = new DetallePeticion(idDetallePeticon, idPeticion, idEquipo, obsevaciones);
            ejbDetallePeticion.create(newDetallePeticion);
            respuesta = Response.status(Response.Status.CREATED).entity(newDetallePeticion).build();
        }
        return respuesta;
    }
    
    @Path("/{lower}/{higher}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<DetallePeticion> findRange(@PathParam("lower") int lower, @PathParam("higher") int higher) {
      List listaDetallePeticion = null;
      if (ejbDetallePeticion != null) {
        listaDetallePeticion = ejbDetallePeticion.findRange(lower, higher);
      }
      
      return listaDetallePeticion;
    }
    
    @Path("/findByName/{name}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<DetallePeticion> findByName(@PathParam("name") String name) {
      List listaDetallePeticon = null;
      
      if (ejbDetallePeticion != null) {
        listaDetallePeticon = ejbDetallePeticion.findByName(name);
      }
      
      return listaDetallePeticon;
    }
    
    @Path("/edit/{idDetallePeticionPeticion}/{idPeticion}/{idEquipo}/{observaciones}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response edit(@PathParam("idDetallePeticion") Integer idDetallePeticon,@PathParam("idPeticion") Peticion idPeticion, @PathParam("idEquipo") Equipo idEquipo, @PathParam("obsevaciones") String obsevaciones){       
        Response respuesta = Response.status(Response.Status.NOT_FOUND).build();
        
        if(ejbDetallePeticion != null){
            DetallePeticion editDetallePeticion = new DetallePeticion(idDetallePeticon, idPeticion, idEquipo, obsevaciones);
            ejbDetallePeticion.edit(editDetallePeticion);
            respuesta = Response.status(Response.Status.OK).build();
        }
        return respuesta;
    }
}
