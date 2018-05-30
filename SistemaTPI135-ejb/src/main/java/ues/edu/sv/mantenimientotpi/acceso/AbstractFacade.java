/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.edu.sv.mantenimientotpi.acceso;

import java.util.Collections;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 *
 * @author esperanza
 * @Param <T>
 */
public abstract class AbstractFacade<T> {
    private Class<T> entityClass;

    public AbstractFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    protected abstract EntityManager getEntityManager();

    public T create(T entity) {
        if (entity != null && getEntityManager()!=null) {
            getEntityManager().persist(entity);
            return entity;
        }else{
            return null;
        }
    }

    public T edit(T entity) {
        if (entity != null && getEntityManager()!=null) {
            getEntityManager().merge(entity);
            return entity;
        }else{
            return null;
        }
    }

    public T remove(T entity) {
        if (entity!=null && getEntityManager()!=null) {
            getEntityManager().remove(getEntityManager().merge(entity));
            return entity;
        }else{
            return null;
        }
    }
    
    public boolean crear(T entity){
        
        if (entity!= null && getEntityManager()!=null) {
            return create(entity)==entity;
        }
        return false;
    }
    
    public boolean modificar(T entity){
        if (entity!= null && getEntityManager()!=null) {
            return edit(entity)==entity;
        }
        return false;
    }
    
    public boolean eliminar(T entity){
        if (entity!= null && getEntityManager()!=null) {
            return remove(entity)==entity;
        }
        return false;
    }
    

    public T find(Object id) {
        return getEntityManager().find(entityClass, id);
    }

    public List<T> findAll() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return getEntityManager().createQuery(cq).getResultList();
    }

    public List<T> findRange(int[] range) {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        q.setMaxResults(range[1] - range[0] + 1);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }

    public int count() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<T> rt = cq.from(entityClass);
        cq.select(getEntityManager().getCriteriaBuilder().count(rt));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }
    
    public List<T> findRange(int lower, int higher) {
      if (higher > lower) {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        q.setMaxResults(higher - lower + 1);
        q.setFirstResult(higher);
        return q.getResultList();
      }
      return Collections.emptyList();
    }

    public List<T> findByName(String name) {
        if (name != null && getEntityManager() != null) {
            CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();
            CriteriaQuery<T> query = builder.createQuery(entityClass);
            Root<T> root = query.from(entityClass);
            Predicate findByName = builder.like(builder.lower(root.<String>get("nombre")), "%" + name.toLowerCase() + "%");
            query.select(root).where(findByName);
            return getEntityManager().createQuery(query).getResultList();
        } else {
            return Collections.emptyList();
        }
    }
}
