/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.edu.sv.tpi135.serviciorest;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import ues.edu.sv.mantenimientolib.Marca;
import ues.edu.sv.mantenimientotpi.acceso.AbstractFacadeInterface;
import ues.edu.sv.mantenimientotpi.acceso.MarcaFacadeLocal;

/**
 *
 * @author mateo
 */
@Stateless
@Path("marca")
public class MarcaFacadeREST extends AbstractRest<Marca> {

    @EJB
    protected MarcaFacadeLocal marcaEJB;

    @Override
    protected AbstractFacadeInterface<Marca> entity() {
        return  marcaEJB;
    }

    @Override
    protected Marca nuevo() {
        return new Marca();
    }
    
    @Path("/findByName/{name}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Marca> findByName(@PathParam("name") String name) {
      List listaMarca = null;
      
      if (marcaEJB != null) {
        listaMarca = marcaEJB.findByName(name);
      }
      
      return listaMarca;
}
    
}
