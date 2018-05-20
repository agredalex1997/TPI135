/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.edu.sv.mantenimientolib;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author esperanza
 */
@Entity
@Table(name = "PASOS", catalog = "mantenimientoTpi", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pasos.findAll", query = "SELECT p FROM Pasos p")
    , @NamedQuery(name = "Pasos.findById", query = "SELECT p FROM Pasos p WHERE p.id = :id")
    , @NamedQuery(name = "Pasos.findByNombre", query = "SELECT p FROM Pasos p WHERE p.nombre = :nombre")
    , @NamedQuery(name = "Pasos.findByDescripcion", query = "SELECT p FROM Pasos p WHERE p.descripcion = :descripcion")})
public class Pasos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPaso")
    private Collection<PasosProcedimiento> pasosProcedimientoCollection;

    public Pasos() {
    }

    public Pasos(Integer id) {
        this.id = id;
    }

    public Pasos(Integer id, String nombre, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public Collection<PasosProcedimiento> getPasosProcedimientoCollection() {
        return pasosProcedimientoCollection;
    }

    public void setPasosProcedimientoCollection(Collection<PasosProcedimiento> pasosProcedimientoCollection) {
        this.pasosProcedimientoCollection = pasosProcedimientoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pasos)) {
            return false;
        }
        Pasos other = (Pasos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ues.edu.sv.mantenimientoLib.Pasos[ id=" + id + " ]";
    }
    
}
