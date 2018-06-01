/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.edu.sv.tpi135.serviciorest;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Path;
import ues.edu.sv.mantenimientolib.DiagnosticoHardware;
import ues.edu.sv.mantenimientotpi.acceso.AbstractFacadeInterface;
import ues.edu.sv.mantenimientotpi.acceso.DiagnosticoHardwareFacadeLocal;

/**
 *
 * @author mateo
 */
@Stateless
@Path("diagnosticoHardware")
public class DiagnosticoHardwareFacadeREST extends AbstractRest<DiagnosticoHardware> {

    @EJB
    protected DiagnosticoHardwareFacadeLocal diagnosticoEJB;

    @Override
    protected AbstractFacadeInterface<DiagnosticoHardware> entity() {
        return diagnosticoEJB;
    }

    @Override
    protected DiagnosticoHardware nuevo() {
        return new DiagnosticoHardware();
    }
    
}
