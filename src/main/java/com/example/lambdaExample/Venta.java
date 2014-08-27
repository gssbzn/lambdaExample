package com.example.lambdaExample;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 
 * @author Gustavo Bazan
 *
 */
public class Venta implements Serializable{
	/**	 */
	private static final long serialVersionUID = 2220303649185573984L;
	
	private long transaccion;
	
	private BigDecimal monto;

	public Venta() {		
		this.transaccion = 0;
		this.monto = BigDecimal.ZERO;
	}
	
	public Venta(long transaccion, BigDecimal monto) {
		this.transaccion = transaccion;
		this.monto = monto;
	}

	public long getTransaccion() {
		return transaccion;
	}

	public void setTransaccion(long transaccion) {
		this.transaccion = transaccion;
	}

	public BigDecimal getMonto() {
		return monto;
	}

	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((monto == null) ? 0 : monto.hashCode());
		result = prime * result + (int) (transaccion ^ (transaccion >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Venta other = (Venta) obj;
		if (monto == null) {
			if (other.monto != null)
				return false;
		} else if (!monto.equals(other.monto))
			return false;
		if (transaccion != other.transaccion)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Venta [monto=" + monto + "]";
	}
	
	
}
