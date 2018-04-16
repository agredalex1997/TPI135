/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.edu.sv.tpi135.entidades;

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
@Table(name = "HARDWARE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Hardware.findAll", query = "SELECT h FROM Hardware h")
    , @NamedQuery(name = "Hardware.findById", query = "SELECT h FROM Hardware h WHERE h.id = :id")
    , @NamedQuery(name = "Hardware.findByNombre", query = "SELECT h FROM Hardware h WHERE h.nombre = :nombre")
    , @NamedQuery(name = "Hardware.findByUnidadMedida", query = "SELECT h FROM Hardware h WHERE h.unidadMedida = :unidadMedida")
    , @NamedQuery(name = "Hardware.findByObservaciones", query = "SELECT h FROM Hardware h WHERE h.observaciones = :observaciones")})
public class Hardware implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "UNIDAD_MEDIDA")
    private String unidadMedida;
    @Column(name = "OBSERVACIONES")
    private String observaciones;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idHardware")
    private Collection<DiagnosticoHardware> diagnosticoHardwareCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "hardware")
    private Collection<DetalleEquipo> detalleEquipoCollection;

    public Hardware() {
    }

    public Hardware(Integer id) {
        this.id = id;
    }

    public Hardware(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
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

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    @XmlTransient
    public Collection<DiagnosticoHardware> getDiagnosticoHardwareCollection() {
        return diagnosticoHardwareCollection;
    }

    public void setDiagnosticoHardwareCollection(Collection<DiagnosticoHardware> diagnosticoHardwareCollection) {
        this.diagnosticoHardwareCollection = diagnosticoHardwareCollection;
    }

    @XmlTransient
    public Collection<DetalleEquipo> getDetalleEquipoCollection() {
        return detalleEquipoCollection;
    }

    public void setDetalleEquipoCollection(Collection<DetalleEquipo> detalleEquipoCollection) {
        this.detalleEquipoCollection = detalleEquipoCollection;
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
        if (!(object instanceof Hardware)) {
            return false;
        }
        Hardware other = (Hardware) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ues.edu.sv.tpi135.entidades.Hardware[ id=" + id + " ]";
    }
    
}
