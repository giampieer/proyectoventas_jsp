/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagerBean;

import Factoria.DaoFactory;
import JPA.Cliente;
import java.util.ArrayList;
import java.util.List;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import Interfaces.ClienteDAO;

/**
 *
 * @author TOSHIBA
 */
public class ManagerCliente {
    private int idcliente;
    private String nombre;
    private String apellido;
    private String sexo;
    private int edad;
    private String correo;
    private String usuario;
    private String clave;
    private String mensaje;
    private List<Cliente>lista;
    private ArrayList<SelectItem> listaItem;
    
    /**
     * Creates a new instance of ManagerAlumno
     */
    public ManagerCliente() {
    }

    public int getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(int idalumno) {
        this.idcliente = idalumno;
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

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public List<Cliente> getLista() throws Exception {
        DaoFactory objfaofactory=DaoFactory.getDaoFactory(DaoFactory.MYSQL);
        ClienteDAO objalumno=objfaofactory.getCliente();
        lista=objalumno.listarcliente();
        return lista;
    }

    public void setLista(List<Cliente> lista) {
        this.lista = lista;
    }
    
    public void CargarAlumno(ActionEvent e){
          String  idalumno;
          DaoFactory objfaofactory=DaoFactory.getDaoFactory(DaoFactory.MYSQL);
          ClienteDAO objalumno=objfaofactory.getCliente();
        
         try {
            idalumno = e.getComponent().getAttributes().get("idalumno").toString();
            int idalumno1=Integer.parseInt(idalumno);
            Cliente objbean1=new Cliente();
            objbean1.setIdcliente(idalumno1);
            Cliente objBean = objalumno.cargarcliente(objbean1);
            setIdcliente(objBean.getIdcliente());
            setNombre(objBean.getNombre());
            setApellido(objBean.getApellido());
            setSexo(objBean.getSexo());
            setEdad(objBean.getEdad());
            setCorreo(objBean.getCorreo());
            setUsuario(objBean.getUsuario());
            setClave(objBean.getClave());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void GrabarAlumno(ActionEvent e2){
        DaoFactory objfaofactory=DaoFactory.getDaoFactory(DaoFactory.MYSQL);
        ClienteDAO objalumno=objfaofactory.getCliente();
            try {
                Cliente objbean=new Cliente();
                objbean.setIdcliente(getId());
                objbean.setNombre(getNombre());
                objbean.setApellido(getApellido());
                objbean.setSexo(getSexo());
                objbean.setEdad(getEdad());
                objbean.setCorreo(getCorreo());
                objbean.setUsuario(getUsuario());
                objbean.setClave(getClave());
                String i = objalumno.grabarcliente(objbean);  
                this.setMensaje(i);
                setNombre("");
                setApellido("");
                setSexo("");
                setEdad(0);
                setCorreo("");
                setUsuario("");
                setClave("");
        } catch (Exception ex) {
            ex.printStackTrace();
        }    
    }
    public void ModificarAlumno(ActionEvent e2){
        DaoFactory objfaofactory=DaoFactory.getDaoFactory(DaoFactory.MYSQL);
        ClienteDAO objalumno=objfaofactory.getCliente();
        String i="";
            try {
                Cliente objbean=new Cliente();
                objbean.setIdcliente(getIdcliente());
                objbean.setNombre(getNombre());
                objbean.setApellido(getApellido());
                objbean.setSexo(getSexo());
                objbean.setEdad(getEdad());
                objbean.setCorreo(getCorreo());
                objbean.setUsuario(getUsuario());
                objbean.setClave(getClave());
                i = objalumno.modificarcliente(objbean);  
                this.setMensaje(i);
        } catch (Exception ex) {
            ex.printStackTrace();
        }     
    }
    
    public void EliminarAlumno(ActionEvent e){
        String  idalumno;
        DaoFactory objfaofactory=DaoFactory.getDaoFactory(DaoFactory.MYSQL);
        ClienteDAO objalumno=objfaofactory.getCliente();
        
         try {
            idalumno = e.getComponent().getAttributes().get("idalumno").toString();
            int idalumno1=Integer.parseInt(idalumno);
            Cliente objbean1=new Cliente();
            objbean1.setIdcliente(idalumno1);
            String i = objalumno.eliminarcliente(objbean1);
            this.setMensaje(i);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    private int id;

    public int getId() throws Exception {
        DaoFactory objDaoFactory=DaoFactory.getDaoFactory(DaoFactory.MYSQL);
        ClienteDAO objAlumnoDAO=objDaoFactory.getCliente();
        id=objAlumnoDAO.GenerarCodigo();
        if(id==0){
            id=1;
        }else{
            id=objAlumnoDAO.GenerarCodigo()+1;
        }
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<SelectItem> getListaItem() {
        listaItem=new ArrayList<SelectItem>();
        DaoFactory objDaoFactory=DaoFactory.getDaoFactory(DaoFactory.MYSQL);
        ClienteDAO objAlumnoDAO=objDaoFactory.getCliente();
        try {
            for(Cliente obj:objAlumnoDAO.listarcliente()){
                listaItem.add(new SelectItem(obj.getIdcliente(),obj.getNombre()));
            }
        } catch (Exception e) {
        }
        return listaItem;
    }

    public void setListaItem(ArrayList<SelectItem> listaItem) {
        this.listaItem = listaItem;
    }
}
