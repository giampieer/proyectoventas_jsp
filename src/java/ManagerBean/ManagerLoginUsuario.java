/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagerBean;

import Factoria.DaoFactory;
import Interfaces.AdministradorDao;
import JPA.Administrador;
import javax.swing.JOptionPane;
import Interfaces.ClienteDAO;
import JPA.Cliente;

/**
 *
 * @author Jhonk
 */
public class ManagerLoginUsuario {

    private int tipousuario;
    private String usuario;
    private String clave;
    private String mensaje;
    private int cod;

    public ManagerLoginUsuario() {
    }

    String redireccion;

    public String LoginAcceso(ManagerLoginUsuario objbean) {
        try {
            DaoFactory objDaoFactoria = DaoFactory.getDaoFactory(DaoFactory.MYSQL);
            AdministradorDao objDao = objDaoFactoria.getAdministradorDao();
            ClienteDAO objClienteDAO = objDaoFactoria.getCliente();
            Administrador ad = new Administrador();
            Cliente al = new Cliente();
            int i = 0;
            if (tipousuario == 1) {
                ad.setUsuario(usuario);
                ad.setClave(clave);
                i = objDao.LoginAdmin(ad);
                if (i == 1) {
                    Administrador dat=objDao.DatosAdmin(ad);
                    redireccion = "PRINCIPALADMINISTRADOR";
                    setMensaje("Bienvenido Administrador");
                    int id=dat.getIdAdministrador();
                    this.setCod(id);
                } else {
                    redireccion = "LOGIN";
                    setMensaje("Datos Incorrectos,PRUEBE OTRA VEZ");
                }
            } else if (tipousuario == 2) {
                al.setUsuario(usuario);
                al.setClave(clave);
                i = objClienteDAO.logincliente(al);
                if (i == 1) {
                    Cliente dat=objClienteDAO.DatosCliente(al);
                    redireccion = "MENUPRINCIPALCLIENTE";
                    setMensaje("Bienvenido Alumno");
                    int ide=dat.getIdcliente();
                    this.setCod(ide);
                } else {
                    redireccion = "LOGIN";
                    setMensaje("Datos Incorrectos,PRUEBE OTRA VEZ");
                }
            }
        } catch (Exception ex) {
        }
        return redireccion;
    }

    public int getTipousuario() {
        return tipousuario;
    }

    public void setTipousuario(int tipousuario) {
        this.tipousuario = tipousuario;
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

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

}
