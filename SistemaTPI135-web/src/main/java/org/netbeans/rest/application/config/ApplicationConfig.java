/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.netbeans.rest.application.config;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author esperanza
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(org.netbeans.rest.application.config.CorsFliter.class);
        resources.add(ues.edu.sv.tpi135.servicioRest.AreaFacadeREST.class);
        resources.add(ues.edu.sv.tpi135.servicioRest.CalendarioFacadeREST.class);
        resources.add(ues.edu.sv.tpi135.servicioRest.DetalleEquipoFacadeREST.class);
        resources.add(ues.edu.sv.tpi135.servicioRest.DetallePeticionFacadeREST.class);
        resources.add(ues.edu.sv.tpi135.servicioRest.DiagnosticoHardwareFacadeREST.class);
        resources.add(ues.edu.sv.tpi135.servicioRest.DiagnosticoSoftwareFacadeREST.class);
        resources.add(ues.edu.sv.tpi135.servicioRest.EquipoFacadeREST.class);
        resources.add(ues.edu.sv.tpi135.servicioRest.EstadoFacadeREST.class);
        resources.add(ues.edu.sv.tpi135.servicioRest.ExcepcionCalendarioFacadeREST.class);
        resources.add(ues.edu.sv.tpi135.servicioRest.HardwareFacadeREST.class);
        resources.add(ues.edu.sv.tpi135.servicioRest.MarcaFacadeREST.class);
        resources.add(ues.edu.sv.tpi135.servicioRest.ModeloFacadeREST.class);
        resources.add(ues.edu.sv.tpi135.servicioRest.OrdenTrabajoFacadeREST.class);
        resources.add(ues.edu.sv.tpi135.servicioRest.OrigenPeticionFacadeREST.class);
        resources.add(ues.edu.sv.tpi135.servicioRest.PasosFacadeREST.class);
        resources.add(ues.edu.sv.tpi135.servicioRest.PasosProcedimientoFacadeREST.class);
        resources.add(ues.edu.sv.tpi135.servicioRest.PersonalMantenimientoFacadeREST.class);
        resources.add(ues.edu.sv.tpi135.servicioRest.PeticionFacadeREST.class);
        resources.add(ues.edu.sv.tpi135.servicioRest.ProcedimientoFacadeREST.class);
        resources.add(ues.edu.sv.tpi135.servicioRest.TipoMantenimientoFacadeREST.class);
    }
    
}
