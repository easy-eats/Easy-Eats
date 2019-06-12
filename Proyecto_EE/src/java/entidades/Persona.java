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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "personas")
@NamedQueries({
    @NamedQuery(name = "Persona.findAll", query = "SELECT p FROM Persona p")
    , @NamedQuery(name = "Persona.findByCodIdentificacion", query = "SELECT p FROM Persona p WHERE p.codIdentificacion = :codIdentificacion")
    , @NamedQuery(name = "Persona.findByPrirmerNombre", query = "SELECT p FROM Persona p WHERE p.prirmerNombre = :prirmerNombre")
    , @NamedQuery(name = "Persona.findBySegundoNombre", query = "SELECT p FROM Persona p WHERE p.segundoNombre = :segundoNombre")
    , @NamedQuery(name = "Persona.findByPrimerApellido", query = "SELECT p FROM Persona p WHERE p.primerApellido = :primerApellido")
    , @NamedQuery(name = "Persona.findBySegundoApellido", query = "SELECT p FROM Persona p WHERE p.segundoApellido = :segundoApellido")
    , @NamedQuery(name = "Persona.findByTelefono", query = "SELECT p FROM Persona p WHERE p.telefono = :telefono")
    , @NamedQuery(name = "Persona.findByCorreo", query = "SELECT p FROM Persona p WHERE p.correo = :correo")
    , @NamedQuery(name = "Persona.findByFechaNacimiento", query = "SELECT p FROM Persona p WHERE p.fechaNacimiento = :fechaNacimiento")})
public class Persona implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_identificacion")
    private Long codIdentificacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "prirmer_nombre")
    private String prirmerNombre;
    @Size(max = 25)
    @Column(name = "segundo_nombre")
    private String segundoNombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "primer_apellido")
    private String primerApellido;
    @Size(max = 25)
    @Column(name = "segundo_apellido")
    private String segundoApellido;
    @Basic(optional = false)
    @NotNull
    @Column(name = "telefono")
    private long telefono;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "correo")
    private String correo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "fecha_nacimiento")
    private String fechaNacimiento;
    @JoinColumn(name = "rol_cod_rol", referencedColumnName = "cod_rol")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Rol rolCodRol;
    @JoinColumn(name = "usuarios_nick_name", referencedColumnName = "nick_name")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Usuario usuariosNickName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "personasCodIdentificacion", fetch = FetchType.LAZY)
    private List<MallaTurno> mallaTurnoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "personasCodIdentificacion", fetch = FetchType.LAZY)
    private List<PuntoVenta> puntoVentaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "personasCodIdentificacion", fetch = FetchType.LAZY)
    private List<Comision> comisionList;

    public Persona() {
    }

    public Persona(Long codIdentificacion) {
        this.codIdentificacion = codIdentificacion;
    }

    public Persona(Long codIdentificacion, String prirmerNombre, String primerApellido, long telefono, String correo, String fechaNacimiento) {
        this.codIdentificacion = codIdentificacion;
        this.prirmerNombre = prirmerNombre;
        this.primerApellido = primerApellido;
        this.telefono = telefono;
        this.correo = correo;
        this.fechaNacimiento = fechaNacimiento;
    }

    public Long getCodIdentificacion() {
        return codIdentificacion;
    }

    public void setCodIdentificacion(Long codIdentificacion) {
        this.codIdentificacion = codIdentificacion;
    }

    public String getPrirmerNombre() {
        return prirmerNombre;
    }

    public void setPrirmerNombre(String prirmerNombre) {
        this.prirmerNombre = prirmerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Rol getRolCodRol() {
        return rolCodRol;
    }

    public void setRolCodRol(Rol rolCodRol) {
        this.rolCodRol = rolCodRol;
    }

    public Usuario getUsuariosNickName() {
        return usuariosNickName;
    }

    public void setUsuariosNickName(Usuario usuariosNickName) {
        this.usuariosNickName = usuariosNickName;
    }

    public List<MallaTurno> getMallaTurnoList() {
        return mallaTurnoList;
    }

    public void setMallaTurnoList(List<MallaTurno> mallaTurnoList) {
        this.mallaTurnoList = mallaTurnoList;
    }

    public List<PuntoVenta> getPuntoVentaList() {
        return puntoVentaList;
    }

    public void setPuntoVentaList(List<PuntoVenta> puntoVentaList) {
        this.puntoVentaList = puntoVentaList;
    }

    public List<Comision> getComisionList() {
        return comisionList;
    }

    public void setComisionList(List<Comision> comisionList) {
        this.comisionList = comisionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codIdentificacion != null ? codIdentificacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Persona)) {
            return false;
        }
        Persona other = (Persona) object;
        if ((this.codIdentificacion == null && other.codIdentificacion != null) || (this.codIdentificacion != null && !this.codIdentificacion.equals(other.codIdentificacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Persona[ codIdentificacion=" + codIdentificacion + " ]";
    }
    
}
