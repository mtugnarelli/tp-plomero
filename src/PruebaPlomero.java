import org.junit.Assert;
import org.junit.Test;


public class PruebaPlomero {

	private Plomero plomero = new Plomero();
	
	private int desdeFila;
	private int hastaFila;
	
	@Test
	public void construirCanieriaDesdeFila1HastaFila5EnParedDe8x8() {
		
		/* condición inicial */
		Material[][] pared = new Material[8][8];
		this.completarConLadrillos(pared);
		this.desdeFila = 1;
		this.hastaFila = 5;
		pared[this.desdeFila][0] = Material.CANIO_HORIZONTAL;
		pared[this.hastaFila][7] = Material.CANIO_HORIZONTAL;

		/* operación */
		this.plomero.construirCanieria(pared);
		
		/* comprobación */
		this.comprobarCanieria(pared);
	}
	
	@Test
	public void construirCanieriaDesdeFila5HastaFila8EnParedDe40x10() {
		
		/* condición inicial */
		Material[][] pared = new Material[40][10];
		this.completarConLadrillos(pared);
		this.desdeFila = 5;
		this.hastaFila = 8;
		pared[this.desdeFila][0] = Material.CANIO_HORIZONTAL;
		pared[this.hastaFila][9] = Material.CANIO_HORIZONTAL;

		/* operación */
		this.plomero.construirCanieria(pared);		
		
		/* comprobación */
		this.comprobarCanieria(pared);
	}

	@Test
	public void construirCanieriaDesdeFila11HastaFila3EnParedDe15x15() {
		
		/* condición inicial */
		Material[][] pared = new Material[15][15];
		this.completarConLadrillos(pared);
		this.desdeFila = 11;
		this.hastaFila = 3;
		pared[this.desdeFila][0] = Material.CANIO_HORIZONTAL;
		pared[this.hastaFila][14] = Material.CANIO_HORIZONTAL;

		/* operación */
		this.plomero.construirCanieria(pared);
		
		/* comprobación */
		this.comprobarCanieria(pared);
	}
	
	private void comprobarCanieria(Material[][] pared) {

		for (int fila = 0 ; fila < pared.length; fila++) {
			
			for (int columna = 0; columna < pared[fila].length; columna++) {
				
				switch (pared[fila][columna]) {
					
					case CANIO_HORIZONTAL: 
						this.comprobarCanioHorizontal(pared, fila, columna);
						break;
					case CANIO_VERTICAL: 
						this.comprobarCanioVertical(pared, fila, columna);
						break;
					case CANIO_ABAJO_DERECHA: 
						this.comprobarCanioAbajoDerecha(pared, fila, columna);
						break;
					case CANIO_ABAJO_IZQUIERDA: 
						this.comprobarCanioAbajoIzquierda(pared, fila, columna);
						break;
					case CANIO_ARRIBA_DERECHA:
						this.comprobarCanioArribaDerecha(pared, fila, columna);
						break;
					case CANIO_ARRIBA_IZQUIERDA:
						this.comprobarCanioArribaIzquierda(pared, fila, columna);
						break;
				}
			}
		}
	
	}
	
	private void comprobarCanioHorizontal(Material[][] pared, int fila, int columna) {

		if (columna == 0) {
			
			Assert.assertEquals(this.desdeFila, fila);
		
		} else {

			this.comprobarConexionHaciaIzquierda(pared, fila, columna);
		}
		
		if (columna == pared[fila].length - 1) {
			
			Assert.assertEquals(this.hastaFila, fila);
			
		} else {

			this.comprobarConexionHaciaDerecha(pared, fila, columna);
		}
	}

	private void comprobarCanioVertical(Material[][] pared, int fila, int columna) {
		
		this.comprobarConexionHaciaArriba(pared, fila, columna);
		this.comprobarConexionHaciaAbajo(pared, fila, columna);
	}


	private void comprobarCanioAbajoIzquierda(Material[][] pared, int fila, int columna) {

		this.comprobarConexionHaciaAbajo(pared, fila, columna);
		this.comprobarConexionHaciaIzquierda(pared, fila, columna);
	}

	private void comprobarCanioAbajoDerecha(Material[][] pared, int fila, int columna) {
		
		this.comprobarConexionHaciaAbajo(pared, fila, columna);
		this.comprobarConexionHaciaDerecha(pared, fila, columna);
	}

	private void comprobarCanioArribaIzquierda(Material[][] pared, int fila, int columna) {

		this.comprobarConexionHaciaArriba(pared, fila, columna);
		this.comprobarConexionHaciaIzquierda(pared, fila, columna);
	}

	private void comprobarCanioArribaDerecha(Material[][] pared, int fila, int columna) {
		
		this.comprobarConexionHaciaArriba(pared, fila, columna);
		this.comprobarConexionHaciaDerecha(pared, fila, columna);
	}

	private void comprobarConexionHaciaDerecha(Material[][] pared, int fila, int columna) {

		Assert.assertTrue(columna != pared[fila].length - 1);
		Material derecha = pared[fila][columna + 1];
		Assert.assertTrue("DERECHA de " + pared[fila][columna] + " en [" + fila + "][" + columna + "] es " + derecha,
						  derecha == Material.CANIO_HORIZONTAL ||
						  derecha == Material.CANIO_ABAJO_IZQUIERDA ||
						  derecha == Material.CANIO_ARRIBA_IZQUIERDA);
	}

	private void comprobarConexionHaciaIzquierda(Material[][] pared, int fila, int columna) {

		Assert.assertTrue(columna != 0);
		Material izquierda = pared[fila][columna - 1];
		Assert.assertTrue("IZQUIERDA de " + pared[fila][columna] + " en [" + fila + "][" + columna + "] es " + izquierda,
						  izquierda == Material.CANIO_HORIZONTAL ||
						  izquierda == Material.CANIO_ABAJO_DERECHA ||
						  izquierda == Material.CANIO_ARRIBA_DERECHA);
	}

	private void comprobarConexionHaciaAbajo(Material[][] pared, int fila, int columna) {

		Assert.assertTrue(fila != pared.length - 1);
		Material abajo = pared[fila + 1][columna];
		Assert.assertTrue("ABAJO de " + pared[fila][columna] + " en [" + fila + "][" + columna + "] es " + abajo,
						  abajo == Material.CANIO_VERTICAL ||
						  abajo == Material.CANIO_ARRIBA_DERECHA ||
						  abajo == Material.CANIO_ARRIBA_IZQUIERDA);
	}

	private void comprobarConexionHaciaArriba(Material[][] pared, int fila, int columna) {

		Assert.assertTrue(fila != 0);
		Material arriba = pared[fila - 1][columna];
		Assert.assertTrue("ARRIBA de " + pared[fila][columna] + " en [" + fila + "][" + columna + "] es " + arriba,
						  arriba == Material.CANIO_VERTICAL ||
						  arriba == Material.CANIO_ABAJO_DERECHA ||
						  arriba == Material.CANIO_ABAJO_IZQUIERDA);
	}
	
	private void completarConLadrillos(Material[][] pared) {
		
		for (int fila = 0; fila < pared.length; fila++) {
			
			for (int columna = 0; columna < pared[fila].length; columna++) {
				
				pared[fila][columna] = Material.LADRILLO;
			}
		}
	}
}
