package Taller2;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class Main {
	// Almacenará el precio total del carrito
	private static BigDecimal precioTotal = new BigDecimal(0);
	// Lista que almacenará los productos que empiecen por C
	static List<String> lista = new ArrayList<String>();

	public static void main(String[] args) {
		// Lista de productos del carrito
		List<Product> shoppingCart = List.of(new Product("Clothes", new BigDecimal("15.90"), Tax.NORMAL),
				new Product("Bread", new BigDecimal("1.5"), Tax.SUPERREDUCED),
				new Product("Meat", new BigDecimal("13.99"), Tax.REDUCED),
				new Product("Cheese", new BigDecimal("3.59"), Tax.SUPERREDUCED),
				new Product("Coke", new BigDecimal("1.89"), Tax.REDUCED),
				new Product("Whiskey", new BigDecimal("19.90"), Tax.NORMAL));

		/*
		 * Primero convertimos a flujo, después mapeamos para conseguir la lista de
		 * precios finales de los productos y por último sumamos las cantidades.
		 * Imprimimos redondeando el precio.
		 */
		precioTotal = shoppingCart.stream().map(Product::getPrecioFinal).reduce(BigDecimal.ZERO, (a, b) -> a.add(b));
		System.out.printf("El precio total del carrito es de %2.2f euros.\n",
				precioTotal.setScale(2, RoundingMode.HALF_UP));

		/*
		 * Convertimos la lista a flujo, filtramos y obtenemos los que empiezan con C,
		 * los ordenamos alfabéticamente con sorted y los recorremos y almacenamos en la
		 * lista.
		 */
		shoppingCart.stream().filter(producto -> producto.getNombre().startsWith("C")).sorted().forEach(producto -> {

			lista.add(producto.getNombre());

		});

		// Imprimimos la lista usando el método joining de la clase Collectos para
		// introducir comas entre los elementos.
		System.out.println("Productos que empienzan por C: " + lista.stream().collect(Collectors.joining(", ")));

	}

}
