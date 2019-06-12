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
@Table(name = "barrios")
@NamedQueries({
    @NamedQuery(name = "Barrio.findAll", query = "SELECT b FROM Barrio b")
    , @NamedQuery(name = "Barrio.findByCodBarrio", query = "SELECT b FROM Barrio b WHERE b.codBarrio = :codBarrio")
    , @NamedQuery(name = "Barrio.findByNombreBarrio", query = "SELECT b FROM Barrio b WHERE b.nombreBarrio = :nombreBarrio")})
public class Barrio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_barrio")
    private Integer codBarrio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 35)
    @Column(name = "nombre_barrio")
    private String nombreBarrio;
    @JoinColumn(name = "puntos_venta_cod_punto_venta", referencedColumnName = "cod_punto_venta")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private PuntoVenta puntosVentaCodPuntoVenta;

    public Barrio() {
    }

    public Barrio(Integer codBarrio) {
        this.codBarrio = codBarrio;
    }

    public Barrio(Integer codBarrio, String nombreBarrio) {
        this.codBarrio = codBarrio;
        this.nombreBarrio = nombreBarrio;
    }

    public Integer getCodBarrio() {
        return codBarrio;
    }

    public void setCodBarrio(Integer codBarrio) {
        this.codBarrio = codBarrio;
    }

    public String getNombreBarrio() {
        return nombreBarrio;
    }

    public void setNombreBarrio(String nombreBarrio) {
        this.nombreBarrio = nombreBarrio;
    }

    public PuntoVenta getPuntosVentaCodPuntoVenta() {
        return puntosVentaCodPuntoVenta;
    }

    public void setPuntosVentaCodPuntoVenta(PuntoVenta puntosVentaCodPuntoVenta) {
        this.puntosVentaCodPuntoVenta = puntosVentaCodPuntoVenta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codBarrio != null ? codBarrio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Barrio)) {
            return false;
        }
        Barrio other = (Barrio) object;
        if ((this.codBarrio == null && other.codBarrio != null) || (this.codBarrio != null && !this.codBarrio.equals(other.codBarrio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Barrio[ codBarrio=" + codBarrio + " ]";
    }
    
}
