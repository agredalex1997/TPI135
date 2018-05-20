package ues.edu.sv.mantenimientoTPI.acceso;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.embeddable.EJBContainer;
import javax.persistence.EntityManager;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.Rule;
import org.junit.Test;
import org.powermock.reflect.Whitebox;
import ues.edu.sv.mantenimientolib.Area;

/**
 *
 * @author esperanza
 */
public class AreaFacadeTest {
//    @Rule public EntityManagerProvider emProvider = new EntityManagerProvider("testPU");
//
//    public AreaFacadeTest() {
//    }
//
//    /**
//     * Test of create method, of class AreaFacade.
//     */
//    @Test
//    public void testCreate() throws Exception {
//        System.out.println("create");
//
//        EntityManager em = emProvider.em();
//
//        Area area1 = new Area(1, "Posgrados");
//        Area area2 = new Area(2, "Economia");
//
//        AreaFacade Af = new AreaFacade();
//        Whitebox.setInternalState(Af, "em", em);
//        Af.getEntityManager().getTransaction().begin();
//
//        boolean probar1 = Af.crear(null);
//        boolean probar2 = Af.crear(area1);
//        boolean probar3 = Af.crear(area2);
//        
//        System.out.println(Af.findAll());
//        
//        assertFalse(probar1);
//        assertTrue(probar2);
//        assertTrue(probar3);
//        assertEquals(2, Af.findAll().size());
//    }
//
//    /**
//     * Test of edit method, of class AreaFacade.
//     */
//    @Test
//    public void testEdit() throws Exception {
//        EntityManager em = emProvider.em();
//        Area area1 = new Area(1, "postgrado");
//        AreaFacade af = new AreaFacade();
//        Whitebox.setInternalState(af, "em", em);
//        af.getEntityManager().getTransaction().begin();
//        af.getEntityManager().persist(area1);
//        Area areaEdit = new Area(1, "ingenieria");
//        Area a = af.edit(areaEdit);
//        assertNotNull(a.getId()); //revisando si la base de datos no esta vacia 
//        assertEquals(areaEdit.getNombre(), a.getNombre());//revisando si edita en la base de datos 
//
//    }
//
//    /**
//     * Test of remove method, of class AreaFacade.
//     */
//    @Test
//    public void testRemove() throws Exception {
//        EntityManager em = emProvider.em();
//        Area area1 = new Area(1, "postgrado");
//        AreaFacade af = new AreaFacade();
//        Whitebox.setInternalState(af, "em", em);
//        af.getEntityManager().getTransaction().begin();
//        af.getEntityManager().persist(area1);
//        boolean resultado = af.eliminar(area1);
//        boolean resultadoFalso = af.eliminar(null);
//        assertTrue(resultado);//
//        assertFalse(resultadoFalso);
//        assertEquals(0, af.findAll().size());
//    }
//
//    /**
//     * Test of findAll method, of class AreaFacade.
//     */
//    @org.junit.Test
//    public void testFindAll() throws Exception {
//        EntityManager em = emProvider.em();
//        Area area1 = new Area(1);
//        Area area2 = new Area(2);
//        Area area3 = new Area(3);
//        ArrayList<Area> list = new ArrayList<Area>();
//        list.add(0, area1);
//        list.add(1, area2);
//        list.add(2, area3);
//        AreaFacade af = new AreaFacade();
//        Whitebox.setInternalState(af, "em", em);
//        af.getEntityManager().getTransaction().begin();
//        af.getEntityManager().persist(area1);
//        af.getEntityManager().persist(area2);
//        af.getEntityManager().persist(area3);
//        assertEquals(list.toString(), af.findAll().toString());
//        assertEquals(list.size(), af.findAll().size());
//
//    }
//
//    /**
//     * Test of findRange method, of class AreaFacade.
//     */
//    @org.junit.Test
//    public void testFindRange() throws Exception {
//        System.out.println("findRange");
//        int[] range = null;
//        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
//        AreaFacadeLocal instance = (AreaFacadeLocal) container.getContext().lookup("java:global/classes/AreaFacade");
//        List<Area> expResult = null;
//        List<Area> result = instance.findRange(range);
//        assertEquals(expResult, result);
//        container.close();
//        // TODO review the generated test code and remove the default call to fail.
//        //  fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of count method, of class AreaFacade.
//     */
//    @org.junit.Test
//    public void testCount() throws Exception {
//        EntityManager em = emProvider.em();
//        Area area1 = new Area(1);
//        Area area2 = new Area(2);
//        List<Area> list = new ArrayList<Area>();
//        list.add(area1);
//        list.add(area2);
//        AreaFacade af = new AreaFacade();
//        Whitebox.setInternalState(af, "em", em);
//        af.getEntityManager().getTransaction().begin();
//        af.getEntityManager().persist(area1);
//        af.getEntityManager().persist(area2);
//        assertEquals(list.size(), af.count());
//
//    }
}
