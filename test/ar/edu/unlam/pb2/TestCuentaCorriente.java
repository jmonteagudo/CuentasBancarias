package ar.edu.unlam.pb2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class TestCuentaCorriente {
	
	private final Double DELTA = 0.01;
	
	@Test
	public void queSePuedaCrearUnaCuentaCorriente() {
		
		// Ejecución
		CuentaCorriente nuevaCuenta= new CuentaCorriente();
		
		// Validación
		assertNotNull(nuevaCuenta);
	}

	@Test
	public void queSePuedaDepositarDineroEnUnaCuentaCorriente() {	
		// Datos de entrada
		final Double IMPORTE_A_DEPOSITAR = 50000.0;
		
		// Valores esperados
		final Double SALDO_ESPERADO = IMPORTE_A_DEPOSITAR;
		
		// Ejecución
		CuentaCorriente nueva = new CuentaCorriente();
		nueva.depositar(IMPORTE_A_DEPOSITAR);

		assertEquals(SALDO_ESPERADO, nueva.getSaldo());
	}

	@Test
	public void queSePuedaExtraerDeUnaCuentaCorrienteUnImporteMenorAlSaldo() {
		// Datos de entrada
		final Double IMPORTE_A_DEPOSITAR = 100.0;
		final Double IMPORTE_A_EXTRAER = 50.0;
		
		// Valores esperados
		final Double SALDO_ESPERADO = IMPORTE_A_DEPOSITAR - IMPORTE_A_EXTRAER;
		
		// Ejecución
		CuentaCorriente nueva = new CuentaCorriente();
		nueva.depositar(IMPORTE_A_DEPOSITAR);
		nueva.extraer(IMPORTE_A_EXTRAER);

		// Validación
		assertEquals(SALDO_ESPERADO, nueva.getSaldo());
	}

	@Test
	public void queSePuedaExtraerDeUnaCuentaCorrienteoUnImporteIgualAlSaldo() {
		// Datos de entrada
		final Double IMPORTE_A_DEPOSITAR = 100.0;
		final Double IMPORTE_A_EXTRAER = 100.0;
		
		// Valores esperados
		final Double SALDO_ESPERADO = IMPORTE_A_DEPOSITAR - IMPORTE_A_EXTRAER;
		
		// Ejecución
		CuentaCorriente nueva = new CuentaCorriente();
		nueva.depositar(IMPORTE_A_DEPOSITAR);
		nueva.extraer(IMPORTE_A_EXTRAER);

		// Validación
		assertEquals(SALDO_ESPERADO, nueva.getSaldo());
	}

	@Test
	public void queSePuedaExtraerDeUnaCuentaCorrienteoUnImporteIgualAlSaldoMasElDescubierto() {
		// Datos de entrada
		final Double IMPORTE_A_DEPOSITAR = 100.0;
		final Double IMPORTE_A_EXTRAER = 250.0;
		
		// Valores esperados
		final Double SALDO_ESPERADO = 0.0;
		final Double DESCUBIERTO_ACTUAL_ESPERADO = IMPORTE_A_EXTRAER - IMPORTE_A_DEPOSITAR;
		
		// Ejecución
		CuentaCorriente nueva = new CuentaCorriente();
		nueva.depositar(IMPORTE_A_DEPOSITAR);
		nueva.extraer(IMPORTE_A_EXTRAER);

		// Validación
		assertEquals(SALDO_ESPERADO, nueva.getSaldo());
		assertEquals(DESCUBIERTO_ACTUAL_ESPERADO, nueva.getDescubiertoActual());
	}

	@Test
	public void queNoSePuedaExtraerDeUnaCuentaCorrienteUnImporteMayorAlSaldoMasElDescubierto() {
		// Datos de entrada
		final Double IMPORTE_A_DEPOSITAR = 100.0;
		final Double IMPORTE_A_EXTRAER = 251.0;
		
		// Valores esperados
		final Double SALDO_ESPERADO = IMPORTE_A_DEPOSITAR;
		final Double DESCUBIERTO_ACTUAL_ESPERADO = 0.0;
		
		// Ejecución
		CuentaCorriente nueva = new CuentaCorriente();
		nueva.depositar(IMPORTE_A_DEPOSITAR);
		nueva.extraer(IMPORTE_A_EXTRAER);

		// Validación
		assertEquals(SALDO_ESPERADO, nueva.getSaldo());
		assertEquals(DESCUBIERTO_ACTUAL_ESPERADO, nueva.getDescubiertoActual());
	}

	@Test
	public void queSeCobreCincoPorcientoDeComisionAlDepositarDineroLuegoDeHaberRealizadoUnaExtraccionMayorAlSaldo() {
		
		// Datos de entrada
		final Double IMPORTE_A_DEPOSITAR_DEPOSITO_1 = 100.0;
		final Double IMPORTE_A_EXTRAER = 200.0;
		final Double IMPORTE_A_DEPOSITAR_DEPOSITO_2 = 105.0;
		
		// Valores esperados
		final Double DESCUBIERTO_ACTUAL_ESPERADO = 0.0;
		final Double SALDO_ESPERADO = 0.0;
		
		// Ejecución
		CuentaCorriente nueva = new CuentaCorriente();
		nueva.depositar(IMPORTE_A_DEPOSITAR_DEPOSITO_1);
		nueva.extraer(IMPORTE_A_EXTRAER);
		nueva.depositar(IMPORTE_A_DEPOSITAR_DEPOSITO_2);

		// Validación
		assertEquals(SALDO_ESPERADO, nueva.getSaldo());
		assertEquals(DESCUBIERTO_ACTUAL_ESPERADO, nueva.getDescubiertoActual());
	}
	
	@Test
	public void queSeCobreElCincoPorCientoDeComisionPorMasQueElProximoDepositoNoSeaSuficieteParaCubrirElDescubierto() {
		
		// Datos de entrada
		final Double IMPORTE_A_DEPOSITAR_DEPOSITO_1 = 100.0;
		final Double IMPORTE_A_EXTRAER = 200.0;
		final Double IMPORTE_A_DEPOSITAR_DEPOSITO_2 = 100.0;
		
		// Valores esperados
		final Double DESCUBIERTO_ACTUAL_ESPERADO = 5.0;
		final Double SALDO_ESPERADO = 0.0;
		final Double DEUDA_ESPERADA = 0.0;
		
		// Ejecución
		CuentaCorriente nueva = new CuentaCorriente();
		nueva.depositar(IMPORTE_A_DEPOSITAR_DEPOSITO_1);
		nueva.extraer(IMPORTE_A_EXTRAER);
		nueva.depositar(IMPORTE_A_DEPOSITAR_DEPOSITO_2);

		// Validación
		assertEquals(SALDO_ESPERADO, nueva.getSaldo());
		assertEquals(DESCUBIERTO_ACTUAL_ESPERADO, nueva.getDescubiertoActual());
		assertEquals(DEUDA_ESPERADA, nueva.getDeuda());
	}
	
	@Test
	public void queUnaExtraccionCuandoYaSeTieneDeudaIncrementeLaDeuda() {
		
		// Datos de entrada
		final Double IMPORTE_A_DEPOSITAR = 100.0;
		final Double IMPORTE_A_EXTRAER_EXTRACCION_1 = 200.0;
		final Double IMPORTE_A_EXTRAER_EXTRACCION_2 = 50.0;
		
		// Valores esperados
		final Double DESCUBIERTO_ACTUAL_ESPERADO = 150.0;
		final Double SALDO_ESPERADO = 0.0;
		final Double DEUDA_ESPERADA = 7.50;
		
		// Ejecución
		CuentaCorriente nueva = new CuentaCorriente();
		nueva.depositar(IMPORTE_A_DEPOSITAR);
		nueva.extraer(IMPORTE_A_EXTRAER_EXTRACCION_1);
		nueva.extraer(IMPORTE_A_EXTRAER_EXTRACCION_2);

		// Validación
		assertEquals(SALDO_ESPERADO, nueva.getSaldo());
		assertEquals(DESCUBIERTO_ACTUAL_ESPERADO, nueva.getDescubiertoActual());
		assertEquals(DEUDA_ESPERADA, nueva.getDeuda());
	}
	
	@Test
	public void queLosDistintosMovimientosDeDepositoYExtraccionGenerenElSaldoDescubiertoYDeudaCorrectos() {
		
		// Datos de entrada
		final Double IMPORTE_A_DEPOSITAR_DEPOSITO_1 = 100.0;
		final Double IMPORTE_A_EXTRAER_EXTRACCION_1 = 200.0;
		final Double IMPORTE_A_EXTRAER_EXTRACCION_2 = 50.0;
		final Double IMPORTE_A_DEPOSITAR_DEPOSITO_2 = 50.0;
		final Double IMPORTE_A_EXTRAER_EXTRACCION_3 = 40.0;
		final Double IMPORTE_A_DEPOSITAR_DEPOSITO_3 = 150.0;
		
		// Valores esperados
		final Double DESCUBIERTO_ACTUAL_ESPERADO = 0.0;
		final Double SALDO_ESPERADO = 0.50;
		final Double DEUDA_ESPERADA = 0.0;
		
		// Ejecución
		CuentaCorriente nueva = new CuentaCorriente();
		nueva.depositar(IMPORTE_A_DEPOSITAR_DEPOSITO_1);
		nueva.extraer(IMPORTE_A_EXTRAER_EXTRACCION_1);
		nueva.extraer(IMPORTE_A_EXTRAER_EXTRACCION_2);
		nueva.depositar(IMPORTE_A_DEPOSITAR_DEPOSITO_2);
		nueva.extraer(IMPORTE_A_EXTRAER_EXTRACCION_3);
		nueva.depositar(IMPORTE_A_DEPOSITAR_DEPOSITO_3);
		
		// Validación
		assertEquals(SALDO_ESPERADO, nueva.getSaldo());
		assertEquals(DESCUBIERTO_ACTUAL_ESPERADO, nueva.getDescubiertoActual());
		assertEquals(DEUDA_ESPERADA, nueva.getDeuda());
	}
	
	@Test
	public void queElDepositoNoAlcanceParaCubrirLaDeuda() {
		
		// Datos de entrada
		final Double IMPORTE_A_DEPOSITAR_1 = 100.0;
		final Double IMPORTE_A_EXTRAER_EXTRACCION_1 = 200.0;
		final Double IMPORTE_A_DEPOSITAR_2 = 2.5;
		
		// Valores esperados
		final Double DESCUBIERTO_ACTUAL_ESPERADO = 100.0;
		final Double SALDO_ESPERADO = 0.0;
		final Double DEUDA_ESPERADA = 2.50;
		
		// Ejecución
		CuentaCorriente nueva = new CuentaCorriente();
		nueva.depositar(IMPORTE_A_DEPOSITAR_1);
		nueva.extraer(IMPORTE_A_EXTRAER_EXTRACCION_1);
		nueva.depositar(IMPORTE_A_DEPOSITAR_2);

		// Validación
		assertEquals(SALDO_ESPERADO, nueva.getSaldo());
		assertEquals(DESCUBIERTO_ACTUAL_ESPERADO, nueva.getDescubiertoActual());
		assertEquals(DEUDA_ESPERADA, nueva.getDeuda());
	}
}
