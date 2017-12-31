/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Factoria;

import Interfaces.AdministradorDao;
import Interfaces.ClienteDAO;
import Interfaces.FacturaDao;
import Interfaces.ProductoDAO;

/**
 *
 * @author Home
 */
public abstract  class DaoFactory {
    public static final int MYSQL=1;
    public abstract  ClienteDAO getCliente();
    public abstract AdministradorDao getAdministradorDao();
    public abstract ProductoDAO getProductoDAO();
    public abstract FacturaDao getFacturaDao();
    public static DaoFactory getDaoFactory(int op){
      switch(op){
          case 1 :
          return new MysqlDaoFactory();
          default: return null;
          
      }
    }
}
