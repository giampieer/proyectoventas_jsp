package JPA;

import JPA.Factura;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-11-29T00:31:43")
@StaticMetamodel(Administrador.class)
public class Administrador_ { 

    public static volatile SingularAttribute<Administrador, Integer> idAdministrador;
    public static volatile SingularAttribute<Administrador, String> clave;
    public static volatile SingularAttribute<Administrador, String> apellido;
    public static volatile SingularAttribute<Administrador, String> correo;
    public static volatile SingularAttribute<Administrador, String> usuario;
    public static volatile SingularAttribute<Administrador, String> sexo;
    public static volatile SingularAttribute<Administrador, String> nombre;
    public static volatile SingularAttribute<Administrador, Integer> edad;
    public static volatile CollectionAttribute<Administrador, Factura> facturaCollection;

}