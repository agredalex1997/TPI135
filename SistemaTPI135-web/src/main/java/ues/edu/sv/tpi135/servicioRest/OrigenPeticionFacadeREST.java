/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.edu.sv.tpi135.servicioRest;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Path;
import ues.edu.sv.mantenimientoLib.OrigenPeticion;
import ues.edu.sv.mantenimientoTPI.acceso.AbstractFacadeInterface;
import ues.edu.sv.mantenimientoTPI.acceso.OrigenPeticionFacadeLocal;

/**
 *
 * @author mateo
 */
@Stateless
@Path("origenPeticion")
public class OrigenPeticionFacadeREST extends AbstractRest<OrigenPeticion> {

   @EJB
    protected OrigenPeticionFacadeLocal origenEJB;

    @Override
    protected AbstractFacadeInterface<OrigenPeticion> entity() {
        return (AbstractFacadeInterface<OrigenPeticion>) origenEJB;
    }

    @Override
    protected OrigenPeticion nuevo() {
        return new OrigenPeticion();
    }

    
}
