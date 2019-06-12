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

/**
 *
 * @author sergi
 */
@Entity
@Table(name = "productos_menus")
@NamedQueries({
    @NamedQuery(name = "ProductoMenu.findAll", query = "SELECT p FROM ProductoMenu p")
    , @NamedQuery(name = "ProductoMenu.findByCodProductoMenu", query = "SELECT p FROM ProductoMenu p WHERE p.codProductoMenu = :codProductoMenu")})
public class ProductoMenu implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_producto_menu")
    private Integer codProductoMenu;
    @JoinColumn(name = "menu_cod_menu", referencedColumnName = "cod_menu")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Menu menuCodMenu;
    @JoinColumn(name = "producto_cod_producto", referencedColumnName = "cod_producto")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Producto productoCodProducto;

    public ProductoMenu() {
    }

    public ProductoMenu(Integer codProductoMenu) {
        this.codProductoMenu = codProductoMenu;
    }

    public Integer getCodProductoMenu() {
        return codProductoMenu;
    }

    public void setCodProductoMenu(Integer codProductoMenu) {
        this.codProductoMenu = codProductoMenu;
    }

    public Menu getMenuCodMenu() {
        return menuCodMenu;
    }

    public void setMenuCodMenu(Menu menuCodMenu) {
        this.menuCodMenu = menuCodMenu;
    }

    public Producto getProductoCodProducto() {
        return productoCodProducto;
    }

    public void setProductoCodProducto(Producto productoCodProducto) {
        this.productoCodProducto = productoCodProducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codProductoMenu != null ? codProductoMenu.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductoMenu)) {
            return false;
        }
        ProductoMenu other = (ProductoMenu) object;
        if ((this.codProductoMenu == null && other.codProductoMenu != null) || (this.codProductoMenu != null && !this.codProductoMenu.equals(other.codProductoMenu))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.ProductoMenu[ codProductoMenu=" + codProductoMenu + " ]";
    }
    
}
