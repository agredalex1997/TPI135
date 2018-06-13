package ues.edu.sv.tpi135.serviciorest;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import ues.edu.sv.mantenimientolib.Area;
import ues.edu.sv.mantenimientotpi.acceso.AbstractFacadeInterface;
import ues.edu.sv.mantenimientotpi.acceso.AreaFacadeLocal;

/**
 *
 * @author mateo
 */
@Stateless
@Path("area")
public class AreaFacadeREST extends AbstractRest<Area> {

    @EJB
    protected AreaFacadeLocal areaEJB;

    @Override
    protected AbstractFacadeInterface<Area> entity() {
        return areaEJB;
    }

    @Override
    protected Area nuevo() {
        return new Area();
    }
    
    @Path("/findByName/{name}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Area> findByName(@PathParam("name") String name) {
        List listaArea = null;

        if (areaEJB != null) {
            listaArea = areaEJB.findByName(name);
        }

        return listaArea;
    }

}
