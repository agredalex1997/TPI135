/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.edu.sv.tpi135.servicioRest;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Path;
import ues.edu.sv.mantenimientoLib.Marca;
import ues.edu.sv.mantenimientoTPI.acceso.AbstractFacadeInterface;
import ues.edu.sv.mantenimientoTPI.acceso.MarcaFacadeLocal;

/**
 *
 * @author mateo
 */
@Stateless
@Path("marca")
public class MarcaFacadeREST extends AbstractRest<Marca> {

    @EJB
    protected MarcaFacadeLocal marcaEJB;

    @Override
    protected AbstractFacadeInterface<Marca> entity() {
        return  marcaEJB;
    }

    @Override
    protected Marca nuevo() {
        return new Marca();
    }

    
}
