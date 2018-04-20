/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.edu.sv.mantenimientoTPI.acceso;

import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author kevin
 */
public abstract class AbstractFacade<T> {

    private Class<T> entityClass;

    public AbstractFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    protected abstract EntityManager getEntityManager();

     public T create(T entity) {
        if (entity != null && getEntityManager() != null) {
            getEntityManager().persist(entity);
            return entity;
        } else {
            return null;
        }
    }

    public T edit(T entity) {
        if (entity != null && getEntityManager() != null) {
            getEntityManager().merge(entity);
            return entity;
        } else {
            return null;
        }
    }

    public T remove(T entity) {
        if (entity != null && getEntityManager() != null) {
            getEntityManager().remove(getEntityManager().merge(entity));
            return entity;
        } else {
            return null;
        }
    }

    public T find(Object id) {
        return getEntityManager().find(entityClass, id);
    }

    public boolean crear(T entity) {

        if (entity != null && getEntityManager() != null) {
            return create(entity) == entity;
        }
        return false;
    }

    public boolean modificar(T entity) {
        if (entity != null && getEntityManager() != null) {
            return edit(entity) == entity;
        }
        return false;
    }

    public boolean eliminar(T entity) {
        if (entity != null && getEntityManager() != null) {
            return remove(entity) == entity;
        }
        return false;
    }

    public List<T> findAll() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return getEntityManager().createQuery(cq).getResultList();
    }

    public List<T> findRange(int min, int max) {
        if(max > min){javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        q.setMaxResults(max - min + 1);
        q.setFirstResult(max);
        return q.getResultList();
        }else{
        return null;} 
    }

    public int count() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<T> rt = cq.from(entityClass);
        cq.select(getEntityManager().getCriteriaBuilder().count(rt));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }

}
