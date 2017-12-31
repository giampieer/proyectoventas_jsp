/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagerBean;

import Factoria.DaoFactory;
import JPA.Producto;
import java.util.ArrayList;
import java.util.List;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import Interfaces.ProductoDAO;

/**
 *
 * @author TOSHIBA
 */
public class ManagerCurso {

    private int idproducto;
    private String nombre;
    private String categoria;
    private double precio;
    private int stock;
    private String mensaje;
    private List<Producto> lista;
    private ArrayList<SelectItem> listaitem;

    /**
     * Creates a new instance of ManagerCurso
     */
    public ManagerCurso() {
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getMensaje() {
        return mensaje;
    }
    
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
    public List<Producto> getLista() throws Exception {
        DaoFactory objfaofactory = DaoFactory.getDaoFactory(DaoFactory.MYSQL);
        ProductoDAO objcurso = objfaofactory.getProductoDAO();
        lista = objcurso.listarproducto();
        return lista;
    }
    
    public void setLista(List<Producto> lista) {
        this.lista = lista;
    }
    
    public void CargarProducto(ActionEvent e) {
        String idproducto;
        DaoFactory objfaofactory = DaoFactory.getDaoFactory(DaoFactory.MYSQL);
        ProductoDAO objcurso = objfaofactory.getProductoDAO();
        
        try {
            idproducto = e.getComponent().getAttributes().get("idcurso").toString();
            int idproducto1 = Integer.parseInt(idproducto);
            Producto objbean1 = new Producto();
            objbean1.setIdproducto(idproducto1);
            Producto objBean = objcurso.cargarproducto(objbean1);
            setIdproducto(objBean.getIdproducto());
            setNombre(objBean.getNombre());
            setCategoria(objBean.getCategoria());
            setPrecio(objBean.getPrecio());
            setStock(objBean.getStock());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void GrabarCurso(ActionEvent e2) {
        DaoFactory objfaofactory = DaoFactory.getDaoFactory(DaoFactory.MYSQL);
        ProductoDAO objcurso = objfaofactory.getProductoDAO();
        String i = "";
        try {
            Producto objbean = new Producto();
            objbean.setIdproducto(getId());
            objbean.setNombre(getNombre());
            objbean.setCategoria(getCategoria());
            objbean.setPrecio(getPrecio());
            objbean.setStock(getStock());
            i = objcurso.grabarproducto(objbean);            
            this.setMensaje(i);
            setNombre("");
            setCategoria("");
        } catch (Exception ex) {
            ex.printStackTrace();
        }        
    }

    public void ModificarCurso(ActionEvent e2) {
        DaoFactory objfaofactory = DaoFactory.getDaoFactory(DaoFactory.MYSQL);
        ProductoDAO objcurso = objfaofactory.getProductoDAO();
        String i = "";
        try {
            Producto objbean = new Producto();
            objbean.setIdproducto(getIdproducto());
            objbean.setNombre(getNombre());
            objbean.setCategoria(getCategoria());
            objbean.setPrecio(getPrecio());
            objbean.setStock(getStock());
            i = objcurso.modificarproducto(objbean);            
            this.setMensaje(i);
        } catch (Exception ex) {
            ex.printStackTrace();
        }        
    }

    public void EliminarCurso(ActionEvent e) {
        String idcurso;
        DaoFactory objfaofactory = DaoFactory.getDaoFactory(DaoFactory.MYSQL);
        ProductoDAO objcurso = objfaofactory.getProductoDAO();
        String id = "";
        try {
            idcurso = e.getComponent().getAttributes().get("idcurso").toString();
            int idcurso1 = Integer.parseInt(idcurso);
            Producto objbean1 = new Producto();
            objbean1.setIdproducto(idcurso1);
            id = objcurso.eliminarproducto(objbean1);
            this.setMensaje(id);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    private int id;
    
    public int getId() throws Exception {
        DaoFactory objDaoFactory = DaoFactory.getDaoFactory(DaoFactory.MYSQL);
        ProductoDAO objCursoDAO = objDaoFactory.getProductoDAO();
        id = objCursoDAO.GenerarCodigo();
        if (id == 0) {
            id = 1;
        } else {
            id = objCursoDAO.GenerarCodigo() + 1;
        }
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public ArrayList<SelectItem> getListaitem() {
        listaitem = new ArrayList<SelectItem>();
        DaoFactory objDaoFactory = DaoFactory.getDaoFactory(DaoFactory.MYSQL);
        ProductoDAO objCursoDAO = objDaoFactory.getProductoDAO();
        try {
            for (Producto obj : objCursoDAO.listarproducto()) {
                listaitem.add(new SelectItem(obj.getIdproducto(), obj.getNombre()));
            }
        } catch (Exception e) {
        }
        return listaitem;
    }
    
    public void setListaitem(ArrayList<SelectItem> listaitem) {
        this.listaitem = listaitem;
    }
    
    public int getIdproducto() {
        return idproducto;
    }
    
    public void setIdproducto(int idproducto) {
        this.idproducto = idproducto;
    }
    
    public String getCategoria() {
        return categoria;
    }
    
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    
    public double getPrecio() {
        return precio;
    }
    
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    public int getStock() {
        return stock;
    }
    
    public void setStock(int stock) {
        this.stock = stock;
    }
    
}
