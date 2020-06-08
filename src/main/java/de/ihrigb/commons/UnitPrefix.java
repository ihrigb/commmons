package de.ihrigb.commons;

/**
 * All physical decimal powers.
 */
public enum UnitPrefix {

	/**
	 * Yocto, y, 10<sup>-24</sup>
	 */
	YOCTO(-24),

	/**
	 * Zepto, z, 10<sup>-21</sup>
	 */
	ZEPTO(-21),

	/**
	 * Atto, a, 10<sup>-18</sup>
	 */
	ATTO(-18),

	/**
	 * Femto, f, 10<sup>-15</sup>
	 */
	FEMTO(-15),

	/**
	 * Pico, p, 10<sup>-12</sup>
	 */
	PICO(-12),

	/**
	 * Nano, n, 10<sup>-9</sup>
	 */
	NANO(-9),

	/**
	 * Micro, μ, 10<sup>-6</sup>
	 */
	MICRO(-6),

	/**
	 * Millo, m, 10<sup>-3</sup>
	 */
	MILLI(-3),

	/**
	 * Centi, c, 10<sup>-2</sup>
	 */
	CENTI(-2),

	/**
	 * Deci, d, 10<sup>-1</sup>
	 */
	DECI(-1),

	/**
	 * --, --, 10<sup>0</sup>
	 */
	ONE(0),

	/**
	 * Deca, da, 10<sup>1</sup>
	 */
	DECA(1),

	/**
	 * Hecto, h, 10<sup>2</sup>
	 */
	HECTO(2),

	/**
	 * Kilo, k, 10<sup>3</sup>
	 */
	KILO(3),

	/**
	 * Mega, M, 10<sup>6</sup>
	 */
	MEGA(6),

	/**
	 * Giga, G, 10<sup>9</sup>
	 */
	GIGA(9),

	/**
	 * Tera, T, 10<sup>12</sup>
	 */
	TERA(12),

	/**
	 * Peta, P, 10<sup>15</sup>
	 */
	PETA(15),

	/**
	 * Exa, E, 10<sup>18</sup>
	 */
	EXA(18),

	/**
	 * Zetta, Z, 10<sup>21</sup>
	 */
	ZETTA(21),

	/**
	 * Yotta, Y, 10<sup>24</sup>
	 */
	YOTTA(24);

	private final int decimalPower;

	private UnitPrefix(int decimalPower) {
		this.decimalPower = decimalPower;
	}

	/**
	 * Get the decimal power.
	 *
	 * @return decimal power
	 */
	public int getDecimalPower() {
		return this.decimalPower;
	}

	/**
	 * Get the factor (10<sup>power</sup>)
	 *
	 * @return factor
	 */
	public double getFactor() {
		return Math.pow(10, this.getDecimalPower());
	}

	/**
	 * Multiply a value by the decimal power factor.
	 *
	 * @param factor the factor to be multiplied
	 * @return product
	 */
	public double multiply(double factor) {
		return factor * this.getFactor();
	}

	/**
	 * Divide a value by the decimal power factor.
	 *
	 * @param divisor divisor
	 * @return fraction
	 */
	public double divide(double divisor) {
		return divisor / this.getFactor();
	}
}
