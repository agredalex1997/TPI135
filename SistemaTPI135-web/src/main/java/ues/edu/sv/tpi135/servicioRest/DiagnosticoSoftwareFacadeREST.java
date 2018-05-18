/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.edu.sv.tpi135.servicioRest;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Path;
import ues.edu.sv.mantenimientoLib.DiagnosticoSoftware;
import ues.edu.sv.mantenimientoTPI.acceso.AbstractFacadeInterface;
import ues.edu.sv.mantenimientoTPI.acceso.DiagnosticoSoftwareFacadeLocal;

/**
 *
 * @author mateo
 */
@Stateless
@Path("diagnosticoSoftware")
public class DiagnosticoSoftwareFacadeREST extends AbstractRest<DiagnosticoSoftware> {

    @EJB
    protected DiagnosticoSoftwareFacadeLocal diagnosticoSEJB;

    @Override
    protected AbstractFacadeInterface<DiagnosticoSoftware> entity() {
        return  diagnosticoSEJB;
    }

    @Override
    protected DiagnosticoSoftware nuevo() {
        return new DiagnosticoSoftware();
    }
    
}
