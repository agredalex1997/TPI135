/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.edu.sv.mantenimientoLib;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
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
 * @author kevin
 */
@Entity
@Table(name = "MODELO", catalog = "mantenimientoTpi", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Modelo.findAll", query = "SELECT m FROM Modelo m")
    , @NamedQuery(name = "Modelo.findById", query = "SELECT m FROM Modelo m WHERE m.modeloPK.id = :id")
    , @NamedQuery(name = "Modelo.findByIdMarca", query = "SELECT m FROM Modelo m WHERE m.modeloPK.idMarca = :idMarca")
    , @NamedQuery(name = "Modelo.findByNombre", query = "SELECT m FROM Modelo m WHERE m.nombre = :nombre")
    , @NamedQuery(name = "Modelo.findByObservaciones", query = "SELECT m FROM Modelo m WHERE m.observaciones = :observaciones")})
public class Modelo implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ModeloPK modeloPK;
    @Basic(optional = false)
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "OBSERVACIONES")
    private String observaciones;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idModelo")
    private Collection<Equipo> equipoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idModelo")
    private Collection<DetalleEquipo> detalleEquipoCollection;
    @JoinColumn(name = "ID_MARCA", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Marca marca;

    public Modelo() {
    }

    public Modelo(ModeloPK modeloPK) {
        this.modeloPK = modeloPK;
    }

    public Modelo(ModeloPK modeloPK, String nombre) {
        this.modeloPK = modeloPK;
        this.nombre = nombre;
    }

    public Modelo(int id, int idMarca) {
        this.modeloPK = new ModeloPK(id, idMarca);
    }

    public ModeloPK getModeloPK() {
        return modeloPK;
    }

    public void setModeloPK(ModeloPK modeloPK) {
        this.modeloPK = modeloPK;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    @XmlTransient
    public Collection<Equipo> getEquipoCollection() {
        return equipoCollection;
    }

    public void setEquipoCollection(Collection<Equipo> equipoCollection) {
        this.equipoCollection = equipoCollection;
    }

    @XmlTransient
    public Collection<DetalleEquipo> getDetalleEquipoCollection() {
        return detalleEquipoCollection;
    }

    public void setDetalleEquipoCollection(Collection<DetalleEquipo> detalleEquipoCollection) {
        this.detalleEquipoCollection = detalleEquipoCollection;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (modeloPK != null ? modeloPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Modelo)) {
            return false;
        }
        Modelo other = (Modelo) object;
        if ((this.modeloPK == null && other.modeloPK != null) || (this.modeloPK != null && !this.modeloPK.equals(other.modeloPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ues.edu.sv.mantenimientoLib.Modelo[ modeloPK=" + modeloPK + " ]";
    }
    
}
