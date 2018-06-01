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
@Table(name = "DETALLE_PETICION", catalog = "mantenimientoTpi", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetallePeticion.findAll", query = "SELECT d FROM DetallePeticion d")
    , @NamedQuery(name = "DetallePeticion.findById", query = "SELECT d FROM DetallePeticion d WHERE d.id = :id")
    , @NamedQuery(name = "DetallePeticion.findByObservaciones", query = "SELECT d FROM DetallePeticion d WHERE d.observaciones = :observaciones")})
public class DetallePeticion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "OBSERVACIONES")
    private String observaciones;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDetallePeticion")
    private Collection<OrdenTrabajo> ordenTrabajoCollection;
    @JoinColumn(name = "ID_EQUIPO", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Equipo idEquipo;
    @JoinColumn(name = "ID_PETICION", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Peticion idPeticion;

    public DetallePeticion() {
    }

    public DetallePeticion(Integer id) {
        this.id = id;
    }

    public DetallePeticion(Integer id, Peticion idPeticion, Equipo idEquipo, String observaciones) {
        this.id = id;
        this.observaciones = observaciones;
        this.idEquipo = idEquipo;
        this.idPeticion = idPeticion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Equipo getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(Equipo idEquipo) {
        this.idEquipo = idEquipo;
    }

    public Peticion getIdPeticion() {
        return idPeticion;
    }

    public void setIdPeticion(Peticion idPeticion) {
        this.idPeticion = idPeticion;
    }

    
}
