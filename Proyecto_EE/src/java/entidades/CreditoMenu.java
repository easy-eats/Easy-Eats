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
@Table(name = "credito_menu")
@NamedQueries({
    @NamedQuery(name = "CreditoMenu.findAll", query = "SELECT c FROM CreditoMenu c")
    , @NamedQuery(name = "CreditoMenu.findByCodCreditoMenu", query = "SELECT c FROM CreditoMenu c WHERE c.codCreditoMenu = :codCreditoMenu")})
public class CreditoMenu implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_credito_menu")
    private Integer codCreditoMenu;
    @JoinColumn(name = "credito_abierto_cod_abierto", referencedColumnName = "cod_abierto")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private CreditoAbierto creditoAbiertoCodAbierto;
    @JoinColumn(name = "menu_cod_menu", referencedColumnName = "cod_menu")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Menu menuCodMenu;

    public CreditoMenu() {
    }

    public CreditoMenu(Integer codCreditoMenu) {
        this.codCreditoMenu = codCreditoMenu;
    }

    public Integer getCodCreditoMenu() {
        return codCreditoMenu;
    }

    public void setCodCreditoMenu(Integer codCreditoMenu) {
        this.codCreditoMenu = codCreditoMenu;
    }

    public CreditoAbierto getCreditoAbiertoCodAbierto() {
        return creditoAbiertoCodAbierto;
    }

    public void setCreditoAbiertoCodAbierto(CreditoAbierto creditoAbiertoCodAbierto) {
        this.creditoAbiertoCodAbierto = creditoAbiertoCodAbierto;
    }

    public Menu getMenuCodMenu() {
        return menuCodMenu;
    }

    public void setMenuCodMenu(Menu menuCodMenu) {
        this.menuCodMenu = menuCodMenu;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codCreditoMenu != null ? codCreditoMenu.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CreditoMenu)) {
            return false;
        }
        CreditoMenu other = (CreditoMenu) object;
        if ((this.codCreditoMenu == null && other.codCreditoMenu != null) || (this.codCreditoMenu != null && !this.codCreditoMenu.equals(other.codCreditoMenu))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.CreditoMenu[ codCreditoMenu=" + codCreditoMenu + " ]";
    }
    
}
