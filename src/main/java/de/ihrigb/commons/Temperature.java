package de.ihrigb.commons;

import java.util.function.Function;

/**
 * Physical quantity 'temperature'
 */
public final class Temperature extends PhysicalQuantity<Temperature.TemperatureUnit>
		implements Comparable<Temperature> {

	/**
	 * Absolute Zero.
	 */
	public static final Temperature ABSOLUTE_ZERO = Temperature.ofKelvin(0d);

	/**
	 * Create a temperature based on a scalar value and a unit.
	 *
	 * @param value scalar value
	 * @param unit  TemperatureUnit
	 * @return instance of temperature
	 */
	public static Temperature of(double value, TemperatureUnit unit) {
		if (unit == null) {
			throw new IllegalArgumentException("Unit must not be null.");
		}
		return new Temperature(unit.toSi(value));
	}

	/**
	 * Create a temperature of a kelvin value.
	 *
	 * @param value the value
	 * @return instance of temperature
	 */
	public static Temperature ofKelvin(double value) {
		return Temperature.of(value, TemperatureUnit.KELVIN);
	}

	/**
	 * Create a temperature of a degrees celsius value.
	 *
	 * @param value the value
	 * @return instance of temperature
	 */
	public static Temperature ofDegreesCelsius(double value) {
		return Temperature.of(value, TemperatureUnit.DEGREES_CELSIUS);
	}

	/**
	 * Create a temperature of a degrees fahrenheit value.
	 *
	 * @param value the value
	 * @return instance of temperature
	 */
	public static Temperature ofDegreesFahrenheit(double value) {
		return Temperature.of(value, TemperatureUnit.DEGREES_FAHRENHEIT);
	}

	private Temperature(double kelvin) {
		super(kelvin);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Temperature)) {
			return false;
		}
		Temperature o = (Temperature) obj;
		return this.compareTo(o) == 0;
	}

	/**
	 * Check if this temperature is greater than another.
	 *
	 * @param d other temperature
	 * @return true, if greater
	 */
	public boolean isGreater(Temperature d) {
		return this.compareTo(d) > 0;
	}

	/**
	 * Check if this temperature is greater or equal than another.
	 *
	 * @param d other temperature
	 * @return true, if greater or equal
	 */
	public boolean isGreaterOrEqual(Temperature d) {
		return this.compareTo(d) >= 0;
	}

	/**
	 * Check if this temperature is less than another.
	 *
	 * @param d other temperature
	 * @return true, if less
	 */
	public boolean isLess(Temperature d) {
		return this.compareTo(d) < 0;
	}

	/**
	 * Check if this temperature is less or equal than another.
	 *
	 * @param d other temperature
	 * @return true, if less or equal
	 */
	public boolean isLessOrEqual(Temperature d) {
		return this.compareTo(d) <= 0;
	}

	@Override
	public int compareTo(Temperature o) {
		return Double.valueOf(this.getSiValue()).compareTo(o.getSiValue());
	}

	/**
	 * Get the temperature in kelvin.
	 *
	 * @return temperature in kelvin
	 */
	public double getKelvin() {
		return this.get(TemperatureUnit.KELVIN);
	}

	/**
	 * Get the temperature in degrees celsius.
	 *
	 * @return temperature in degrees celsius
	 */
	public double getDegreesCelsius() {
		return this.get(TemperatureUnit.DEGREES_CELSIUS);
	}

	/**
	 * Get the temperature in degrees fahrenheit.
	 *
	 * @return temperature in degrees fahrenheit
	 */
	public double getDegreesFahrenheit() {
		return this.get(TemperatureUnit.DEGREES_FAHRENHEIT);
	}

	@Override
	protected TemperatureUnit getSiUnit() {
		return TemperatureUnit.KELVIN;
	}

	/**
	 * Unit for temperatures.
	 */
	public static final class TemperatureUnit extends Unit {

		/**
		 * Convert degrees celsius to kelvin.
		 */
		public static final Function<Double, Double> CELSIUS_TO_KELVIN = v -> v + 273.15d;

		/**
		 * Convert kelvin to degrees celsius.
		 */
		public static final Function<Double, Double> KELVIN_TO_CELSIUS = v -> v - 273.15d;

		/**
		 * Convert degrees fahrenheit to kelvin.
		 */
		public static final Function<Double, Double> FAHRENHEIT_TO_KELVIN = CELSIUS_TO_KELVIN
				.compose(v -> ((v - 32) * 5 / 9));

		/**
		 * Convert kelvin to degrees fahrenheit.
		 */
		public static final Function<Double, Double> KELVIN_TO_FAHRENHEIT = KELVIN_TO_CELSIUS
				.andThen(v -> (v * (9d / 5d)) + 32);

		/**
		 * Kelvin (K) unit.
		 */
		public static final TemperatureUnit KELVIN = new TemperatureUnit();

		/**
		 * Degrees Celsius (°C) unit.
		 */
		public static final TemperatureUnit DEGREES_CELSIUS = new TemperatureUnit("°C", CELSIUS_TO_KELVIN,
				KELVIN_TO_CELSIUS);

		/**
		 * Degrees Fahrenheit (°F) unit.
		 */
		public static final TemperatureUnit DEGREES_FAHRENHEIT = new TemperatureUnit("°F", FAHRENHEIT_TO_KELVIN,
				KELVIN_TO_FAHRENHEIT);

		private TemperatureUnit() {
			super("K");
		}

		/**
		 * Constructs a temperature unit.
		 *
		 * @param sign               the sign of the unit
		 * @param toKelvinFunction   function to get the SI-Value from a value under the
		 *                           constructed unit
		 * @param fromKelvinFunction function to get the value under the constructed
		 *                           unit from the SI-Value
		 */
		public TemperatureUnit(String sign, Function<Double, Double> toKelvinFunction,
				Function<Double, Double> fromKelvinFunction) {
			super(sign, toKelvinFunction, fromKelvinFunction);
		}
	}
}
