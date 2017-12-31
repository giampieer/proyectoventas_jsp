package JPA;

import JPA.Factura;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-11-29T00:31:43")
@StaticMetamodel(Producto.class)
public class Producto_ { 

    public static volatile SingularAttribute<Producto, Double> precio;
    public static volatile SingularAttribute<Producto, String> categoria;
    public static volatile SingularAttribute<Producto, Integer> stock;
    public static volatile SingularAttribute<Producto, Integer> idproducto;
    public static volatile SingularAttribute<Producto, String> nombre;
    public static volatile CollectionAttribute<Producto, Factura> facturaCollection;

}