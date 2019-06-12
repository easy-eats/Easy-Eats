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
import javax.persistence.Lob;
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
@Table(name = "malla_turnos")
@NamedQueries({
    @NamedQuery(name = "MallaTurno.findAll", query = "SELECT m FROM MallaTurno m")
    , @NamedQuery(name = "MallaTurno.findByCodMalla", query = "SELECT m FROM MallaTurno m WHERE m.codMalla = :codMalla")})
public class MallaTurno implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_malla")
    private Integer codMalla;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Column(name = "doc_malla")
    private byte[] docMalla;
    @JoinColumn(name = "personas_cod_identificacion", referencedColumnName = "cod_identificacion")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Persona personasCodIdentificacion;

    public MallaTurno() {
    }

    public MallaTurno(Integer codMalla) {
        this.codMalla = codMalla;
    }

    public MallaTurno(Integer codMalla, byte[] docMalla) {
        this.codMalla = codMalla;
        this.docMalla = docMalla;
    }

    public Integer getCodMalla() {
        return codMalla;
    }

    public void setCodMalla(Integer codMalla) {
        this.codMalla = codMalla;
    }

    public byte[] getDocMalla() {
        return docMalla;
    }

    public void setDocMalla(byte[] docMalla) {
        this.docMalla = docMalla;
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
        hash += (codMalla != null ? codMalla.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MallaTurno)) {
            return false;
        }
        MallaTurno other = (MallaTurno) object;
        if ((this.codMalla == null && other.codMalla != null) || (this.codMalla != null && !this.codMalla.equals(other.codMalla))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.MallaTurno[ codMalla=" + codMalla + " ]";
    }
    
}
