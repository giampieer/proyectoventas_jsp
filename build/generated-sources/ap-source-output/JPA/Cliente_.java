package JPA;

import JPA.Factura;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-11-29T00:31:43")
@StaticMetamodel(Cliente.class)
public class Cliente_ { 

    public static volatile SingularAttribute<Cliente, String> clave;
    public static volatile SingularAttribute<Cliente, String> apellido;
    public static volatile SingularAttribute<Cliente, String> correo;
    public static volatile SingularAttribute<Cliente, String> usuario;
    public static volatile SingularAttribute<Cliente, String> sexo;
    public static volatile SingularAttribute<Cliente, Integer> idcliente;
    public static volatile SingularAttribute<Cliente, String> nombre;
    public static volatile SingularAttribute<Cliente, Integer> edad;
    public static volatile CollectionAttribute<Cliente, Factura> facturaCollection;

}