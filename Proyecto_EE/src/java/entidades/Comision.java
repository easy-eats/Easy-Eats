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
@Table(name = "comision")
@NamedQueries({
    @NamedQuery(name = "Comision.findAll", query = "SELECT c FROM Comision c")
    , @NamedQuery(name = "Comision.findByCodComision", query = "SELECT c FROM Comision c WHERE c.codComision = :codComision")
    , @NamedQuery(name = "Comision.findByComisionValor", query = "SELECT c FROM Comision c WHERE c.comisionValor = :comisionValor")
    , @NamedQuery(name = "Comision.findByComisionMeta", query = "SELECT c FROM Comision c WHERE c.comisionMeta = :comisionMeta")})
public class Comision implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_comision")
    private Integer codComision;
    @Column(name = "comision_valor")
    private Integer comisionValor;
    @Column(name = "comision_meta")
    private Integer comisionMeta;
    @JoinColumn(name = "personas_cod_identificacion", referencedColumnName = "cod_identificacion")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Persona personasCodIdentificacion;

    public Comision() {
    }

    public Comision(Integer codComision) {
        this.codComision = codComision;
    }

    public Integer getCodComision() {
        return codComision;
    }

    public void setCodComision(Integer codComision) {
        this.codComision = codComision;
    }

    public Integer getComisionValor() {
        return comisionValor;
    }

    public void setComisionValor(Integer comisionValor) {
        this.comisionValor = comisionValor;
    }

    public Integer getComisionMeta() {
        return comisionMeta;
    }

    public void setComisionMeta(Integer comisionMeta) {
        this.comisionMeta = comisionMeta;
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
        hash += (codComision != null ? codComision.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Comision)) {
            return false;
        }
        Comision other = (Comision) object;
        if ((this.codComision == null && other.codComision != null) || (this.codComision != null && !this.codComision.equals(other.codComision))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Comision[ codComision=" + codComision + " ]";
    }
    
}
