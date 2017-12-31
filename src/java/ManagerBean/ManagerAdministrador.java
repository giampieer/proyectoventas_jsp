/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagerBean;

import Factoria.DaoFactory;
import Interfaces.AdministradorDao;
import JPA.Administrador;
import java.util.ArrayList;
import java.util.List;
import javax.faces.event.ActionEvent;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;
import javax.swing.JOptionPane;

/**
 *
 * @author Jhonk
 */
public class ManagerAdministrador {

    private int idadministrador;
    private String nombre;
    private String apellido;
    private String sexo;
    private int edad;
    private String correo;
    private String usuario;
    private String clave;
    private String mensaje;
    private List<Administrador> listar;
    private int id;
    private ArrayList<SelectItem> listaitem;
    private String ContraNueva;

    public ManagerAdministrador() {
    }

    public int getIdadministrador() {
        return idadministrador;
    }

    public void setIdadministrador(int idadministrador) {
        this.idadministrador = idadministrador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public List<Administrador> getListar() throws Exception {
        DaoFactory objDaoFactoria = DaoFactory.getDaoFactory(DaoFactory.MYSQL);
        AdministradorDao objDao = objDaoFactoria.getAdministradorDao();
        listar = objDao.lista();
        return listar;
    }

    public void setListar(List<Administrador> listar) {
        this.listar = listar;
    }

    public void GrabarAdmin(ActionEvent e) {
        String i;
        try {
            DaoFactory objDaoFactoria = DaoFactory.getDaoFactory(DaoFactory.MYSQL);
            AdministradorDao objAdministradorDao = objDaoFactoria.getAdministradorDao();

            Administrador obj = new Administrador();
            obj.setIdAdministrador(getId());
            obj.setNombre(getNombre());
            obj.setApellido(getApellido());
            obj.setSexo(getSexo());
            obj.setEdad(getEdad());
            obj.setCorreo(getCorreo());
            obj.setUsuario(getUsuario());
            obj.setClave(getClave());
            i = objAdministradorDao.AgregarAdmin(obj);
            this.setMensaje(i);
            setNombre("");
            setApellido("");
            setSexo("");
            setEdad(0);
            setCorreo("");
            setUsuario("");
            setClave("");
        } catch (Exception ex) {
        }
    }

    public void CargarDato(ActionEvent e) {
        Administrador obj = new Administrador();
        int idad;
        DaoFactory objDaoFactoria = DaoFactory.getDaoFactory(DaoFactory.MYSQL);
        AdministradorDao objAdministradorDao = objDaoFactoria.getAdministradorDao();
        try {
            idad = Integer.parseInt(e.getComponent().getAttributes().get("iduser").toString());
            obj.setIdAdministrador(idad);
            Administrador objbean = objAdministradorDao.CapturarDatos(obj);
            setIdadministrador(objbean.getIdAdministrador());
            setNombre(objbean.getNombre());
            setApellido(objbean.getApellido());
            setSexo(objbean.getSexo());
            setEdad(objbean.getEdad());
            setCorreo(objbean.getCorreo());
            setUsuario(objbean.getUsuario());
            setClave(objbean.getClave());
        } catch (Exception ex) {
        }
    }

    public void ModificarAdmin(ActionEvent e) {
        String i;
        try {
            DaoFactory objDaoFactoria = DaoFactory.getDaoFactory(DaoFactory.MYSQL);
            AdministradorDao objAdministradorDao = objDaoFactoria.getAdministradorDao();

            Administrador obj = new Administrador();
            obj.setIdAdministrador(getIdadministrador());
            obj.setNombre(getNombre());
            obj.setApellido(getApellido());
            obj.setSexo(getSexo());
            obj.setEdad(getEdad());
            obj.setCorreo(getCorreo());
            obj.setUsuario(getUsuario());
            obj.setClave(getClave());
            i = objAdministradorDao.ModificarAdmin(obj);
            this.setMensaje(i);

        } catch (Exception ex) {
        }
    }

    public void ModificarClave(ActionEvent e) {
        DaoFactory objDaoFactoria = DaoFactory.getDaoFactory(DaoFactory.MYSQL);
        AdministradorDao objAdministradorDao = objDaoFactoria.getAdministradorDao();
        String i;
        try {
                if(getContraNueva()!=getClave()){
                    this.setMensaje("Las Contraseñas no considen");
                }else if(getContraNueva()==getClave()){
                    Administrador contra = new Administrador();
                    contra.setIdAdministrador(getIdadministrador());
                    contra.setClave(getClave());
                    i=objAdministradorDao.ModificarAdmin(contra);
                    this.setMensaje(i);
                }
                
        } catch (Exception ex) {
        }
    }

    public void EliminarAdmin(ActionEvent e) {
        String i;
        int idad;
        DaoFactory objDaoFactoria = DaoFactory.getDaoFactory(DaoFactory.MYSQL);
        AdministradorDao objAdministradorDao = objDaoFactoria.getAdministradorDao();
        try {
            idad = Integer.parseInt(e.getComponent().getAttributes().get("iduser").toString());
            Administrador obj = new Administrador();
            obj.setIdAdministrador(idad);
            i = objAdministradorDao.EliminarAdmin(obj);
            this.setMensaje(i);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public int getId() throws Exception {
        DaoFactory objDaoFactory = DaoFactory.getDaoFactory(DaoFactory.MYSQL);
        AdministradorDao objAdministradorDao = objDaoFactory.getAdministradorDao();
        id = objAdministradorDao.generarcodigo();
        if (id == 0) {
            id = 1;
        } else {
            id = objAdministradorDao.generarcodigo() + 1;
        }
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<SelectItem> getListaitem() {
        listaitem = new ArrayList<SelectItem>();
        DaoFactory objDaoFactory = DaoFactory.getDaoFactory(DaoFactory.MYSQL);
        AdministradorDao objAdministradorDao = objDaoFactory.getAdministradorDao();
        try {
            for (Administrador obj : objAdministradorDao.lista()) {
                listaitem.add(new SelectItem(obj.getIdAdministrador(), obj.getNombre()));
            }
        } catch (Exception e) {
        }
        return listaitem;
    }

    public void setListaitem(ArrayList<SelectItem> listaitem) {
        this.listaitem = listaitem;
    }

    public String getContraNueva() {
        return ContraNueva;
    }

    public void setContraNueva(String ContraNueva) {
        this.ContraNueva = ContraNueva;
    }

}
