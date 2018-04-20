/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.edu.sv.mantenimientoLib;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author kevin
 */
@Entity
@Table(name = "PETICION", catalog = "mantenimientoTpi", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Peticion.findAll", query = "SELECT p FROM Peticion p")
    , @NamedQuery(name = "Peticion.findById", query = "SELECT p FROM Peticion p WHERE p.id = :id")
    , @NamedQuery(name = "Peticion.findByFecha", query = "SELECT p FROM Peticion p WHERE p.fecha = :fecha")
    , @NamedQuery(name = "Peticion.findByObservaciones", query = "SELECT p FROM Peticion p WHERE p.observaciones = :observaciones")})
public class Peticion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "FECHA")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Column(name = "OBSERVACIONES")
    private String observaciones;
    @JoinColumn(name = "ID_ORIGEN", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private OrigenPeticion idOrigen;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "peticion")
    private Collection<DetallePeticion> detallePeticionCollection;

    public Peticion() {
    }

    public Peticion(Integer id) {
        this.id = id;
    }

    public Peticion(Integer id, Date fecha) {
        this.id = id;
        this.fecha = fecha;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public OrigenPeticion getIdOrigen() {
        return idOrigen;
    }

    public void setIdOrigen(OrigenPeticion idOrigen) {
        this.idOrigen = idOrigen;
    }

    @XmlTransient
    public Collection<DetallePeticion> getDetallePeticionCollection() {
        return detallePeticionCollection;
    }

    public void setDetallePeticionCollection(Collection<DetallePeticion> detallePeticionCollection) {
        this.detallePeticionCollection = detallePeticionCollection;
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
        if (!(object instanceof Peticion)) {
            return false;
        }
        Peticion other = (Peticion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ues.edu.sv.mantenimientoLib.Peticion[ id=" + id + " ]";
    }
    
}
