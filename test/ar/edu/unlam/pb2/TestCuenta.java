package ar.edu.unlam.pb2;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestCuenta {
	
	@Test
	public void queSePuedaCrearUnaCuenta() {
		
		// Ejecución
		Cuenta nuevaCuenta= new CajaDeAhorro();
		
		// Validación
		assertNotNull(nuevaCuenta);
	}

	@Test
	public void queSePuedaConsultarElSaldoDeUnaCuenta() {
		// Valores esperados
		final Double SALDO_ESPERADO = 0.0 ;
		
		// Ejecución
		Cuenta nuevaCuenta= new CuentaCorriente();
		
		// Validación
		assertEquals(SALDO_ESPERADO, nuevaCuenta.getSaldo());		
	}
}
