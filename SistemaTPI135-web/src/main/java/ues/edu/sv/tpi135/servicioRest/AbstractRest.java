/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.edu.sv.tpi135.servicioRest;

import java.io.Serializable;
import java.util.List;
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
import ues.edu.sv.mantenimientoTPI.acceso.AbstractFacadeInterface;

/**
 *
 * @author mateo
 * @param <T>
 */
public abstract class AbstractRest<T> implements Serializable {

    protected abstract AbstractFacadeInterface<T> entity();

    protected abstract T nuevo();

    @POST
    @Path("crear")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(T entity) {
        if(entity().crear(entity)){
        return Response.status(Response.Status.CREATED).entity(entity).build();
        }
        return Response.status(Response.Status.NOT_FOUND).header("No se pudo crear el objeto ", this).build();
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response edit(T entity) {
        if(entity().modificar(entity)){
        return Response.status(Response.Status.OK).entity(entity).build();
        }
        return Response.status(Response.Status.NOT_FOUND).header("No se pudo modificar el objeto", this).build();
    }

    @DELETE
    @Path("{id}")
    public Response remove(@PathParam("id") Integer id) {
        if(entity().eliminar(entity().find(id))){
        return Response.status(Response.Status.OK).header("Objeto eliminado ",this).build();
        }
        return Response.status(Response.Status.NOT_FOUND).header("No se pudo eliminar el objeto ", this).build();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public T find(@PathParam("id") Integer id) {
        if( entity() != null ){
        return entity().find(id);
        }
        return null;
    }

    @GET
    @Path("findAll")
    @Produces(MediaType.APPLICATION_JSON)
    public List<T> findAll() {
         if( entity() != null ){
        return entity().findAll();
        }
        return null;
    }

    @GET
    @Path("{from}/{to}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<T> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
         if( entity() != null ){
        return entity().findRange(from, to);
        }
        return null;
    }

    @GET
    @Path("count")
    @Produces(MediaType.APPLICATION_JSON)
    public int countREST() {
        if( entity() != null ){
        return entity().count();
        }
        return 0;
    }

}
