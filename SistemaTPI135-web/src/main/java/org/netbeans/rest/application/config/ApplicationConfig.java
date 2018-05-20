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
        resources.add(ues.edu.sv.tpi135.serviciorest.AreaFacadeREST.class);
        resources.add(ues.edu.sv.tpi135.serviciorest.CalendarioFacadeREST.class);
        resources.add(ues.edu.sv.tpi135.serviciorest.DetalleEquipoFacadeREST.class);
        resources.add(ues.edu.sv.tpi135.serviciorest.DetallePeticionFacadeREST.class);
        resources.add(ues.edu.sv.tpi135.serviciorest.DiagnosticoHardwareFacadeREST.class);
        resources.add(ues.edu.sv.tpi135.serviciorest.DiagnosticoSoftwareFacadeREST.class);
        resources.add(ues.edu.sv.tpi135.serviciorest.EquipoFacadeREST.class);
        resources.add(ues.edu.sv.tpi135.serviciorest.EstadoFacadeREST.class);
        resources.add(ues.edu.sv.tpi135.serviciorest.ExcepcionCalendarioFacadeREST.class);
        resources.add(ues.edu.sv.tpi135.serviciorest.HardwareFacadeREST.class);
        resources.add(ues.edu.sv.tpi135.serviciorest.MarcaFacadeREST.class);
        resources.add(ues.edu.sv.tpi135.serviciorest.ModeloFacadeREST.class);
        resources.add(ues.edu.sv.tpi135.serviciorest.OrdenTrabajoFacadeREST.class);
        resources.add(ues.edu.sv.tpi135.serviciorest.OrigenPeticionFacadeREST.class);
        resources.add(ues.edu.sv.tpi135.serviciorest.PasosFacadeREST.class);
        resources.add(ues.edu.sv.tpi135.serviciorest.PasosProcedimientoFacadeREST.class);
        resources.add(ues.edu.sv.tpi135.serviciorest.PersonalMantenimientoFacadeREST.class);
        resources.add(ues.edu.sv.tpi135.serviciorest.PeticionFacadeREST.class);
        resources.add(ues.edu.sv.tpi135.serviciorest.ProcedimientoFacadeREST.class);
        resources.add(ues.edu.sv.tpi135.serviciorest.TipoMantenimientoFacadeREST.class);
    }
    
}
