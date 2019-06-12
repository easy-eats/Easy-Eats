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
@Table(name = "rol")
@NamedQueries({
    @NamedQuery(name = "Rol.findAll", query = "SELECT r FROM Rol r")
    , @NamedQuery(name = "Rol.findByCodRol", query = "SELECT r FROM Rol r WHERE r.codRol = :codRol")
    , @NamedQuery(name = "Rol.findByTipoRol", query = "SELECT r FROM Rol r WHERE r.tipoRol = :tipoRol")})
public class Rol implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_rol")
    private Integer codRol;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "tipo_rol")
    private String tipoRol;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rolCodRol", fetch = FetchType.LAZY)
    private List<Persona> personaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rolCodRol", fetch = FetchType.LAZY)
    private List<RolPermiso> rolPermisoList;

    public Rol() {
    }

    public Rol(Integer codRol) {
        this.codRol = codRol;
    }

    public Rol(Integer codRol, String tipoRol) {
        this.codRol = codRol;
        this.tipoRol = tipoRol;
    }

    public Integer getCodRol() {
        return codRol;
    }

    public void setCodRol(Integer codRol) {
        this.codRol = codRol;
    }

    public String getTipoRol() {
        return tipoRol;
    }

    public void setTipoRol(String tipoRol) {
        this.tipoRol = tipoRol;
    }

    public List<Persona> getPersonaList() {
        return personaList;
    }

    public void setPersonaList(List<Persona> personaList) {
        this.personaList = personaList;
    }

    public List<RolPermiso> getRolPermisoList() {
        return rolPermisoList;
    }

    public void setRolPermisoList(List<RolPermiso> rolPermisoList) {
        this.rolPermisoList = rolPermisoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codRol != null ? codRol.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rol)) {
            return false;
        }
        Rol other = (Rol) object;
        if ((this.codRol == null && other.codRol != null) || (this.codRol != null && !this.codRol.equals(other.codRol))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Rol[ codRol=" + codRol + " ]";
    }
    
}
