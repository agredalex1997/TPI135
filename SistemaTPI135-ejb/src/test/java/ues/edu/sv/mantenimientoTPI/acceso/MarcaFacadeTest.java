/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.edu.sv.mantenimientoTPI.acceso;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 *
 * @author mateo
 */
@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty"}, features = "src/test/resources", strict = true)
public class MarcaFacadeTest {
    
}
