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
@Table(name = "marcas")
@NamedQueries({
    @NamedQuery(name = "Marca.findAll", query = "SELECT m FROM Marca m")
    , @NamedQuery(name = "Marca.findByCodMarca", query = "SELECT m FROM Marca m WHERE m.codMarca = :codMarca")
    , @NamedQuery(name = "Marca.findByMarca", query = "SELECT m FROM Marca m WHERE m.marca = :marca")})
public class Marca implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_marca")
    private Integer codMarca;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "marca")
    private String marca;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "marcasCodMarca", fetch = FetchType.LAZY)
    private List<PuntoVenta> puntoVentaList;

    public Marca() {
    }

    public Marca(Integer codMarca) {
        this.codMarca = codMarca;
    }

    public Marca(Integer codMarca, String marca) {
        this.codMarca = codMarca;
        this.marca = marca;
    }

    public Integer getCodMarca() {
        return codMarca;
    }

    public void setCodMarca(Integer codMarca) {
        this.codMarca = codMarca;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public List<PuntoVenta> getPuntoVentaList() {
        return puntoVentaList;
    }

    public void setPuntoVentaList(List<PuntoVenta> puntoVentaList) {
        this.puntoVentaList = puntoVentaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codMarca != null ? codMarca.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Marca)) {
            return false;
        }
        Marca other = (Marca) object;
        if ((this.codMarca == null && other.codMarca != null) || (this.codMarca != null && !this.codMarca.equals(other.codMarca))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Marca[ codMarca=" + codMarca + " ]";
    }
    
}
