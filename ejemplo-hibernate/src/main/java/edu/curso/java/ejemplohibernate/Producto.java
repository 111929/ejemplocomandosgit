package edu.curso.java.ejemplohibernate;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;


@Entity
@NamedQueries({
	@NamedQuery(name = "listadoProductos", query = "from Producto as p order by p.nombre")
})
@NamedNativeQueries({
	@NamedNativeQuery(name = "listadoProductosNativo", query = "SELECT PRODUCTO.ID, PRODUCTO.NOMBRE, PRODUCTO.PRECIO, PRODUCTO.IVA FROM PRODUCTO")
})
public class Producto {


	@Id
	@GeneratedValue
	private Long id;
	private String nombre;
	private Double precio;
	private Double iva;
	
	@ManyToMany
	private Set<Proveedor> proveedores = new HashSet<Proveedor>();
	
	public Set<Proveedor> getProveedores() {
		return proveedores;
	}
	public void setProveedores(Set<Proveedor> proveedores) {
		this.proveedores = proveedores;
	}
	public Double getIva() {
		return iva;
	}
	public void setIva(Double iva) {
		this.iva = iva;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Producto other = (Producto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
	
}
