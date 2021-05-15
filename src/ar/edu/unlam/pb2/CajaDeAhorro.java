package ar.edu.unlam.pb2;

public class CajaDeAhorro extends Cuenta {
	private Double cobroAdicionaldeseispesos;
	private final Double CONCEPTO_ADICIONAL = 6.0;
	private final Integer CANTIDAD_DE_EXTRACCIONES_MAXIMAS = 6;
	private Integer cantidadDeExtracciones = 0;
	
	
	public CajaDeAhorro() {
		super();
		
	}
	
	public Double getCobroAdicionaldeseispesos() {
		return cobroAdicionaldeseispesos;
	}
	
	public void calcularAdicional(Double saldo){
		cobroAdicionaldeseispesos= saldo + CONCEPTO_ADICIONAL;
		
	}
	
	// Sobreescritura
	@Override
	public Boolean extraer(Double monto) {
		if(cantidadDeExtracciones < (CANTIDAD_DE_EXTRACCIONES_MAXIMAS - 1)) {
			if(monto<=saldo) {
				this.saldo= saldo - monto ;
				cantidadDeExtracciones++;
				return true;
			}
		}
		else {
			if(monto<=(saldo  + CONCEPTO_ADICIONAL)) {
				saldo= saldo - monto - CONCEPTO_ADICIONAL;
				cantidadDeExtracciones++;
				return true;
			}
		}
		return false;	
	}
	
}