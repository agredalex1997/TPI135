package ues.edu.sv.tpi135.servicioRest;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Path;
import ues.edu.sv.mantenimientoLib.Area;
import ues.edu.sv.mantenimientoTPI.acceso.AbstractFacadeInterface;
import ues.edu.sv.mantenimientoTPI.acceso.AreaFacadeLocal;

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
