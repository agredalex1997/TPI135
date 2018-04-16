/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.edu.sv.tpi135.entidades;

import java.io.Serializable;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author esperanza
 */
@Entity
@Table(name = "ORDEN_TRABAJO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrdenTrabajo.findAll", query = "SELECT o FROM OrdenTrabajo o")
    , @NamedQuery(name = "OrdenTrabajo.findById", query = "SELECT o FROM OrdenTrabajo o WHERE o.id = :id")
    , @NamedQuery(name = "OrdenTrabajo.findByFechaEntrada", query = "SELECT o FROM OrdenTrabajo o WHERE o.fechaEntrada = :fechaEntrada")
    , @NamedQuery(name = "OrdenTrabajo.findByFechaSalida", query = "SELECT o FROM OrdenTrabajo o WHERE o.fechaSalida = :fechaSalida")})
public class OrdenTrabajo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "FECHA_ENTRADA")
    @Temporal(TemporalType.DATE)
    private Date fechaEntrada;
    @Column(name = "FECHA_SALIDA")
    @Temporal(TemporalType.DATE)
    private Date fechaSalida;
    @JoinColumn(name = "ID_ENCARGADO_MANTENIMIENTO", referencedColumnName = "DUI")
    @ManyToOne(optional = false)
    private PersonalMantenimiento idEncargadoMantenimiento;
    @JoinColumn(name = "ID_EQUIPO", referencedColumnName = "ID_EQUIPO")
    @ManyToOne(optional = false)
    private DetallePeticion idEquipo;
    @JoinColumn(name = "ID_ESTADO", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Estado idEstado;
    @JoinColumn(name = "ID_PETICION", referencedColumnName = "ID_PETICION")
    @ManyToOne(optional = false)
    private DetallePeticion idPeticion;
    @JoinColumn(name = "ID_TIPO_MANTENIMIENTO", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private TipoMantenimiento idTipoMantenimiento;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "ordenTrabajo")
    private DiagnosticoHardware diagnosticoHardware;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "ordenTrabajo")
    private DiagnosticoSoftware diagnosticoSoftware;

    public OrdenTrabajo() {
    }

    public OrdenTrabajo(Integer id) {
        this.id = id;
    }

    public OrdenTrabajo(Integer id, Date fechaEntrada) {
        this.id = id;
        this.fechaEntrada = fechaEntrada;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(Date fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public PersonalMantenimiento getIdEncargadoMantenimiento() {
        return idEncargadoMantenimiento;
    }

    public void setIdEncargadoMantenimiento(PersonalMantenimiento idEncargadoMantenimiento) {
        this.idEncargadoMantenimiento = idEncargadoMantenimiento;
    }

    public DetallePeticion getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(DetallePeticion idEquipo) {
        this.idEquipo = idEquipo;
    }

    public Estado getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Estado idEstado) {
        this.idEstado = idEstado;
    }

    public DetallePeticion getIdPeticion() {
        return idPeticion;
    }

    public void setIdPeticion(DetallePeticion idPeticion) {
        this.idPeticion = idPeticion;
    }

    public TipoMantenimiento getIdTipoMantenimiento() {
        return idTipoMantenimiento;
    }

    public void setIdTipoMantenimiento(TipoMantenimiento idTipoMantenimiento) {
        this.idTipoMantenimiento = idTipoMantenimiento;
    }

    public DiagnosticoHardware getDiagnosticoHardware() {
        return diagnosticoHardware;
    }

    public void setDiagnosticoHardware(DiagnosticoHardware diagnosticoHardware) {
        this.diagnosticoHardware = diagnosticoHardware;
    }

    public DiagnosticoSoftware getDiagnosticoSoftware() {
        return diagnosticoSoftware;
    }

    public void setDiagnosticoSoftware(DiagnosticoSoftware diagnosticoSoftware) {
        this.diagnosticoSoftware = diagnosticoSoftware;
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
        if (!(object instanceof OrdenTrabajo)) {
            return false;
        }
        OrdenTrabajo other = (OrdenTrabajo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ues.edu.sv.tpi135.entidades.OrdenTrabajo[ id=" + id + " ]";
    }
    
}
