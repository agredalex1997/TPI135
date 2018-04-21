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
        resources.add(ues.edu.sv.tpi135.servicioRest.AreaResource.class);
        resources.add(ues.edu.sv.tpi135.servicioRest.CalendarioResource.class);
        resources.add(ues.edu.sv.tpi135.servicioRest.DetalleEquipoResource.class);
        resources.add(ues.edu.sv.tpi135.servicioRest.DetallePeticionResource.class);
        resources.add(ues.edu.sv.tpi135.servicioRest.DiagnisticoHardwareResource.class);
        resources.add(ues.edu.sv.tpi135.servicioRest.DiagnosticoSoftwareResource.class);
        resources.add(ues.edu.sv.tpi135.servicioRest.EquipoResource.class);
        resources.add(ues.edu.sv.tpi135.servicioRest.EstadoResource.class);
        resources.add(ues.edu.sv.tpi135.servicioRest.ExcepcionCalendarioResource.class);
        resources.add(ues.edu.sv.tpi135.servicioRest.HardwareResource.class);
        resources.add(ues.edu.sv.tpi135.servicioRest.MarcaResources.class);
        resources.add(ues.edu.sv.tpi135.servicioRest.ModeloResource.class);
        resources.add(ues.edu.sv.tpi135.servicioRest.OrdenTrabajoResource.class);
        resources.add(ues.edu.sv.tpi135.servicioRest.OrigenPeticionResource.class);
        resources.add(ues.edu.sv.tpi135.servicioRest.PasosProceimientoResource.class);
        resources.add(ues.edu.sv.tpi135.servicioRest.PasosResource.class);
        resources.add(ues.edu.sv.tpi135.servicioRest.PersonalMantenimientoResource.class);
        resources.add(ues.edu.sv.tpi135.servicioRest.PeticionResource.class);
        resources.add(ues.edu.sv.tpi135.servicioRest.ProcedimientoResource.class);
        resources.add(ues.edu.sv.tpi135.servicioRest.TipoMantenimientoResource.class);
    }
    
}
