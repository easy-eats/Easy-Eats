/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author sergi
 */
@Entity
@Table(name = "ingresos")
@NamedQueries({
    @NamedQuery(name = "Ingreso.findAll", query = "SELECT i FROM Ingreso i")
    , @NamedQuery(name = "Ingreso.findByCodIngreso", query = "SELECT i FROM Ingreso i WHERE i.codIngreso = :codIngreso")
    , @NamedQuery(name = "Ingreso.findByFechaIngreso", query = "SELECT i FROM Ingreso i WHERE i.fechaIngreso = :fechaIngreso")
    , @NamedQuery(name = "Ingreso.findByTiempoEnSistema", query = "SELECT i FROM Ingreso i WHERE i.tiempoEnSistema = :tiempoEnSistema")
    , @NamedQuery(name = "Ingreso.findByCalificacion", query = "SELECT i FROM Ingreso i WHERE i.calificacion = :calificacion")})
public class Ingreso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_ingreso")
    private Integer codIngreso;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "fecha_ingreso")
    private String fechaIngreso;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "tiempo_en_sistema")
    private String tiempoEnSistema;
    @Basic(optional = false)
    @NotNull
    @Column(name = "calificacion")
    private int calificacion;
    @JoinColumn(name = "usuarios_nick_name", referencedColumnName = "nick_name")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Usuario usuariosNickName;

    public Ingreso() {
    }

    public Ingreso(Integer codIngreso) {
        this.codIngreso = codIngreso;
    }

    public Ingreso(Integer codIngreso, String fechaIngreso, String tiempoEnSistema, int calificacion) {
        this.codIngreso = codIngreso;
        this.fechaIngreso = fechaIngreso;
        this.tiempoEnSistema = tiempoEnSistema;
        this.calificacion = calificacion;
    }

    public Integer getCodIngreso() {
        return codIngreso;
    }

    public void setCodIngreso(Integer codIngreso) {
        this.codIngreso = codIngreso;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getTiempoEnSistema() {
        return tiempoEnSistema;
    }

    public void setTiempoEnSistema(String tiempoEnSistema) {
        this.tiempoEnSistema = tiempoEnSistema;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    public Usuario getUsuariosNickName() {
        return usuariosNickName;
    }

    public void setUsuariosNickName(Usuario usuariosNickName) {
        this.usuariosNickName = usuariosNickName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codIngreso != null ? codIngreso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ingreso)) {
            return false;
        }
        Ingreso other = (Ingreso) object;
        if ((this.codIngreso == null && other.codIngreso != null) || (this.codIngreso != null && !this.codIngreso.equals(other.codIngreso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Ingreso[ codIngreso=" + codIngreso + " ]";
    }
    
}
