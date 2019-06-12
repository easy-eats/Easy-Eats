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
import javax.validation.constraints.Size;

/**
 *
 * @author sergi
 */
@Entity
@Table(name = "credito_cerrado")
@NamedQueries({
    @NamedQuery(name = "CreditoCerrado.findAll", query = "SELECT c FROM CreditoCerrado c")
    , @NamedQuery(name = "CreditoCerrado.findByCodCerrado", query = "SELECT c FROM CreditoCerrado c WHERE c.codCerrado = :codCerrado")
    , @NamedQuery(name = "CreditoCerrado.findByEmpresa", query = "SELECT c FROM CreditoCerrado c WHERE c.empresa = :empresa")})
public class CreditoCerrado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_cerrado")
    private Integer codCerrado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "empresa")
    private String empresa;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Column(name = "doc_cerrado")
    private byte[] docCerrado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "creditoCerradoCodCerrado", fetch = FetchType.LAZY)
    private List<ClienteCredito> clienteCreditoList;

    public CreditoCerrado() {
    }

    public CreditoCerrado(Integer codCerrado) {
        this.codCerrado = codCerrado;
    }

    public CreditoCerrado(Integer codCerrado, String empresa, byte[] docCerrado) {
        this.codCerrado = codCerrado;
        this.empresa = empresa;
        this.docCerrado = docCerrado;
    }

    public Integer getCodCerrado() {
        return codCerrado;
    }

    public void setCodCerrado(Integer codCerrado) {
        this.codCerrado = codCerrado;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public byte[] getDocCerrado() {
        return docCerrado;
    }

    public void setDocCerrado(byte[] docCerrado) {
        this.docCerrado = docCerrado;
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
        hash += (codCerrado != null ? codCerrado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CreditoCerrado)) {
            return false;
        }
        CreditoCerrado other = (CreditoCerrado) object;
        if ((this.codCerrado == null && other.codCerrado != null) || (this.codCerrado != null && !this.codCerrado.equals(other.codCerrado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.CreditoCerrado[ codCerrado=" + codCerrado + " ]";
    }
    
}
