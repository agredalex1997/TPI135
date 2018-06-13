/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.edu.sv.tpi135.serviciorest;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Response;
import static org.junit.Assert.*;
import ues.edu.sv.mantenimientolib.Area;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 *
 * @author mateo
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(AreaFacadeREST.class)
public class AreaFacadeRESTSteps {
    AreaFacadeREST areaRest = new AreaFacadeREST();
    Area area = new Area();
    Response estado;
    List<Area> resultado = new ArrayList<>();
    int count, desde, hasta;
    String nombre;
    
    @Given("tengo un objeto area con id, nombre, observacion {int} AND {string} AND {string}")
    public void tengo_un_objeto_area_con_id_nombre_observacion_AND_AND(Integer id, String nombre, String observaciones) {
        area.setId(id);
        area.setNombre(nombre);
        area.setObservaciones(observaciones);
    }

    @When("hago una peticion para crear")
    public void hago_una_peticion_para_crear() {
        estado = areaRest.create(area);
    }

    @Then("obtengo un estado de creado")
    public void obtengo_un_estado_de_creado() {
        assertNotNull(estado);
        assertEquals(201, estado.getStatus());
    }

    @Given("tengo un objeto area con nombre, observacion {string} AND {string}")
    public void tengo_un_objeto_area_con_nombre_observacion_AND(String nombre, String observaciones) {
        area.setNombre(nombre);
        area.setObservaciones(observaciones);
    }

    @When("selecciono un id {int}")
    public void selecciono_un_id(Integer id) {
        area.setId(id);
    }

    @Then("hago una peticion para editar")
    public void hago_una_peticion_para_editar() {
        estado = areaRest.edit(area);
    }

    @Then("obtengo un estado de modificado")
    public void obtengo_un_estado_de_modificado() {
        assertNotNull(estado);
        assertEquals(200, estado.getStatus());
    }

    @When("seleciono un id {int}")
    public void seleciono_un_id(Integer id) {
        area.setId(id);
    }

    @Then("hago una peticion para eliminar")
    public void hago_una_peticion_para_eliminar() {
        estado = areaRest.remove(area.getId());
    }

    @Then("obtengo un estado de eliminado")
    public void obtengo_un_estado_de_eliminado() {
        assertNotNull(estado);
        assertEquals(200, estado.getStatus());
    }

    @When("tengo un id {int}")
    public void tengo_un_id(Integer id) {
        area.setId(id);
    }

    @Then("hago una peticion para obtener una entidad")
    public void hago_una_peticion_para_obtener_una_entidad() {
        area = areaRest.find(area.getId());
    }

    @Then("obtengo una entidad")
    public void obtengo_una_entidad() {
        Area area1 = new Area();
        area1.setId(1);
        area1.setNombre("Ingenieria y Arquitectura");
        area1.setObservaciones(" ");
        
        assertNotNull(area);
        assertEquals(area.getId(), area1.getId());
        assertEquals(area.getNombre(), area1.getNombre());
        assertEquals(area.getObservaciones(), area1.getObservaciones());
    }

    @When("hago una peticion para obtener todo")
    public void hago_una_peticion_para_obtener_todo() {
        resultado.clear();
        resultado.addAll(areaRest.findAll());
    }

    @Then("obtengo una lista de areas")
    public void obtengo_una_lista_de_areas() {
        Area area1 = new Area(1, "Ingenieria y Arquitectura");
        Area area2 = new Area(2, "Idiomas");
        Area area3 = new Area(3, "Letras");
        Area area4 = new Area(4, "Fisica");
        Area area5 = new Area(5, "Medicina");
        List<Area> lista = new ArrayList<>();
        lista.add(area1);
        lista.add(area2);
        lista.add(area3);
        lista.add(area4);
        lista.add(area5);
        
        assertNotNull(resultado);
        for (int i = 0; i < lista.size(); i++) {
            assertEquals(resultado.get(i).getId(), lista.get(i).getId());
            assertEquals(resultado.get(i).getNombre(), lista.get(i).getNombre());
            assertEquals(resultado.get(i).getObservaciones(), lista.get(i).getObservaciones());
        }
    }

    @When("tengo un rango desde, hata {int}, {int}")
    public void tengo_un_rango_desde_hata(Integer desde, Integer hasta) {
        this.desde = desde;
        this.hasta = hasta;
    }

    @Then("hago una peticion con el rango")
    public void hago_una_peticion_con_el_rango() {
        resultado = areaRest.findRange(desde, hasta);
    }

    @Then("obtengo una lista por rango")
    public void obtengo_una_lista_por_rango() {
        Area area1 = new Area(2, "Idiomas");
        Area area2 = new Area(3, "Letras");
        Area area3 = new Area(4, "Fisica");
        List<Area> lista = new ArrayList<>();
        lista.add(area1);
        lista.add(area2);
        lista.add(area3);
        
        assertNotNull(resultado);
        for (int i = 0; i < lista.size(); i++) {
            assertEquals(resultado.get(i).getId(), lista.get(i).getId());
            assertEquals(resultado.get(i).getNombre(), lista.get(i).getNombre());
            assertEquals(resultado.get(i).getObservaciones(), lista.get(i).getObservaciones());
        }
    }

    @When("hago una peticion para contar")
    public void hago_una_peticion_para_contar() {
        count = areaRest.countREST();
    }

    @Then("obtengo el numero de entidades")
    public void obtengo_el_numero_de_entidades() {
        assertEquals(5, count);
    }
    
    @When("tengo una cadena de texto {string}")
    public void tengo_una_cadena_de_texto(String nombre) {
        this.nombre = nombre;
        
    }
    
    @Then("hago una peticion con la cadena obtenida")
    public void hago_una_peticion_con_la_cadena_obtenida() {
        resultado = areaRest.findByName(nombre);
    }

    @Then("obtengo una lista por nombres")
    public void obtengo_una_lista_por_nombres() {
        Area area1 = new Area(1, "Ingenieria y Arquitectura");
        Area area2 = new Area(3, "Letras");
        Area area3 = new Area(5, "Medicina");
        List<Area> lista = new ArrayList<>();
        lista.add(area1);
        lista.add(area2);
        lista.add(area3);
        
        assertNotNull(resultado);
        for (int i = 0; i < lista.size(); i++) {
            assertEquals(resultado.get(i).getId(), lista.get(i).getId());
            assertEquals(resultado.get(i).getNombre(), lista.get(i).getNombre());
            assertEquals(resultado.get(i).getObservaciones(), lista.get(i).getObservaciones());
        }
    }
}
