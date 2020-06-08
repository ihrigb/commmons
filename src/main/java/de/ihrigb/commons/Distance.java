package de.ihrigb.commons;

import java.util.function.Function;

/**
 * Physical quantity 'distance'
 */
public final class Distance extends PhysicalQuantity<Distance.DistanceUnit> implements Comparable<Distance> {

	/**
	 * Create a distance based on a scalar value and a unit.
	 *
	 * @param value scalar value
	 * @param unit  DistanceUnit
	 * @return instance of distance
	 */
	public static Distance of(double value, DistanceUnit unit) {
		if (unit == null) {
			throw new IllegalArgumentException("Unit must not be null.");
		}
		return new Distance(unit.toSi(value));
	}

	/**
	 * Create a distance of a nanometer value.
	 *
	 * @param value the value
	 */
	public static Distance ofNanometer(double value) {
		return Distance.of(value, DistanceUnit.NANOMETER);
	}

	/**
	 * Create a distance of a micrometer value.
	 *
	 * @param value the value
	 */
	public static Distance ofMicrometer(double value) {
		return Distance.of(value, DistanceUnit.MICROMETER);
	}

	/**
	 * Create a distance of a millimeter value.
	 *
	 * @param value the value
	 */
	public static Distance ofMillimeter(double value) {
		return Distance.of(value, DistanceUnit.MILLIMETER);
	}

	/**
	 * Create a distance of a centimeter value.
	 *
	 * @param value the value
	 */
	public static Distance ofCentimeter(double value) {
		return Distance.of(value, DistanceUnit.CENTIMETER);
	}

	/**
	 * Create a distance of a decimeter value.
	 *
	 * @param value the value
	 */
	public static Distance ofDecimeter(double value) {
		return Distance.of(value, DistanceUnit.DECIMETER);
	}

	/**
	 * Create a distance of a meter value.
	 *
	 * @param value the value
	 */
	public static Distance ofMeter(double value) {
		return Distance.of(value, DistanceUnit.METER);
	}

	/**
	 * Create a distance of a decameter value.
	 *
	 * @param value the value
	 */
	public static Distance ofDecameter(double value) {
		return Distance.of(value, DistanceUnit.DECAMETER);
	}

	/**
	 * Create a distance of a hectometer value.
	 *
	 * @param value the value
	 */
	public static Distance ofHectometer(double value) {
		return Distance.of(value, DistanceUnit.HECTOMETER);
	}

	/**
	 * Create a distance of a kilometer value.
	 *
	 * @param value the value
	 */
	public static Distance ofKilometer(double value) {
		return Distance.of(value, DistanceUnit.KILOMETER);
	}

	/**
	 * Create a distance of a inch value.
	 *
	 * @param value the value
	 */
	public static Distance ofInch(double value) {
		return Distance.of(value, DistanceUnit.INCH);
	}

	/**
	 * Create a distance of a feet value.
	 *
	 * @param value the value
	 */
	public static Distance ofFeet(double value) {
		return Distance.of(value, DistanceUnit.FEET);
	}

	/**
	 * Create a distance of a yard value.
	 *
	 * @param value the value
	 */
	public static Distance ofYard(double value) {
		return Distance.of(value, DistanceUnit.YARD);
	}

	/**
	 * Create a distance of a mile value.
	 *
	 * @param value the value
	 */
	public static Distance ofMile(double value) {
		return Distance.of(value, DistanceUnit.MILE);
	}

	/**
	 * Create a distance of a nautical mile value.
	 *
	 * @param value the value
	 */
	public static Distance ofNauticalMile(double value) {
		return Distance.of(value, DistanceUnit.NAUTICAL_MILE);
	}

