/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.edu.sv.tpi135.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author esperanza
 */
@Entity
@Table(name = "EXCEPCION_CALENDARIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ExcepcionCalendario.findAll", query = "SELECT e FROM ExcepcionCalendario e")
    , @NamedQuery(name = "ExcepcionCalendario.findByFecha", query = "SELECT e FROM ExcepcionCalendario e WHERE e.fecha = :fecha")
    , @NamedQuery(name = "ExcepcionCalendario.findByDescripcion", query = "SELECT e FROM ExcepcionCalendario e WHERE e.descripcion = :descripcion")})
public class ExcepcionCalendario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "FECHA")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @Column(name = "DESCRIPCION")
    private String descripcion;

    public ExcepcionCalendario() {
    }

    public ExcepcionCalendario(Date fecha) {
        this.fecha = fecha;
    }

    public ExcepcionCalendario(Date fecha, String descripcion) {
        this.fecha = fecha;
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fecha != null ? fecha.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ExcepcionCalendario)) {
            return false;
        }
        ExcepcionCalendario other = (ExcepcionCalendario) object;
        if ((this.fecha == null && other.fecha != null) || (this.fecha != null && !this.fecha.equals(other.fecha))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ues.edu.sv.tpi135.entidades.ExcepcionCalendario[ fecha=" + fecha + " ]";
    }
    
}
