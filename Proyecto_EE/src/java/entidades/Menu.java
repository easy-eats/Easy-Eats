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
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author sergi
 */
@Entity
@Table(name = "menu")
@NamedQueries({
    @NamedQuery(name = "Menu.findAll", query = "SELECT m FROM Menu m")
    , @NamedQuery(name = "Menu.findByCodMenu", query = "SELECT m FROM Menu m WHERE m.codMenu = :codMenu")
    , @NamedQuery(name = "Menu.findByPrecio1", query = "SELECT m FROM Menu m WHERE m.precio1 = :precio1")
    , @NamedQuery(name = "Menu.findByPrecio2", query = "SELECT m FROM Menu m WHERE m.precio2 = :precio2")
    , @NamedQuery(name = "Menu.findByPrecio3", query = "SELECT m FROM Menu m WHERE m.precio3 = :precio3")})
public class Menu implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_menu")
    private Integer codMenu;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Column(name = "menu")
    private byte[] menu;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio1")
    private int precio1;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio2")
    private int precio2;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio3")
    private int precio3;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "menuCodMenu", fetch = FetchType.LAZY)
    private List<MenuPuntoVenta> menuPuntoVentaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "menuCodMenu", fetch = FetchType.LAZY)
    private List<ProductoMenu> productoMenuList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "menuCodMenu", fetch = FetchType.LAZY)
    private List<CreditoMenu> creditoMenuList;

    public Menu() {
    }

    public Menu(Integer codMenu) {
        this.codMenu = codMenu;
    }

    public Menu(Integer codMenu, byte[] menu, int precio1, int precio2, int precio3) {
        this.codMenu = codMenu;
        this.menu = menu;
        this.precio1 = precio1;
        this.precio2 = precio2;
        this.precio3 = precio3;
    }

    public Integer getCodMenu() {
        return codMenu;
    }

    public void setCodMenu(Integer codMenu) {
        this.codMenu = codMenu;
    }

    public byte[] getMenu() {
        return menu;
    }

    public void setMenu(byte[] menu) {
        this.menu = menu;
    }

    public int getPrecio1() {
        return precio1;
    }

    public void setPrecio1(int precio1) {
        this.precio1 = precio1;
    }

    public int getPrecio2() {
        return precio2;
    }

    public void setPrecio2(int precio2) {
        this.precio2 = precio2;
    }

    public int getPrecio3() {
        return precio3;
    }

    public void setPrecio3(int precio3) {
        this.precio3 = precio3;
    }

    public List<MenuPuntoVenta> getMenuPuntoVentaList() {
        return menuPuntoVentaList;
    }

    public void setMenuPuntoVentaList(List<MenuPuntoVenta> menuPuntoVentaList) {
        this.menuPuntoVentaList = menuPuntoVentaList;
    }

    public List<ProductoMenu> getProductoMenuList() {
        return productoMenuList;
    }

    public void setProductoMenuList(List<ProductoMenu> productoMenuList) {
        this.productoMenuList = productoMenuList;
    }

    public List<CreditoMenu> getCreditoMenuList() {
        return creditoMenuList;
    }

    public void setCreditoMenuList(List<CreditoMenu> creditoMenuList) {
        this.creditoMenuList = creditoMenuList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codMenu != null ? codMenu.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Menu)) {
            return false;
        }
        Menu other = (Menu) object;
        if ((this.codMenu == null && other.codMenu != null) || (this.codMenu != null && !this.codMenu.equals(other.codMenu))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Menu[ codMenu=" + codMenu + " ]";
    }
    
}
