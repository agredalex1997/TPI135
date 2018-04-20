/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.edu.sv.mantenimientoLib;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author kevin
 */
@Embeddable
public class DetalleEquipoPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "ID_EQUIPO")
    private int idEquipo;
    @Basic(optional = false)
    @Column(name = "ID_HARDWARE")
    private int idHardware;

    public DetalleEquipoPK() {
    }

    public DetalleEquipoPK(int idEquipo, int idHardware) {
        this.idEquipo = idEquipo;
        this.idHardware = idHardware;
    }

    public int getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(int idEquipo) {
        this.idEquipo = idEquipo;
    }

    public int getIdHardware() {
        return idHardware;
    }

    public void setIdHardware(int idHardware) {
        this.idHardware = idHardware;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idEquipo;
        hash += (int) idHardware;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleEquipoPK)) {
            return false;
        }
        DetalleEquipoPK other = (DetalleEquipoPK) object;
        if (this.idEquipo != other.idEquipo) {
            return false;
        }
        if (this.idHardware != other.idHardware) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ues.edu.sv.mantenimientoLib.DetalleEquipoPK[ idEquipo=" + idEquipo + ", idHardware=" + idHardware + " ]";
    }
    
}
