/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;


import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import Interfaces.ProductoDAO;
import JPA.Producto;

/**
 *
 * @author TOSHIBA
 */
public class MysqlProductoDao implements ProductoDAO{

    EntityManagerFactory emf=Persistence.createEntityManagerFactory("ventas");
    EntityManager em=emf.createEntityManager();
    @Override
    public String grabarproducto(Producto obj) throws Exception {
        String mensaje="";
        try {
            em.getTransaction().begin();
            em.persist(obj);
            mensaje="Registro Insertado";
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
        return mensaje;
    }

    @Override
    public String eliminarproducto(Producto obj) throws Exception {
        String mensaje="";
        try {
            em.getTransaction().begin();
            Producto cur=em.find(Producto.class, obj.getIdproducto());
            em.remove(cur);
            mensaje="Registro Eliminado";
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
        return mensaje;
    }

    @Override
    public String modificarproducto(Producto obj) throws Exception {
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
    public List<Producto> listarproducto() throws Exception {
        List<Producto> lista=null;
        try {
            em.getTransaction().begin();
            Query sql=em.createQuery("select c from Producto c");
            lista=sql.getResultList();
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
        return lista;
    }

    @Override
    public Producto cargarproducto(Producto obj) throws Exception {
        Producto objeto=null;
        try {
            em.getTransaction().begin();
            objeto=em.find(Producto.class, obj.getIdproducto());
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
        return objeto;
    }

    @Override
    public int GenerarCodigo() throws Exception {
        int i=0;
        try {
            em.getTransaction().begin();
            i=(Integer)em.createQuery("select max(c.idproducto) from Producto c").getSingleResult();
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
        return i;
    }

}
