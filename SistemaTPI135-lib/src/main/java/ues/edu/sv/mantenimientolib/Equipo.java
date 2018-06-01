/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.edu.sv.mantenimientolib;

import java.io.Serializable;
import java.util.Collection;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author esperanza
 */
@Entity
@Table(name = "EQUIPO", catalog = "mantenimientoTpi", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Equipo.findAll", query = "SELECT e FROM Equipo e")
    , @NamedQuery(name = "Equipo.findById", query = "SELECT e FROM Equipo e WHERE e.id = :id")
    , @NamedQuery(name = "Equipo.findByNoSerie", query = "SELECT e FROM Equipo e WHERE e.noSerie = :noSerie")
    , @NamedQuery(name = "Equipo.findByNoInventario", query = "SELECT e FROM Equipo e WHERE e.noInventario = :noInventario")
    , @NamedQuery(name = "Equipo.findByOs", query = "SELECT e FROM Equipo e WHERE e.os = :os")
    , @NamedQuery(name = "Equipo.findByLicencia", query = "SELECT e FROM Equipo e WHERE e.licencia = :licencia")
    , @NamedQuery(name = "Equipo.findByUsuario", query = "SELECT e FROM Equipo e WHERE e.usuario = :usuario")
    , @NamedQuery(name = "Equipo.findByObservaciones", query = "SELECT e FROM Equipo e WHERE e.observaciones = :observaciones")})
public class Equipo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "NO_SERIE")
    private Integer noSerie;
    @Column(name = "NO_INVENTARIO")
    private Integer noInventario;
    @Basic(optional = false)
    @Column(name = "OS")
    private String os;
    @Basic(optional = false)
    @Column(name = "LICENCIA")
    private boolean licencia;
    @Column(name = "USUARIO")
    private String usuario;
    @Column(name = "OBSERVACIONES")
    private String observaciones;
    @JoinColumn(name = "ID_AREA", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Area idArea;
    @JoinColumn(name = "ID_MODELO", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Modelo idModelo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEquipo")
    private Collection<DetallePeticion> detallePeticionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "equipo")
    private Collection<DetalleEquipo> detalleEquipoCollection;

    public Equipo() {
    }

    public Equipo(Integer id) {
        this.id = id;
    }

    public Equipo(Integer id, String os, boolean licencia) {
        this.id = id;
        this.os = os;
        this.licencia = licencia;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNoSerie() {
        return noSerie;
    }

    public void setNoSerie(Integer noSerie) {
        this.noSerie = noSerie;
    }

    public Integer getNoInventario() {
        return noInventario;
    }

    public void setNoInventario(Integer noInventario) {
        this.noInventario = noInventario;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public boolean getLicencia() {
        return licencia;
    }

    public void setLicencia(boolean licencia) {
        this.licencia = licencia;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Area getIdArea() {
        return idArea;
    }

    public void setIdArea(Area idArea) {
        this.idArea = idArea;
    }

    public Modelo getIdModelo() {
        return idModelo;
    }

    public void setIdModelo(Modelo idModelo) {
        this.idModelo = idModelo;
    }

    @XmlTransient
    public Collection<DetallePeticion> getDetallePeticionCollection() {
        return detallePeticionCollection;
    }

    public void setDetallePeticionCollection(Collection<DetallePeticion> detallePeticionCollection) {
        this.detallePeticionCollection = detallePeticionCollection;
    }

    @XmlTransient
    public Collection<DetalleEquipo> getDetalleEquipoCollection() {
        return detalleEquipoCollection;
    }

    public void setDetalleEquipoCollection(Collection<DetalleEquipo> detalleEquipoCollection) {
        this.detalleEquipoCollection = detalleEquipoCollection;
    }

    
}
