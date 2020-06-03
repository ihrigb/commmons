package de.ihrigb.commons;

import java.util.function.Function;

public final class Distance {

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
		public final static Unit NANOMETER = new Unit(DecimalPowers.NANO);
		public final static Unit MICROMETER = new Unit(DecimalPowers.MICRO);
		public final static Unit MILLIMETER = new Unit(DecimalPowers.MILLI);
		public final static Unit CENTIMETER = new Unit(DecimalPowers.CENTI);
		public final static Unit DECIMETER = new Unit(DecimalPowers.DECI);
		public final static Unit METER = new Unit(DecimalPowers.ONE);
		public final static Unit DECAMETER = new Unit(DecimalPowers.DECA);
		public final static Unit HECTOMETER = new Unit(DecimalPowers.HECTO);
		public final static Unit KILOMETER = new Unit(DecimalPowers.KILO);

		public final static Unit INCH = new Unit(v -> v / 39.37, v -> v * 39.37);
		public final static Unit FEET = new Unit(v -> v / 3.2808, v -> v * 3.2808);
		public final static Unit YARD = new Unit(v -> v / 1.0936, v -> v * 1.0936);
		public final static Unit MILE = new Unit(v -> v / 0.00062137, v -> v * 0.00062137);

		private final Function<Double, Double> toMetersFunction;
		private final Function<Double, Double> fromMetersFunction;

		public Unit(DecimalPowers decimalPowers) {
			this(decimalPowers::multiply, decimalPowers::divide);
		}

		public Unit(Function<Double, Double> toMetersFunction, Function<Double, Double> fromMetersFunction) {
			if (toMetersFunction == null) {
				throw new IllegalArgumentException("toMetersFunction must not be null.");
			}
			if (fromMetersFunction == null) {
				throw new IllegalArgumentException("fromMetersFunction must not be null.");
			}
			this.toMetersFunction = toMetersFunction;
			this.fromMetersFunction = fromMetersFunction;
		}
	}
}