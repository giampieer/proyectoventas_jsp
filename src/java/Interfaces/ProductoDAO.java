/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import JPA.Producto;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author TOSHIBA
 */
public interface ProductoDAO {
    public String grabarproducto(Producto obj)throws Exception;
    public String eliminarproducto(Producto obj)throws Exception;
    public String modificarproducto(Producto obj)throws Exception;
    public List<Producto>listarproducto()throws Exception;
    public Producto cargarproducto(Producto obj)throws Exception;
    public int GenerarCodigo()throws Exception;
    
}
