package ar.edu.unlam.pb2;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestCuenta {
	
	@Test
	public void queSePuedaCrearUnaCuenta() {
		
		// Ejecuci�n
		Cuenta nuevaCuenta= new CajaDeAhorro();
		
		// Validaci�n
		assertNotNull(nuevaCuenta);
	}

	@Test
	public void queSePuedaConsultarElSaldoDeUnaCuenta() {
		// Valores esperados
		final Double SALDO_ESPERADO = 0.0 ;
		
		// Ejecuci�n
		Cuenta nuevaCuenta= new CuentaCorriente();
		
		// Validaci�n
		assertEquals(SALDO_ESPERADO, nuevaCuenta.getSaldo());		
	}
}
