/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Factoria;

import Dao.MysqlAdministradorDao;
import Dao.MysqlClienteDao;
import Dao.MysqlFacturaDao;
import Dao.MysqlProductoDao;
import Interfaces.AdministradorDao;
import Interfaces.ClienteDAO;
import Interfaces.FacturaDao;
import Interfaces.ProductoDAO;

public class MysqlDaoFactory extends DaoFactory{

    @Override
    public ClienteDAO getCliente() {
    return new MysqlClienteDao();
    }


    @Override
    public AdministradorDao getAdministradorDao() {
        return new MysqlAdministradorDao();
    }

    @Override
    public ProductoDAO getProductoDAO() {
        return new MysqlProductoDao();
    }

    @Override
    public FacturaDao getFacturaDao() {
        return new MysqlFacturaDao();
    }

    
}
