/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.edu.sv.tpi135.entidades;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "DETALLE_PETICION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetallePeticion.findAll", query = "SELECT d FROM DetallePeticion d")
    , @NamedQuery(name = "DetallePeticion.findByIdPeticion", query = "SELECT d FROM DetallePeticion d WHERE d.detallePeticionPK.idPeticion = :idPeticion")
    , @NamedQuery(name = "DetallePeticion.findByIdEquipo", query = "SELECT d FROM DetallePeticion d WHERE d.detallePeticionPK.idEquipo = :idEquipo")
    , @NamedQuery(name = "DetallePeticion.findByObservaciones", query = "SELECT d FROM DetallePeticion d WHERE d.observaciones = :observaciones")})
public class DetallePeticion implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DetallePeticionPK detallePeticionPK;
    @Column(name = "OBSERVACIONES")
    private String observaciones;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEquipo")
    private Collection<OrdenTrabajo> ordenTrabajoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPeticion")
    private Collection<OrdenTrabajo> ordenTrabajoCollection1;
    @JoinColumn(name = "ID_EQUIPO", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Equipo equipo;
    @JoinColumn(name = "ID_PETICION", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Peticion peticion;

    public DetallePeticion() {
    }

    public DetallePeticion(DetallePeticionPK detallePeticionPK) {
        this.detallePeticionPK = detallePeticionPK;
    }

    public DetallePeticion(int idPeticion, int idEquipo) {
        this.detallePeticionPK = new DetallePeticionPK(idPeticion, idEquipo);
    }

    public DetallePeticionPK getDetallePeticionPK() {
        return detallePeticionPK;
    }

    public void setDetallePeticionPK(DetallePeticionPK detallePeticionPK) {
        this.detallePeticionPK = detallePeticionPK;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    @XmlTransient
    public Collection<OrdenTrabajo> getOrdenTrabajoCollection() {
        return ordenTrabajoCollection;
    }

    public void setOrdenTrabajoCollection(Collection<OrdenTrabajo> ordenTrabajoCollection) {
        this.ordenTrabajoCollection = ordenTrabajoCollection;
    }

    @XmlTransient
    public Collection<OrdenTrabajo> getOrdenTrabajoCollection1() {
        return ordenTrabajoCollection1;
    }

    public void setOrdenTrabajoCollection1(Collection<OrdenTrabajo> ordenTrabajoCollection1) {
        this.ordenTrabajoCollection1 = ordenTrabajoCollection1;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public Peticion getPeticion() {
        return peticion;
    }

    public void setPeticion(Peticion peticion) {
        this.peticion = peticion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (detallePeticionPK != null ? detallePeticionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetallePeticion)) {
            return false;
        }
        DetallePeticion other = (DetallePeticion) object;
        if ((this.detallePeticionPK == null && other.detallePeticionPK != null) || (this.detallePeticionPK != null && !this.detallePeticionPK.equals(other.detallePeticionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ues.edu.sv.tpi135.entidades.DetallePeticion[ detallePeticionPK=" + detallePeticionPK + " ]";
    }
    
}
