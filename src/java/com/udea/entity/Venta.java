/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author giovanny
 */
@Entity
@Table(name = "venta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Venta.findAll", query = "SELECT v FROM Venta v")
    , @NamedQuery(name = "Venta.findByFecha", query = "SELECT v FROM Venta v WHERE v.fecha = :fecha")})
public class Venta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @JoinColumn(name = "cuenta_idAccount", referencedColumnName = "idAccount")
    @ManyToOne(optional = false)
    private Cuenta cuentaidAccount;
    @JoinColumn(name = "vehiculo_matricula", referencedColumnName = "matricula")
    @ManyToOne(optional = false)
    private Vehiculo vehiculoMatricula;

    public Venta() {
    }

    public Venta(Date fecha) {
        this.fecha = fecha;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Cuenta getCuentaidAccount() {
        return cuentaidAccount;
    }

    public void setCuentaidAccount(Cuenta cuentaidAccount) {
        this.cuentaidAccount = cuentaidAccount;
    }

    public Vehiculo getVehiculoMatricula() {
        return vehiculoMatricula;
    }

    public void setVehiculoMatricula(Vehiculo vehiculoMatricula) {
        this.vehiculoMatricula = vehiculoMatricula;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fecha != null ? fecha.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Venta)) {
            return false;
        }
        Venta other = (Venta) object;
        if ((this.fecha == null && other.fecha != null) || (this.fecha != null && !this.fecha.equals(other.fecha))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.udea.entity.Venta[ fecha=" + fecha + " ]";
    }
    
}
