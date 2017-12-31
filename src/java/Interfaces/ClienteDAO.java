/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import JPA.Cliente;
import ManagerBean.ManagerCliente;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author TOSHIBA
 */
public interface ClienteDAO {
    public int logincliente(Cliente obj)throws Exception;
    public String grabarcliente(Cliente obj)throws Exception;
    public String eliminarcliente(Cliente obj)throws Exception;
    public String modificarcliente(Cliente obj)throws Exception;
    public List<Cliente>listarcliente()throws Exception;
    public Cliente cargarcliente(Cliente obj)throws Exception;
    public Cliente DatosCliente(Cliente obj)throws Exception;
    public int GenerarCodigo()throws Exception;
}
