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
@Table(name = "credito_abierto")
@NamedQueries({
    @NamedQuery(name = "CreditoAbierto.findAll", query = "SELECT c FROM CreditoAbierto c")
    , @NamedQuery(name = "CreditoAbierto.findByCodAbierto", query = "SELECT c FROM CreditoAbierto c WHERE c.codAbierto = :codAbierto")
    , @NamedQuery(name = "CreditoAbierto.findByEmpresa", query = "SELECT c FROM CreditoAbierto c WHERE c.empresa = :empresa")})
public class CreditoAbierto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_abierto")
    private Integer codAbierto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "empresa")
    private String empresa;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "creditoAbiertoCodAbierto", fetch = FetchType.LAZY)
    private List<CreditoMenu> creditoMenuList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "creditoAbiertoCodAbierto", fetch = FetchType.LAZY)
    private List<ClienteCredito> clienteCreditoList;

    public CreditoAbierto() {
    }

    public CreditoAbierto(Integer codAbierto) {
        this.codAbierto = codAbierto;
    }

    public CreditoAbierto(Integer codAbierto, String empresa) {
        this.codAbierto = codAbierto;
        this.empresa = empresa;
    }

    public Integer getCodAbierto() {
        return codAbierto;
    }

    public void setCodAbierto(Integer codAbierto) {
        this.codAbierto = codAbierto;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public List<CreditoMenu> getCreditoMenuList() {
        return creditoMenuList;
    }

    public void setCreditoMenuList(List<CreditoMenu> creditoMenuList) {
        this.creditoMenuList = creditoMenuList;
    }

    public List<ClienteCredito> getClienteCreditoList() {
        return clienteCreditoList;
    }

    public void setClienteCreditoList(List<ClienteCredito> clienteCreditoList) {
        this.clienteCreditoList = clienteCreditoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codAbierto != null ? codAbierto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CreditoAbierto)) {
            return false;
        }
        CreditoAbierto other = (CreditoAbierto) object;
        if ((this.codAbierto == null && other.codAbierto != null) || (this.codAbierto != null && !this.codAbierto.equals(other.codAbierto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.CreditoAbierto[ codAbierto=" + codAbierto + " ]";
    }
    
}
