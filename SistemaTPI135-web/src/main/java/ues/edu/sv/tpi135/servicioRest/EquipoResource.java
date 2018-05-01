
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
import ues.edu.sv.mantenimientoTPI.acceso.EquipoFacadeLocal;
import ues.edu.sv.mantenimientoLib.Equipo;

/**
 *
 * @author mateo
 */

@Path("/equipo")
public class EquipoResource implements Serializable{
    @EJB
    private EquipoFacadeLocal ejbEquipo;
    
    @Path("/findAll")
    @GET
    @Produces(MediaType.APPLICATION_JSON)    
    public List<Equipo> findAll(){
        List listaEquipo = null;
        
        if (ejbEquipo != null) {
            listaEquipo =  ejbEquipo.findAll();
        }
        
        return listaEquipo;
    }
    
    @Path("/count")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Integer count(){
        int count = 0;
        
        if (ejbEquipo != null) {
            count = ejbEquipo.count();
        }
        return count;
    }
    
    @Path("/{idEquipo}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Equipo findById(@PathParam("idEquipo") Integer idEquipo){
        if (ejbEquipo != null) {
            return ejbEquipo.find(idEquipo);
        }
        return new Equipo();
    }
    
    @Path("/remove/{idEquipo}")
    @DELETE
    public Response remove(@PathParam("idEquipo") Integer idEquipo){
        Response respuesta = Response.status(Response.Status.NOT_FOUND).build();
        if (ejbEquipo != null) {
            Equipo removedEquipo = new Equipo(idEquipo);
            ejbEquipo.remove(removedEquipo);
            respuesta = Response.status(Response.Status.OK).build();
        }
        return respuesta;
    }
    
    @Path("/create/{idEquipo}/{os}/{licencia}")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(@PathParam("idEquipo") int idEquipo, @PathParam("os") String os, @PathParam("licencia") boolean licencia){       
        Response respuesta = Response.status(Response.Status.NOT_FOUND).build();
        if(ejbEquipo != null){
            Equipo newEquipo = new Equipo(idEquipo, os, licencia);
            ejbEquipo.create(newEquipo);
            respuesta = Response.status(Response.Status.CREATED).entity(newEquipo).build();   
        }
        return respuesta;
    }
    
    @Path("/{lower}/{higher}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Equipo> findRange(@PathParam("lower") int lower, @PathParam("higher") int higher) {
      List listaEquipo = null;
      if (ejbEquipo != null) {
        listaEquipo = ejbEquipo.findRange(lower, higher);
      }
      
      return listaEquipo;
    }
    
    @Path("/findByName/{name}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Equipo> findByName(@PathParam("name") String name) {
      List listaEquipo = null;
      
      if (ejbEquipo != null) {
        listaEquipo = ejbEquipo.findByName(name);
      }
      
      return listaEquipo;
    }
    
    @Path("/edit/{idEquipo}/{os}/{licencia}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response edit(@PathParam("idEquipo") int idEquipo, @PathParam("os") String os, @PathParam("licencia") boolean licencia){       
        Response respuesta = Response.status(Response.Status.NOT_FOUND).build();
        if(ejbEquipo != null){
            Equipo editEquipo = new Equipo(idEquipo, os, licencia);
            ejbEquipo.edit(editEquipo);
            respuesta = Response.status(Response.Status.OK).build();   
        }
        return respuesta;
    }
}
