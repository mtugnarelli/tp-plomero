import org.junit.Assert;
import org.junit.Test;


public class PruebaPlomeroPrincipiante {

	private Plomero plomero = new Plomero();
	
	@Test
	public void construirEnParedMinima() {
		
		/* condición inicial */
		Material[][] pared = new Material[1][3];
		pared[0][0] = Material.CANIO_HORIZONTAL;
		pared[0][1] = Material.LADRILLO;
		pared[0][2] = Material.CANIO_HORIZONTAL;

		/* operación */
		this.plomero.construirCanieria(pared);
		
		/* comprobación */
		Assert.assertEquals(Material.CANIO_HORIZONTAL, pared[0][1]);
	}
	
	@Test
	public void construirCanieriaLinealSuperiorEnParedCuadradaMinima() {
		
		/* condición inicial */
		Material[][] pared = new Material[][] {
				{ Material.CANIO_HORIZONTAL, Material.LADRILLO, Material.CANIO_HORIZONTAL },	
				{ Material.LADRILLO,         Material.LADRILLO, Material.LADRILLO },
				{ Material.LADRILLO,         Material.LADRILLO, Material.LADRILLO }	
		};
		
		/* operación */
		this.plomero.construirCanieria(pared);
		
		/* comprobación */
		Assert.assertEquals(Material.CANIO_HORIZONTAL, pared[0][1]);
	}
	
	@Test
	public void construirCanieriaLinealCentralEnParedCuadradaMinima() {
		
		/* condición inicial */
		Material[][] pared = new Material[][] {
				{ Material.LADRILLO,         Material.LADRILLO, Material.LADRILLO },
				{ Material.CANIO_HORIZONTAL, Material.LADRILLO, Material.CANIO_HORIZONTAL },	
				{ Material.LADRILLO,         Material.LADRILLO, Material.LADRILLO }	
		};
		
		/* operación */
		this.plomero.construirCanieria(pared);
		
		/* comprobación */
		Assert.assertEquals(Material.CANIO_HORIZONTAL, pared[1][1]);
	}

	@Test
	public void construirCanieriaLinealInferiorEnParedCuadradaMinima() {
		
		/* condición inicial */
		Material[][] pared = new Material[][] {
				{ Material.LADRILLO,         Material.LADRILLO, Material.LADRILLO },
				{ Material.LADRILLO,         Material.LADRILLO, Material.LADRILLO },	
				{ Material.CANIO_HORIZONTAL, Material.LADRILLO, Material.CANIO_HORIZONTAL }	
		};
		
		/* operación */
		this.plomero.construirCanieria(pared);
		
		/* comprobación */
		Assert.assertEquals(Material.CANIO_HORIZONTAL, pared[2][1]);
	}

	@Test
	public void construirCanieriaLinealCentralEnParedDe3x5() {
		
		/* condición inicial */
		Material[][] pared = new Material[3][5];
		this.completarConLadrillos(pared);
		pared[1][0] = Material.CANIO_HORIZONTAL;
		pared[1][4] = Material.CANIO_HORIZONTAL;
		
		/* operación */
		this.plomero.construirCanieria(pared);
		
		/* comprobación */
		Assert.assertEquals(Material.CANIO_HORIZONTAL, pared[1][1]);
		Assert.assertEquals(Material.CANIO_HORIZONTAL, pared[1][2]);
		Assert.assertEquals(Material.CANIO_HORIZONTAL, pared[1][3]);
	}
	
	@Test
	public void construirCanieriaLinealInferiorEnParedDe5x8() {
		
		/* condición inicial */
		Material[][] pared = new Material[5][8];
		this.completarConLadrillos(pared);
		pared[3][0] = Material.CANIO_HORIZONTAL;
		pared[3][7] = Material.CANIO_HORIZONTAL;
		
		/* operación */
		this.plomero.construirCanieria(pared);
		
		/* comprobación */
		Assert.assertEquals(Material.CANIO_HORIZONTAL, pared[3][1]);
		Assert.assertEquals(Material.CANIO_HORIZONTAL, pared[3][2]);
		Assert.assertEquals(Material.CANIO_HORIZONTAL, pared[3][3]);
		Assert.assertEquals(Material.CANIO_HORIZONTAL, pared[3][4]);
		Assert.assertEquals(Material.CANIO_HORIZONTAL, pared[3][5]);
		Assert.assertEquals(Material.CANIO_HORIZONTAL, pared[3][6]);
	}
	
	private void completarConLadrillos(Material[][] pared) {
		
		for (int fila = 0; fila < pared.length; fila++) {
			
			for (int columna = 0; columna < pared[fila].length; columna++) {
				
				pared[fila][columna] = Material.LADRILLO;
			}
		}
	}
}
