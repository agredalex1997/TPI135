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
public class ModeloPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "ID")
    private int id;
    @Basic(optional = false)
    @Column(name = "ID_MARCA")
    private int idMarca;

    public ModeloPK() {
    }

    public ModeloPK(int id, int idMarca) {
        this.id = id;
        this.idMarca = idMarca;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(int idMarca) {
        this.idMarca = idMarca;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        hash += (int) idMarca;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ModeloPK)) {
            return false;
        }
        ModeloPK other = (ModeloPK) object;
        if (this.id != other.id) {
            return false;
        }
        if (this.idMarca != other.idMarca) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ues.edu.sv.tpi135.entidades.ModeloPK[ id=" + id + ", idMarca=" + idMarca + " ]";
    }
    
}
