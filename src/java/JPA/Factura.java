/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JPA;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Jhonk
 */
@Entity
@Table(name = "factura", catalog = "compras", schema = "")
@NamedQueries({
    @NamedQuery(name = "Factura.findAll", query = "SELECT f FROM Factura f")})
public class Factura implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "numfactura")
    private Integer numfactura;
    @Basic(optional = false)
    @Column(name = "fecha")
    private String fecha;
    @Basic(optional = false)
    @Column(name = "cantidad")
    private int cantidad;
    @Basic(optional = false)
    @Column(name = "precio")
    private double precio;
    @JoinColumn(name = "Administrador_idAdministrador", referencedColumnName = "idAdministrador")
    @ManyToOne(optional = false)
    private Administrador administrador;
    @JoinColumn(name = "cliente_idcliente", referencedColumnName = "idcliente")
    @ManyToOne(optional = false)
    private Cliente cliente;
    @JoinColumn(name = "producto_idproducto", referencedColumnName = "idproducto")
    @ManyToOne(optional = false)
    private Producto producto;

    public Factura() {
    }

    public Factura(Integer numfactura) {
        this.numfactura = numfactura;
    }

    public Factura(Integer numfactura, String fecha, int cantidad, double precio) {
        this.numfactura = numfactura;
        this.fecha = fecha;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public Integer getNumfactura() {
        return numfactura;
    }

    public void setNumfactura(Integer numfactura) {
        this.numfactura = numfactura;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Administrador getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numfactura != null ? numfactura.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Factura)) {
            return false;
        }
        Factura other = (Factura) object;
        if ((this.numfactura == null && other.numfactura != null) || (this.numfactura != null && !this.numfactura.equals(other.numfactura))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "JPA.Factura[ numfactura=" + numfactura + " ]";
    }
    
}