	private Distance(double meters) {
		super(meters);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Distance)) {
			return false;
		}
		Distance o = (Distance) obj;
		return this.compareTo(o) == 0;
	}

	@Override
	public int compareTo(Distance o) {
		return Double.valueOf(this.getSiValue()).compareTo(Double.valueOf(o.getSiValue()));
	}

	/**
	 * Check if this distance is greater than another.
	 *
	 * @param d other distance
	 * @return true, if greater
	 */
	public boolean isGreater(Distance d) {
		return this.compareTo(d) > 0;
	}

	/**
	 * Check if this distance is greater or equal than another.
	 *
	 * @param d other distance
	 * @return true, if greater or equal
	 */
	public boolean isGreaterOrEqual(Distance d) {
		return this.compareTo(d) >= 0;
	}

	/**
	 * Check if this distance is less than another.
	 *
	 * @param d other distance
	 * @return true, if less
	 */
	public boolean isLess(Distance d) {
		return this.compareTo(d) < 0;
	}

	/**
	 * Check if this distance is less or equal than another.
	 *
	 * @param d other distance
	 * @return true, if less or equal
	 */
	public boolean isLessOrEqual(Distance d) {
		return this.compareTo(d) <= 0;
	}

	/**
	 * Add a distance to this and return the result. Leaves this distance unchanged.
	 *
	 * @param d other distance
	 * @return new summed distance
	 */
	public Distance add(Distance d) {
		return new Distance(this.getSiValue() + d.getSiValue());
	}

	/**
	 * Substracts a distance from this and return the result. Leaves this distance
	 * unchanged.
	 *
	 * @param d other distance
	 * @return new substracted distance
	 */
	public Distance substract(Distance d) {
		return new Distance(this.getSiValue() - d.getSiValue());
	}

	/**
	 * Multiplies this distance with a factor and returns the result. Leaves this
	 * distance unchanged.
	 *
	 * @param factor factor to multiply the distance
	 * @return new multiplied distance
	 */
	public Distance multiply(double factor) {
		if (factor < 0) {
			throw new IllegalArgumentException("Factors for Distance multiplication must not be negative.");
		}
		return new Distance(this.getSiValue() * factor);
	}

	/**
	 * Divides this distance by a divisor and returns the result. Leaves this
	 * distance unchanged.
	 *
	 * @param factor divisor to divide the distance
	 * @return new divided distance
	 */
	public Distance divide(double divisor) {
		if (divisor < 0) {
			throw new IllegalArgumentException("Divisors for Distance division must not be negative.");
		}
		return new Distance(this.getSiValue() / divisor);
	}

	/**
	 * Get the distance in nanometer.
	 *
	 * @return distance in nanometer
	 */
	public double getNanometer() {
		return this.get(DistanceUnit.NANOMETER);
	}

	/**
	 * Get the distance in nanometer.
	 *
	 * @return distance in nanometer
	 */
	public double getMicrometer() {
		return this.get(DistanceUnit.MICROMETER);
	}

	/**
	 * Get the distance in millimeter.
	 *
	 * @return distance in millimeter
	 */
	public double getMillimeter() {
		return this.get(DistanceUnit.MILLIMETER);
	}

	/**
	 * Get the distance in centimeter.
	 *
	 * @return distance in centimeter
	 */
	public double getCentimeter() {
		return this.get(DistanceUnit.CENTIMETER);
	}

	/**
	 * Get the distance in decimeter.
	 *
	 * @return distance in decimeter
	 */
	public double getDecimeter() {
		return this.get(DistanceUnit.DECIMETER);
	}

	/**
	 * Get the distance in meter.
	 *
	 * @return distance in meter
	 */
	public double getMeter() {
		return this.get(DistanceUnit.METER);
	}

	/**
	 * Get the distance in decameter.
	 *
	 * @return distance in decameter
	 */
	public double getDecameter() {
		return this.get(DistanceUnit.DECAMETER);
	}

	/**
	 * Get the distance in hectometer.
	 *
	 * @return distance in hectometer
	 */
	public double getHectometer() {
		return this.get(DistanceUnit.HECTOMETER);
	}

	/**
	 * Get the distance in kilometer.
	 *
	 * @return distance in kilometer
	 */
	public double getKilometer() {
		return this.get(DistanceUnit.KILOMETER);
	}

	/**
	 * Get the distance in inches.
	 *
	 * @return distance in inches
	 */
	public double getInch() {
		return this.get(DistanceUnit.INCH);
	}

	/**
	 * Get the distance in feet.
	 *
	 * @return distance in feet
	 */
	public double getFeet() {
		return this.get(DistanceUnit.FEET);
	}

	/**
	 * Get the distance in yards.
	 *
	 * @return distance in yards
	 */
	public double getYard() {
		return this.get(DistanceUnit.YARD);
	}

	/**
	 * Get the distance in miles.
	 *
	 * @return distance in miles
	 */
	public double getMile() {
		return this.get(DistanceUnit.MILE);
	}

	/**
	 * Get the distance in nautical miles.
	 *
	 * @return distance in nautical miles
	 */
	public double getNauticalMile() {
		return this.get(DistanceUnit.NAUTICAL_MILE);
	}

	@Override
	protected DistanceUnit getSiUnit() {
		return DistanceUnit.METER;
	}

	/**
	 * Unit for distances.
	 */
	public static final class DistanceUnit extends Unit {

		/**
		 * 1 nm = 10<sup>-9</sup> m
		 */
		public final static DistanceUnit NANOMETER = new DistanceUnit("nm", UnitPrefix.NANO);

		/**
		 * 1 μm = 10<sup>-6</sup> m
		 */
		public final static DistanceUnit MICROMETER = new DistanceUnit("μm", UnitPrefix.MICRO);

		/**
		 * 1 mm = 10<sup>-3</sup> m
		 */
		public final static DistanceUnit MILLIMETER = new DistanceUnit("mm", UnitPrefix.MILLI);

		/**
		 * 1 cm = 10<sup>-2</sup> m
		 */
		public final static DistanceUnit CENTIMETER = new DistanceUnit("cm", UnitPrefix.CENTI);

		/**
		 * 1 dm = 10<sup>-1</sup> m
		 */
		public final static DistanceUnit DECIMETER = new DistanceUnit("dm", UnitPrefix.DECI);

		/**
		 * SI Unit of Distance.
		 */
		public final static DistanceUnit METER = new DistanceUnit("m");

		/**
		 * 1 dam = 10<sup>1</sup> m
		 */
		public final static DistanceUnit DECAMETER = new DistanceUnit("dam", UnitPrefix.DECA);

		/**
		 * 1 hm = 10<sup>2</sup> m
		 */
		public final static DistanceUnit HECTOMETER = new DistanceUnit("hm", UnitPrefix.HECTO);

		/**
		 * 1 km = 10<sup>3</sup> m
		 */
		public final static DistanceUnit KILOMETER = new DistanceUnit("km", UnitPrefix.KILO);

		/**
		 * 1 in = 0.0254 m
		 */
		public final static DistanceUnit INCH = new DistanceUnit("in", v -> v / 39.37, v -> v * 39.37);

		/**
		 * 1 ft = 0.3048 m
		 */
		public final static DistanceUnit FEET = new DistanceUnit("ft", v -> v / 3.2808, v -> v * 3.2808);

		/**
		 * 1 yd = 0.9144 m
		 */
		public final static DistanceUnit YARD = new DistanceUnit("yd", v -> v / 1.0936, v -> v * 1.0936);

		/**
		 * 1 mi = 1609.34 m
		 */
		public final static DistanceUnit MILE = new DistanceUnit("mi", v -> v / 0.00062137, v -> v * 0.00062137);

		/**
		 * 1 nmi = 1852 m
		 */
		public final static DistanceUnit NAUTICAL_MILE = new DistanceUnit("nmi", v -> v * 1852, v -> v / 1852);

		/**
		 * Constructs the distance SI unit.
		 *
		 * @param sign
		 */
		private DistanceUnit(String sign) {
			super(sign);
		}

		/**
		 * Constructs a unit with decimal powers relation to the SI unit.
		 *
		 * @param sign       the sign of the unit
		 * @param unitPrefix the unit prefix
		 */
		public DistanceUnit(String sign, UnitPrefix unitPrefix) {
			super(sign, unitPrefix);
		}

		/**
		 * Constructs a distance unit.
		 *
		 * @param sign               the sign of the unit
		 * @param toMetersFunction   function to get the SI-Value from a value under the
		 *                           constructed unit
		 * @param fromMetersFunction function to get the value under the constructed
		 *                           unit from the SI-Value
		 */
		public DistanceUnit(String sign, Function<Double, Double> toMetersFunction,
				Function<Double, Double> fromMetersFunction) {
			super(sign, toMetersFunction, fromMetersFunction);
		}
	}
}
