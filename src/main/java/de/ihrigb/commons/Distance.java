package de.ihrigb.commons;

import java.util.function.Function;

public final class Distance implements Comparable<Distance> {

	public static Distance of(double value, Unit unit) {
		if (unit == null) {
			throw new IllegalArgumentException("Unit must not be null.");
		}
		return new Distance(unit.toMetersFunction.apply(value));
	}

	public static Distance ofNanometer(double value) {
		return Distance.of(value, Unit.NANOMETER);
	}

	public static Distance ofMicrometer(double value) {
		return Distance.of(value, Unit.MICROMETER);
	}

	public static Distance ofMillimeter(double value) {
		return Distance.of(value, Unit.MILLIMETER);
	}

	public static Distance ofCentimeter(double value) {
		return Distance.of(value, Unit.CENTIMETER);
	}

	public static Distance ofDecimeter(double value) {
		return Distance.of(value, Unit.DECIMETER);
	}

	public static Distance ofMeter(double value) {
		return Distance.of(value, Unit.METER);
	}

	public static Distance ofDecameter(double value) {
		return Distance.of(value, Unit.DECAMETER);
	}

	public static Distance ofHectometer(double value) {
		return Distance.of(value, Unit.HECTOMETER);
	}

	public static Distance ofKilometer(double value) {
		return Distance.of(value, Unit.KILOMETER);
	}

	public static Distance ofInch(double value) {
		return Distance.of(value, Unit.INCH);
	}

	public static Distance ofFeet(double value) {
		return Distance.of(value, Unit.FEET);
	}

	public static Distance ofYard(double value) {
		return Distance.of(value, Unit.YARD);
	}

	public static Distance ofMile(double value) {
		return Distance.of(value, Unit.MILE);
	}

	private final double meters;

	private Distance(double meters) {
		if (meters < 0) {
			throw new IllegalArgumentException("Distances must not be negative.");
		}
		this.meters = meters;
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
	public int hashCode() {
		return Double.valueOf(this.meters).hashCode();
	}

	@Override
	public int compareTo(Distance o) {
		return Double.valueOf(this.meters).compareTo(Double.valueOf(o.meters));
	}

	public boolean isGreater(Distance d) {
		return this.compareTo(d) > 0;
	}

	public boolean isGreaterOrEqual(Distance d) {
		return this.compareTo(d) >= 0;
	}

	public boolean isLess(Distance d) {
		return this.compareTo(d) < 0;
	}

	public boolean isLessOrEqual(Distance d) {
		return this.compareTo(d) <= 0;
	}

	public Distance add(Distance d) {
		return new Distance(this.meters + d.meters);
	}

	public Distance substract(Distance d) {
		return new Distance(this.meters - d.meters);
	}

	public Distance multiply(double factor) {
		if (factor < 0) {
			throw new IllegalArgumentException("Factors for Distance multiplication must not be negative.");
		}
		return new Distance(this.meters * factor);
	}

	public Distance divide(double divisor) {
		if (divisor < 0) {
			throw new IllegalArgumentException("Divisors for Distance division must not be negative.");
		}
		return new Distance(this.meters / divisor);
	}

	public String toString(Unit unit) {
		if (unit == null) {
			throw new IllegalArgumentException("Unit must not be null.");
		}
		return unit.format(this.meters);
	}

	@Override
	public String toString() {
		return this.toString(Unit.METER);
	}

	public double get(Unit unit) {
		if (unit == null) {
			throw new IllegalArgumentException("Unit must not be null.");
		}
		return unit.fromMetersFunction.apply(this.meters);
	}

	public double getNanometer() {
		return this.get(Unit.NANOMETER);
	}

	public double getMicrometer() {
		return this.get(Unit.MICROMETER);
	}

	public double getMillimeter() {
		return this.get(Unit.MILLIMETER);
	}

	public double getCentimeter() {
		return this.get(Unit.CENTIMETER);
	}

	public double getDecimeter() {
		return this.get(Unit.DECIMETER);
	}

	public double getMeter() {
		return this.get(Unit.METER);
	}

	public double getDecameter() {
		return this.get(Unit.DECAMETER);
	}

	public double getHectometer() {
		return this.get(Unit.HECTOMETER);
	}

	public double getKilometer() {
		return this.get(Unit.KILOMETER);
	}

	public double getInch() {
		return this.get(Unit.INCH);
	}

	public double getFeet() {
		return this.get(Unit.FEET);
	}

	public double getYard() {
		return this.get(Unit.YARD);
	}

	public double getMile() {
		return this.get(Unit.MILE);
	}

	public static final class Unit {
		public final static Unit NANOMETER = new Unit(DecimalPowers.NANO, "nm");
		public final static Unit MICROMETER = new Unit(DecimalPowers.MICRO, "μm");
		public final static Unit MILLIMETER = new Unit(DecimalPowers.MILLI, "mm");
		public final static Unit CENTIMETER = new Unit(DecimalPowers.CENTI, "cm");
		public final static Unit DECIMETER = new Unit(DecimalPowers.DECI, "dm");
		public final static Unit METER = new Unit(DecimalPowers.ONE, "m");
		public final static Unit DECAMETER = new Unit(DecimalPowers.DECA, "dam");
		public final static Unit HECTOMETER = new Unit(DecimalPowers.HECTO, "hm");
		public final static Unit KILOMETER = new Unit(DecimalPowers.KILO, "km");

		public final static Unit INCH = new Unit(v -> v / 39.37, v -> v * 39.37, "in");
		public final static Unit FEET = new Unit(v -> v / 3.2808, v -> v * 3.2808, "ft");
		public final static Unit YARD = new Unit(v -> v / 1.0936, v -> v * 1.0936, "yd");
		public final static Unit MILE = new Unit(v -> v / 0.00062137, v -> v * 0.00062137, "mi");

		private final Function<Double, Double> toMetersFunction;
		private final Function<Double, Double> fromMetersFunction;
		private final String sign;

		public Unit(DecimalPowers decimalPowers, String sign) {
			this(decimalPowers::multiply, decimalPowers::divide, sign);
		}

		public Unit(Function<Double, Double> toMetersFunction, Function<Double, Double> fromMetersFunction, String sign) {
			if (toMetersFunction == null) {
				throw new IllegalArgumentException("toMetersFunction must not be null.");
			}
			if (fromMetersFunction == null) {
				throw new IllegalArgumentException("fromMetersFunction must not be null.");
			}
			if (!StringUtils.hasText(sign)) {
				throw new IllegalArgumentException("Sign must have text.");
			}
			this.toMetersFunction = toMetersFunction;
			this.fromMetersFunction = fromMetersFunction;
			this.sign = sign;
		}

		public String getSign() {
			return this.sign;
		}

		public String format(double value) {
			value = this.fromMetersFunction.apply(value);
			return String.format("%f %s", value, this.getSign());
		}

		@Override
		public String toString() {
			return this.sign;
		}
	}
}