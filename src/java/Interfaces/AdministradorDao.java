/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import JPA.Administrador;
import ManagerBean.ManagerAdministrador;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jhonk
 */
public interface AdministradorDao {
    public int LoginAdmin(Administrador obj) throws Exception;
    public List<Administrador> lista() throws Exception;
    public String AgregarAdmin(Administrador obj)throws Exception;
    public Administrador CapturarDatos(Administrador obj);
    public String ModificarAdmin(Administrador obj)throws Exception;
    public String EliminarAdmin(Administrador obj)throws Exception;
    public Administrador DatosAdmin(Administrador obj)throws Exception;
    public int generarcodigo() throws  Exception;
    public int CambiarClave(Administrador obj) throws Exception;
}
