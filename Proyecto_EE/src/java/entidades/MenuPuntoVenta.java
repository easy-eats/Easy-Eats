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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author sergi
 */
@Entity
@Table(name = "menus_puntos_venta")
@NamedQueries({
    @NamedQuery(name = "MenuPuntoVenta.findAll", query = "SELECT m FROM MenuPuntoVenta m")
    , @NamedQuery(name = "MenuPuntoVenta.findByCodMenuPunto", query = "SELECT m FROM MenuPuntoVenta m WHERE m.codMenuPunto = :codMenuPunto")})
public class MenuPuntoVenta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_menu_punto")
    private Integer codMenuPunto;
    @JoinColumn(name = "menu_cod_menu", referencedColumnName = "cod_menu")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Menu menuCodMenu;
    @JoinColumn(name = "puntos_venta_cod_punto_venta", referencedColumnName = "cod_punto_venta")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private PuntoVenta puntosVentaCodPuntoVenta;

    public MenuPuntoVenta() {
    }

    public MenuPuntoVenta(Integer codMenuPunto) {
        this.codMenuPunto = codMenuPunto;
    }

    public Integer getCodMenuPunto() {
        return codMenuPunto;
    }

    public void setCodMenuPunto(Integer codMenuPunto) {
        this.codMenuPunto = codMenuPunto;
    }

    public Menu getMenuCodMenu() {
        return menuCodMenu;
    }

    public void setMenuCodMenu(Menu menuCodMenu) {
        this.menuCodMenu = menuCodMenu;
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
        hash += (codMenuPunto != null ? codMenuPunto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MenuPuntoVenta)) {
            return false;
        }
        MenuPuntoVenta other = (MenuPuntoVenta) object;
        if ((this.codMenuPunto == null && other.codMenuPunto != null) || (this.codMenuPunto != null && !this.codMenuPunto.equals(other.codMenuPunto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.MenuPuntoVenta[ codMenuPunto=" + codMenuPunto + " ]";
    }
    
}
