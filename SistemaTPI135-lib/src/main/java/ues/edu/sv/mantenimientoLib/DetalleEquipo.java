/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.edu.sv.mantenimientoLib;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author esperanza
 */
@Entity
@Table(name = "DETALLE_EQUIPO", catalog = "mantenimientoTpi", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalleEquipo.findAll", query = "SELECT d FROM DetalleEquipo d")
    , @NamedQuery(name = "DetalleEquipo.findByIdEquipo", query = "SELECT d FROM DetalleEquipo d WHERE d.detalleEquipoPK.idEquipo = :idEquipo")
    , @NamedQuery(name = "DetalleEquipo.findByIdHardware", query = "SELECT d FROM DetalleEquipo d WHERE d.detalleEquipoPK.idHardware = :idHardware")
    , @NamedQuery(name = "DetalleEquipo.findByNoInventario", query = "SELECT d FROM DetalleEquipo d WHERE d.noInventario = :noInventario")
    , @NamedQuery(name = "DetalleEquipo.findByNoSerie", query = "SELECT d FROM DetalleEquipo d WHERE d.noSerie = :noSerie")
    , @NamedQuery(name = "DetalleEquipo.findByTamanio", query = "SELECT d FROM DetalleEquipo d WHERE d.tamanio = :tamanio")
    , @NamedQuery(name = "DetalleEquipo.findByObservaciones", query = "SELECT d FROM DetalleEquipo d WHERE d.observaciones = :observaciones")})
public class DetalleEquipo implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DetalleEquipoPK detalleEquipoPK;
    @Column(name = "NO_INVENTARIO")
    private Integer noInventario;
    @Column(name = "NO_SERIE")
    private Integer noSerie;
    @Column(name = "TAMANIO")
    private Integer tamanio;
    @Column(name = "OBSERVACIONES")
    private String observaciones;
    @JoinColumn(name = "ID_EQUIPO", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Equipo equipo;
    @JoinColumn(name = "ID_HARDWARE", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Hardware hardware;
    @JoinColumn(name = "ID_MODELO", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Modelo idModelo;

    public DetalleEquipo() {
    }

    public DetalleEquipo(DetalleEquipoPK detalleEquipoPK) {
        this.detalleEquipoPK = detalleEquipoPK;
    }

    public DetalleEquipo(int idEquipo, int idHardware) {
        this.detalleEquipoPK = new DetalleEquipoPK(idEquipo, idHardware);
    }

    public DetalleEquipoPK getDetalleEquipoPK() {
        return detalleEquipoPK;
    }

    public void setDetalleEquipoPK(DetalleEquipoPK detalleEquipoPK) {
        this.detalleEquipoPK = detalleEquipoPK;
    }

    public Integer getNoInventario() {
        return noInventario;
    }

    public void setNoInventario(Integer noInventario) {
        this.noInventario = noInventario;
    }

    public Integer getNoSerie() {
        return noSerie;
    }

    public void setNoSerie(Integer noSerie) {
        this.noSerie = noSerie;
    }

    public Integer getTamanio() {
        return tamanio;
    }

    public void setTamanio(Integer tamanio) {
        this.tamanio = tamanio;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public Hardware getHardware() {
        return hardware;
    }

    public void setHardware(Hardware hardware) {
        this.hardware = hardware;
    }

    public Modelo getIdModelo() {
        return idModelo;
    }

    public void setIdModelo(Modelo idModelo) {
        this.idModelo = idModelo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (detalleEquipoPK != null ? detalleEquipoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleEquipo)) {
            return false;
        }
        DetalleEquipo other = (DetalleEquipo) object;
        if ((this.detalleEquipoPK == null && other.detalleEquipoPK != null) || (this.detalleEquipoPK != null && !this.detalleEquipoPK.equals(other.detalleEquipoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ues.edu.sv.mantenimientoLib.DetalleEquipo[ detalleEquipoPK=" + detalleEquipoPK + " ]";
    }
    
}
