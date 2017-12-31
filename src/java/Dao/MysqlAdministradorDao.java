/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Factoria.DaoFactory;
import Interfaces.AdministradorDao;
import JPA.Administrador;
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

/**
 *
 * @author Jhonk
 */
public class MysqlAdministradorDao implements AdministradorDao{
    
    EntityManagerFactory emf=Persistence.createEntityManagerFactory("ventas");
    EntityManager em=emf.createEntityManager();
    @Override
    public int LoginAdmin(Administrador obj)throws Exception{
        int i=0;
        try {
            em.getTransaction().begin();
            Query sql=em.createQuery("select a FROM Administrador a where a.usuario=?1 and a.clave=?2");
            sql.setParameter(1, obj.getUsuario());
            sql.setParameter(2, obj.getClave());
            List<Administrador> lista=sql.getResultList();
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
    public List<Administrador> lista() throws Exception{
        List lista=null;
        try {
            em.getTransaction().begin();
            Query sql=em.createQuery("select a from Administrador a");
            lista=sql.getResultList();
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
        return lista;
    }

    @Override
    public String AgregarAdmin(Administrador obj) throws Exception {
        String estado="";
        try {
            em.getTransaction().begin();
            em.persist(obj);
            estado="Registro Insertado";
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
        return estado;
    }

    @Override
    public Administrador CapturarDatos(Administrador obj) {
        Administrador objeto=null;
        try {
            em.getTransaction().begin();
            objeto = em.find(Administrador.class, obj.getIdAdministrador());
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
        return objeto;
    }

    @Override
    public String ModificarAdmin(Administrador obj) throws Exception {
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
    public String EliminarAdmin(Administrador obj) throws Exception {
        String mensaje="";
        try {
            em.getTransaction().begin();
            Administrador a = em.find(Administrador.class, obj.getIdAdministrador());
            em.remove(a);
            mensaje="Registro Eliminado";
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
        return mensaje;
    }

    @Override
    public int generarcodigo() throws Exception {
        int i=0;
        try {
            em.getTransaction().begin();
            i=(Integer)em.createQuery("select max(a.idAdministrador) from Administrador a").getSingleResult();
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
        return i;
    }

    @Override
    public Administrador DatosAdmin(Administrador obj) throws Exception {
        Administrador Datos=null;
        try {
            em.getTransaction().begin();
            Query sql=em.createQuery("select a FROM Administrador a where a.usuario=?1 and a.clave=?2");
            sql.setParameter(1, obj.getUsuario());
            sql.setParameter(2, obj.getClave());
            List<Administrador> lista=sql.getResultList();
            if(lista.size()>0){
                Datos=lista.get(0);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
        return Datos;
    }

    @Override
    public int CambiarClave(Administrador obj) throws Exception {
        int i=0;
        try {
            em.getTransaction().begin();
            String query="UPDATE Administrador SET clave="+obj.getClave()+" WHERE idadministrador="+obj.getIdAdministrador();
            Query sql=em.createNativeQuery(query);
            sql.setParameter(1, obj.getClave());
            sql.setParameter(2, obj.getIdAdministrador());
            List<Administrador> lista=sql.getResultList();
            if(lista.size()>0){
                i=1;
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
        return i;
    }
}