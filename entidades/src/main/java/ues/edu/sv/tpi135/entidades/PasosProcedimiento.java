/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.edu.sv.tpi135.entidades;

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
 * @author esperanza
 */
@Entity
@Table(name = "PASOS_PROCEDIMIENTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PasosProcedimiento.findAll", query = "SELECT p FROM PasosProcedimiento p")
    , @NamedQuery(name = "PasosProcedimiento.findByIdProcedimiento", query = "SELECT p FROM PasosProcedimiento p WHERE p.idProcedimiento = :idProcedimiento")
    , @NamedQuery(name = "PasosProcedimiento.findByCorrelativo", query = "SELECT p FROM PasosProcedimiento p WHERE p.correlativo = :correlativo")})
public class PasosProcedimiento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_PROCEDIMIENTO")
    private Integer idProcedimiento;
    @Basic(optional = false)
    @Column(name = "CORRELATIVO")
    private int correlativo;
    @JoinColumn(name = "ID_PASO", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Pasos idPaso;
    @JoinColumn(name = "ID_PROCEDIMIENTO", referencedColumnName = "ID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Procedimiento procedimiento;

    public PasosProcedimiento() {
    }

    public PasosProcedimiento(Integer idProcedimiento) {
        this.idProcedimiento = idProcedimiento;
    }

    public PasosProcedimiento(Integer idProcedimiento, int correlativo) {
        this.idProcedimiento = idProcedimiento;
        this.correlativo = correlativo;
    }

    public Integer getIdProcedimiento() {
        return idProcedimiento;
    }

    public void setIdProcedimiento(Integer idProcedimiento) {
        this.idProcedimiento = idProcedimiento;
    }

    public int getCorrelativo() {
        return correlativo;
    }

    public void setCorrelativo(int correlativo) {
        this.correlativo = correlativo;
    }

    public Pasos getIdPaso() {
        return idPaso;
    }

    public void setIdPaso(Pasos idPaso) {
        this.idPaso = idPaso;
    }

    public Procedimiento getProcedimiento() {
        return procedimiento;
    }

    public void setProcedimiento(Procedimiento procedimiento) {
        this.procedimiento = procedimiento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProcedimiento != null ? idProcedimiento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PasosProcedimiento)) {
            return false;
        }
        PasosProcedimiento other = (PasosProcedimiento) object;
        if ((this.idProcedimiento == null && other.idProcedimiento != null) || (this.idProcedimiento != null && !this.idProcedimiento.equals(other.idProcedimiento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ues.edu.sv.tpi135.entidades.PasosProcedimiento[ idProcedimiento=" + idProcedimiento + " ]";
    }
    
}
