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
@Table(name = "cliente_credito")
@NamedQueries({
    @NamedQuery(name = "ClienteCredito.findAll", query = "SELECT c FROM ClienteCredito c")
    , @NamedQuery(name = "ClienteCredito.findByCodCredito", query = "SELECT c FROM ClienteCredito c WHERE c.codCredito = :codCredito")})
public class ClienteCredito implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_credito")
    private Integer codCredito;
    @JoinColumn(name = "credito_abierto_cod_abierto", referencedColumnName = "cod_abierto")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private CreditoAbierto creditoAbiertoCodAbierto;
    @JoinColumn(name = "credito_cerrado_cod_cerrado", referencedColumnName = "cod_cerrado")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private CreditoCerrado creditoCerradoCodCerrado;

    public ClienteCredito() {
    }

    public ClienteCredito(Integer codCredito) {
        this.codCredito = codCredito;
    }

    public Integer getCodCredito() {
        return codCredito;
    }

    public void setCodCredito(Integer codCredito) {
        this.codCredito = codCredito;
    }

    public CreditoAbierto getCreditoAbiertoCodAbierto() {
        return creditoAbiertoCodAbierto;
    }

    public void setCreditoAbiertoCodAbierto(CreditoAbierto creditoAbiertoCodAbierto) {
        this.creditoAbiertoCodAbierto = creditoAbiertoCodAbierto;
    }

    public CreditoCerrado getCreditoCerradoCodCerrado() {
        return creditoCerradoCodCerrado;
    }

    public void setCreditoCerradoCodCerrado(CreditoCerrado creditoCerradoCodCerrado) {
        this.creditoCerradoCodCerrado = creditoCerradoCodCerrado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codCredito != null ? codCredito.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClienteCredito)) {
            return false;
        }
        ClienteCredito other = (ClienteCredito) object;
        if ((this.codCredito == null && other.codCredito != null) || (this.codCredito != null && !this.codCredito.equals(other.codCredito))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.ClienteCredito[ codCredito=" + codCredito + " ]";
    }
    
}
