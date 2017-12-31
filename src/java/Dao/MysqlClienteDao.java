/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Factoria.DaoFactory;
import Interfaces.AdministradorDao;
import JPA.Administrador;
import JPA.Cliente;
import ManagerBean.ManagerAdministrador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import Interfaces.ClienteDAO;

/**
 *
 * @author Jhonk
 */
public class MysqlClienteDao implements ClienteDAO{
    
    EntityManagerFactory emf=Persistence.createEntityManagerFactory("ventas");
    EntityManager em=emf.createEntityManager();
    @Override
    public int logincliente(Cliente obj)throws Exception{
        int i=0;
        try {
            em.getTransaction().begin();
            Query sql=em.createQuery("select a FROM Cliente a where a.usuario=?1 and a.clave=?2");
            sql.setParameter(1, obj.getUsuario());
            sql.setParameter(2, obj.getClave());
            List<Cliente> lista=sql.getResultList();
            if(lista.size()>0){
                i=1;
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
        return i;
    }
    

    @Override
    public String grabarcliente(Cliente obj) throws Exception{
        String mensaje="";
        try {
            em.getTransaction().begin();
            em.persist(obj);
            mensaje="Registro Insertado";
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        }
        return mensaje;
    }

    @Override
    public String eliminarcliente(Cliente obj) throws Exception{
        String mensaje="";
        try {
            em.getTransaction().begin();
            Cliente alum=em.find(Cliente.class, obj.getIdcliente());
            em.remove(alum);
            mensaje="Registro Eliminado";
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
        return mensaje;
    }

    @Override
    public String modificarcliente(Cliente obj)throws Exception{
        String mensaje="";
        try {
            em.getTransaction().begin();
            em.merge(obj);
            mensaje="Registro Modificado";
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
        return mensaje;
    }

    @Override
    public List<Cliente> listarcliente() throws Exception{
        List lista=null;
        try {
            em.getTransaction().begin();
            Query sql=em.createQuery("select al from Cliente al");
            lista=sql.getResultList();
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        }
       return lista;
    }

    @Override
    public Cliente cargarcliente(Cliente obj)throws Exception {
        Cliente datos=null;
        try {
            em.getTransaction().begin();
            datos=em.find(Cliente.class, obj.getIdcliente());
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
        return  datos;
    }

    @Override
    public int GenerarCodigo() throws Exception {
        int i=0;
        try {
            em.getTransaction().begin();
            i=(Integer)em.createQuery("select max(a.idcliente) from Cliente a").getSingleResult();
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
        return i;
    }

    @Override
    public Cliente DatosCliente(Cliente obj) throws Exception {
        Cliente Datos=null;
        try {
            em.getTransaction().begin();
            Query sql=em.createQuery("select a FROM Cliente a where a.usuario=?1 and a.clave=?2");
            sql.setParameter(1, obj.getUsuario());
            sql.setParameter(2, obj.getClave());
            List<Cliente> lista=sql.getResultList();
            if(lista.size()>0){
                Datos=lista.get(0);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
        return Datos;
    }
    
}