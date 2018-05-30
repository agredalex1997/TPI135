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
@Table(name = "ORIGEN_PETICION", catalog = "mantenimientoTpi", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrigenPeticion.findAll", query = "SELECT o FROM OrigenPeticion o")
    , @NamedQuery(name = "OrigenPeticion.findById", query = "SELECT o FROM OrigenPeticion o WHERE o.id = :id")
    , @NamedQuery(name = "OrigenPeticion.findByNombre", query = "SELECT o FROM OrigenPeticion o WHERE o.nombre = :nombre")})
public class OrigenPeticion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "NOMBRE")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idOrigen")
    private Collection<Peticion> peticionCollection;

    public OrigenPeticion() {
    }

    public OrigenPeticion(Integer id) {
        this.id = id;
    }

    public OrigenPeticion(Integer id, String nombre) {
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

    @XmlTransient
    public Collection<Peticion> getPeticionCollection() {
        return peticionCollection;
    }

    public void setPeticionCollection(Collection<Peticion> peticionCollection) {
        this.peticionCollection = peticionCollection;
    }

 
    
}
