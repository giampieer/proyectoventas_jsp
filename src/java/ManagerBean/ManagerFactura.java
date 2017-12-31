/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagerBean;

import Factoria.DaoFactory;
import Interfaces.FacturaDao;
import Interfaces.ProductoDAO;
import JPA.Administrador;
import JPA.Cliente;
import JPA.Factura;
import JPA.Producto;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author Jhonk
 */
public class ManagerFactura {

    private int numfactura;
    private int idadmin;
    private int idcliente;
    private int idproducto;
    private String fecha;
    private int cantidad;
    private double precio;
    private String mensaje;
    private int cod;
    private List<Factura> lista;

    public ManagerFactura() {
    }

    public int getNumfactura() {
        return numfactura;
    }

    public void setNumfactura(int numfactura) {
        this.numfactura = numfactura;
    }

    public int getIdadmin() {
        return idadmin;
    }

    public void setIdadmin(int idadmin) {
        this.idadmin = idadmin;
    }

    public int getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
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

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public void GrabarFactura(ActionEvent e) {
        int iduser;
        DaoFactory objDaoFactory = DaoFactory.getDaoFactory(DaoFactory.MYSQL);
        FacturaDao objFacturaDao = objDaoFactory.getFacturaDao();
        FacesContext facesContext = FacesContext.getCurrentInstance();
        Map params = facesContext.getExternalContext().getRequestParameterMap();
        String i = "";
        try {
            iduser = new Integer((String) params.get("iduser"));
            this.setCod(iduser);

            Factura objbean = new Factura();
            Cliente objcliente = new Cliente();
            Producto objproducto = new Producto();
            objproducto.setIdproducto(getIdproducto());
            objcliente.setIdcliente(getIdcliente());
            Administrador objadmin = new Administrador();
            objadmin.setIdAdministrador(1);
            objbean.setNumfactura(getId());
            objbean.setAdministrador(objadmin);
            objbean.setProducto(objproducto);
            objbean.setCliente(objcliente);
            objbean.setFecha(getFecha());
            objbean.setCantidad(getCantidad());
            int cant = getCantidad();
            double pre = getPrecio();
            double preci = cant * pre;
            objbean.setPrecio(preci);
            i = objFacturaDao.GrabarFactura(objbean);

            this.setMensaje(i);
        } catch (Exception ex) {
        }
    }

    public void Datos(ActionEvent ex) {
        DaoFactory objDaoFactory = DaoFactory.getDaoFactory(DaoFactory.MYSQL);
        ProductoDAO objProductoDAO = objDaoFactory.getProductoDAO();
        try {
            String idproduct = ex.getComponent().getAttributes().get("idproducto").toString();
            int idpro = Integer.parseInt(idproduct);
            setIdproducto(idpro);

            Producto objpro = new Producto();
            objpro.setIdproducto(idpro);
            Producto objp = objProductoDAO.cargarproducto(objpro);
            setPrecio(objp.getPrecio());

            FacesContext facesContext = FacesContext.getCurrentInstance();
            Map params = facesContext.getExternalContext().getRequestParameterMap();
            int iduser = new Integer((String) params.get("iduser"));
            this.setIdcliente(iduser);
        } catch (Exception e) {
        }
    }

    public void Codigo(ActionEvent e) {
        int iduser;
        try {
            FacesContext facesContext = FacesContext.getCurrentInstance();
            Map params = facesContext.getExternalContext().getRequestParameterMap();
            iduser = new Integer((String) params.get("iduser"));
            this.setCod(iduser);
        } catch (Exception ex) {
        }
    }

    public int getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(int idproducto) {
        this.idproducto = idproducto;
    }
    private int id;

    public int getId() throws Exception {
        DaoFactory objDaoFactory = DaoFactory.getDaoFactory(DaoFactory.MYSQL);
        FacturaDao objFacturaDao = objDaoFactory.getFacturaDao();
        id = objFacturaDao.GenerarCodigo();
        if (id == 0) {
            id = 1;
        } else {
            id = objFacturaDao.GenerarCodigo() + 1;
        }
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public void listaDatos(ActionEvent e) throws Exception {
        int iduser;
        DaoFactory objDaoFactory = DaoFactory.getDaoFactory(DaoFactory.MYSQL);
        FacturaDao objFacturaDao = objDaoFactory.getFacturaDao();

        Factura fact = new Factura();
        Cliente client = new Cliente();

        FacesContext facesContext = FacesContext.getCurrentInstance();
        Map params = facesContext.getExternalContext().getRequestParameterMap();
        try {
            iduser = new Integer((String) params.get("iduser"));
            client.setIdcliente(iduser);
            fact.setCliente(client);
            lista = objFacturaDao.MostrarFactura(fact);
            this.setCod(iduser);
        } catch (Exception ex) {
        }
    }

    public List<Factura> getLista() throws Exception {
        return lista;
    }

    public void setLista(List<Factura> lista) {
        this.lista = lista;
    }

}
