package ar.edu.unlam.pb2;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestCuentaSueldo {

	@Test
	public void queSePuedaCrearUnaCuentaSueldo() {
		
		// Ejecución
		CuentaSueldo nuevaCuenta= new CuentaSueldo();
		
		// Validación
		assertNotNull(nuevaCuenta);
	}

	@Test
	public void queSePuedaDepositarDineroEnUnaCuentaSueldo() {
		
		// Datos de entrada
		final Double IMPORTE_A_DEPOSITAR = 15000.0;
		// Valores esperados
		final Double SALDO_ESPERADO = IMPORTE_A_DEPOSITAR;
		
		// Ejecución
		CuentaSueldo nuevaCuenta= new CuentaSueldo();
		nuevaCuenta.depositar(IMPORTE_A_DEPOSITAR);
		
		// Validación
		assertEquals(SALDO_ESPERADO, nuevaCuenta.getSaldo());
	}

	@Test
	public void queSePuedaExtraerDeUnaCuentaSueldoUnImporteMenorAlSaldo() {
		// Datos de entrada
		final Double IMPORTE_A_DEPOSITAR = 15000.0;
		final Double IMPORTE_A_EXTRAER = 13000.0;
		// Valores esperados
		final Double SALDO_ESPERADO = IMPORTE_A_DEPOSITAR - IMPORTE_A_EXTRAER;
		
		// Ejecución 
		CuentaSueldo nuevaCuenta= new CuentaSueldo();
		nuevaCuenta.depositar(IMPORTE_A_DEPOSITAR);
		nuevaCuenta.extraer(IMPORTE_A_EXTRAER);
		
		assertEquals(SALDO_ESPERADO, nuevaCuenta.getSaldo());
	}

	@Test
	public void queSePuedaExtraerDeUnaCuentaSueldoUnImporteIgualAlSaldo() {
		// Datos de entrada
		final Double IMPORTE_A_DEPOSITAR = 15000.0;
		final Double IMPORTE_A_EXTRAER = 15000.0;
		
		// Valores esperados
		final Double SALDO_ESPERADO = 0.0;
		
		// Ejecución
		CuentaSueldo nuevaCuenta= new CuentaSueldo();
		nuevaCuenta.depositar(IMPORTE_A_DEPOSITAR);
		nuevaCuenta.extraer(IMPORTE_A_EXTRAER);
		
		// Validación
		assertEquals(SALDO_ESPERADO, nuevaCuenta.getSaldo());
	}

	@Test
	public void queNoSePuedaExtraerDeUnaCuentaSueldoUnImporteMayorAlSaldo() {
		// Datos de entrada
		final Double IMPORTE_A_DEPOSITAR = 10000.0;
		final Double IMPORTE_A_EXTRAER = 15000.0;
		
		// Valores esperados
		final Double SALDO_ESPERADO = IMPORTE_A_DEPOSITAR;
		
		// Ejecución
		CuentaSueldo nuevaCuenta= new CuentaSueldo();
		nuevaCuenta.depositar(IMPORTE_A_DEPOSITAR);
		
		// Validación
		assertFalse(nuevaCuenta.extraer(IMPORTE_A_EXTRAER));
		assertEquals(SALDO_ESPERADO, nuevaCuenta.getSaldo());
	}

	@Test
	public void queNoSeCobreAdicionalLuegoDeLaQuintaExtraccionDeUnaCuentaSueldo() {
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
		CuentaSueldo nuevaCuenta= new CuentaSueldo();
		nuevaCuenta.depositar(IMPORTE_A_DEPOSITAR);
		nuevaCuenta.extraer(IMPORTE_A_EXTRAER_1);
		nuevaCuenta.extraer(IMPORTE_A_EXTRAER_2);
		nuevaCuenta.extraer(IMPORTE_A_EXTRAER_3);
		nuevaCuenta.extraer(IMPORTE_A_EXTRAER_4);
		nuevaCuenta.extraer(IMPORTE_A_EXTRAER_5);
		
		// Validación
		assertEquals(SALDO_ESPERADO, nuevaCuenta.getSaldo());
	}

}
