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
@Table(name = "permisos")
@NamedQueries({
    @NamedQuery(name = "Permiso.findAll", query = "SELECT p FROM Permiso p")
    , @NamedQuery(name = "Permiso.findByCodPermiso", query = "SELECT p FROM Permiso p WHERE p.codPermiso = :codPermiso")
    , @NamedQuery(name = "Permiso.findByNombre", query = "SELECT p FROM Permiso p WHERE p.nombre = :nombre")
    , @NamedQuery(name = "Permiso.findByUrl", query = "SELECT p FROM Permiso p WHERE p.url = :url")
    , @NamedQuery(name = "Permiso.findByCodPadre", query = "SELECT p FROM Permiso p WHERE p.codPadre = :codPadre")})
public class Permiso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_permiso")
    private Integer codPermiso;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "url")
    private String url;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Column(name = "icono")
    private byte[] icono;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_padre")
    private int codPadre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "permisosCodPermiso", fetch = FetchType.LAZY)
    private List<RolPermiso> rolPermisoList;

    public Permiso() {
    }

    public Permiso(Integer codPermiso) {
        this.codPermiso = codPermiso;
    }

    public Permiso(Integer codPermiso, String nombre, String url, byte[] icono, int codPadre) {
        this.codPermiso = codPermiso;
        this.nombre = nombre;
        this.url = url;
        this.icono = icono;
        this.codPadre = codPadre;
    }

    public Integer getCodPermiso() {
        return codPermiso;
    }

    public void setCodPermiso(Integer codPermiso) {
        this.codPermiso = codPermiso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public byte[] getIcono() {
        return icono;
    }

    public void setIcono(byte[] icono) {
        this.icono = icono;
    }

    public int getCodPadre() {
        return codPadre;
    }

    public void setCodPadre(int codPadre) {
        this.codPadre = codPadre;
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
        hash += (codPermiso != null ? codPermiso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Permiso)) {
            return false;
        }
        Permiso other = (Permiso) object;
        if ((this.codPermiso == null && other.codPermiso != null) || (this.codPermiso != null && !this.codPermiso.equals(other.codPermiso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Permiso[ codPermiso=" + codPermiso + " ]";
    }
    
}
