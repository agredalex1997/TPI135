/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.edu.sv.mantenimientoLib;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author kevin
 */
@Entity
@Table(name = "DIAGNOSTICO_SOFTWARE", catalog = "mantenimientoTpi", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DiagnosticoSoftware.findAll", query = "SELECT d FROM DiagnosticoSoftware d")
    , @NamedQuery(name = "DiagnosticoSoftware.findByIdOrdenTrabajo", query = "SELECT d FROM DiagnosticoSoftware d WHERE d.idOrdenTrabajo = :idOrdenTrabajo")
    , @NamedQuery(name = "DiagnosticoSoftware.findByDiagnostico", query = "SELECT d FROM DiagnosticoSoftware d WHERE d.diagnostico = :diagnostico")
    , @NamedQuery(name = "DiagnosticoSoftware.findByObservaciones", query = "SELECT d FROM DiagnosticoSoftware d WHERE d.observaciones = :observaciones")})
public class DiagnosticoSoftware implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_ORDEN_TRABAJO")
    private Integer idOrdenTrabajo;
    @Basic(optional = false)
    @Column(name = "DIAGNOSTICO")
    private String diagnostico;
    @Column(name = "OBSERVACIONES")
    private String observaciones;
    @JoinColumn(name = "ID_PROCEDIMIENTO_APLICADO", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Procedimiento idProcedimientoAplicado;
    @JoinColumn(name = "ID_ORDEN_TRABAJO", referencedColumnName = "ID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private OrdenTrabajo ordenTrabajo;

    public DiagnosticoSoftware() {
    }

    public DiagnosticoSoftware(Integer idOrdenTrabajo) {
        this.idOrdenTrabajo = idOrdenTrabajo;
    }

    public DiagnosticoSoftware(Integer idOrdenTrabajo, String diagnostico) {
        this.idOrdenTrabajo = idOrdenTrabajo;
        this.diagnostico = diagnostico;
    }

    public Integer getIdOrdenTrabajo() {
        return idOrdenTrabajo;
    }

    public void setIdOrdenTrabajo(Integer idOrdenTrabajo) {
        this.idOrdenTrabajo = idOrdenTrabajo;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Procedimiento getIdProcedimientoAplicado() {
        return idProcedimientoAplicado;
    }

    public void setIdProcedimientoAplicado(Procedimiento idProcedimientoAplicado) {
        this.idProcedimientoAplicado = idProcedimientoAplicado;
    }

    public OrdenTrabajo getOrdenTrabajo() {
        return ordenTrabajo;
    }

    public void setOrdenTrabajo(OrdenTrabajo ordenTrabajo) {
        this.ordenTrabajo = ordenTrabajo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOrdenTrabajo != null ? idOrdenTrabajo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DiagnosticoSoftware)) {
            return false;
        }
        DiagnosticoSoftware other = (DiagnosticoSoftware) object;
        if ((this.idOrdenTrabajo == null && other.idOrdenTrabajo != null) || (this.idOrdenTrabajo != null && !this.idOrdenTrabajo.equals(other.idOrdenTrabajo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ues.edu.sv.mantenimientoLib.DiagnosticoSoftware[ idOrdenTrabajo=" + idOrdenTrabajo + " ]";
    }
    
}
