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
@Table(name = "roles_permisos")
@NamedQueries({
    @NamedQuery(name = "RolPermiso.findAll", query = "SELECT r FROM RolPermiso r")
    , @NamedQuery(name = "RolPermiso.findByCodRolper", query = "SELECT r FROM RolPermiso r WHERE r.codRolper = :codRolper")})
public class RolPermiso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_rolper")
    private Integer codRolper;
    @JoinColumn(name = "permisos_cod_permiso", referencedColumnName = "cod_permiso")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Permiso permisosCodPermiso;
    @JoinColumn(name = "rol_cod_rol", referencedColumnName = "cod_rol")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Rol rolCodRol;

    public RolPermiso() {
    }

    public RolPermiso(Integer codRolper) {
        this.codRolper = codRolper;
    }

    public Integer getCodRolper() {
        return codRolper;
    }

    public void setCodRolper(Integer codRolper) {
        this.codRolper = codRolper;
    }

    public Permiso getPermisosCodPermiso() {
        return permisosCodPermiso;
    }

    public void setPermisosCodPermiso(Permiso permisosCodPermiso) {
        this.permisosCodPermiso = permisosCodPermiso;
    }

    public Rol getRolCodRol() {
        return rolCodRol;
    }

    public void setRolCodRol(Rol rolCodRol) {
        this.rolCodRol = rolCodRol;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codRolper != null ? codRolper.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RolPermiso)) {
            return false;
        }
        RolPermiso other = (RolPermiso) object;
        if ((this.codRolper == null && other.codRolper != null) || (this.codRolper != null && !this.codRolper.equals(other.codRolper))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.RolPermiso[ codRolper=" + codRolper + " ]";
    }
    
}
