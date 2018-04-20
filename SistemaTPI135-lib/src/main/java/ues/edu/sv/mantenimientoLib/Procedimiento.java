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
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author kevin
 */
@Entity
@Table(name = "PROCEDIMIENTO", catalog = "mantenimientoTpi", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Procedimiento.findAll", query = "SELECT p FROM Procedimiento p")
    , @NamedQuery(name = "Procedimiento.findById", query = "SELECT p FROM Procedimiento p WHERE p.id = :id")
    , @NamedQuery(name = "Procedimiento.findByNombre", query = "SELECT p FROM Procedimiento p WHERE p.nombre = :nombre")
    , @NamedQuery(name = "Procedimiento.findByDescripcion", query = "SELECT p FROM Procedimiento p WHERE p.descripcion = :descripcion")})
public class Procedimiento implements Serializable {

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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProcedimientoAplicado")
    private Collection<DiagnosticoHardware> diagnosticoHardwareCollection;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "procedimiento")
    private PasosProcedimiento pasosProcedimiento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProcedimientoAplicado")
    private Collection<DiagnosticoSoftware> diagnosticoSoftwareCollection;

    public Procedimiento() {
    }

    public Procedimiento(Integer id) {
        this.id = id;
    }

    public Procedimiento(Integer id, String nombre, String descripcion) {
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
    public Collection<DiagnosticoHardware> getDiagnosticoHardwareCollection() {
        return diagnosticoHardwareCollection;
    }

    public void setDiagnosticoHardwareCollection(Collection<DiagnosticoHardware> diagnosticoHardwareCollection) {
        this.diagnosticoHardwareCollection = diagnosticoHardwareCollection;
    }

    public PasosProcedimiento getPasosProcedimiento() {
        return pasosProcedimiento;
    }

    public void setPasosProcedimiento(PasosProcedimiento pasosProcedimiento) {
        this.pasosProcedimiento = pasosProcedimiento;
    }

    @XmlTransient
    public Collection<DiagnosticoSoftware> getDiagnosticoSoftwareCollection() {
        return diagnosticoSoftwareCollection;
    }

    public void setDiagnosticoSoftwareCollection(Collection<DiagnosticoSoftware> diagnosticoSoftwareCollection) {
        this.diagnosticoSoftwareCollection = diagnosticoSoftwareCollection;
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
        if (!(object instanceof Procedimiento)) {
            return false;
        }
        Procedimiento other = (Procedimiento) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ues.edu.sv.mantenimientoLib.Procedimiento[ id=" + id + " ]";
    }
    
}
