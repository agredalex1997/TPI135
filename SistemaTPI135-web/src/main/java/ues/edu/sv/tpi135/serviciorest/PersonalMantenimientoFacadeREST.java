/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.edu.sv.tpi135.serviciorest;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Path;
import ues.edu.sv.mantenimientolib.PersonalMantenimiento;
import ues.edu.sv.mantenimientotpi.acceso.AbstractFacadeInterface;
import ues.edu.sv.mantenimientotpi.acceso.PersonalMantenimientoFacadeLocal;

/**
 *
 * @author mateo
 */
@Stateless
@Path("personalMantenimiento")
public class PersonalMantenimientoFacadeREST extends AbstractRest<PersonalMantenimiento> {

   @EJB
    protected PersonalMantenimientoFacadeLocal pmEJB;

    @Override
    protected AbstractFacadeInterface<PersonalMantenimiento> entity() {
        return pmEJB;
    }

    @Override
    protected PersonalMantenimiento nuevo() {
        return new PersonalMantenimiento();
    }

    
}
