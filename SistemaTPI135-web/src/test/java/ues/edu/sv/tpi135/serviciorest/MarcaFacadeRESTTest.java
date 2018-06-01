/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.edu.sv.tpi135.serviciorest;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Response;
import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import ues.edu.sv.mantenimientolib.Marca;

/**
 *
 * @author mateo
 */

@RunWith(PowerMockRunner.class)
@PrepareForTest(MarcaFacadeREST.class)
public class MarcaFacadeRESTTest {
    Marca marcaMock = Mockito.mock(Marca.class);
    MarcaFacadeREST marcaRestMock = Mockito.mock(MarcaFacadeREST.class);
    
    public MarcaFacadeRESTTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws Exception {
        PowerMockito.whenNew(Marca.class).withAnyArguments().thenReturn(marcaMock);
        List<Marca> listaMarcas = new ArrayList<>();
        Marca marca1 = new Marca(1, "Dell", true, "");
        Marca marca2 = new Marca(2, "Lenovo", true, "");
        listaMarcas.add(marca1);
        listaMarcas.add(marca2);
        Mockito.when(marcaRestMock.create(marca1)).thenReturn(Response.status(Response.Status.CREATED).build());
        Mockito.when(marcaRestMock.edit(marca2)).thenReturn(Response.status(Response.Status.OK).build());
        Mockito.when(marcaRestMock.remove(2)).thenReturn(Response.status(Response.Status.OK).build());
        Mockito.when(marcaRestMock.find(1)).thenReturn(marca1);
        Mockito.when(marcaRestMock.findAll()).thenReturn(listaMarcas);
        Mockito.when(marcaRestMock.findRange(1, 2)).thenReturn(listaMarcas);
        Mockito.when(marcaRestMock.countREST()).thenReturn(2);
        Mockito.when(marcaRestMock.findByName("e")).thenReturn(listaMarcas);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of create method, of class MarcaFacadeREST.
     * @throws java.lang.Exception
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        Marca marca = new Marca(3, "Acer", true, "");
        MarcaFacadeREST instance = marcaRestMock;
        Response expResult = Response.status(Response.Status.CREATED).build();
        Response result = instance.create(marca);
        assertEquals(expResult.getStatus(), result.getStatus());
        //fail("The test case is a prototype.");
    }

    /**
     * Test of edit method, of class MarcaFacadeREST.
     * @throws java.lang.Exception
     */
    @Test
    public void testEdit() throws Exception {
        System.out.println("edit");
        Marca marca = new Marca(2, "Toshiba", true, "");
        MarcaFacadeREST instance = marcaRestMock;
        Response expResult = Response.status(Response.Status.OK).build();
        Response result = instance.edit(marca);
        assertEquals(expResult.getStatus(), result.getStatus());
        //fail("The test case is a prototype.");
    }

    /**
     * Test of remove method, of class MarcaFacadeREST.
     * @throws java.lang.Exception
     */
    @Test
    public void testRemove() throws Exception {
        System.out.println("remove");
        int id = 2;
        MarcaFacadeREST instance = marcaRestMock;
        Response expResult = Response.status(Response.Status.OK).build();
        Response result = instance.remove(id);
        assertEquals(expResult.getStatus(), result.getStatus());
        //fail("The test case is a prototype.");
    }

    /**
     * Test of find method, of class MarcaFacadeREST.
     * @throws java.lang.Exception
     */
    @Test
    public void testFind() throws Exception {
        System.out.println("find");
        int id = 1;
        Marca expResult = new Marca(1, "Dell", true, "");
        MarcaFacadeREST instance = marcaRestMock;
        Marca result = instance.find(id);
        assertEquals(expResult, result);
        //fail("The test case is a prototype.");
    }

    /**
     * Test of findAll method, of class MarcaFacadeREST.
     * @throws java.lang.Exception
     */
    @Test
    public void testFindAll() throws Exception {
        System.out.println("findAll");
        List<Marca> expResult = new ArrayList<>();
        Marca marca1 = new Marca(1, "Dell", true, "");
        Marca marca2 = new Marca(2, "Lenovo", true, "");
        expResult.add(marca1);
        expResult.add(marca2);
        MarcaFacadeREST instance = marcaRestMock;
        List<Marca> result = instance.findAll();
        assertThat(result, CoreMatchers.equalTo(expResult));
        //fail("The test case is a prototype.");
    }

    /**
     * Test of findRange method, of class MarcaFacadeREST.
     * @throws java.lang.Exception
     */
    @Test
    public void testFindRange() throws Exception {
        System.out.println("findRange");
        Integer from = 1;
        Integer to = 2;
        MarcaFacadeREST instance = marcaRestMock; 
        List<Marca> expResult = new ArrayList<>();
        Marca marca1 = new Marca(1, "Dell", true, "");
        Marca marca2 = new Marca(2, "Lenovo", true, "");
        expResult.add(marca1);
        expResult.add(marca2);
        List<Marca> result = instance.findRange(from, to);
        assertEquals(expResult, result);
        //fail("The test case is a prototype.");
    }

    /**
     * Test of countREST method, of class MarcaFacadeREST.
     * @throws java.lang.Exception
     */
    @Test
    public void testCountREST() throws Exception {
        System.out.println("countREST");
        MarcaFacadeREST instance = marcaRestMock;
        int expResult = 2;
        int result = instance.countREST();
        assertEquals(expResult, result);
        //fail("The test case is a prototype.");
    }

    /**
     * Test of findByName method, of class MarcaFacadeREST.
     * @throws java.lang.Exception
     */
    @Test
    public void testFindByName() throws Exception {
        System.out.println("findByName");
        String name = "e";
        MarcaFacadeREST instance = marcaRestMock;
        List<Marca> expResult = new ArrayList<>();
        Marca marca1 = new Marca(1, "Dell", true, "");
        Marca marca2 = new Marca(2, "Lenovo", true, "");
        expResult.add(marca1);
        expResult.add(marca2);
        List<Marca> result = instance.findByName(name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
