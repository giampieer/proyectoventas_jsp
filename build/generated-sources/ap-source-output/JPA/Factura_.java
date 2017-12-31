package JPA;

import JPA.Administrador;
import JPA.Cliente;
import JPA.Producto;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-11-29T00:31:43")
@StaticMetamodel(Factura.class)
public class Factura_ { 

    public static volatile SingularAttribute<Factura, String> fecha;
    public static volatile SingularAttribute<Factura, Cliente> cliente;
    public static volatile SingularAttribute<Factura, Integer> numfactura;
    public static volatile SingularAttribute<Factura, Double> precio;
    public static volatile SingularAttribute<Factura, Administrador> administrador;
    public static volatile SingularAttribute<Factura, Integer> cantidad;
    public static volatile SingularAttribute<Factura, Producto> producto;

}