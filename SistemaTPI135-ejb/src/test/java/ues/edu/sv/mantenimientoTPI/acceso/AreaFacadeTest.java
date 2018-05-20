package ues.edu.sv.mantenimientoTPI.acceso;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.Ignore;
import org.junit.Test;
import org.powermock.reflect.Whitebox;
import ues.edu.sv.mantenimientoLib.Area;

/**
 *
 * @author esperanza
 */
public class AreaFacadeTest {
   public EntityManagerProvider emp = EntityManagerProvider.persistenceUnit("testPU");
   public AreaFacadeTest() {}

    /**
     * Test of findAll method, of class AreaFacade.
     */
   
    @Test
    public void testFindAll() throws Exception {
        System.out.println("findAll");
        Area area = new Area(1, "postgrados");
        Area area2 = new Area(2, "economia");

        List<Area> list = new ArrayList<>();
        list.add(area);
        list.add(area2);

        AreaFacade Af = new AreaFacade();
        Whitebox.setInternalState(Af, "em", emp.em());
        Af.getEntityManager().getTransaction().begin();
        Af.getEntityManager().persist(area);
        Af.getEntityManager().persist(area2);
        assertEquals(list, Af.findAll());
    }

    /**
     * Test of findRange method, of class AreaFacade.
     */
    @Test
    public void testFindRange() throws Exception {
        EntityManager em = emp.em();
        System.out.println("findRange");
        
        Area area = new Area(4, "Postgrado");
        Area area2 = new Area(5, "Ingenieria");
        
        List<Area> list = new ArrayList<>();
        list.add(area);
        list.add(area2);
        
        AreaFacade Af = new AreaFacade();
        Whitebox.setInternalState(Af, "em", em);
        
        Af.getEntityManager().getTransaction().begin();
        Af.getEntityManager().persist(area2);
        Af.getEntityManager().persist(area);
        int[] rango = {0, 1};
        assertEquals(list.get(0), Af.findRange(rango).get(0));
    }

    /**
     * Test of count method, of class AreaFacade.
     */
    
    @Test
    public void testCount() throws Exception {
        EntityManager em = emp.em();
        Area area1 = new Area(6, "Postgrado");
        Area area2 = new Area(7, "Ingenieria");
        List<Area> list = new ArrayList<>();
        list.add(area1);
        list.add(area2);
        AreaFacade Af = new AreaFacade();
        Whitebox.setInternalState(Af, "em", em);
        Af.getEntityManager().getTransaction().begin();
        Af.getEntityManager().persist(area1);
        Af.getEntityManager().persist(area2);
        assertEquals(list.size(), Af.count());
    }
    
    
    /**
     * Test of create method, of class AreaFacade.
     */
    @Test
    public void testCreate() throws Exception {
        EntityManager em = emp.em();
        System.out.println("create");

        Area area1 = new Area(1, "Posgrados");
        Area area2 = new Area(2, "Economia");

        AreaFacade Af = new AreaFacade();
        Whitebox.setInternalState(Af, "em", em);
        Af.getEntityManager().getTransaction().begin();

        boolean probar1 = Af.crear(null);
        boolean probar2 = Af.crear(area1);
        boolean probar3 = Af.crear(area2);

        assertFalse(probar1);
        assertTrue(probar2);
        assertTrue(probar3);
    }

    /**
     * Test of edit method, of class AreaFacade.
     */
    @Test
    public void testEdit() throws Exception {
        EntityManager em = emp.em();
        Area area1 = new Area(9, "Postgrado");
        AreaFacade Af = new AreaFacade();
        Whitebox.setInternalState(Af, "em", em);
        Af.getEntityManager().getTransaction().begin();
        Af.getEntityManager().persist(area1);
        Area esperada = new Area(1, "ingenieria");
        Area a = Af.edit(esperada);
        assertNotNull(a.getId()); //revisando si la base de datos no esta vacia 
        assertEquals(esperada.getNombre(), a.getNombre());//revisando si edita en la base de datos 
    }

    /**
     * Test of remove method, of class AreaFacade.
     */
    @Test
    public void testRemove() throws Exception {
        System.out.println("remove");
        Area area = new Area(1, "postgrados");
        AreaFacade Af = new AreaFacade();
        Whitebox.setInternalState(Af, "em", emp.em());
        Af.getEntityManager().getTransaction().begin();
        Af.getEntityManager().persist(area);
        boolean resultado = Af.eliminar(area);
        boolean resultadoFalso = Af.eliminar(null);
        assertTrue(resultado);//
        assertFalse(resultadoFalso);
        assertEquals(0, Af.findAll().size());
    }

    /**
     * Test of find method, of class AreaFacade.
     */
    @Test
    public void testFind() throws Exception {
        System.out.println("find");
        Area area = new Area(1, "posgrados");
        AreaFacade Af = new AreaFacade();
        Whitebox.setInternalState(Af, "em", emp.em());
        Af.getEntityManager().getTransaction().begin();
        Af.getEntityManager().persist(area);
        assertEquals(area, Af.find(1));
    }
}
