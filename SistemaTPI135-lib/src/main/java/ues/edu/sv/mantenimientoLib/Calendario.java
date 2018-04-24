/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.edu.sv.mantenimientoLib;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author esperanza
 */
@Entity
@Table(name = "CALENDARIO", catalog = "mantenimientoTpi", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Calendario.findAll", query = "SELECT c FROM Calendario c")
    , @NamedQuery(name = "Calendario.findByFecha", query = "SELECT c FROM Calendario c WHERE c.calendarioPK.fecha = :fecha")
    , @NamedQuery(name = "Calendario.findByIdEquipo", query = "SELECT c FROM Calendario c WHERE c.calendarioPK.idEquipo = :idEquipo")})
public class Calendario implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CalendarioPK calendarioPK;

    public Calendario() {
    }

    public Calendario(CalendarioPK calendarioPK) {
        this.calendarioPK = calendarioPK;
    }

    public Calendario(Date fecha, int idEquipo) {
        this.calendarioPK = new CalendarioPK(fecha, idEquipo);
    }

    public CalendarioPK getCalendarioPK() {
        return calendarioPK;
    }

    public void setCalendarioPK(CalendarioPK calendarioPK) {
        this.calendarioPK = calendarioPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (calendarioPK != null ? calendarioPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Calendario)) {
            return false;
        }
        Calendario other = (Calendario) object;
        if ((this.calendarioPK == null && other.calendarioPK != null) || (this.calendarioPK != null && !this.calendarioPK.equals(other.calendarioPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ues.edu.sv.mantenimientoLib.Calendario[ calendarioPK=" + calendarioPK + " ]";
    }
    
}
