package ar.edu.unlam.pb2;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestCajaDeAhorro {

	@Test
	public void queSePuedaCrearUnaCajaDeAhorro() {
		
		// Ejecución
		CajaDeAhorro nuevaCuenta= new CajaDeAhorro();
		
		// Validación
		assertNotNull(nuevaCuenta);
	}
	
	@Test
	public void queSePuedaDepositarDineroEnUnaCuentaDeAhorro() {
		// Datos de entrada
		final Double IMPORTE_A_DEPOSITAR = 50000.0;
		
		// Valores esperados
		final Double SALDO_ESPERADO = IMPORTE_A_DEPOSITAR;
		
		// Ejecución
		CajaDeAhorro nuevaCuentaDeAhorro= new CajaDeAhorro();
		nuevaCuentaDeAhorro.depositar(IMPORTE_A_DEPOSITAR);
		
		assertEquals(SALDO_ESPERADO, nuevaCuentaDeAhorro.getSaldo());
	}

	@Test
	public void queSePuedaExtraerDeUnaCuentaDeAhorroUnImporteMenorAlSaldo() {
		// Datos de entrada
		final Double IMPORTE_A_DEPOSITAR = 50000.0;
		final Double IMPORTE_A_EXTRAER = 1000.0;
		
		// Valores esperados
		final Double SALDO_ESPERADO = IMPORTE_A_DEPOSITAR - IMPORTE_A_EXTRAER;
		
		// Ejecución
		CajaDeAhorro nuevaCuentaDeAhorro= new CajaDeAhorro();
		nuevaCuentaDeAhorro.depositar(IMPORTE_A_DEPOSITAR);
		nuevaCuentaDeAhorro.extraer(IMPORTE_A_EXTRAER);
		
		// Validación
		assertEquals(SALDO_ESPERADO, nuevaCuentaDeAhorro.getSaldo());
	}

	@Test
	public void queSePuedaExtraerDeUnaCuentaDeAhorroUnImporteIgualAlSaldo() {
		// Datos de entrada
		final Double IMPORTE_A_DEPOSITAR = 50000.0;
		final Double IMPORTE_A_EXTRAER = 1000.0;
		
		// Valores esperados
		final Double SALDO_ESPERADO = IMPORTE_A_DEPOSITAR - IMPORTE_A_EXTRAER;
		
		CajaDeAhorro nuevaCuentaDeAhorro= new CajaDeAhorro();
		nuevaCuentaDeAhorro.depositar(IMPORTE_A_DEPOSITAR);
		nuevaCuentaDeAhorro.extraer(IMPORTE_A_EXTRAER);
		
		assertEquals(SALDO_ESPERADO, nuevaCuentaDeAhorro.getSaldo());
	}

	@Test
	public void queNoSePuedaExtraerDeUnaCuentaDeAhorroUnImporteMayorAlSaldo() {
		// Datos de entrada
		final Double IMPORTE_A_DEPOSITAR = 50000.0;
		final Double IMPORTE_A_EXTRAER = 50001.0;
		
		// Valores esperados
		final Double SALDO_ESPERADO = IMPORTE_A_DEPOSITAR;
		
		// Ejecución		
		CajaDeAhorro nuevaCuentaDeAhorro= new CajaDeAhorro();
		nuevaCuentaDeAhorro.depositar(IMPORTE_A_DEPOSITAR);
		
		// Validación
		assertFalse(nuevaCuentaDeAhorro.extraer(IMPORTE_A_EXTRAER));
		assertEquals(SALDO_ESPERADO, nuevaCuentaDeAhorro.getSaldo());
	}

	@Test
	public void queSeCobreSeisPesosAdicionalesLuegoDeLaQuintaExtraccionDeUnaCuentaDeAhorro() {
		// Datos de entrada
		final Double IMPORTE_A_DEPOSITAR = 50000.0;
		final Double IMPORTE_A_EXTRAER_1 = 1000.0;
		final Double IMPORTE_A_EXTRAER_2 = 2000.0;
		final Double IMPORTE_A_EXTRAER_3 = 3000.0;
		final Double IMPORTE_A_EXTRAER_4 = 4000.0;
		final Double IMPORTE_A_EXTRAER_5 = 5000.0;
		final Double IMPORTE_A_EXTRAER_6 = 5000.0;
		final Double ADICIONAL_SEXTA_EXTRACCION = 6.0;
		
		// Valores esperados
		final Double SALDO_ESPERADO = IMPORTE_A_DEPOSITAR - (IMPORTE_A_EXTRAER_1 + IMPORTE_A_EXTRAER_2 + IMPORTE_A_EXTRAER_3 + IMPORTE_A_EXTRAER_4 + IMPORTE_A_EXTRAER_5 + IMPORTE_A_EXTRAER_6 + ADICIONAL_SEXTA_EXTRACCION);
		
		// Ejecución
		CajaDeAhorro nuevaCuentaDeAhorro= new CajaDeAhorro();
		
		nuevaCuentaDeAhorro.depositar(IMPORTE_A_DEPOSITAR);
		nuevaCuentaDeAhorro.extraer(IMPORTE_A_EXTRAER_1);
		nuevaCuentaDeAhorro.extraer(IMPORTE_A_EXTRAER_2);
		nuevaCuentaDeAhorro.extraer(IMPORTE_A_EXTRAER_3);
		nuevaCuentaDeAhorro.extraer(IMPORTE_A_EXTRAER_4);
		nuevaCuentaDeAhorro.extraer(IMPORTE_A_EXTRAER_5);
		nuevaCuentaDeAhorro.extraer(IMPORTE_A_EXTRAER_6);
		
		// Validación
		assertEquals(SALDO_ESPERADO, nuevaCuentaDeAhorro.getSaldo());
	}

	@Test
	public void queNoSeCobreNingunAdicionalAntesDeLaQuintaExtraccionDeUnaCuentaDeAhorro() {
		// Datos de entrada
		final Double IMPORTE_A_DEPOSITAR = 50000.0;
		final Double IMPORTE_A_EXTRAER_1 = 1000.0;
		final Double IMPORTE_A_EXTRAER_2 = 2000.0;
		final Double IMPORTE_A_EXTRAER_3 = 3000.0;
		final Double IMPORTE_A_EXTRAER_4 = 4000.0;
		
		// Valores esperados
		final Double SALDO_ESPERADO = IMPORTE_A_DEPOSITAR - (IMPORTE_A_EXTRAER_1 + IMPORTE_A_EXTRAER_2 + IMPORTE_A_EXTRAER_3 + IMPORTE_A_EXTRAER_4);
		
		// Ejecución
		CajaDeAhorro nuevaCuenta= new CajaDeAhorro();
		nuevaCuenta.depositar(IMPORTE_A_DEPOSITAR);
		nuevaCuenta.extraer(IMPORTE_A_EXTRAER_1);
		nuevaCuenta.extraer(IMPORTE_A_EXTRAER_2);
		nuevaCuenta.extraer(IMPORTE_A_EXTRAER_3);
		nuevaCuenta.extraer(IMPORTE_A_EXTRAER_4);
		
		// Validación
		assertEquals(SALDO_ESPERADO, nuevaCuenta.getSaldo());
	}

	@Test
	public void queNoSeCobreNingunAdicionalEnLaQuintaExtraccionDeUnaCuentaDeAhorro() {
		// Datos de entrada
		final Double IMPORTE_A_DEPOSITAR = 50000.0;
		final Double IMPORTE_A_EXTRAER_1 = 1000.0;
		final Double IMPORTE_A_EXTRAER_2 = 2000.0;
		final Double IMPORTE_A_EXTRAER_3 = 3000.0;
		final Double IMPORTE_A_EXTRAER_4 = 4000.0;
		final Double IMPORTE_A_EXTRAER_5 = 5000.0;
		
		// Valores esperados
		final Double SALDO_ESPERADO = IMPORTE_A_DEPOSITAR - (IMPORTE_A_EXTRAER_1 + IMPORTE_A_EXTRAER_2 + IMPORTE_A_EXTRAER_3 + IMPORTE_A_EXTRAER_4 + IMPORTE_A_EXTRAER_5);
		
		// Ejecución
		CajaDeAhorro nuevaCuentaDeAhorro= new CajaDeAhorro();
		nuevaCuentaDeAhorro.depositar(IMPORTE_A_DEPOSITAR);
		nuevaCuentaDeAhorro.extraer(IMPORTE_A_EXTRAER_1);
		nuevaCuentaDeAhorro.extraer(IMPORTE_A_EXTRAER_2);
		nuevaCuentaDeAhorro.extraer(IMPORTE_A_EXTRAER_3);
		nuevaCuentaDeAhorro.extraer(IMPORTE_A_EXTRAER_4);
		nuevaCuentaDeAhorro.extraer(IMPORTE_A_EXTRAER_5);
		
		// Validación
		assertEquals(SALDO_ESPERADO, nuevaCuentaDeAhorro.getSaldo());
	}

}
