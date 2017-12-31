/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Interfaces.FacturaDao;
import JPA.Factura;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Jhonk
 */
public class MysqlFacturaDao implements FacturaDao {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("ventas");
    EntityManager em = emf.createEntityManager();

    @Override
    public String GrabarFactura(Factura obj) throws Exception {
        String mensaje = "";
        try {
            em.getTransaction().begin();
            em.persist(obj);
            mensaje = "Registro Insertado";
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
        return mensaje;
    }

    @Override
    public List<Factura> MostrarFactura(Factura obj) throws Exception {
        List lista = null;
        try {
            em.getTransaction().begin();
            Query sql = em.createQuery("select a from Factura a where a.cliente.idcliente=:x");
            sql.setParameter("x", obj.getCliente().getIdcliente());
            lista = sql.getResultList();
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
        return lista;
    }

    @Override
    public int GenerarCodigo() throws Exception {
        int i = 0;
        try {
            em.getTransaction().begin();
            i = (Integer) em.createQuery("select max(c.numfactura) from Factura c").getSingleResult();
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
        return i;
    }

}
