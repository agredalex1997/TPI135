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
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author esperanza
 */
@Entity
@Table(name = "PERSONAL_MANTENIMIENTO", catalog = "mantenimientoTpi", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PersonalMantenimiento.findAll", query = "SELECT p FROM PersonalMantenimiento p")
    , @NamedQuery(name = "PersonalMantenimiento.findByDui", query = "SELECT p FROM PersonalMantenimiento p WHERE p.dui = :dui")
    , @NamedQuery(name = "PersonalMantenimiento.findByNombres", query = "SELECT p FROM PersonalMantenimiento p WHERE p.nombres = :nombres")
    , @NamedQuery(name = "PersonalMantenimiento.findByApellidos", query = "SELECT p FROM PersonalMantenimiento p WHERE p.apellidos = :apellidos")
    , @NamedQuery(name = "PersonalMantenimiento.findByTelefono", query = "SELECT p FROM PersonalMantenimiento p WHERE p.telefono = :telefono")
    , @NamedQuery(name = "PersonalMantenimiento.findByEmail", query = "SELECT p FROM PersonalMantenimiento p WHERE p.email = :email")})
public class PersonalMantenimiento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "DUI")
    private Integer dui;
    @Basic(optional = false)
    @Column(name = "NOMBRES")
    private String nombres;
    @Basic(optional = false)
    @Column(name = "APELLIDOS")
    private String apellidos;
    @Basic(optional = false)
    @Column(name = "TELEFONO")
    private String telefono;
    @Basic(optional = false)
    @Column(name = "EMAIL")
    private String email;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEncargadoMantenimiento")
    private Collection<OrdenTrabajo> ordenTrabajoCollection;

    public PersonalMantenimiento() {
    }

    public PersonalMantenimiento(Integer dui) {
        this.dui = dui;
    }

    public PersonalMantenimiento(Integer dui, String nombres, String apellidos, String telefono, String email) {
        this.dui = dui;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.email = email;
    }

    public Integer getDui() {
        return dui;
    }

    public void setDui(Integer dui) {
        this.dui = dui;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @XmlTransient
    public Collection<OrdenTrabajo> getOrdenTrabajoCollection() {
        return ordenTrabajoCollection;
    }

    public void setOrdenTrabajoCollection(Collection<OrdenTrabajo> ordenTrabajoCollection) {
        this.ordenTrabajoCollection = ordenTrabajoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dui != null ? dui.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PersonalMantenimiento)) {
            return false;
        }
        PersonalMantenimiento other = (PersonalMantenimiento) object;
        if ((this.dui == null && other.dui != null) || (this.dui != null && !this.dui.equals(other.dui))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ues.edu.sv.mantenimientoLib.PersonalMantenimiento[ dui=" + dui + " ]";
    }
    
}
