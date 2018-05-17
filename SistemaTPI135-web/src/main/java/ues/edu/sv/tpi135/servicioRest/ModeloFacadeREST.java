/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.edu.sv.tpi135.servicioRest;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Path;
import ues.edu.sv.mantenimientoLib.Modelo;
import ues.edu.sv.mantenimientoTPI.acceso.AbstractFacadeInterface;
import ues.edu.sv.mantenimientoTPI.acceso.ModeloFacadeLocal;

/**
 *
 * @author mateo
 */
@Stateless
@Path("modelo")
public class ModeloFacadeREST extends AbstractRest<Modelo> {

     @EJB
    protected ModeloFacadeLocal modeloEJB;

    @Override
    protected AbstractFacadeInterface<Modelo> entity() {
        return (AbstractFacadeInterface<Modelo>) modeloEJB;
    }

    @Override
    protected Modelo nuevo() {
        return new Modelo();
    }

    
}
