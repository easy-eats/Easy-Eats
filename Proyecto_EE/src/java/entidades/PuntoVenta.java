/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author sergi
 */
@Entity
@Table(name = "puntos_venta")
@NamedQueries({
    @NamedQuery(name = "PuntoVenta.findAll", query = "SELECT p FROM PuntoVenta p")
    , @NamedQuery(name = "PuntoVenta.findByCodPuntoVenta", query = "SELECT p FROM PuntoVenta p WHERE p.codPuntoVenta = :codPuntoVenta")
    , @NamedQuery(name = "PuntoVenta.findByNombrePunto", query = "SELECT p FROM PuntoVenta p WHERE p.nombrePunto = :nombrePunto")
    , @NamedQuery(name = "PuntoVenta.findByDireccionPunto", query = "SELECT p FROM PuntoVenta p WHERE p.direccionPunto = :direccionPunto")})
public class PuntoVenta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_punto_venta")
    private Integer codPuntoVenta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre_punto")
    private String nombrePunto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "direccion_punto")
    private String direccionPunto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "puntosVentaCodPuntoVenta", fetch = FetchType.LAZY)
    private List<MenuPuntoVenta> menuPuntoVentaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "puntosVentaCodPuntoVenta", fetch = FetchType.LAZY)
    private List<Barrio> barrioList;
    @JoinColumn(name = "marcas_cod_marca", referencedColumnName = "cod_marca")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Marca marcasCodMarca;
    @JoinColumn(name = "personas_cod_identificacion", referencedColumnName = "cod_identificacion")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Persona personasCodIdentificacion;

    public PuntoVenta() {
    }

    public PuntoVenta(Integer codPuntoVenta) {
        this.codPuntoVenta = codPuntoVenta;
    }

    public PuntoVenta(Integer codPuntoVenta, String nombrePunto, String direccionPunto) {
        this.codPuntoVenta = codPuntoVenta;
        this.nombrePunto = nombrePunto;
        this.direccionPunto = direccionPunto;
    }

    public Integer getCodPuntoVenta() {
        return codPuntoVenta;
    }

    public void setCodPuntoVenta(Integer codPuntoVenta) {
        this.codPuntoVenta = codPuntoVenta;
    }

    public String getNombrePunto() {
        return nombrePunto;
    }

    public void setNombrePunto(String nombrePunto) {
        this.nombrePunto = nombrePunto;
    }

    public String getDireccionPunto() {
        return direccionPunto;
    }

    public void setDireccionPunto(String direccionPunto) {
        this.direccionPunto = direccionPunto;
    }

    public List<MenuPuntoVenta> getMenuPuntoVentaList() {
        return menuPuntoVentaList;
    }

    public void setMenuPuntoVentaList(List<MenuPuntoVenta> menuPuntoVentaList) {
        this.menuPuntoVentaList = menuPuntoVentaList;
    }

    public List<Barrio> getBarrioList() {
        return barrioList;
    }

    public void setBarrioList(List<Barrio> barrioList) {
        this.barrioList = barrioList;
    }

    public Marca getMarcasCodMarca() {
        return marcasCodMarca;
    }

    public void setMarcasCodMarca(Marca marcasCodMarca) {
        this.marcasCodMarca = marcasCodMarca;
    }

    public Persona getPersonasCodIdentificacion() {
        return personasCodIdentificacion;
    }

    public void setPersonasCodIdentificacion(Persona personasCodIdentificacion) {
        this.personasCodIdentificacion = personasCodIdentificacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codPuntoVenta != null ? codPuntoVenta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PuntoVenta)) {
            return false;
        }
        PuntoVenta other = (PuntoVenta) object;
        if ((this.codPuntoVenta == null && other.codPuntoVenta != null) || (this.codPuntoVenta != null && !this.codPuntoVenta.equals(other.codPuntoVenta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.PuntoVenta[ codPuntoVenta=" + codPuntoVenta + " ]";
    }
    
}
