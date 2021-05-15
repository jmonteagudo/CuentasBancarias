package ar.edu.unlam.pb2;

public class CuentaCorriente extends Cuenta {
	
	private final Double DESCUBIERTO_MAXIMO_DISPONIBLE = 150.0;
	private final Double COMISION = 0.05;
	
	private Double descubiertoActual = 0.0;

	private Double deuda = 0.0;

	public CuentaCorriente() {
		super();
	}
	
	public Boolean extraer(Double monto) {
		Double descubiertoInicial = descubiertoActual;
		if(monto<=saldo) {
			saldo-=monto;
			return true;
		}
		else if(monto<=(saldo+(DESCUBIERTO_MAXIMO_DISPONIBLE-descubiertoActual))){
			descubiertoActual  += (monto-saldo);
			deuda += ((descubiertoActual-descubiertoInicial) * COMISION);
			saldo = 0.0;
			return true;
		}
		return false;
	}
	
	public Boolean depositar(Double monto) {
		if(descubiertoActual == 0.0) {
			saldo+=monto;
		}
		else {
			if(monto >= (descubiertoActual + deuda) ) {
				saldo += (monto-descubiertoActual - deuda);
				descubiertoActual = 0.0;
				deuda = 0.0;
			}
			else if(monto >= deuda){
				descubiertoActual -= (monto-deuda);
				deuda = 0.0;
			}
			else {
				deuda -= monto;
			}
		}
		return true;
	}
	
	public Double getDescubiertoActual() {
		return descubiertoActual;
	}
	
	public Double getDescubiertoMaximoDisponible() {
		return DESCUBIERTO_MAXIMO_DISPONIBLE;
	}
	
	public Double getDeuda() {
		return this.deuda;
	}

}
