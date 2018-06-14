/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.edu.sv.mantenimientoTPI.acceso;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Response;
import ues.edu.sv.mantenimientolib.Marca;
import ues.edu.sv.mantenimientotpi.acceso.MarcaFacade;

/**
 *
 * @author mateo
 */
public class MarcaFacadeSteps {
    MarcaFacade marcaFacade = new MarcaFacade();
    Marca marca = new Marca();
    List<Marca> resultado = new ArrayList<>();
    Response estado;
    int count, desde, hasta;
    String nombre;
    
    @Given("tengo un nuevo objeto Marca {int}, {string}, {string}, {string}")
    public void tengo_un_nuevo_objeto_Marca(Integer id, String nombre, String string2, String string3) {
        marca.setId(id);
    }

    @When("hago una peticion para crear")
    public void hago_una_peticion_para_crear() {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("obtengo el estado creado")
    public void obtengo_el_estado_creado() {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Given("tengo un objeto Marca {string}, {string}, {string}")
    public void tengo_un_objeto_Marca(String string, String string2, String string3) {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("hago una peticion para editar")
    public void hago_una_peticion_para_editar() {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("obtengo un estado editado")
    public void obtengo_un_estado_editado() {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("tengo un id")
    public void tengo_un_id() {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("hago una peticion para eliminar")
    public void hago_una_peticion_para_eliminar() {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("obtengo un estado eliminado")
    public void obtengo_un_estado_eliminado() {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("tengo un id Marca")
    public void tengo_un_id_Marca() {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("hago una peticion para buscar")
    public void hago_una_peticion_para_buscar() {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("obtengo una entidad Marca")
    public void obtengo_una_entidad_Marca() {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("hago una peticion")
    public void hago_una_peticion() {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("obtengo una lista")
    public void obtengo_una_lista() {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("tengo un rango {double}")
    public void tengo_un_rango(Double double1) {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("hago una peticion con el rango")
    public void hago_una_peticion_con_el_rango() {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("obtengo una lista de entidades por rango")
    public void obtengo_una_lista_de_entidades_por_rango() {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("hago una peticion para obtener el numero de entidades")
    public void hago_una_peticion_para_obtener_el_numero_de_entidades() {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("obtengo el numero de entidades")
    public void obtengo_el_numero_de_entidades() {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("tengo un nombre {string}")
    public void tengo_un_nombre(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("hago una peticion con el nombre")
    public void hago_una_peticion_con_el_nombre() {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("obtengo una lista por nombres")
    public void obtengo_una_lista_por_nombres() {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}
