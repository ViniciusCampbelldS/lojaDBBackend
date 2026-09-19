import model.*;
//spring initializer --> --> --> https://start.spring.io/
public class Main {
	public static void main(String[] args) {
		Produto produto0 = new Produto(
				0,
				"Notebook",
				"Notebook para estudos",
				3499.99,
				10
		);
		
		Categoria categoria0 = new Categoria(
				0,
				"Tecnologia",
				"Aparelhos digitais, comunicação e TI."
		);
		
		Cliente cliente0 = new Cliente(
				0,
				"Joannette",
				"joanetteejulietteamigasparasempre@gmail.com",
				"666.069.666-69"
		);
		
	}
}