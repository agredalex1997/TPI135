package ues.edu.sv.tpi135.serviciorest;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Path;
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

}
