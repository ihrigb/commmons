package de.ihrigb.commons;

public final class LatLng {

	public static Distance distance(LatLng start, LatLng end) {
		return Haversine.distance(start, end);
	}

	private final double lat;
	private final double lng;

	public LatLng(double lat, double lng) {
		this.lat = lat;
		this.lng = lng;
	}

	public double getLatitude() {
		return this.lat;
	}

	public double getLongitude() {
		return this.lng;
	}

	public Radians getRadians() {
		return new Radians(this);
	}

	public Distance getDistanceTo(LatLng other) {
		return LatLng.distance(this, other);
	}

	public final class Radians {

		private final LatLng latLng;

		private Radians(LatLng latLng) {
			this.latLng = latLng;
		}

		public double getLatitude() {
			return Math.toRadians(this.latLng.lat);
		}

		public double getLongitude() {
			return Math.toRadians(this.latLng.lng);
		}
	}
}
