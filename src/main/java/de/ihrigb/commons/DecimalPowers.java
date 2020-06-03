package de.ihrigb.commons;

public enum DecimalPowers {

	YOCTO(-24),
	ZEPTO(-21),
	ATTO(-18),
	FEMTO(-15),
	PICO(-12),
	NANO(-9),
	MICRO(-6),
	MILLI(-3),
	CENTI(-2),
	DECI(-1),
	ONE(0),
	DECA(1),
	HECTO(2),
	KILO(3),
	MEGA(6),
	GIGA(9),
	TERA(12),
	PETA(15),
	EXA(18),
	ZETTA(21),
	YOTTA(24);

	private final int decimalPower;

	private DecimalPowers(int decimalPower) {
		this.decimalPower = decimalPower;
	}

	public int getDecimalPower() {
		return this.decimalPower;
	}

	public double getFactor() {
		return Math.pow(10, this.getDecimalPower());
	}

	public double multiply(double v) {
		return v * this.getFactor();
	}

	public double divide(double v) {
		return v / this.getFactor();
	}
}
