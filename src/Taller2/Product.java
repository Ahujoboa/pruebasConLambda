package Taller2;

import java.math.BigDecimal;

public class Product implements Comparable<Product> {

	private String nombre;
	private BigDecimal precioSinIVA;
	private Tax tax;
	private BigDecimal precioFinal;

	public Product(String nombre, BigDecimal precioSinIVA, Tax tax) {
		super();
		this.nombre = nombre;
		this.precioSinIVA = precioSinIVA;
		this.tax = tax;
	}

	public Tax getTax() {
		return tax;
	}

	public void setTax(Tax tax) {
		this.tax = tax;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public BigDecimal getPrecioSinIVA() {
		return precioSinIVA;
	}

	public void setPrecioSinIVA(BigDecimal precioSinIVA) {
		this.precioSinIVA = precioSinIVA;
	}

	public BigDecimal getPrecioFinal() {
		return this.precioSinIVA.add(tax.getPrecio().multiply(precioSinIVA));
	}

	public void setPrecioFinal(BigDecimal precioFinal) {
		this.precioFinal = precioFinal;
	}

	@Override
	public int compareTo(Product o) {

		return this.nombre.compareTo(o.getNombre());
	}

}
