package de.ihrigb.commons;

/**
 * Abstract class for a physical quantity based on a scalar (non vector).
 *
 * @param <T> unit type
 */
public abstract class PhysicalQuantity<T extends Unit> {

	private final double siValue;

	/**
	 * Construct the physical quantity based on the SI value
	 *
	 * @param siValue SI value
	 */
	protected PhysicalQuantity(double siValue) {
		this.siValue = siValue;
	}

	/**
	 * Construct the physical quantity based on a value and a unit.
	 *
	 * @param value value under the unit
	 * @param unit  unit of the value
	 */
	protected PhysicalQuantity(double value, T unit) {
		this(unit.toSi(value));
	}

	@Override
	@SuppressWarnings("rawtypes")
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof PhysicalQuantity)) {
			return false;
		}
		PhysicalQuantity o = (PhysicalQuantity) obj;
		return this.siValue == o.siValue;
	}

	@Override
	public int hashCode() {
		return Double.valueOf(this.siValue).hashCode();
	}

	/**
	 * Format the physical quantity based on a unit.
	 *
	 * @param unit unit to be formatted
	 * @return '&lt;value under unit&gt; &lt;unit sign&gt;'
	 */
	public String toString(T unit) {
		if (unit == null) {
			throw new IllegalArgumentException("Unit must not be null.");
		}
		return String.format("%f %s", unit.fromSi(this.siValue), unit.getSign());
	}

	@Override
	public String toString() {
		return this.toString(this.getSiUnit());
	}

	/**
	 * Get the value under a unit.
	 *
	 * @param unit unit
	 * @return value under unit
	 */
	public double get(T unit) {
		if (unit == null) {
			throw new IllegalArgumentException("Unit must not be null.");
		}
		return unit.fromSi(this.siValue);
	}

	/**
	 * Get the SI value of the physical quantity
	 *
	 * @return SI value
	 */
	protected double getSiValue() {
		return this.siValue;
	}

	/**
	 * Get the SI unit of the physical quantity
	 *
	 * @return SI unit
	 */
	abstract protected T getSiUnit();
}
