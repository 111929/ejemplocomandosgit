package edu.curso.java.ejemplohibernate;

import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import java.util.*;

import javax.persistence.criteria.*;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SessionFactory sf = HibernateUtils.getSessionFactory();
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		
		//String consulta1 = "from Fabrica as f where f.proveedor.nombre = 'El Proveedor 1'";
		//List<Fabrica> consulta1Resultado = session.createQuery(consulta1, Fabrica.class).getResultList();
		//for (Fabrica fabrica : consulta1Resultado) {
		//	System.out.println(fabrica.getNombre());
		//}
		
		
		//String consulta2 = "select p.fabricas from Proveedor as p where p.id = 1";
		//List<Fabrica> consulta2Resultado = session.createQuery(consulta2, Fabrica.class).getResultList();
		//for (Fabrica fabrica : consulta2Resultado) {
		//	System.out.println(fabrica.getNombre());
		//}
		
		//String consulta3 = "select p.localidad from Proveedor as p where p.id = 1";
		//Localidad localidadConsulta3 = session.createQuery(consulta3, Localidad.class).getSingleResult();
		//System.out.println(localidadConsulta3.getNombre());
		
		/*String consulta4 = "select p.nombre, p.precio from Producto as p where p.id = 1";
		Object[] row = (Object[]) session.createQuery(consulta4).getSingleResult();
		String nombre = (String) row[0];
		Double precio = (Double) row[1];
		
		System.out.println(nombre);
		System.out.println(precio);*/
		
		///String consulta5 = "select count(*) from Producto";
		//Long cantidadDeProductos = session.createQuery(consulta5, Long.class).getSingleResult();
		//System.out.println(cantidadDeProductos);

		
		/*Query<Producto> consulta6 = session.createQuery("from Producto as p order by p.nombre", Producto.class);
		consulta6.setFirstResult(1);
		consulta6.setMaxResults(2);
		
		List<Producto> consulta1Resultado = consulta6.getResultList();
		for (Producto producto : consulta1Resultado) {
			System.out.println(producto.getNombre());
		}*/
		//for (Fabrica fabrica : consulta1Resultado) {
		//	System.out.println(fabrica.getNombre());
		//}
		
	/*
		NativeQuery<Producto> consultaNativa1 = session.
				createNativeQuery("SELECT PRODUCTO.ID, PRODUCTO.NOMBRE, PRODUCTO.PRECIO, PRODUCTO.IVA FROM PRODUCTO",
				Producto.class);
		List<Producto> productos = consultaNativa1.getResultList();
		for (Producto p : productos) {
			System.out.println("Nombre: " + p.getNombre());
		}
		*/
		
		//
		//
		
		Query<Producto> namedQueryPorductos = session.createNamedQuery("listadoProductos", Producto.class);
		
		List<Producto> productos = namedQueryPorductos.getResultList();
		for (Producto p : productos) {
			System.out.println("Nombre: " + p.getNombre());
		}
		
		NativeQuery<Producto> namedNativeQueryPorductos = session.createNativeQuery("listadoProductosNativo", Producto.class);
		List<Producto> productos2 = namedNativeQueryPorductos.getResultList();
		for (Producto p : productos2) {
			System.out.println("Nombre: " + p.getNombre());
		}
		
		//Localidad
		/*
		Localidad localidad1 = new Localidad();
		localidad1.setNombre("Capital Federal");
		session.save(localidad1);
		/*/
		
		//Fabrica
		/*Fabrica fabrica1 = new Fabrica();
		fabrica1.setNombre("La Fabrica 1");
		fabrica1.setAltura(1234L);
		fabrica1.setCalle("Callao");

		session.save(fabrica1);*/
		
		//Producto 
		/*Producto producto1 = new Producto();
		producto1.setNombre("El Producto 1");
		producto1.setPrecio(5000.0);
		session.save(producto1);
		*/
		//Proveedor
		/*Proveedor proveedor1 = new Proveedor();
		proveedor1.setLocalidad(localidad1);
		proveedor1.getFabricas().add(fabrica1);
		proveedor1.setNombre("El Proveedor 1");
		proveedor1.getProductos().add(producto1);
		session.save(proveedor1);
		
		producto1.getProveedores().add(proveedor1);
		session.update(producto1);

		fabrica1.setProveedor(proveedor1);
		session.update(fabrica1);*/
		
		transaction.commit();
		session.close();
		sf.close();
	}

}
