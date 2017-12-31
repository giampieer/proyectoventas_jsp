/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import JPA.Factura;
import java.util.List;

/**
 *
 * @author Jhonk
 */
public interface FacturaDao {
    public String GrabarFactura(Factura obj)throws Exception;
    public List<Factura> MostrarFactura(Factura obj)throws Exception;
    public int GenerarCodigo()throws Exception;
}
