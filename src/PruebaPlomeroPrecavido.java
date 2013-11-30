import org.junit.Test;


public class PruebaPlomeroPrecavido {

	private Plomero plomero = new Plomero();
	
	@Test(expected = Error.class)
	public void construirEnParedNula() {
		
		/* operación */
		this.plomero.construirCanieria(null);
	}

	@Test(expected = Error.class)
	public void construirEnParedNoRegular() {

		/* condición inicial */
		Material[][] pared = new Material[14][];
		for (int fila = 0; fila < pared.length; fila++) {
			pared[fila] = new Material[fila + 2];
		}
		this.completarConLadrillos(pared);
		
		/* operación */
		this.plomero.construirCanieria(pared);
	}

	@Test(expected = Error.class)
	public void construirEnParedSinCanioInicial() {
		
		/* condición inicial */
		Material[][] pared = new Material[5][8];
		this.completarConLadrillos(pared);
		pared[3][7] = Material.CANIO_HORIZONTAL;
		
		/* operación */
		this.plomero.construirCanieria(pared);
	}

	@Test(expected = Error.class)
	public void construirEnParedSinCanioFinal() {
		
		/* condición inicial */
		Material[][] pared = new Material[5][8];
		this.completarConLadrillos(pared);
		pared[3][0] = Material.CANIO_HORIZONTAL;
		
		/* operación */
		this.plomero.construirCanieria(pared);
	}

	private void completarConLadrillos(Material[][] pared) {
		
		for (int fila = 0; fila < pared.length; fila++) {
			
			for (int columna = 0; columna < pared[fila].length; columna++) {
				
				pared[fila][columna] = Material.LADRILLO;
			}
		}
	}
}
