/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.edu.sv.tpi135.servicioRest;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import ues.edu.sv.mantenimientoLib.Peticion;
import ues.edu.sv.mantenimientoTPI.acceso.AbstractFacadeInterface;
import ues.edu.sv.mantenimientoTPI.acceso.PeticionFacadeLocal;

/**
 *
 * @author mateo
 */
@Stateless
@Path("peticion")
public class PeticionFacadeREST extends AbstractRest<Peticion> {

    @EJB
    protected PeticionFacadeLocal peticionEJB;

    @Override
    protected AbstractFacadeInterface<Peticion> entity() {
        return peticionEJB;
    }

    @Override
    protected Peticion nuevo() {
        return new Peticion();
    }

}
