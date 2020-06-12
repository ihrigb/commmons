package de.ihrigb.commons;

import java.util.function.Function;

/**
 * Basic class to represent a physical unit.
 */
public abstract class Unit {

	private final String sign;
	private final Function<Double, Double> toSiFunction;
	private final Function<Double, Double> fromSiFunction;

	/**
	 * Create a SI Unit.
	 *
	 * This uses Function::identity as toSi and fromSi functions.
	 *
	 * @param sign the sign of the unit
	 */
	protected Unit(String sign) {
		this(sign, Function.identity(), Function.identity());
	}

	/**
	 * Creates a Unit that relates to the SI unit by a decimal power.
	 *
	 * @param sign       the sign of the unit
	 * @param unitPrefix the unit prefix
	 */
	protected Unit(String sign, UnitPrefix unitPrefix) {
		// TODO remove anoying fix
		this(sign, new Function<Double, Double>() {
			@Override
			public Double apply(Double t) {
				return unitPrefix.multiply(t);
			}
		}, new Function<Double, Double>() {
			@Override
			public Double apply(Double t) {
				return unitPrefix.divide(t);
			}
		});
	}

	/**
	 * Creates a new unit.
	 *
	 * @param sign           the sign of the unit
	 * @param toSiFunction   function used to convert a value under this unit to the
	 *                       SI unit.
	 * @param fromSiFunction function used to convert the SI unit to a value under
	 *                       this unit.
	 */
	protected Unit(String sign, Function<Double, Double> toSiFunction, Function<Double, Double> fromSiFunction) {
		Assert.notNull(sign, "Sign must not be null.");
		Assert.notNull(toSiFunction, "toSiFunction must not be null.");
		Assert.notNull(fromSiFunction, "fromSiFunction must not be null.");

		this.sign = sign;
		this.toSiFunction = toSiFunction;
		this.fromSiFunction = fromSiFunction;
	}

	/**
	 * Get the sign of the unit.
	 *
	 * @return sign
	 */
	public String getSign() {
		return this.sign;
	}

	@Override
	public String toString() {
		return this.getSign();
	}

	/**
	 * Calculate the 'SI-Value' of a value under this unit.
	 *
	 * @param value value under this unit
	 * @return SI-Value
	 */
	public double toSi(double value) {
		return this.toSiFunction.apply(value);
	}

	/**
	 * Calculate the value under this unit of a 'SI-Value'.
	 * 
	 * @param value SI-Value
	 * @return value under this unit
	 */
	public double fromSi(double value) {
		return this.fromSiFunction.apply(value);
	}
}
