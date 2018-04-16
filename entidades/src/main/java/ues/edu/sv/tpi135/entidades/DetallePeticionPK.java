/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.edu.sv.tpi135.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author esperanza
 */
@Embeddable
public class DetallePeticionPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "ID_PETICION")
    private int idPeticion;
    @Basic(optional = false)
    @Column(name = "ID_EQUIPO")
    private int idEquipo;

    public DetallePeticionPK() {
    }

    public DetallePeticionPK(int idPeticion, int idEquipo) {
        this.idPeticion = idPeticion;
        this.idEquipo = idEquipo;
    }

    public int getIdPeticion() {
        return idPeticion;
    }

    public void setIdPeticion(int idPeticion) {
        this.idPeticion = idPeticion;
    }

    public int getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(int idEquipo) {
        this.idEquipo = idEquipo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idPeticion;
        hash += (int) idEquipo;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetallePeticionPK)) {
            return false;
        }
        DetallePeticionPK other = (DetallePeticionPK) object;
        if (this.idPeticion != other.idPeticion) {
            return false;
        }
        if (this.idEquipo != other.idEquipo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ues.edu.sv.tpi135.entidades.DetallePeticionPK[ idPeticion=" + idPeticion + ", idEquipo=" + idEquipo + " ]";
    }
    
}
