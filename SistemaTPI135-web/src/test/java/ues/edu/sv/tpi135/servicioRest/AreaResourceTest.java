
package ues.edu.sv.tpi135.servicioRest;

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
import ues.edu.sv.mantenimientoLib.Area;

/**
 *
 * @author mateo
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(AreaResource.class)
public class AreaResourceTest {
    Area areaMock = Mockito.mock(Area.class);
    AreaResource areaResourceMock = Mockito.mock(AreaResource.class);

    public AreaResourceTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws Exception {
        PowerMockito.whenNew(Area.class).withAnyArguments().thenReturn(areaMock);
        List<Area> listaArea = new ArrayList<>();
        Area a1 = new Area(1, "Ingenieria y Arquitectura");
        Area a2 = new Area(2, "Fisica");
        listaArea.add(a1);
        listaArea.add(a2);
        Mockito.when(areaResourceMock.findAll()).thenReturn(listaArea);
        Mockito.when(areaResourceMock.count()).thenReturn(2);
        Mockito.when(areaResourceMock.findById(1)).thenReturn(a1);
        Mockito.when(areaResourceMock.remove(2)).thenReturn(Response.status(Response.Status.OK).build());
        Mockito.when(areaResourceMock.create(2, "Fisica")).thenReturn(Response.status(Response.Status.CREATED).build());
        Mockito.when(areaResourceMock.findRange(1, 2)).thenReturn(listaArea);
        Mockito.when(areaResourceMock.findByName("Fisica")).thenReturn(listaArea);
        Mockito.when(areaResourceMock.edit(2, "Medicina")).thenReturn(Response.status(Response.Status.OK).build());
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of findAll method, of class AreaResource.
     */
    @Test
    public void testFindAll() {
        System.out.println("findAll");
        AreaResource instance = areaResourceMock;
        Area a1 = new Area(1, "Ingenieria y Arquitectura");
        Area a2 = new Area(2, "Fisica");
        List<Area> expResult = new ArrayList<>();
        expResult.add(a1);
        expResult.add(a1);
        List<Area> result = instance.findAll();
        assertThat(result, CoreMatchers.equalTo(expResult));
        //fail("The test case is a prototype.");
    }

    /**
     * Test of count method, of class AreaResource.
     */
    @Test
    public void testCount() {
        System.out.println("count");
        AreaResource instance = areaResourceMock;
        Integer expResult = 2;
        Integer result = instance.count();
        assertEquals(expResult, result);
        //fail("The test case is a prototype.");
    }

    /**
     * Test of findById method, of class AreaResource.
     */
    @Test
    public void testFindById() {
         System.out.println("findById");
        Integer idArea = 1;
        AreaResource instance = areaResourceMock;
        Area expResult = new Area(1, "Ingenieria y Arquitectura");
        Area result = instance.findById(idArea);
        assertEquals(expResult, result);
        //fail("The test case is a prototype.");
    }

    /**
     * Test of remove method, of class AreaResource.
     */
    @Test
    public void testRemove() {
        System.out.println("remove");
        Integer idArea = 2;
        AreaResource instance = areaResourceMock;
        Response expResult = Response.status(Response.Status.OK).build();
        Response result = instance.remove(idArea);
        assertEquals(expResult.getStatus(), result.getStatus());
        //fail("The test case is a prototype.");
    }

    /**
     * Test of create method, of class AreaResource.
     */
    @Test
    public void testCreate() {
        System.out.println("create");
        int idArea = 2;
        String nombreArea = "Fisica";
        AreaResource instance = areaResourceMock;
        Response expResult = Response.status(Response.Status.CREATED).build();
        Response result = instance.create(idArea, nombreArea);
        assertEquals(expResult.getStatus(), result.getStatus());
        //fail("The test case is a prototype.");
    }

    /**
     * Test of findRange method, of class AreaResource.
     */
    @Test
    public void testFindRange() {
        System.out.println("findRange");
        int lower = 1;
        int higher = 2;
        AreaResource instance = areaResourceMock;
        Area a1 = new Area(1, "Ingenieria y Arquitectura");
        Area a2 = new Area(2, "Fisica");
        List<Area> expResult = new ArrayList<>();
        expResult.add(a1);
        expResult.add(a1);
        List<Area> result = instance.findRange(lower, higher);
        assertThat(result, CoreMatchers.equalTo(expResult));
        //fail("The test case is a prototype.");
    }

    /**
     * Test of findByName method, of class AreaResource.
     */
    @Test
    public void testFindByName() {
        System.out.println("findByName");
        String name = "Fisica";
        AreaResource instance = areaResourceMock;
        Area expResult = new Area(2, "Fisica");
        List<Area> result = instance.findByName(name);
        assertThat(result, CoreMatchers.hasItems(expResult));
        //fail("The test case is a prototype.");
    }

    /**
     * Test of edit method, of class AreaResource.
     */
    @Test
    public void testEdit() {
        System.out.println("edit");
        int idArea = 2;
        String nombreArea = "Medicina";
        AreaResource instance = areaResourceMock;
        Response expResult = Response.status(Response.Status.OK).build();
        Response result = instance.edit(idArea, nombreArea);
        assertEquals(expResult.getStatus(), result.getStatus());
        //fail("The test case is a prototype.");
    }
    
}
