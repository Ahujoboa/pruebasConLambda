package Taller2;

import java.math.BigDecimal;

public enum Tax {
	NORMAL(new BigDecimal("0.21")), SUPERREDUCED(new BigDecimal("0.04")), REDUCED(new BigDecimal("0.1"));

	private BigDecimal IVA;

	Tax(BigDecimal IVA) {
		this.IVA = IVA;
	}

	public BigDecimal getPrecio() {
		return IVA;
	}

	public void setPrecio(BigDecimal IVA) {
		this.IVA = IVA;
	}
}